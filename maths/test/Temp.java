package maths.test;

import java.util.ArrayList;
import java.util.List;

public class Temp {
    public static void main(String[] args) {
        int x = (int)Math.ceil(Math.log(128));
        System.err.println(x);

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        System.err.println(list);
        fun(list);
        System.err.println(list);
    }

    static void fun(List<Integer> list){
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        list = l;
    }
}
