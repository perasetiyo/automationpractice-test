## Documentaion for test scenario and case

### Searching product

| No  |       Scenario      | No  |      Case       | No  |     Step          |     test data     |       Expected result
| --  |       --------      | --  |      ----       | --  |     ----          |     ---------     |       ---------------
| 1 | Search by specific category                 | 1 | Search by valid product name                                               | 1 | Open Home Page                                        | URL = www.automationpractice.com                   | Specific product should display |
|   |                                             |   |                                                                            | 2 | Input product name in search field                    | keyword = Dress                                    | |
|   |                                             |   |                                                                            | 3 | Click button search                                   |                                                    | |
|   |                                             | 2 | Search category = Dresses                                                  | 1 | Open Home Page                                        | URL = www.automationpractice.com                   | All product should contain name = Dress |
|   |                                             |   |                                                                            | 2 | Click category Dresses in navigation bar              |                                                    | |
| 2 | Filter specific category by price range     | 1 | Category = T-Shirt, specific price range that not contain specific product | 1 | Open Home Page                                        | URL = www.automationpractice.com                   | Should display message "There are no products." |
|   |                                             |   |                                                                            | 2 | Add query in URL, id_category = 5, price = 16.80 - 17 | ?id_category=5&controller=category#/price-16.84-17 | |
|   |                                             | 2 | Category = T-Shirt, specific price range that not contain specific product | 1 | Open Home Page                                        | URL = www.automationpractice.com                   | Total item in filter result should contain valid amount = 0 |
|   |                                             |   |                                                                            | 2 | Add query in URL, id_category = 5, price = 16.80 - 17 | ?id_category=5&controller=category#/price-16.84-17 | |

### Wishlist

| No  |       Scenario      | No  |      Case       | No  |     Step          |     test data     |       Expected result
| --  |       --------      | --  |      ----       | --  |     ----          |     ---------     |       ---------------
| 1 | Add specific product to wishlist | 1 | Add specific product with category = T-Shirt to wihlist | 1 | Open Home Page                                               | URL = www.automationpractice.com                                                                   | In wishlist page, should contain valid product added to wishlist |
|   |                                  |   |                                                         | 2 | Login using registered account                               | email = automationpractice-test01@email.com password = 123456                                      | |
|   |                                  |   |                                                         | 3 | Click category T-Shirt in navigation bar                     |                                                                                                    | |  
|   |                                  |   |                                                         | 4 | Click close sign at pop up message                           |                                                                                                    | | 
|   |                                  |   |                                                         | 5 | Click "Add to wishlist" at product index = 1 in list product | product name = Faded Short Sleeve T-Shirt                                                          | |
|   |                                  |   |                                                         | 6 | Open Wishlist Page                                           | URL = http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist | |

### Cart

| No  |       Scenario      | No  |      Case       | No  |     Step          |     test data     |       Expected result
| --  |       --------      | --  |      ----       | --  |     ----          |     ---------     |       ---------------
| 1 | Add product to cart | 1 | Add specific product with category = Women to cart | 1 | Open Home Page                           | URL = www.automationpractice.com                                                                   | In cart page, should contain valid product name |
|   |                     |   |                                                    | 2 | Login using registered account           | email = automationpractice-test01@email.com password = 123456                                      | |
|   |                     |   |                                                    | 3 | Click category Women in navigation bar   |                                                                                                    | | 
|   |                     |   |                                                    | 4 | Click "Add to cart" at product index = 1 | product name = Faded Short Sleeve T-Shirt                                                          | | 
|   |                     |   |                                                    | 5 | Close modal Cart Information             |                                                                                                    | |
|   |                     |   |                                                    | 6 | Open Cart Page                           | URL = http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist | |

### Checkout

| No  |       Scenario      | No  |      Case       | No  |     Step          |     test data     |       Expected result
| --  |       --------      | --  |      ----       | --  |     ----          |     ---------     |       ---------------
| 1 | Checkout order products in cart | 1 | Use payment "Pay By Bank Wire" | 1 | Open Home Page                                   | URL = www.automationpractice.com                                                                   | Should contain message "Your order on My Store is complete" and should contain valid "Amount" | 
|   |                                 |   |                                | 2 | Login using registered account                   | email = automationpractice-test01@email.com password = 123456                                      | |
|   |                                 |   |                                | 3 | Click category Women in navigation bar           |                                                                                                    | | 
|   |                                 |   |                                | 4 | Click "Add to cart" at product index = 1         | product name = Faded Short Sleeve T-Shirt                                                          | | 
|   |                                 |   |                                | 5 | Close modal Cart Information                     |                                                                                                    | |
|   |                                 |   |                                | 6 | Open Cart Page                                   | URL = http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist | |
|   |                                 |   |                                | 7 | Click "Proceed to checkout" in "Summary" phase   |                                                                                                    | |
|   |                                 |   |                                | 8 | Click "Proceed to checkout" in "Address" phase   |                                                                                                    | |
|   |                                 |   |                                | 9 | Click label agreement                            |                                                                                                    | |
|   |                                 |   |                                | 10 | Click "Proceed to checkout" in "Shipping" phase |                                                                                                    | |
|   |                                 |   |                                | 11 | Click "Pay by Bank Wire" in "Payment" phase     |
|   |                                 |   |                                | 12 | Click "Proceed to checkout" in "Payment" phase  |

