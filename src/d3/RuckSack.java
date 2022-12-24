package d3;

import java.util.HashMap;

public class RuckSack {

    private String wholeString;
    private String firstHalf;
    private String secondHalf;
    private char sameChar;
    private int val;

    public RuckSack(String wholeString, HashMap<Character, Integer> letterPoints) {
        this.wholeString = wholeString;
        int mid = wholeString.length() / 2;
        String[] parts = {wholeString.substring(0, mid),wholeString.substring(mid)};
        this.firstHalf = parts[0];
        this.secondHalf = parts[1];
        findSimilarities();
        if (sameChar == 0) {
            val = 0;
        }else {
            val = letterPoints.get(sameChar);
        }
    }

    //TODO: create find same type()
    public void findSimilarities() {
        for (char c :
                firstHalf.toCharArray()) {
            for (char d:
                 secondHalf.toCharArray()) {
                if (c == d) {
                    sameChar = c;
                    return;
                }
            }
        }
    }

    public int getVal() {
        return val;
    }

    public char getSameChar() {
        return sameChar;
    }

    public String getWholeString() {
        return wholeString;
    }
}
