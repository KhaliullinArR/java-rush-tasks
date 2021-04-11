package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f1 = new BufferedReader( new FileReader(bufferedReader.readLine()));
        BufferedReader f2 = new BufferedReader(new FileReader(bufferedReader.readLine()))) {

            List<String> list1 = f1.lines().collect(Collectors.toCollection(ArrayList::new));
            List<String> list2 = f2.lines().collect(Collectors.toCollection(ArrayList::new));

            int k = 0,i = 0;
            try {
                while (true) {

                    if (list1.get(i).equals(list2.get(k))) {
                            lines.add(new LineItem(Type.SAME, list1.get(i)));
                            i++;
                            k++;
                            if(i+1>list1.size())throw new IndexOutOfBoundsException("1");

                    } else if (list1.get(i).equals(list2.get(k + 1))) {
                        lines.add(new LineItem(Type.ADDED, list2.get(k)));
                        k++;
                    } else {
                        lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                        i++;
                    }

                }
            } catch (IndexOutOfBoundsException e) {
//                lines.add(new LineItem(Type.REMOVED, list1.get(list1.size() - 1)));
                if(!e.getMessage().equals("1")) {
                    try {
                        if (list1.get(i + 1).equals(list2.get(k))) {
                            lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                            lines.add(new LineItem(Type.SAME, list1.get(i + 1)));
                        }
                    } catch (Exception exception) {
                        lines.add(new LineItem(Type.REMOVED, list1.get(list1.size() - 1)));
                    }
                }else {
                    try {
                        LineItem lineItem = new LineItem(Type.ADDED,list2.get(k));
                        lines.add(lineItem);
                    } catch (Exception exception) {
                    }
                }
            }

          /*  D:\Projects\IDEA_PROJECTS\JavaRushTasks\2.JavaCore\src\com\javarush\task\task19\task1916\text1
            D:\Projects\IDEA_PROJECTS\JavaRushTasks\2.JavaCore\src\com\javarush\task\task19\task1916\text2 */




        } catch (IOException e) {
            e.printStackTrace();
        }

        lines.forEach(x-> System.out.println(x.type+" "+x.line));
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
