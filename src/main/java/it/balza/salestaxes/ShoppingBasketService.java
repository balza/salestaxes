package it.balza.salestaxes;

import java.util.List;

/**
 * Created by paolo on 28/04/17.
 */
public class ShoppingBasketService {

  Receipt purchase(List<Item> purchasedItems) {
    return new Receipt(purchasedItems);
  }

}

