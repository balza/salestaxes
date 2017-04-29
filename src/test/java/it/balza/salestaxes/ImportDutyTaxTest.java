package it.balza.salestaxes;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by paolo on 29/04/17.
 */
public class ImportDutyTaxTest {
  @Test
  public void calculate() throws Exception {
    ImportDutyTax importDutyTax = new ImportDutyTax();
    double taxedPrice = importDutyTax.calculate(100);
    Assert.assertEquals(5, taxedPrice, 0.1);
  }

}