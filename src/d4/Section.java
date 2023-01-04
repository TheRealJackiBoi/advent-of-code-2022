package d4;

import java.util.ArrayList;

public class Section {
    int firstFirstSec;
    int firstSecondSec;
    int secondFirstSec;
    int secondSecondSec;

    ArrayList<Integer> firstWholeSec = new ArrayList<>();
    ArrayList<Integer> secondWholeSec = new ArrayList<>();

    boolean isFullyContained = false;

    public Section(int firstFirstSec, int firstSecondSec, int secondFirstSec, int secondSecondSec) {
        this.firstFirstSec = firstFirstSec;
        this.firstSecondSec = firstSecondSec;
        this.secondFirstSec = secondFirstSec;
        this.secondSecondSec = secondSecondSec;
        makeFirstSec();
        makeSecondSec();
        calcIsFullyContained();
    }


    private void makeFirstSec() {
        for (int i = firstFirstSec; i <= firstSecondSec ; i++) {
            firstWholeSec.add(i);
        }
    }

    private void makeSecondSec() {
        for (int i = secondFirstSec; i <= secondSecondSec ; i++) {
            secondWholeSec.add(i);
        }
    }

    private void calcIsFullyContained() {
        if (firstWholeSec.size() > secondWholeSec.size()) {
            for (Integer i :
                    secondWholeSec) {
                if (firstWholeSec.contains(i)) {
                    isFullyContained = true;
                    break;
                }

            }
        }
        else {
                for (Integer i :
                        firstWholeSec) {
                    if (secondWholeSec.contains(i)) {
                        isFullyContained = true;
                        break;

                }
                }
            }
    }

}
