package com.javarush.task.task17.task1711.dataBaseCommands;

import com.javarush.task.task17.task1711.DataManage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public abstract   class Command{

    public static SimpleDateFormat dateFormatFromArg = new SimpleDateFormat("dd/MM/yyyy");
    public static SimpleDateFormat fromDataBasetoOutput = new SimpleDateFormat("d-MMM-yyyy", Locale.ENGLISH);

    public static Command of(String[] arg, DataManage dataManage) throws ParseException {
        Command command = null;
        if( dataManage == DataManage.INFO) command = new Info(arg);
        else   if ( dataManage == DataManage.CREATE) command = new Create(arg);
        else   if ( dataManage == DataManage.UPDATE) command = new Update(arg);
        else   if ( dataManage == DataManage.DELETE) command = new Delete(arg);
        return command;
       /* return switch (dataManage){
            case INFO -> new Info(arg);
            case CREATE -> new Create(arg);
            case DELETE -> new Delete(arg);
            case UPDATE -> new Update(arg);
        };*/
    }

   protected Command(){}

   public abstract void doOperation();
}
