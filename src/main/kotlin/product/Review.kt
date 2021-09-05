package product

import customer.Customer
import shop.Shop
import user.UserData

class Review(
    var reviewCustomer: Customer,
    var reviewProduct: Product,
    var reviewDesc: String,
    var reViewPoint: Double)
    //Customer, Product, Shop owner of review, Point (4.5 etc) )

{
    companion object{

        fun createReview(customer:Customer,
                         product: Product,
                         desc:String,
                         point:Double){

            // Creating review instance
            var reviewInstance = Review(customer, product, desc, point)



            // Customer should only leave one review to a product
            if(product.productReview.size != 0){
                for(i in 0 until product.productReview.size){

                    if(product.productReview[i].reviewCustomer == customer){
                        println("You already wrote a review for this product!")
                        continue
                    }else{
                        println("success review!")
                        product.productReview.add(reviewInstance)
                        UserData.allReviewList.add(reviewInstance)
                    }
                }
            }else{
                println("success review!")
                product.productReview.add(reviewInstance)
                UserData.allReviewList.add(reviewInstance)
            }

        }

        fun getReviewAverage(product: Product):Double{
            //Getting average point of review list for specific product
            var sum = 0.0
            for(i in 0 until product.productReview.size){
                sum += product.productReview[i].reViewPoint
            }
            return sum / product.productReview.size
        }


    }

}
