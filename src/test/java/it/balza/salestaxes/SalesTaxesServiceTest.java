package it.balza.salestaxes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paolo on 28/04/17.
 */
public class SalesTaxesServiceTest {
  private ShoppingBasketService shoppingBasketService;

  @Before
  public void setUp() throws Exception {
    shoppingBasketService = new ShoppingBasketService();
  }

  @Test
  public void purchaseInput1() throws Exception {
    List<Item> purchasedItems = new ArrayList<Item>();
    Item book = new Item(new ExemptTax());
    book.setDescription("book");
    book.setPrice(12.49d);
    purchasedItems.add(book);
    Item musicCD = new Item(new ExemptTax());
    musicCD.setDescription("music CD");
    musicCD.setPrice(14.99d);
    purchasedItems.add(musicCD);
    Item chocolate = new Item(new BasicTax());
    chocolate.setDescription("chocolate");
    chocolate.setPrice(0.85d);
    purchasedItems.add(chocolate);
    Receipt receipt = shoppingBasketService.purchase(purchasedItems);
    Assert.assertNotNull(receipt);
    Assert.assertEquals(3, receipt.getPurchasedItems().size());
    Assert.assertEquals(1.50d, receipt.getSalesTaxes(), 0.1d);
    Assert.assertEquals(29.83d, receipt.getTotal(), 0.1d);
  }

  @Test
  public void purchaseInput2() throws Exception {
    List<Item> purchasedItems = new ArrayList<Item>();
    Item importedBoxOfChocolate = new Item(new ExemptTax());
    importedBoxOfChocolate.setImported(true);
    importedBoxOfChocolate.setDescription("imported box of chocolate");
    importedBoxOfChocolate.setPrice(10.00d);
    purchasedItems.add(importedBoxOfChocolate);
    Item importedBottleOfPerfume = new Item(new BasicTax());
    importedBottleOfPerfume.setDescription("imported bottle of perfume");
    importedBottleOfPerfume.setImported(true);
    importedBottleOfPerfume.setPrice(47.50d);
    purchasedItems.add(importedBottleOfPerfume);
    Receipt receipt = shoppingBasketService.purchase(purchasedItems);
    Assert.assertNotNull(receipt);
    Assert.assertEquals(2, receipt.getPurchasedItems().size());
    Assert.assertEquals(7.65d, receipt.getSalesTaxes(), 0.1d);
    Assert.assertEquals(65.15d, receipt.getTotal(), 0.1d);
  }

}