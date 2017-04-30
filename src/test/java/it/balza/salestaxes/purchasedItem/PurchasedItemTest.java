package it.balza.salestaxes.purchasedItem;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by paolo on 30/04/17.
 */
public class PurchasedItemTest {

  @Test
  public void testToString() throws Exception {
    PurchasedItem purchasedItem = new PurchasedItem();
    purchasedItem.setQuantity(1);
    purchasedItem.setTaxOnItem(1.99);
    purchasedItem.setDescription("book");
    purchasedItem.setTaxedPrice(15.9999);
    Assert.assertEquals("1 book: 15.99" , purchasedItem.toString());
  }

  @Test
  public void testToString2() throws Exception {
    PurchasedItem purchasedItem = new PurchasedItem();
    purchasedItem.setQuantity(1);
    purchasedItem.setTaxOnItem(1.99);
    purchasedItem.setDescription("book");
    purchasedItem.setTaxedPrice(15.9);
    Assert.assertEquals("1 book: 15.90" , purchasedItem.toString());
  }

}