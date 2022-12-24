package d2;

public class Turn {

    private char p1;
    private char strat;

    private int result;

    public Turn(char p1, char strat) {
        this.p1 = p1;
        this.strat = strat;
        this.result = calculateResult();
    }

    private int calculateResult() {
        int res = 0;
        char pChoice;


        switch (strat) {
            case 'X':
                switch (p1) {
                    case 'A':
                        pChoice = 'C';
                        res += 3;
                        break;
                    case  'B':
                        pChoice = 'A';
                        res += 1;
                        break;
                    case 'C':
                        pChoice = 'B';
                        res += 2;
                        break;
                }
                break;

            case 'Y':
                switch (p1) {
                    case 'A':
                        pChoice = 'A';
                        res += 1;
                        break;
                    case  'B':
                        pChoice = 'B';
                        res += 2;
                        break;
                    case 'C':
                        pChoice = 'C';
                        res += 3;
                        break;
                }
                break;

            case 'Z':
                switch (p1) {
                    case 'A':
                        pChoice = 'B';
                        res += 2;
                        break;
                    case  'B':
                        pChoice = 'C';
                        res += 3;
                        break;
                    case 'C':
                        pChoice = 'A';
                        res += 1;
                        break;
                }
                break;
        }

        switch (strat) {
            case 'Y' -> res += 3;
            case 'Z' -> res += 6;
        }

        return res;
    }


    public int getResult() {
        return result;
    }
}
