package category

enum class PRODUCTTYPE(val get:Int, val comissionRate:Double){
    CLOTH(1, 0.20),
    ELECTRONIC(2,0.025),
    HOME(3,0.18),
    SPORT(4, 0.12),
    BOOK(5, 0.18),
    GIFT(6, 0.22),
    TRAVEL(7, 0.18)

}