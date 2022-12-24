package d1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        //load data from calories.txt
        ArrayList<Elf> elves = loadData();

        Elf maxElf = findMaxElf(elves);
        Elf secondMaxElf = findLowerMaxElf(maxElf, elves);
        Elf thirdMaxElf = findLowerMaxElf(secondMaxElf, elves);

        System.out.println("Total kcal of top 3 elves: " + (maxElf.getTotalCalories() + secondMaxElf.getTotalCalories() + thirdMaxElf.getTotalCalories()));
    }

    public static Elf findMaxElf(ArrayList<Elf> elves) {
        int maxIndex = 0;
        for (int i = 0; i < elves.size(); i++) {
            Elf currElf = elves.get(i);
            System.out.println("id: " + currElf.getId() + " kcal: " + currElf.getTotalCalories());
            if (currElf.getTotalCalories() > elves.get(maxIndex).getTotalCalories()) {
                maxIndex = i;
            }
        }
        return elves.get(maxIndex);
    }

    public static Elf findLowerMaxElf(Elf maxElf, ArrayList<Elf> elves) {
        int maxIndex = 0;
        for (int i = 0; i < elves.size(); i++) {
            Elf currElf = elves.get(i);
            System.out.println("id: " + currElf.getId() + " kcal: " + currElf.getTotalCalories());
            if (currElf.getTotalCalories() > elves.get(maxIndex).getTotalCalories() && currElf.getTotalCalories() < maxElf.getTotalCalories()) {
                maxIndex = i;
            }
        }
        return elves.get(maxIndex);
    }

    public static ArrayList<Elf> loadData() {
        ArrayList<Elf> elves = new ArrayList<>();
        ArrayList<ArrayList<Integer>> calories = new ArrayList<>();

        try {
            Scanner scn = new Scanner(new File("src/d1/calories.txt"));

            int i = 0;
            calories.add(new ArrayList<>());
            while (scn.hasNext()) {
                String line = scn.nextLine();
                //check if new elf
                if(line.equals("")) {
                    i++;
                    calories.add(new ArrayList<>());
                }
                else {
                    calories.get(i).add(Integer.parseInt(line));
                }
            }
            scn.close();

        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        for (int i = 0; i < calories.size(); i++){
            elves.add(new Elf(i + 1, calories.get(i)));
        }
        return elves;
    }
}
