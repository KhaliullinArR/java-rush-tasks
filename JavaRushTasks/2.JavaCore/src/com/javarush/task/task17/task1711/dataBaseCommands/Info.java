package com.javarush.task.task17.task1711.dataBaseCommands;

import com.javarush.task.task17.task1711.Person;
import com.javarush.task.task17.task1711.Sex;
import com.javarush.task.task17.task1711.Solution;

class Info extends Command {
    private String[] args;

    Info(String[] args) {
        this.args = args;
    }

    @Override
    public void doOperation() {
        Person info;
        for (int i = 1; i < args.length; i++) {
            info = Solution.allPeople.get(Integer.parseInt(args[i]));
            String sex = (info.getSex().equals(Sex.FEMALE)) ? "ж" : "м";
            System.out.printf("%s %s %s\n",info.getName(),sex,fromDataBasetoOutput.format(info.getBirthDate()));
        }

    }
}
