package it.balza.salestaxes.purchasedItem;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by paolo on 29/04/17.
 */
class PurchasedItem {

  private int quantity;

  private String description;

  private double taxedPrice;

  private double taxOnItem;

  void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  String getDescription() {
    return description;
  }

  void setDescription(String description) {
    this.description = description;
  }

  double getTaxedPrice() {
    return taxedPrice;
  }

  void setTaxedPrice(double taxedPrice) {
    this.taxedPrice = taxedPrice;
  }

  double getTaxOnItem() {
    return taxOnItem;
  }

  void setTaxOnItem(double taxOnItem) {
    this.taxOnItem = taxOnItem;
  }

  @Override
  public String toString() {
    NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
    DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
    decimalFormat.applyPattern("0.00");
    decimalFormat.setRoundingMode(RoundingMode.FLOOR);
    return
        quantity + " " + description + ": " + decimalFormat.format(taxedPrice);
  }
}
