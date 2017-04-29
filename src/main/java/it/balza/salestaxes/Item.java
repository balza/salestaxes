package it.balza.salestaxes;

import it.balza.salestaxes.Tax;

/**
 * Created by paolo on 28/04/17.
 */
public class Item {

  private String description;

  private double price;

  private Tax tax;

  private boolean imported;

  public Item(Tax tax) {
    this.tax = tax;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public double getPrice() {
    return price;
  }

  public Tax getTax() {
    return this.tax;
  }

  public boolean isImported() {
    return imported;
  }

  public void setImported(boolean imported) {
    this.imported = imported;
  }
}
