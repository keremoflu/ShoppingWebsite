package user

import customer.Customer
import product.Product
import product.Review
import shop.Shop

class UserData{
    companion object{

        //Global lists
        var customerList = ArrayList<Customer>()
        var shopList = ArrayList<Shop>()
        var productList = ArrayList<Product>()
        var allReviewList = ArrayList<Review>() //To fetch shop's review ratio

        var shoppingSystemCompanyRevenue : Double = 0.0
    }

    fun listAllProducts(){

        println("Listing all products exist on shopping website")
        productList.forEach { println("${it.productId} -> ${it.productName}") }

    }
}