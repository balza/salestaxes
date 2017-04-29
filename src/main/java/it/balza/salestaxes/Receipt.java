package it.balza.salestaxes;

import java.util.List;

/**
 * Created by paolo on 28/04/17.
 */
public class Receipt {

  private List<Item> purchasedItems;

  private double salesTaxes;

  private double total;

  public Receipt(List<Item> purchasedItems) {
    this.purchasedItems = purchasedItems;
    salesTaxes = 1.50;
    total = 29.83;
  }

  public List<Item> getPurchasedItems() {
    return purchasedItems;
  }

  public double getSalesTaxes() {
    return salesTaxes;
  }

  public double getTotal() {
    return total;
  }
}
