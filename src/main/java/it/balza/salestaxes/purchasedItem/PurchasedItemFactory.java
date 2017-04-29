package it.balza.salestaxes.purchasedItem;

import it.balza.salestaxes.ImportDutyTax;
import it.balza.salestaxes.Item;

/**
 * Created by paolo on 29/04/17.
 */
class PurchasedItemFactory {

  PurchasedItem create(Item item) {
    PurchasedItem purchasedItem = new PurchasedItem();
    purchasedItem.setDescription(item.getDescription());
    double taxedPrice = item.getPrice() + item.getTax().calculate(item.getPrice());
    if (item.isImported()) {
      ImportDutyTax importDutyTax = new ImportDutyTax();
      taxedPrice = taxedPrice + importDutyTax.calculate(item.getPrice());
    }
    double roundedTaxedPrice = Math.round(taxedPrice * 20.0) / 20.0;
    purchasedItem.setTaxedPrice(roundedTaxedPrice);
    return purchasedItem;
  }

}
