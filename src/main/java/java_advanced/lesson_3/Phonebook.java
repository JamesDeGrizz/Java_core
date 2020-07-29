package java_advanced.lesson_3;

import java.util.HashMap;
import java.util.LinkedList;

public class Phonebook {
    private HashMap<String, LinkedList<String>> phonebook = new HashMap<String, LinkedList<String>>();

    public void add(String name, String phonenumber) {
        if (!phonebook.containsKey(name)) {
            phonebook.put(name, new LinkedList<String>());
        }
        phonebook.get(name).add(phonenumber);
    }

    public void get(String name) throws IllegalArgumentException {
        if (!phonebook.containsKey(name)) {
            throw new IllegalArgumentException("Can't find in phonebook name " + name);
        }

        System.out.println("Phone numbers for name " + name);
        for (String str : phonebook.get(name)) {
            System.out.println(str);
        }
    }

}
