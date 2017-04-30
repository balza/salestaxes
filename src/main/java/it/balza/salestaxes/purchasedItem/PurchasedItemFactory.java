package it.balza.salestaxes.purchasedItem;

import it.balza.salestaxes.ImportDutyTax;
import it.balza.salestaxes.Item;

/**
 * Created by paolo on 29/04/17.
 */
class PurchasedItemFactory {

  PurchasedItem create(Item item) {
    PurchasedItem purchasedItem = new PurchasedItem();
    double taxOnItem = item.getTax().calculate(item.getPrice());
    double taxedPrice = item.getPrice() + taxOnItem;
    if (item.isImported()) {
      ImportDutyTax importDutyTax = new ImportDutyTax();
      taxOnItem += importDutyTax.calculate(item.getPrice());
      taxedPrice += importDutyTax.calculate(item.getPrice());
    }
    purchasedItem.setDescription(item.getDescription());
    purchasedItem.setQuantity(item.getQuantity());
    purchasedItem.setTaxOnItem(item.getQuantity() * taxOnItem);
    purchasedItem.setTaxedPrice(item.getQuantity() * taxedPrice);
    return purchasedItem;
  }

}
