package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы
*/

public class Solution {

//    public static FileInputStream fli;






    /*public static int getMaxId(String file) throws IOException {
        int max=0;
        BufferedReader flr = new BufferedReader(new FileReader(file));

        int temp;
        while (flr.ready()){
            temp = Integer.parseInt(flr.readLine().substring(0,7));
            if(temp > max) max = temp;
        }
        flr.close();
        return max;
    }*/

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(System.in));
        String  file = bufferedReader.readLine();

        int max=0;

        try (BufferedReader flr = new BufferedReader(new FileReader(file))) {

            int temp;
            while (flr.ready()) {
                temp = Integer.parseInt(flr.readLine().substring(0, 8).trim());
                if (temp > max) max = temp;
            }
            flr.close();

            try(PrintWriter printWriter = new PrintWriter(new FileWriter(file,true));) {
                String goods = String.format("\n%-8d%-30.30s%-8.8s%-4.4s",max+1,args[1],args[2],args[3]);
                printWriter.write(goods);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }




    }
}
