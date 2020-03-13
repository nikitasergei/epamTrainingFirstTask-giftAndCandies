package by.epam.nikita.entity.gifts;

import by.epam.nikita.entity.candies.Candy;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class Gift {

    private final static Logger logger = Logger.getLogger(Gift.class);

    private List<Candy> candies = new LinkedList<>();

    public List<Candy> getCandies() {
        return candies;
    }

    public void setCandies(List<Candy> candies) {
        this.candies = candies;
    }
}
