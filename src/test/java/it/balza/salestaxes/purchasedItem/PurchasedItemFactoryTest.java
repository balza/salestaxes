package it.balza.salestaxes.purchasedItem;

import it.balza.salestaxes.BasicTax;
import it.balza.salestaxes.ExemptTax;
import it.balza.salestaxes.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by paolo on 29/04/17.
 */
public class PurchasedItemFactoryTest {
  private PurchasedItemFactory purchasedItemFactory;

  @Before
  public void setUp() throws Exception {
    purchasedItemFactory = new PurchasedItemFactory();
  }

  @Test
  public void createBook() throws Exception {
    Item book = new Item(new ExemptTax());
    book.setDescription("book");
    book.setPrice(12.49);
    PurchasedItem purchasedItem = purchasedItemFactory.create(book);
    Assert.assertNotNull(purchasedItem);
    Assert.assertEquals("book", purchasedItem.getDescription());
    Assert.assertEquals(12.49, purchasedItem.getTaxedPrice(), 0.0001);
    Assert.assertEquals(0, purchasedItem.getTaxOnItem(), 0.0001);
  }

  @Test
  public void createMusicCD() throws Exception {
    Item music = new Item(new BasicTax());
    music.setDescription("music CD");
    music.setPrice(14.99);
    PurchasedItem purchasedItem = purchasedItemFactory.create(music);
    Assert.assertNotNull(purchasedItem);
    Assert.assertEquals("music CD", purchasedItem.getDescription());
    Assert.assertEquals(16.49, purchasedItem.getTaxedPrice(), 0.0001);
    Assert.assertEquals(1.5, purchasedItem.getTaxOnItem(), 0.0001);
  }

  @Test
  public void createImportedBoxOfChocolates() throws Exception {
    Item importedChocolates = new Item(new ExemptTax());
    importedChocolates.setImported(true);
    importedChocolates.setDescription("imported box of chocolates");
    importedChocolates.setPrice(10.00);
    PurchasedItem purchasedItem = purchasedItemFactory.create(importedChocolates);
    Assert.assertNotNull(purchasedItem);
    Assert.assertEquals("imported box of chocolates", purchasedItem.getDescription());
    Assert.assertEquals(10.50, purchasedItem.getTaxedPrice(), 0.0001);
    Assert.assertEquals(0.5, purchasedItem.getTaxOnItem(), 0.0001);
  }

  @Test
  public void createImportedBottleOfPerfume() throws Exception {
    Item importedPerfume = new Item(new BasicTax());
    importedPerfume.setDescription("imported bottle of perfume");
    importedPerfume.setImported(true);
    importedPerfume.setPrice(47.50);
    PurchasedItem purchasedItem = purchasedItemFactory.create(importedPerfume);
    Assert.assertNotNull(purchasedItem);
    Assert.assertEquals("imported bottle of perfume", purchasedItem.getDescription());
    Assert.assertEquals(54.65, purchasedItem.getTaxedPrice(), 0.0001);
    Assert.assertEquals(7.15, purchasedItem.getTaxOnItem(), 0.0001);
  }

}