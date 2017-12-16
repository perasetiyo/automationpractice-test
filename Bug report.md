## Bug report

### 1. Product still display and message "There are no products." not displayed
#### Description
When filtering specific category by price range that not contain specific product, product not in range price still display and message "There are no products." not displayed
#### Context = Searching product

| No  |       Scenario      | Case       | No  |     Step          |     test data     |       Expected result       |     Actual result     |   Severity    |
| --  |       --------      | ----       | --  |     ----          |     ---------     |       ---------------       |     ---------------   |   --------    |
| 1 | Filter specific category by price range     | Category = T-Shirt, specific price range that not contain specific product | 1 | Open Home Page                                        | URL = www.automationpractice.com                   | Should display message "There are no products."             | Product not in range price still display and message "There are no products." not displayed | High |
|   |                                             |                                                                            | 2 | Add query in URL, id_category = 5, price = 16.80 - 17 | ?id_category=5&controller=category#/price-16.84-17 | |


### 2. Total item in filter result contain invalid amount
#### Description
When filtering specific category by price range that not contain specific product, Total item in filter result contain amount = 1
#### Context = Searching product

| No  |       Scenario      | Case       | No  |     Step          |     test data     |       Expected result       |     Actual result     |   Severity    |
| --  |       --------      | ----       | --  |     ----          |     ---------     |       ---------------       |     ---------------   |   --------    |
| 1 | Filter specific category by price range     | Category = T-Shirt, specific price range that not contain specific product | 1 | Open Home Page                                        | URL = www.automationpractice.com                   | Total item in filter result should contain valid amount = 0 | Total item in filter result contain amount = 1                                              | Medium |
|   |                                             |                                                                            | 2 | Add query in URL, id_category = 5, price = 16.80 - 17 | ?id_category=5&controller=category#/price-16.84-17 | |
