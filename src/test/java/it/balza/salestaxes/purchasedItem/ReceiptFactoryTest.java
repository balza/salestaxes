package it.balza.salestaxes.purchasedItem;

import it.balza.salestaxes.BasicTax;
import it.balza.salestaxes.ExemptTax;
import it.balza.salestaxes.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paolo on 29/04/17.
 */
public class ReceiptFactoryTest {
  private ReceiptFactory receiptFactory;

  @Before
  public void setUp() throws Exception {
    receiptFactory = new ReceiptFactory();
  }

  @Test
  public void createInput1() throws Exception {
    ArrayList<Item> shoppingBasketItems = new ArrayList<>();
    Item book = new Item(new ExemptTax());
    book.setQuantity(1);
    book.setDescription("book");
    book.setPrice(12.49);
    shoppingBasketItems.add(book);
    Item musicCD = new Item(new BasicTax());
    musicCD.setDescription("music CD");
    musicCD.setPrice(14.99d);
    musicCD.setQuantity(1);
    shoppingBasketItems.add(musicCD);
    Item chocolateBar = new Item(new ExemptTax());
    chocolateBar.setDescription("chocolate bar");
    chocolateBar.setPrice(0.85d);
    chocolateBar.setQuantity(1);
    shoppingBasketItems.add(chocolateBar);
    Receipt receipt = receiptFactory.create(shoppingBasketItems);
    Assert.assertEquals(3, receipt.getPurchasedItems().size());
    Assert.assertEquals("book", receipt.getPurchasedItems().get(0).getDescription());
    Assert.assertEquals(12.49, receipt.getPurchasedItems().get(0).getTaxedPrice(), 0.0001);
    Assert.assertEquals("music CD", receipt.getPurchasedItems().get(1).getDescription());
    Assert.assertEquals(16.49, receipt.getPurchasedItems().get(1).getTaxedPrice(), 0.0001);
    Assert.assertEquals("chocolate bar", receipt.getPurchasedItems().get(2).getDescription());
    Assert.assertEquals(0.85, receipt.getPurchasedItems().get(2).getTaxedPrice(), 0.0001);
    Assert.assertEquals(1.50d, receipt.getSalesTaxes(), 0.01d);
    Assert.assertEquals(29.83d, receipt.getTotal(), 0.0001d);
  }

  @Test
  public void createInput2() throws Exception {
    List<Item> shoppingBasketItems = new ArrayList<>();
    Item importedBoxOfChocolates = new Item(new ExemptTax());
    importedBoxOfChocolates.setDescription("imported box of chocolates");
    importedBoxOfChocolates.setPrice(10.00);
    importedBoxOfChocolates.setImported(true);
    importedBoxOfChocolates.setQuantity(1);
    shoppingBasketItems.add(importedBoxOfChocolates);
    Item importedBottleOfPerfume = new Item(new BasicTax());
    importedBottleOfPerfume.setDescription("imported bottle of perfume");
    importedBottleOfPerfume.setImported(true);
    importedBottleOfPerfume.setPrice(47.50d);
    importedBottleOfPerfume.setQuantity(1);
    shoppingBasketItems.add(importedBottleOfPerfume);
    Receipt receipt = receiptFactory.create(shoppingBasketItems);
    Assert.assertEquals(2, receipt.getPurchasedItems().size());
    Assert.assertEquals("imported box of chocolates", receipt.getPurchasedItems().get(0).getDescription());
    Assert.assertEquals(10.50, receipt.getPurchasedItems().get(0).getTaxedPrice(), 0.0001);
    Assert.assertEquals("imported bottle of perfume", receipt.getPurchasedItems().get(1).getDescription());
    Assert.assertEquals(54.65, receipt.getPurchasedItems().get(1).getTaxedPrice(), 0.0001);
    Assert.assertEquals(7.65d, receipt.getSalesTaxes(), 0.01d);
    Assert.assertEquals(65.15d, receipt.getTotal(), 0.0001d);
  }

  @Test
  public void createInput3() throws Exception {
    List<Item> shoppingBasketItems = new ArrayList<>();
    Item importedBottleOfPerfume = new Item(new BasicTax());
    importedBottleOfPerfume.setDescription("imported bottle of perfume");
    importedBottleOfPerfume.setImported(true);
    importedBottleOfPerfume.setPrice(27.99);
    importedBottleOfPerfume.setQuantity(1);
    shoppingBasketItems.add(importedBottleOfPerfume);
    Item bottleOfPerfume = new Item(new BasicTax());
    bottleOfPerfume.setDescription("bottle of perfume");
    bottleOfPerfume.setPrice(18.99d);
    bottleOfPerfume.setQuantity(1);
    shoppingBasketItems.add(bottleOfPerfume);
    Item packOfHeadachePills = new Item(new ExemptTax());
    packOfHeadachePills.setDescription("pack of headache pills");
    packOfHeadachePills.setPrice(9.75d);
    packOfHeadachePills.setQuantity(1);
    shoppingBasketItems.add(packOfHeadachePills);
    Item boxOfImportedChocolates = new Item(new ExemptTax());
    boxOfImportedChocolates.setDescription("box of imported chocolates");
    boxOfImportedChocolates.setPrice(11.25);
    boxOfImportedChocolates.setImported(true);
    boxOfImportedChocolates.setQuantity(1);
    shoppingBasketItems.add(boxOfImportedChocolates);
    Receipt receipt = receiptFactory.create(shoppingBasketItems);
    Assert.assertEquals(4, receipt.getPurchasedItems().size());
    Assert.assertEquals("imported bottle of perfume", receipt.getPurchasedItems().get(0).getDescription());
    Assert.assertEquals(32.19, receipt.getPurchasedItems().get(0).getTaxedPrice(), 0.0001);
    Assert.assertEquals("bottle of perfume", receipt.getPurchasedItems().get(1).getDescription());
    Assert.assertEquals(20.89, receipt.getPurchasedItems().get(1).getTaxedPrice(), 0.0001);
    Assert.assertEquals("pack of headache pills", receipt.getPurchasedItems().get(2).getDescription());
    Assert.assertEquals(9.75, receipt.getPurchasedItems().get(2).getTaxedPrice(), 0.0001);
    Assert.assertEquals("box of imported chocolates", receipt.getPurchasedItems().get(3).getDescription());
    Assert.assertEquals(11.85, receipt.getPurchasedItems().get(3).getTaxedPrice(), 0.0001);
    Assert.assertEquals(6.70d, receipt.getSalesTaxes(), 0.01d);
    Assert.assertEquals(74.68d, receipt.getTotal(), 0.0001d);
  }

}