package Algoritms;

import java.util.HashMap;
import java.util.LinkedList;

class User {
    String name;
    public User(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        LinkedList<String> linked = new LinkedList<>();
        HashMap<User, String> users = new HashMap<>();
        users.put(new User("Ваня"), "235252525252525");
        users.put(new User("Ваня"), "4363463636346");

        System.out.println(users);

        //int i = 10;
        int j = 010;

        System.out.println(j);

        //System.out.println(i + '' + j);

        MyLinkedList<Integer> numbers = new MyLinkedList<>();
        numbers.add(2);
        numbers.add(3);
        numbers.add(34);
        numbers.add(11);
        numbers.add(20);
        numbers.add(6);
        numbers.add(100);
        numbers.add(200);

        //System.out.println(numbers);
        //System.out.println(numbers.getString());
    }
}
