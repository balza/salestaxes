package it.balza.salestaxes.purchasedItem;

import it.balza.salestaxes.Item;
import it.balza.salestaxes.purchasedItem.PurchasedItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paolo on 28/04/17.
 */
public class Receipt {

  private List<PurchasedItem> purchasedItems;

  private double salesTaxes;

  private double total;

  protected Receipt() {
    purchasedItems = new ArrayList<PurchasedItem>();
    salesTaxes = 0;
    total = 0;
  }

  public List<PurchasedItem> getPurchasedItems() {
    return purchasedItems;
  }

  public double getSalesTaxes() {
    return salesTaxes;
  }

  public double getTotal() {
    return total;
  }

  protected void setSalesTaxes(double salesTaxes) {
    this.salesTaxes = salesTaxes;
  }

  protected void setTotal(double total) {
    this.total = total;
  }
}
