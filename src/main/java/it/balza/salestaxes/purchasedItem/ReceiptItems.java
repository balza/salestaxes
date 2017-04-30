package it.balza.salestaxes.purchasedItem;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by paolo on 30/04/17.
 */
class ReceiptItems extends ArrayList<PurchasedItem> {

  @Override
  public String toString() {
    StringBuilder receiptItems = new StringBuilder();
    for (Iterator iterator = this.iterator(); iterator.hasNext(); ) {
      receiptItems.append(iterator.next());
      if (iterator.hasNext()) {
        receiptItems.append("\n");
      }
    }
    return receiptItems.toString();
  }
}
