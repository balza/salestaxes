package it.balza.salestaxes.purchasedItem;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by paolo on 28/04/17.
 */
public class Receipt {

  private final List<PurchasedItem> purchasedItems;

  private double salesTaxes;

  private double total;

  Receipt() {
    purchasedItems = new ReceiptItems();
    salesTaxes = 0;
    total = 0;
  }

  List<PurchasedItem> getPurchasedItems() {
    return purchasedItems;
  }

  double getSalesTaxes() {
    return salesTaxes;
  }

  double getTotal() {
    return total;
  }

  void setSalesTaxes(double salesTaxes) {
    this.salesTaxes = salesTaxes;
  }

  void setTotal(double total) {
    this.total = total;
  }

  @Override
  public String toString() {
    NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
    DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
    decimalFormat.applyPattern("0.00");
    decimalFormat.setRoundingMode(RoundingMode.FLOOR);
    return
        purchasedItems +
            "\nSales Taxes: " + decimalFormat.format(salesTaxes) +
            "\nTotal: " + decimalFormat.format(total);
  }
}
