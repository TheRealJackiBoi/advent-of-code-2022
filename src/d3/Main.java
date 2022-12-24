package d3;

import d2.Turn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    



    public static void main(String[] args) {
        char[] alphabetLower = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] alphabetUpper = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
        ArrayList<Character> alphabetUpperLower = new ArrayList<>();

        HashMap<Character, Integer> letterPoints = new HashMap<>();

        for (char c :
                alphabetLower) {
            alphabetUpperLower.add(c);
        }
        for (char c :
                alphabetUpper) {
            alphabetUpperLower.add(c);
        }

        for (int i = 0; i < alphabetUpperLower.size(); i++) {
            letterPoints.put(alphabetUpperLower.get(i), i+1);
        }
        System.out.println(letterPoints);
        ArrayList<RuckSackGroup> ruckSacksGroups = loadData(letterPoints);

        int totalVals = 0;
        for (RuckSackGroup r :
                ruckSacksGroups) {
            if (!r.isEmpty()) {
                r.findPriority();
                r.calcValOfPriority(letterPoints);

                System.out.println(r.priority + ": " + r.valOfPrioritiy);
                totalVals += r.valOfPrioritiy;
            }
        }
        System.out.println(totalVals);
    }
    public static ArrayList<RuckSackGroup> loadData(HashMap<Character, Integer> letterPoints) {

        ArrayList<RuckSack> ruckSacks = new ArrayList<>();
        ArrayList<RuckSackGroup> groups = new ArrayList<>();

        try {
            Scanner scn = new Scanner(new File("src/d3/rucksacks.txt"));

            int index = 0;
            groups.add(new RuckSackGroup());
            while (scn.hasNext()) {
                String line = scn.nextLine();
                ruckSacks.add(new RuckSack(line, letterPoints));
                groups.get(index / 3).addRuckSack(ruckSacks.get(index));

                if ((index + 1) % 3 == 0) {
                    groups.add(new RuckSackGroup());
                }

                index += 1;
            }
            scn.close();

        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return groups;
    }
}
