package it.balza.salestaxes.purchasedItem;

import it.balza.salestaxes.Item;

import java.util.List;

/**
 * Created by paolo on 29/04/17.
 */
public class ReceiptFactory {

  public Receipt create(List<Item> shoppingBasketItems) {
    Receipt receipt = new Receipt();
    double total = 0;
    double salesTaxes = 0;
    for (Item shoppingBasketItem : shoppingBasketItems) {
      PurchasedItem purchasedItem = new PurchasedItemFactory().create(shoppingBasketItem);
      total += purchasedItem.getTaxedPrice();
      salesTaxes += purchasedItem.getTaxOnItem();
      receipt.getPurchasedItems().add(purchasedItem);
    }
    receipt.setSalesTaxes(Math.round(salesTaxes * 100.0) / 100.0);
    receipt.setTotal(Math.round(total * 100.0) / 100.0);
    return receipt;
  }
}
