# salestaxes
1. Github setup
2. Create a build script in maven and its default source tree boilerplate (I've in plan to experiment gradle)
3. Adding 3 basic domain objects: Item, Receipt and Tax. I'm not sure that is the "right" model
4. Create the service for the Shopping Basket with method purchase that receive in input the list of items i want purchase 
5. Create a test for Shopping Basket Service
6. Add description and price to Item class
7. Add a test to Shopping Basket Service with "Input 1", the receipt shouldn't be null, the test is red
8. Initialize Receipt in ShoppingBasketService, the test is green
9. try to structure the Receipt class with: list of purchased items, sales taxes and total
10. add an invariant to ShoppingBasketService Input 1: the returned Receipt must have 3 Purchased Items
11. test red: nullpointer, I forgot to initialize the  Receipt:PurchasedItemList. The Receipt exists only if exists its PurchasedItemList(?), so i put in the constructor
12. the test still red but because the returned receipt is empty
13. add 3 fake items to the receipt, the test turn green
14. add invariant for sales taxes and total, with fake result in the Receipt class, the test is green
15. the work is far to be ended, so i need to find another way to turn my test red
16. Add the "Input 2" test case, "Input 1" still green, but the "Input 2" is red 
17. Remove the fake data from ShoppingBasketService, they are not enough to solve our problem, i need something more complex
18. The Receipt to work need the list of purchased items, so I modify the constructor of Receipt class and delete the fake data 
19. The test "input 1" is green, not good!, the "input 2" is red on the sales taxes value, not good! The test are not deep enough, they don't test the content of each single Item, they are limited on the data structure of the Receipt
20. Create an ItemFactory and its test
21. There are differences between Item is used in the Shopping Basket Domain and the PurchasedItem is used in the Receipt context. I prefer to have 2 different classes and perhaps (?) 2 different packages. A refactor is needed
22. Delete ItemFactory, replace with PurchasedItemFactory with a create method that receive an Item in input and return a PurchasedItem and its test class
23. Create test for "book" Item
24. PurchasedItem have a description and a taxedPrice
25. yes PurchasedItem and PurchasedItemFactory must live in the same package to limit the access of other classes to undesired or dangerous data (ie the setter are protected)
26. PurchasedItemFactoryTest for book is green
26. Create a test for "music CD", the test is red. The code doesn't consider different type of taxes.
27. In order to calculate the taxes for each Item I'll use a Strategy design pattern, so Tax is not a Class but an interface implemented by every Strategy in the problem: BasicTax, ExemptTax, ImportDutyTax
28. Each Item must have a Tax, so I put it in the constructor. Fix the code.
29. Added test to each Tax Strategy
30. Modified the behavior of PurchasedItemFactory to consider taxes
31. Added to PurchasedItemFactoryTest the createImportedBoxOfChocolates, green
32. Added to PurchasedItemFactoryTest the createImportedBottleOfPerfume, red!!! I didn't understand the requirement! The ImportDutyTax is additive!
33. I don't know if use an array of taxes in the Item class or to add a Imported flag. The second option is simpler, so I choose to delete Import Duty tax class and add a flag imported to Item. Refactor.
34. The Taxes strategy seems too complicated, I'll refactor later <--!!!
35. I missed the rounding requirement of taxes, so the createImportedBottleOfPerfume test is red, fixed in PurchasedItemFactory
36. The SalesTaxesServiceTests still red due to the wrong value of calculate sales taxes, this need some work
36.1 Refactor of Receipt contains PurchasedItem not Item, the construction of a Receipt is a complex task that need a Factory: ReceiptFactory and the consrtructor of Receipt shouldn't be visible outside the package
36.2 Refactor PurchasedItem to hold the tax on each item value
36.3 Modified PurchasedItemFactory added invariants on taxOnEachItem
36.4 Some problems with rounding strategy, added the Input3 test case in receiptFactory

