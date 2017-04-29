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
    double taxOnItem = item.getTax().calculate(item.getPrice());
    double taxedPrice = item.getPrice() + taxOnItem;
    if (item.isImported()) {
      ImportDutyTax importDutyTax = new ImportDutyTax();
      taxedPrice += importDutyTax.calculate(item.getPrice());
      taxOnItem += importDutyTax.calculate(item.getPrice());
    }
    purchasedItem.setTaxOnItem(round(taxOnItem));
    purchasedItem.setTaxedPrice(round(taxedPrice));
    return purchasedItem;
  }

  private double round(double num){
    return Math.round(num * 20.0) / 20.0;
  }

}
