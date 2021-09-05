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
            100.0,<br/><br/><br/>
            "A gift from my Cappadocia Trip",
            PRODUCTTYPE.TRAVEL, //enum type
            istanbulGiftShop //owner of this product set as istanbulGiftShop)`
            
