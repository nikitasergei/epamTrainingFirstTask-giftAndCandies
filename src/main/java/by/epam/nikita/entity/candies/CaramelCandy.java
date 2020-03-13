package by.epam.nikita.entity.candies;

import org.apache.log4j.Logger;

public class CaramelCandy extends Candy {
    private static final Logger logger = Logger.getLogger(CaramelCandy.class);

    public CaramelCandy() {
        super(200, 225);
        logger.info("Caramel candy created");
    }
}
