package d4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Section> sections = loadData();

        int totalFullyContained = 0;
        for (Section s :
                sections) {
            System.out.println(s.firstFirstSec + "-" + s.firstSecondSec + " ; " + s.secondFirstSec + "-" + s.secondSecondSec + ": " + s.isFullyContained + " |    " + s.firstWholeSec + " ; " + s.secondWholeSec);
            if (s.isFullyContained)
                totalFullyContained += 1;
        }
        System.out.println(totalFullyContained);
    }

    public static ArrayList<Section> loadData() {

        ArrayList<Section>  sections = new ArrayList<>();

        try {
            Scanner scn = new Scanner(new File("src/d4/sections.txt"));

            while (scn.hasNext()) {
                String line = scn.nextLine();
                String[] data = line.split(",");

                int[] firstSecs = new int[2];
                String[] strFirstSec = data[0].split("-");
                firstSecs[0] = Integer.parseInt(strFirstSec[0]);
                firstSecs[1] = Integer.parseInt(strFirstSec[1]);

                int[] secondSecs = new int[2];
                String[] strSecondSecs = data[1].split("-");
                secondSecs[0] = Integer.parseInt(strSecondSecs[0]);
                secondSecs[1] = Integer.parseInt(strSecondSecs[1]);

                sections.add(new Section(firstSecs[0],firstSecs[1], secondSecs[0], secondSecs[1] ));
            }
            scn.close();

        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return sections;
    }
}
