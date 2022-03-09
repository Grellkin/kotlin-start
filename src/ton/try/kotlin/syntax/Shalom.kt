package ton.`try`.kotlin.syntax

class Shalom(val name: String, val surname: String = "vonuchaya", var age: Int) {
    var childern: MutableList<Shalom> = mutableListOf()

    //this runs after primary constructor
    init {
        println("Surname of this shalom is $surname")
    }

    constructor(utka: String): this(utka, "kikovna", 12) {
        println("Recursiya!")
        childern.add(Shalom("ban", age = 44))

    }

    override fun toString(): String {
        return "Shalom(name='$name', surname='$surname', age=$age)"
    }


}