package it.balza.salestaxes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by paolo on 28/04/17.
 */
public class SalesTaxesServiceTest {
    private SalesTaxesService salesTaxesService;

    @Before
    public void setUp() throws Exception {
        salesTaxesService = new SalesTaxesService();
    }

    @Test
    public void purchaseNothing() throws Exception {
        Receipt receipt = salesTaxesService.purchase(null);
        Assert.assertNull(receipt);
    }

}