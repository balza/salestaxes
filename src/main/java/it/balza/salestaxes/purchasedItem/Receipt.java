package it.balza.salestaxes.purchasedItem;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by paolo on 28/04/17.
 */
public class Receipt {

  private List<PurchasedItem> purchasedItems;

  private double salesTaxes;

  private double total;

  protected Receipt() {
    purchasedItems = new ReceiptItems();
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
