package d1;

import java.util.ArrayList;

public class Elf {
    private int id;
    private ArrayList<Integer> food;

    private int totalCalories;

    public Elf(int id, ArrayList<Integer> food) {
        this.id = id;
        this.food = food;
        for (Integer i :
                this.food) {
            totalCalories += i;
        }
    }

    public int getId() {
        return id;
    }

    public int getTotalCalories() {
        return totalCalories;
    }
}
