package d3;

import java.util.HashMap;

public class RuckSackGroup {
    RuckSack r1;
    RuckSack r2;
    RuckSack r3;

    char priority;
    int valOfPrioritiy;

    public RuckSackGroup() {
    }

    public void addRuckSack(RuckSack r) throws Exception {
        if (r1 != null) {
            if (r2 != null) {
                if (r3 != null) {
                    throw new Exception("Trying to add to already filled group");
                }
                else r3 = r;
            }
            else r2 = r;
        }
        else r1 = r;
    }

    public void findPriority() {
        for(char c : r1.getWholeString().toCharArray()) {
            if (r2.getWholeString().contains(Character.toString(c)) && r3.getWholeString().contains(Character.toString(c))) {
                priority = c;
            }
        }
    }

    public int calcValOfPriority(HashMap<Character, Integer> lp) {
        valOfPrioritiy = lp.get(priority);
        return valOfPrioritiy;
    }

    public boolean isEmpty() {
        if (r1 == null) {
            return true;
        }
        else
            return false;
    }
}
