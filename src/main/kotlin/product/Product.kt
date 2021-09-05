package product

import category.PRODUCTTYPE
import shop.Shop
import user.UserData
import user.UserData.Companion.shopList

class Product(
        var productId : Int,
        var productName: String,
        var productPrice: Double,
        var productDesc: String,
        var productType: PRODUCTTYPE,
        var productBelongsTo: Shop,
        var productReview: ArrayList<Review>,
        var productReviewMap: HashMap<Int,Review>
) {

    init{
       // Adding product to shop's own product
       productBelongsTo.addProductToShop(this)
    }

    //Another type of constructor to create product object
    constructor(productId: Int,
                productName: String,
                productPrice: Double,
                productDesc: String,
                productType: PRODUCTTYPE,
                productBelongsTo: Shop)
            : this( productId,
            productName,
            productPrice,
            productDesc,
            productType,
            productBelongsTo,
            arrayListOf<Review>(),
            hashMapOf<Int,Review>())

    override fun toString(): String {

        var reviewText = "\n"
        for (item in productReview.indices){
            reviewText+="${item+1} -> ${productReview[item].reviewDesc} \n"
        }

        return "--- PRODUCT DETAILS --- \n"+
                "Product ID: $productId \n"+
                "Product Name: $productName \n"+
                "Product Price: $productPrice \n"+
                "Product Desc: $productDesc \n"+
                "Product Type: $productType \n"+
                "Product Belongs To Shop: ${productBelongsTo.shopName}\n"+
                "Product Reviews: $reviewText"
    }
}



fun addProductToList(productList: ArrayList<Product>, product: Product){
    productList.add(product).apply { println("${product.productName} added!") }
}

fun showProductReviews(){
    //Prints all reviews belongs this product
}

