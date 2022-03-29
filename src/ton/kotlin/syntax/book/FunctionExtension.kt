package ton.kotlin.syntax.book

fun Int.priseTheSun(): String = "We need prise the Sun for $this times!!!"

@JvmName("kolyas")
fun naiki() {
    println("hello $ageOfEmpire")

    val integer = 12
    println(integer.priseTheSun())

}