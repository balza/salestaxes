package it.balza.salestaxes;

/**
 * Created by paolo on 29/04/17.
 */
public class ImportDutyTax implements Tax {
  private static final double TAX = 0.05;

  @Override

  public double calculate(double price) {
    return Math.ceil(price * TAX * 20.0) / 20.0;
  }
}
