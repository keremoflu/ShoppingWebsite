package customer

import product.Product
import product.Review
import user.UserData

data class Customer(
               var customerID: Int,
               var customerName: String,
               var customerBalance: Double,
               var customerProduct: ArrayList<Product>,
               var customerReview: ArrayList<Review>,
               var customerBasket: ArrayList<Product>){


    constructor(): this(
            0,
            "",
            500.00,
            arrayListOf<Product>(),
            arrayListOf<Review>(),
            arrayListOf<Product>())

    fun createCustomer(customerID: Int, customerName: String,
                       customerBalance: Double):Customer {
        var newCustomer = Customer(customerID,
                customerName,
                customerBalance,
                arrayListOf(),
                arrayListOf(),
                arrayListOf())
        UserData.customerList.add(newCustomer)
                .apply { println("New customer ${newCustomer.customerName} added!") }
        return newCustomer
    }


    fun deleteCustomer(customerID: Int) {

        //Search Customer object by its customerID
        var deletedUser: Customer? = UserData.customerList.find {
            it.customerID == customerID
        }

        //If customerID found, delete.
        if(deletedUser != null){
            UserData.customerList.remove(deletedUser)
            println("Selected customer deleted successfully!")
        }else{
            println("There is no such customer!")
        }

    }

    fun addToBasket(product: Product) {

        //Adding product to shopping card / basket
        customerBasket.add(product)
                .apply { println("${product.productName} added to basket!") }

    }

    fun addReviewToProduct(product: Product,
                           reviewDesc: String,
                            reviewPoint: Double){

        //Adding review ID from last count +1

        Review.createReview(this, product, reviewDesc, reviewPoint)
    }

    fun buyProduct(product: Product){

        //e.g: Product is $100. commission rate goes to system, rest goes to shop owner
        var shopRevenue = 0.0

        if(customerBalance >= product.productPrice){

            // Check balance of customer
            customerProduct.add(product)
            customerBalance -= product.productPrice

            // Revenue share
            shopRevenue = product.productPrice - (product.productPrice * product.productType.comissionRate)
            UserData.shoppingSystemCompanyRevenue += product.productPrice - shopRevenue

            println("Revenue share after buying")
            println("Shop Revenue: $shopRevenue")
            println("Website revenue: ${product.productPrice - shopRevenue}")

            println("log: $customerName purchased ${product.productName}!" +
                    " Current balance is $customerBalance")

            product.productBelongsTo.updateAfterSale(shopRevenue)
            println("log: ${product.productBelongsTo.shopName}" +
                    " earned ${shopRevenue}." +
                    " Total income of shop is " +
                    "${product.productBelongsTo.getShopTotalRevenue()}")
        }else{
            println("Your Balance is not enough to buy this product!")
        }


    }

    fun refundProduct(product: Product){

        if(customerProduct.contains(product)){
            customerProduct.remove(product)
                    .apply {
                        println("Selected ${product.productName} product refunded!")
                    customerBalance += product.productPrice

                    // to refund, call product price with minus
                    var customerShare = product.productPrice - (product.productPrice * product.productType.comissionRate)
                    product.productBelongsTo.addRevenueToShop(-customerShare)

                    UserData.shoppingSystemCompanyRevenue-=product.productPrice-customerShare
                    product.productBelongsTo.printShopInfo()}
        }else{
            println("You can't refund the product you didn't buy yet!")
        }
    }

    override fun toString(): String {
        var basketText: String = "\n"
        for (item in customerBasket.indices){
            basketText+="${item+1} - ${customerBasket[item].productName} \n"
        }

        var productText:String = "\n"
        for(item in customerProduct.indices){
            productText+="${item+1} - ${customerProduct[item].productName} \n"
        }


        var reviewText:String = "\n"
        for(item in customerReview.indices){
            productText+="$item - ${customerReview[item].reviewCustomer} \n"
        }



        return "--- CUSTOMER INFO --- \n" +
                "Customer ID: $customerID \n"+
                "Customer Name: $customerName \n" +
                "Customer Balance: $customerBalance \n" +
                "Customer Basket List:  $basketText \n" +
                "Customer Purchased Product List: $productText\n"+
                "Customer Review List: $reviewText"+
                "----------------------"
    }
}