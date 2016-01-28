package com.nbokare.moneymanager;

public class Emp {
    String name;
    int id;
    String college;

    Emp() {
        System.out.println("Creating new employee object!!!");
    }

    Emp(String n, int i, String c) {
        System.out.println("Creating new employee object with values!!!");

        name = n;
        id = i;
        college = c;

        System.out.println("entered values!!!");
    }

    void putData(String n, int i, String c) {
        name = n;
        id = i;
        college = c;
    }

    void putData(String n, int i) {
        name = n;
        id = i;
        System.out.println("College not given");
    }

    void getData() {
        System.out.println("Details : ");
        System.out.println("Name : " + name);
        System.out.println("ID : " + id);
        System.out.println("College : " + college);
    }
}
