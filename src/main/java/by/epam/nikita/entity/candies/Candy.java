package by.epam.nikita.entity.candies;

import org.apache.log4j.Logger;

public abstract class Candy {
    private static final Logger logger = Logger.getLogger(Candy.class);

    private int sugarWeight;
    private int totalWeight;

    Candy(int sugarWeight, int totalWeight) {
        if (sugarWeight > totalWeight) {
            throw new IllegalArgumentException("Wrong relation sugarWeight and totalWeight");
        } else
            this.sugarWeight = sugarWeight;
        this.totalWeight = totalWeight;
    }

    protected Candy() {
    }

    public int getSugarWeight() {
        return sugarWeight;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "sugarWeight=" + sugarWeight +
                ", totalWeight=" + totalWeight +
                '}';
    }
}
