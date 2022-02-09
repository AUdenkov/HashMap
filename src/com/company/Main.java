package com.company;


import com.company.value.Car;
import com.company.value.Men;

public class Main {

    public static void main(String[] args) {
        MyHashMap<Men, Integer> hasS = new MyHashMap<>();
        Men men1=new Men("Andrey");
        Men men2=new Men("Veronika");
        hasS.put(men1,1);
        hasS.put(men2,1);
        hasS.remove(men2);
        hasS.remove(men1);
        hasS.put(men1,1);
        System.out.println(hasS);
//
    }
}
