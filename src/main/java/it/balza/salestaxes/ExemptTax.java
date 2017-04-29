package it.balza.salestaxes;

/**
 * Created by paolo on 29/04/17.
 */
public class ExemptTax implements Tax {

  @Override
  public double calculate(double price) {
    return 0;
  }

}
