package com.javarush.task.pro.task10.task1010;

import java.util.Objects;

/* 
Два айфона
*/

public class Iphone {
    private String model;
    private String color;
    private int price;

    public Iphone(String model, String color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

    //напишите тут ваш код

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if ( !(obj instanceof Iphone) )
            return false;

        Iphone iphone = (Iphone) obj;

        if(this.price != iphone.price) return  false;

        if(this.model == null && this.color==null)
            return  this.model == iphone.model && this.color == iphone.color;

        if(this.model == null)
            return this.model == iphone.model && this.color.equals(iphone.color);

        if(this.color == null)
            return this.color == iphone.color && this.model.equals(iphone.model);

        return this.color.equals(iphone.color) && this.model.equals(iphone.model);
    }

    public static void main(String[] args) {
        var iphone1 = new Iphone("X", "Black", 999);
        var iphone2 = new Iphone("X", "Black", 999);

        System.out.println(iphone1.equals(iphone2));
    }

}
