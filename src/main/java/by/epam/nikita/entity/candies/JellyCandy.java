package by.epam.nikita.entity.candies;

import org.apache.log4j.Logger;

public class JellyCandy extends Candy {
    private static final Logger logger = Logger.getLogger(JellyCandy.class);

    public JellyCandy()  {
        super(160, 300);
        logger.info("Jelly candy created");
    }
}
