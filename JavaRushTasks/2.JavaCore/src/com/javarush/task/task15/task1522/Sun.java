package com.javarush.task.task15.task1522;

public class Sun implements  Planet{
    private static Sun instance;

    private Sun() {

    }
    public static Sun getInstance() {
        if(instance == null){
            instance = new Sun();
            return instance;
        }else return instance;
    }


}





/*private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton(){}

    public static LazyInitializedSingleton getInstance(){
        if(instance == null){
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }*/
