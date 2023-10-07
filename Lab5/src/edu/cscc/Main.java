package edu.cscc;

public class Main {

    public static void main(String[] args) {
        int current = 600;
        int maxCapacity = 1000;

        HoldingTank tank = new HoldingTank(current, maxCapacity);
        tank.print();
        tank.add(300);
        tank.drain(50);
        tank.print();
        tank.add(500);
        tank.drain(250);
        tank.print();
        tank.drain(1200);
        tank.add(200);
        tank.drain(25);
        tank.print();

    }
}
