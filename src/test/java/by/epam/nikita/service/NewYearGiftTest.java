package by.epam.nikita.service;

import by.epam.nikita.entity.candies.Candy;
import by.epam.nikita.entity.candies.CaramelCandy;
import by.epam.nikita.entity.candies.ChocolateCandy;
import by.epam.nikita.entity.candies.JellyCandy;
import by.epam.nikita.entity.gifts.Gift;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewYearGiftTest {
    private Gift gift = new Gift();
    private NewYearGiftService service;
    private Candy firstCaramelCandy;
    private Candy secondCaramelCandy;
    private Candy firstJellyCandy;
    private Candy secondJellyCandy;
    private Candy firstChocolateCandy;
    private Candy secondChocolateCandy;


    @BeforeMethod
    public void initEntities() {
        firstCaramelCandy = new CaramelCandy();
        secondCaramelCandy = new CaramelCandy();
        firstJellyCandy = new JellyCandy();
        secondJellyCandy = new JellyCandy();
        firstChocolateCandy = new ChocolateCandy();
        secondChocolateCandy = new ChocolateCandy();
        service = new NewYearGiftService();

    }

    @AfterMethod
    public void cleanGift() {
        gift = new Gift();
    }

    @BeforeGroups


    @Test
    public void giftShouldContainsOneCaramelCandy() {
        service.addCandyToGift(gift, firstCaramelCandy);
        int countOfCandiesWitchGiftContains = gift.getCandies().size();
        Assert.assertEquals(1, countOfCandiesWitchGiftContains);
        Assert.assertEquals(CaramelCandy.class, gift.getCandies().get(0).getClass());
    }

    @Test
    public void shouldThrowsIllegalArgumentException() {
        Assert.assertThrows(IllegalArgumentException.class, () -> service.addCandyToGift(gift, null));
    }

    @Test
    public void shouldReturnCorrectTotalGiftWeight() {
        service.addCandyToGift(gift, firstCaramelCandy);
        service.addCandyToGift(gift, firstChocolateCandy);
        Assert.assertEquals(425, service.getTotalGiftWeight(gift));
    }

    @Test
    public void getTotalWeightMustReturnZero() {
        Assert.assertEquals(0, service.getTotalGiftWeight(gift));
    }

    @Test
    public void shouldReturnCorrectNumberOfCandiesWitchHaveSugarWeightInSpecifiedRange() {
        service.addCandyToGift(gift, firstChocolateCandy);       //100
        service.addCandyToGift(gift, firstCaramelCandy);         //200
        service.addCandyToGift(gift, firstJellyCandy);           //160
        service.addCandyToGift(gift, secondJellyCandy);          //160
        service.addCandyToGift(gift, secondChocolateCandy);      //100
        service.addCandyToGift(gift, secondCaramelCandy);        //200
        Assert.assertEquals(2, service.getCandiesBySugarWeight(gift, 130, 190).size());
    }

    @Test
    public void shouldSortGiftCandiesBySugarWeightInCorrectOrder() {
        service.addCandyToGift(gift, firstChocolateCandy);       //100
        service.addCandyToGift(gift, firstCaramelCandy);         //200
        service.addCandyToGift(gift, firstJellyCandy);           //160
        service.addCandyToGift(gift, secondJellyCandy);          //160
        service.addCandyToGift(gift, secondChocolateCandy);      //100
        service.addCandyToGift(gift, secondCaramelCandy);        //200
        service.sortCandiesBySugarWeight(gift);
        Assert.assertEquals(ChocolateCandy.class, gift.getCandies().get(0).getClass());
        Assert.assertEquals(JellyCandy.class, gift.getCandies().get(2).getClass());
        Assert.assertEquals(CaramelCandy.class, gift.getCandies().get(5).getClass());
    }

    @Test
    public void shouldSortGiftCandiesByTotalWeightInCorrectOrder() {
        service.addCandyToGift(gift, firstChocolateCandy);       //200
        service.addCandyToGift(gift, firstCaramelCandy);         //225
        service.addCandyToGift(gift, firstJellyCandy);           //300
        service.addCandyToGift(gift, secondJellyCandy);          //300
        service.addCandyToGift(gift, secondChocolateCandy);      //200
        service.addCandyToGift(gift, secondCaramelCandy);        //225
        service.sortCandiesByTotalWeight(gift);
        Assert.assertEquals(ChocolateCandy.class, gift.getCandies().get(0).getClass());
        Assert.assertEquals(CaramelCandy.class, gift.getCandies().get(2).getClass());
        Assert.assertEquals(JellyCandy.class, gift.getCandies().get(5).getClass());
    }
}