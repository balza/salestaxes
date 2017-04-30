package it.balza.salestaxes.purchasedItem;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by paolo on 30/04/17.
 */
public class ReceiptTest {
  @Test
  public void testToString() throws Exception {
    Receipt receipt = new Receipt();
    receipt.setTotal(15.999999);
    receipt.setSalesTaxes(15.999999);
    Assert.assertEquals("[]\nSales Taxes: 15.99\nTotal: 15.99",receipt.toString());
  }

  @Test
  public void testToString2() throws Exception {
    Receipt receipt = new Receipt();
    receipt.setTotal(15.9);
    receipt.setSalesTaxes(15.9);
    Assert.assertEquals("[]\nSales Taxes: 15.90\nTotal: 15.90",receipt.toString());
  }

}