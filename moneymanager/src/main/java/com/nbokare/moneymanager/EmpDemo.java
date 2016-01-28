package com.nbokare.moneymanager;

public class EmpDemo {
    public static void main(String args[]) {
        System.out.println("Starting program!!");
        Emp e1 = new Emp();
        e1.putData("Stalin", 1);
        e1.getData();

        Emp e2 = new Emp("Nikhil", 2, "COEP");
        e2.getData();
    }

}
