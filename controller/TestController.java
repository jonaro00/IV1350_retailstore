package controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import integration.ExternalSystemCreator;
import integration.Printer;
import integration.ItemDTO;

public class TestController {
    @Test
    public void testPriceOfMultipleItems() {
        Controller contr = new Controller(new ExternalSystemCreator(), new Printer());
        contr.startSale();

        String testItemID = "Apple";
        int numberOfItems = 5;
        ItemDTO testItem = contr.enterItem(testItemID, 0);
        float testItemTotalPrice = testItem.getPrice() * (1 + testItem.getVAT());
        for (int i = 0; i < numberOfItems; i++)
            contr.enterItem(testItemID, 1);
        float expectedPrice = testItemTotalPrice * numberOfItems;
        float result = contr.getSaleTotal();
        assertEquals(expectedPrice, result, "Incorrect price after adding multiple items");
    }
}
