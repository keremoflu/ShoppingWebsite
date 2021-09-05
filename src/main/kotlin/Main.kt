import category.PRODUCTTYPE
import customer.Customer
import product.Product
import product.Review
import shop.Shop
import user.UserData
import java.util.*


fun main(args: Array<String>){
    /*
    Kerem Oflu - 05.09.2021 - github.com/keremoflu
     */

    //Creating shops / sellers
    var istanbulGiftShop = Shop().createShop(1,"Istanbul Gift Shop")

    //Creating customer
    var customer1 = Customer().createCustomer(
            1,
            "Kerem Oflu",
            12000.0)

    var customer2 = Customer().createCustomer(
            2,
            "Ahmet",
            1500.0
    )

    //Creating product
    var product1 = Product(
            1,
            "Cappadocia Poster",
            100.0,
            "A gift from my Cappadocia Trip",
            PRODUCTTYPE.TRAVEL, //enum type
            istanbulGiftShop //owner of this product set as istanbulGiftShop
    )

    // Customer buys a product
    customer1.buyProduct(product1)

    // Adding review to product
    customer1.addReviewToProduct(product1, "Nice quality poster!", 5.0)
    customer2.addReviewToProduct(product1, "nahhh!", 2.0)

    // Get some details
    println(product1.toString()) //product details
    println(customer1.toString()) //customer details
    println(product1.productBelongsTo.getShopTotalRevenue()) //shop revenue
    println(product1.productBelongsTo.getShopReviewRatio()) //average review ratio of shop
    println("Website Revenue: "+UserData.shoppingSystemCompanyRevenue) //website revenue

    // Refund product
    customer1.refundProduct(product1)
    // Delete customer by ID
    customer1.deleteCustomer(1)


}