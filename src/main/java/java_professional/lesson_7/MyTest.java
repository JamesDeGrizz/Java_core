package java_professional.lesson_7;

import  java_professional.lesson_7.Annotations.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    private static HashMap<Integer, List<Method>> methodsMap = new HashMap<Integer, List<Method>>();

    public static void start(Class cl) {
        methodsMap.clear();

        Method[] methods = cl.getDeclaredMethods();

        for (Method method : methods) {
            putAnnotation(method.getAnnotation(BeforeSuite.class), method, 0);
            putAnnotation(method.getAnnotation(AfterSuite.class), method, 11);

            Test a = method.getAnnotation(Test.class);
            if (a != null) {
                putAnnotation(a, method, a.priority());
            }
        }

        checkMethodsMap();
        Object obj = getObject(cl);
        runMethods(obj);
    }

    private static void putAnnotation(Annotation a, Method m, int priority) {
        if (a != null) {
            if (methodsMap.get(priority) == null) {
                methodsMap.put(priority, new ArrayList<>());
            }
            methodsMap.get(priority).add(m);
        }
    }

    private static void checkMethodsMap() {
        if (methodsMap.get(0) != null && methodsMap.get(0).size() > 1) {
            throw new RuntimeException("Too much BeforeSuite annotations");
        }
        if (methodsMap.get(11) != null && methodsMap.get(11).size() > 1) {
            throw new RuntimeException("Too much AfterSuite annotations");
        }
    }

    private static Object getObject(Class cl) {
        Constructor[] constructors = cl.getConstructors();
        HashMap<Integer, Constructor> constructorsByArgumentNumber = new HashMap<>();

        for (Constructor ctr : constructors) {
            constructorsByArgumentNumber.put(ctr.getParameterCount(), ctr);
        }

        Constructor minimumArgumentsConstructor = constructorsByArgumentNumber.entrySet().iterator().next().getValue();
        if (minimumArgumentsConstructor.getParameterCount() != 0) {
            throw new RuntimeException("Need 1 constructor with empty argument list");
        }

        try {
            return minimumArgumentsConstructor.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Something is wrong");
    }

    private static void runMethods(Object obj) {
        methodsMap.forEach((priority, methodsList) -> {
            if (methodsList == null) {
                return;
            }
            for (Method method : methodsList) {
                try {
                    method.invoke(obj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
