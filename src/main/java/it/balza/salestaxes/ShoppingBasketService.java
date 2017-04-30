package it.balza.salestaxes;

import it.balza.salestaxes.purchasedItem.Receipt;
import it.balza.salestaxes.purchasedItem.ReceiptFactory;

import java.util.List;

/**
 * Created by paolo on 28/04/17.
 */
class ShoppingBasketService {

  Receipt purchase(List<Item> shoppingBasketItems) {
    return new ReceiptFactory().create(shoppingBasketItems);
  }

  void print(Receipt receipt){
    System.out.println(receipt.toString());
  }

}

