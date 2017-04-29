package it.balza.salestaxes;

import it.balza.salestaxes.BasicTax;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by paolo on 29/04/17.
 */
public class BasicTaxTest {
  @Test
  public void calculate() throws Exception {
    BasicTax basicTax = new BasicTax();
    double taxedPrice = basicTax.calculate(100);
    Assert.assertEquals(10, taxedPrice, 0.1);
  }

}