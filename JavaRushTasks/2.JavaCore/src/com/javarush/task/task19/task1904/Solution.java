package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        /*PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(new Scanner(System.in));
        System.out.println(personScannerAdapter.read());*/
    }

    public static class PersonScannerAdapter implements PersonScanner {
       private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] person = (fileScanner.nextLine()).split(" ");
            String date = person[3]+" "+person[4]+" "+person[5];
            Date date1 = null;
            try {
                date1 = new SimpleDateFormat("d MM yyyy").parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return new Person(person[1],person[2],person[0],date1);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
//    String firstName, String middleName, String lastName, Date birthDate)
//Иванов Иван Иванович 31 12 1950