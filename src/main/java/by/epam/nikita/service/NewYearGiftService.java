package by.epam.nikita.service;

import by.epam.nikita.entity.gifts.Gift;
import by.epam.nikita.interfaces.GiftService;
import by.epam.nikita.entity.candies.Candy;
import org.apache.log4j.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NewYearGiftService implements GiftService {

    private static final Logger logger = Logger.getLogger(NewYearGiftService.class);

    /**
     * Method check whether {@param candy} isn't null, return {@code true} if {@param candy} was successfully added to gift,
     * else return (@code false}.
     *
     * @param candy - element whose presence in this collection is to be ensured
     * @return {@code true} if {@param candy} was successfully added to gift.
     * @throws IllegalArgumentException if the {@param candy} is {@code null}.
     **/

    public boolean addCandyToGift(Gift gift, Candy candy) {
        if (candy != null) {
            gift.getCandies().add(candy);
            logger.info("Candy successfully added to gift");
            return true;
        } else {

            throw new IllegalArgumentException();
        }
    }

    /**
     * @return total weight of all candies, witch gift contains, else @return 0.
     **/

    public int getTotalGiftWeight(Gift gift) {
        if (!gift.getCandies().isEmpty()) {
            int giftTotalWeight = 0;
            for (Candy candy : gift.getCandies()) {
                giftTotalWeight = giftTotalWeight + candy.getTotalWeight();
            }
            return giftTotalWeight;
        }
        logger.error("The gift is empty");
        return 0;
    }

    /**
     * @param minSugarWeight - min sugar weight for search
     * @param maxSugarWeight - max sugar weight for search
     * @return List of Candies, which have a sugar content between {@param minSugarWeight} and {@param maxSugarWeight}
     */
    public List<Candy> getCandiesBySugarWeight(Gift gift, float minSugarWeight, float maxSugarWeight) {
        return gift.getCandies().stream()
                .filter(candy -> candy.getSugarWeight() >= minSugarWeight && candy.getSugarWeight() <= maxSugarWeight)
                .collect(Collectors.toList());
    }

    /**
     * Sorts candies in a gift by sugar content.
     */
    public void sortCandiesBySugarWeight(Gift gift) {
        if (gift.getCandies() != null && !gift.getCandies().isEmpty()) {
            gift.getCandies().sort(Comparator.comparingInt(Candy::getSugarWeight));
            logger.info("Candies in a gift sorted successfully");
        } else logger.error("The gift is null or empty");
    }

    /**
     * Sorts candies in a gift by candies total weight
     */

    public void sortCandiesByTotalWeight(Gift gift) {
        if (gift.getCandies() != null && !gift.getCandies().isEmpty()) {
            gift.getCandies().sort(Comparator.comparingInt(Candy::getTotalWeight));
            logger.info("Candies in a gift sorted successfully");
        } else logger.error("The gift is null or empty");
    }
}