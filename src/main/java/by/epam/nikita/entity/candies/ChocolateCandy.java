package by.epam.nikita.entity.candies;

import org.apache.log4j.Logger;

public class ChocolateCandy extends Candy {
    private static final Logger logger = Logger.getLogger(ChocolateCandy.class);

    public ChocolateCandy() {
        super(100, 200);
        logger.info("Chocolate candy created");
    }
}
