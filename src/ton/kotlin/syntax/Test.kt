package ton.kotlin.syntax

fun main() {

    val shalom = Shalom(name = "kika", surname = "shmak", age = 23)
    val sina = Shalom("ton", "digidon", age = 24)
    shalom.childern.add(sina)

    shalom.childern.forEach { println(it)}

    Shalom("kisa")

    val rectangle = Rectangle(14.3, 11.3)
    val rectangle2 = Rectangle(14.3, 11.3)
    println(rectangle.equals(rectangle2))
}