package it.balza.salestaxes;

import it.balza.salestaxes.purchasedItem.Receipt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paolo on 29/04/17.
 */
public class App {
  public static void main( String[] args )
    {
      ShoppingBasketService shoppingBasketService = new ShoppingBasketService();
      List<Item> shoppingBasketItems = new ArrayList<Item>();
      System.out.println("Output 1");
      Item book = new Item(new ExemptTax());
      book.setDescription("book");
      book.setPrice(12.49);
      shoppingBasketItems.add(book);
      Item musicCD = new Item(new BasicTax());
      musicCD.setDescription("music CD");
      musicCD.setPrice(14.99d);
      shoppingBasketItems.add(musicCD);
      Item chocolateBar = new Item(new ExemptTax());
      chocolateBar.setDescription("chocolate bar");
      chocolateBar.setPrice(0.85d);
      shoppingBasketItems.add(chocolateBar);
      Receipt receipt = shoppingBasketService.purchase(shoppingBasketItems);
      shoppingBasketService.print(receipt);
      System.out.println("Output 2");
      shoppingBasketItems = new ArrayList<Item>();
      Item importedBoxOfChocolates = new Item(new ExemptTax());
      importedBoxOfChocolates.setDescription("imported box of chocolates");
      importedBoxOfChocolates.setPrice(10.00);
      importedBoxOfChocolates.setImported(true);
      shoppingBasketItems.add(importedBoxOfChocolates);
      Item importedBottleOfPerfume = new Item(new BasicTax());
      importedBottleOfPerfume.setDescription("imported bottle of perfume");
      importedBottleOfPerfume.setImported(true);
      importedBottleOfPerfume.setPrice(47.50d);
      shoppingBasketItems.add(importedBottleOfPerfume);
      receipt = shoppingBasketService.purchase(shoppingBasketItems);
      shoppingBasketService.print(receipt);
      System.out.println("Output 3");
      shoppingBasketItems = new ArrayList<Item>();
      Item importedBottleOfPerfume2 = new Item(new BasicTax());
      importedBottleOfPerfume2.setDescription("imported bottle of perfume");
      importedBottleOfPerfume2.setImported(true);
      importedBottleOfPerfume2.setPrice(27.99);
      shoppingBasketItems.add(importedBottleOfPerfume2);
      Item bottleOfPerfume = new Item(new BasicTax());
      bottleOfPerfume.setDescription("bottle of perfume");
      bottleOfPerfume.setPrice(18.99d);
      shoppingBasketItems.add(bottleOfPerfume);
      Item packOfHeadachePills = new Item(new ExemptTax());
      packOfHeadachePills.setDescription("pack of headache pills");
      packOfHeadachePills.setPrice(9.75d);
      shoppingBasketItems.add(packOfHeadachePills);
      Item boxOfImportedChocolates = new Item(new ExemptTax());
      boxOfImportedChocolates.setDescription("box of imported chocolates");
      boxOfImportedChocolates.setPrice(11.25);
      boxOfImportedChocolates.setImported(true);
      shoppingBasketItems.add(boxOfImportedChocolates);
      receipt = shoppingBasketService.purchase(shoppingBasketItems);
      shoppingBasketService.print(receipt);
    }

}
