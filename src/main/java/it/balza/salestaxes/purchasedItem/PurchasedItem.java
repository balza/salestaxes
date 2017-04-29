package it.balza.salestaxes.purchasedItem;

/**
 * Created by paolo on 29/04/17.
 */
class PurchasedItem {

  private String description;

  private double taxedPrice;

  private double taxOnItem;

  public String getDescription() {
    return description;
  }

  protected void setDescription(String description) {
    this.description = description;
  }

  public double getTaxedPrice() {
    return taxedPrice;
  }

  protected void setTaxedPrice(double taxedPrice) {
    this.taxedPrice = taxedPrice;
  }

  public double getTaxOnItem() {
    return taxOnItem;
  }

  protected void setTaxOnItem(double taxOnItem) {
    this.taxOnItem = taxOnItem;
  }
}
