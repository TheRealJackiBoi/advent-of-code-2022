package d2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int totalResult = 0;
        for (Turn t :
                loadData()) {
            totalResult += t.getResult();
        }
        System.out.println(totalResult);
    }



    public static ArrayList<Turn> loadData() {

        ArrayList<Turn> turns = new ArrayList<>();

        try {
            Scanner scn = new Scanner(new File("src/d2/turns.txt"));

            while (scn.hasNext()) {
                String line = scn.nextLine();
                String[] data = line.split(" ");
                turns.add(new Turn(data[0].charAt(0), data[1].charAt(0)));
            }
            scn.close();

        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        return turns;
    }
}
