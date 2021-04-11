package com.javarush.task.task17.task1710.dataBaseCommands;

import com.javarush.task.task17.task1710.Person;
import com.javarush.task.task17.task1710.Solution;

class Delete extends Command {
    private final String[] args;


    Delete(String[] args) throws NumberFormatException {
        this.args = args;
    }

    @Override
    public void doOperation() {
        Person person;
        for (int i = 1; i < args.length; i++) {
            person = Solution.allPeople.get(Integer.parseInt(args[i]));
            person.setSex(null);
            person.setBirthDate(null);
            person.setName(null);
        }
    }
}
