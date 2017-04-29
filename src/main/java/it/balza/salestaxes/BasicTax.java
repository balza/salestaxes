package it.balza.salestaxes;

/**
 * Created by paolo on 29/04/17.
 */
public class BasicTax implements Tax {
  private static final double TAX = 0.1;

  @Override
  public double calculate(double price) {
    return Math.round(price * TAX * 20.0) / 20.0;
  }
}
