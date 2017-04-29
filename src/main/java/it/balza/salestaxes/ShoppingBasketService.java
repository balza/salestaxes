package it.balza.salestaxes;

import it.balza.salestaxes.purchasedItem.Receipt;
import it.balza.salestaxes.purchasedItem.ReceiptFactory;

import java.util.List;

/**
 * Created by paolo on 28/04/17.
 */
public class ShoppingBasketService {

  Receipt purchase(List<Item> shoppingBasketItems) {
    Receipt receipt = new ReceiptFactory().create(shoppingBasketItems);
    return receipt;
  }

}

