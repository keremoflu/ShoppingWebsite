package shop

import product.Product
import user.UserData

data class Shop(var shopID: Int,
                var shopName: String,
                var shopProductList:ArrayList<Product>)

{

    companion object {
        var shopSalesCount: Int = 0
        var shopTotalRevenue: Double = 0.0
    }

    override fun toString(): String {

        var shopProductText: String = "\n"
        for (item in shopProductList.indices){
            shopProductText+="${item+1} - ${shopProductList[item].productName} \n"
        }

        return "Shop ID : $shopID \n"+
               "Shop Name: $shopName\n"+
               "Shop Product List: $shopProductText\n"

    }

    fun addRevenueToShop(revenue: Double){
        shopTotalRevenue+=revenue
    }

    fun updateAfterSale(shopRevenue: Double){
        shopSalesCount++
        shopTotalRevenue += shopRevenue
    }

    fun getShopTotalRevenue() = shopTotalRevenue

    //empty constructor for data class
    constructor(): this(0,"", arrayListOf<Product>())

    fun createShop(shopID: Int, name: String): Shop {
        var emptyProductList = arrayListOf<Product>()

        var shopObject = Shop(shopID, name, emptyProductList)
        this.shopName = name

        //Adding shop to global/companion shopList
        UserData.shopList.add(shopObject)
                .apply { println("log: $name named shop created!") }
        return shopObject
    }



    fun deleteShop(shopID: Int){
        var deletedShop: Shop? =
                UserData.shopList.find {
                    it.shopID == shopID
                }


        if(deletedShop != null){
            UserData.shopList.remove(deletedShop)
            println("Selected shop deleted!")
            println("Current size of shopList: "+UserData.shopList.size)
        }
    }


    fun getShopReviewRatio():Double {
        //Filter all reviews which owns by this shopID reviews
        //And get ratio and count of reviews belongs this shop

        var sumPoint = 0.0
        var count = 0

        for(i in 0 until UserData.allReviewList.size){
            if(UserData.allReviewList[i].reviewProduct.productBelongsTo.shopID ==
                    this.shopID){
                sumPoint += UserData.allReviewList[i].reViewPoint
                count++
            }
        }

        //Calculate average
        println("Average review point of shop is: ${sumPoint/count}")

        return sumPoint/count
    }

    fun addProductToShop(product: Product){
        shopProductList.add(product)
                .apply { println("log: ${product.productName} added to $shopName shop!") }
    }

    fun printShopInfo(){
        //name and product list

        println("$shopName Product List: ")
        println("Shop Name: $shopName +\n" +
                "Shop Total Revenue: ${getShopTotalRevenue()}")
        shopProductList.forEach{ println("${it.productId} -> ${it.productName}") }

    }

    fun printAllShops(){
        //Listing all shops by their IDs and Names
        println("Listing all existing shops")
        UserData.shopList.forEach{
            println("${it.shopID} -> ${it.shopName}")
        }
        //UserData.shopList.forEach(System.out::print)
    }

    fun getShopByID(shopID: Int){
        var filteredList = UserData.shopList.filter { it.shopID == shopID }
        println("Listing selected shops...")
        filteredList.forEach (System.out::print)
    }
}