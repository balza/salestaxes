package it.balza.salestaxes.purchasedItem;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by paolo on 30/04/17.
 */
public class ReceiptItemsTest {
  @Test
  public void testToString() throws Exception {
    ReceiptItems receiptItems = new ReceiptItems();
    PurchasedItem book = new PurchasedItem();
    book.setDescription("book");
    book.setQuantity(1);
    book.setTaxedPrice(12.49);
    receiptItems.add(book);
    Assert.assertEquals("1 book: 12.49", receiptItems.toString());
  }

  @Test
  public void testToString2() throws Exception {
    ReceiptItems receiptItems = new ReceiptItems();
    PurchasedItem book = new PurchasedItem();
    book.setDescription("book");
    book.setQuantity(1);
    book.setTaxedPrice(12.49);
    receiptItems.add(book);
    PurchasedItem musicCD = new PurchasedItem();
    musicCD.setDescription("music CD");
    musicCD.setQuantity(1);
    musicCD.setTaxedPrice(16.99);
    receiptItems.add(musicCD);
    Assert.assertEquals("1 book: 12.49\n1 music CD: 16.99", receiptItems.toString());
  }

}