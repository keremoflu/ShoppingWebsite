## Shopping System for Kotlin Training

> Creating shop/seller

  `var istanbulGiftShop = Shop().createShop(1,"Istanbul Gift Shop")`

> Creating customer

  `var customer1 = Customer().createCustomer(
            1,
            "Kerem Oflu",
            12000.0)`

> Creating product

`var product1 = Product( 1,
            "Cappadocia Poster",
            100.0,
            "A gift from my Cappadocia Trip",
            PRODUCTTYPE.TRAVEL,
            istanbulGiftShop) `
            
> Customer buys a product

`customer1.buyProduct(product1)  `       

> Adding review to product

`customer1.addReviewToProduct(product1, "Nice quality poster!", 5.0)
customer2.addReviewToProduct(product1, "I didn't like shipping delay.", 2.0)`

> Get some details

### Product details
`println(product1.toString())`

            
