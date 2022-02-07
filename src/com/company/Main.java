package com.company;


import com.company.value.Car;
import com.company.value.Men;

public class Main {

    public static void main(String[] args) {
        MyHashMap<String, Integer> hasS = new MyHashMap<>();
        hasS.put("Denis",1);
        hasS.put("Deni",2);
        hasS.put("Den",3);
        hasS.put("Denis1",4);
        hasS.put("Denis2",5);
        hasS.put("Denis3",6);
        hasS.put("Denis4",7);
        hasS.put("Denis5",8);
        hasS.put("Denis6",9);
        hasS.put("Denis7",0);
        hasS.put("Denis8",10);
        hasS.put("Denis9",11);
        hasS.put("Denis12",12);
        hasS.put("Denis123",13);
        hasS.put("Denis435345",14);
        hasS.put("Denis43543",15);
        hasS.put("Denis435",16);
        hasS.put("Denis43543543",17);
        hasS.put("Denisfsdfsd",18);
        hasS.put("Deniswqrqwfv",19);
        System.out.println(hasS.getNode("Denis6"));
    }
}
