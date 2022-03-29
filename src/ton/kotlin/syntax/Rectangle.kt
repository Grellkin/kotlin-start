package ton.kotlin.syntax

data class Rectangle(var length: Double, var height: Double) {
    var perimetr = (length + length + height + height)

    var weight = 12
        get() = field + 2   //this на поле
        set(value) {
            if (value > 25) println("Too much, take less")
            else field = value
        }

}