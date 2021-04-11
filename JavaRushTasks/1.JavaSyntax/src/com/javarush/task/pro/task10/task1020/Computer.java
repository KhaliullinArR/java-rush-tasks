package com.javarush.task.pro.task10.task1020;

public class Computer {
    private Keyboard keyboard;
    private Monitor monitor;
    private Mouse mouse;
    private  SystemUnit systemUnit;

    public Computer() {
        this.keyboard = new Keyboard();
        this.monitor = new Monitor();
        this.mouse = new Mouse();
        this.systemUnit = new SystemUnit();
    }
}
