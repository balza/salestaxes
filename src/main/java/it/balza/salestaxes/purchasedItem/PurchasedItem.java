package it.balza.salestaxes.purchasedItem;

/**
 * Created by paolo on 29/04/17.
 */
class PurchasedItem {

  private String description;

  private double taxedPrice;

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
}
