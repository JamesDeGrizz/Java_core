package java_professional.lesson_7;

import  java_professional.lesson_7.Annotations.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    private static HashMap<Integer, List<Method>> methodsMap = new HashMap<Integer, List<Method>>();

    public static void start(Class cl, Object obj) {
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

        if (methodsMap.get(0) != null && methodsMap.get(0).size() > 1) {
            throw new RuntimeException("Too much BeforeSuite annotations");
        }
        if (methodsMap.get(11) != null && methodsMap.get(11).size() > 1) {
            throw new RuntimeException("Too much AfterSuite annotations");
        }

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

    private static void putAnnotation(Annotation a, Method m, int priority) {
        if (a != null) {
            if (methodsMap.get(priority) == null) {
                methodsMap.put(priority, new ArrayList<>());
            }
            methodsMap.get(priority).add(m);
        }
    }
}
