package it.balza.salestaxes;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by paolo on 29/04/17.
 */
public class ImportDutyTaxTest {

  @Test
  public void calculateImport() throws Exception {
    ImportDutyTax importDutyTax = new ImportDutyTax();
    double taxedPrice = importDutyTax.calculate(10);
    Assert.assertEquals(10.5, 10 + taxedPrice, 0.0001);
  }

  @Test
  public void calculateBasicAndImport() throws Exception {
    ImportDutyTax importDutyTax = new ImportDutyTax();
    double taxedPrice = importDutyTax.calculate(27.99);
    BasicTax basicTax = new BasicTax();
    Assert.assertEquals(32.19, 27.99 + basicTax.calculate(27.99) + taxedPrice, 0.0001);
  }

}