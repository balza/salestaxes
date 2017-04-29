package it.balza.salestaxes;

import it.balza.salestaxes.ExemptTax;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by paolo on 29/04/17.
 */
public class ExemptTaxTest {
  @Test
  public void calculate() throws Exception {
    ExemptTax exemptTax = new ExemptTax();
    double taxedPrice = exemptTax.calculate(100);
    Assert.assertEquals(0, taxedPrice, 0.1);
  }

}