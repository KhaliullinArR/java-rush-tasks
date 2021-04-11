package com.javarush.task.task17.task1710;

public enum DataManage {
    CREATE("-c"),
    UPDATE("-u"),
    DELETE("-d"),
    INFO("-i");

    private DataManage(String command){
        this.command = command;
    }

    private final String command;

    public String getCommand(){
        return command;
    }


}
