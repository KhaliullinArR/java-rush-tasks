package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(System.in));
        String  file = bufferedReader.readLine();

        ArrayList<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready())data.add(reader.readLine());
        }

        if(args[0].equals("-u")){
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(file))){
                for (int i = 0; i < data.size(); i++) {
                    if(data.get(i).substring(0,8).trim().equals(args[1])){
                        String goods = String.format("%-8.8s%-30.30s%-8.8s%-4.4s",args[1],args[2],args[3],args[4]);
                        printWriter.write(goods);
                    }else printWriter.write(data.get(i));
                    if(!(i == data.size()-1))printWriter.write(System.lineSeparator());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(args[0].equals("-d")){
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(file))){
                for (int i = 0; i < data.size(); i++) {
                    if(data.get(i).substring(0,8).trim().equals(args[1]))continue;
                    else printWriter.write(data.get(i));
                    if(!(i == data.size()-1))printWriter.write(System.lineSeparator());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else System.out.println("Wrong command");

    }
}
