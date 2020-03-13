package by.epam.nikita.interfaces;

import by.epam.nikita.entity.candies.Candy;
import by.epam.nikita.entity.gifts.Gift;

import java.util.List;

public interface GiftService {

    boolean addCandyToGift(Gift gift, Candy candy);

    int getTotalGiftWeight(Gift gift);

    List<Candy> getCandiesBySugarWeight(Gift gift, float minSugarWeight, float maxSugarWeight);

    void sortCandiesBySugarWeight(Gift gift);

    void sortCandiesByTotalWeight(Gift gift);
}
