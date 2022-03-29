package ton.kotlin.syntax.book

import java.time.LocalDate
import java.util.*
import java.util.stream.Collectors
import kotlin.random.Random
import kotlin.reflect.KClass


interface Animal {
    fun grow(size: Int)
    fun eat(food: String)
}

class Dog(var age: Int = 1) : Animal {

    override fun grow(size: Int) {
        age += size
        println("Dog is growing up! Now it`s $age years old")
    }

    override fun eat(food: String) {
        println("I`m dog and I`m eating $food")
    }

    fun bark(): String = "Hello it`s me, $age aged dog"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Dog) return false

        if (age != other.age) return false

        return true
    }

    override fun hashCode(): Int {
        return age
    }


}

class Cow(var amountOfMilk: Int = 5) : Animal {
    override fun grow(size: Int) {
        amountOfMilk *= size
        println("Cow is getting more milk!")
    }

    override fun eat(food: String) {
        println("Cow is eating grass mmm, not interested in $food")
    }

    fun giveMilk(): String = "I give you milk $amountOfMilk liters"
}

fun testAnimal(animal: Animal) {
    val result = when (animal) {
        is Dog -> animal.bark()
        is Cow -> animal.giveMilk()
        else -> throw RuntimeException("Animal of unknown kind")
    }

    println(result)
}


class Antimage(pet: Animal, age: Int) {

}


fun String?.aKikaMoetsa(): String {
    if (this == null) {
        return "NE MOETSA"
    }
    if (this.length > 3) {
        return "PLOHO MOETSA"
    }
    return "MOETSA"
}

operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
    object : Iterator<LocalDate> {

        var current = start

        override fun hasNext(): Boolean {
           return current < endInclusive
        }

        override fun next(): LocalDate {
            current = current.plusDays(1);
            return current
        }

    }

fun main() {
    val closedRange = LocalDate.now()..LocalDate.now().plusDays(2)

    for (d in closedRange) {
        println(d.dayOfMonth)
    }


    var kiki: List<Int?>? = mutableListOf();

    var kiks: String? = null

    val nullOrBlank = kiks.isNullOrBlank()

    println(kiks.aKikaMoetsa())

    testAnimal(Cow(12))

    val kClass: KClass<out Cow> = Cow(11)::class

    val treeMap = TreeMap<String, Int>()
    treeMap["Privet"] = 12

    val listRes = treeMap.entries.stream().map { e -> e.value }.filter { v -> v % 2 == 0 }
        .collect(Collectors.toList())


    val cow = Cow(12).apply { grow(2) }
    println(cow.giveMilk())


    listRes.joinToString(separator = "-", transform = { v -> v.toString() })

    var shalom = { v: Int -> v % 12 }

    val collect: MutableMap<Int, MutableSet<Int>>? =
        listRes.stream()
            .map { e ->
                with(StringBuilder()) {
                    for (let in 'A'..'Z') {
                        append(let)
                        append(e)
                    }
                    toString()
                }
            }
            .map { e -> Integer.parseInt(e) }
            .collect(Collectors.groupingBy({ v: Int -> v % 12 }, Collectors.toSet()))




    val summary = { x: Int, y: Int -> x + y }

    val maybe = maybe()
    maybe?.let { summary(it, it) }

    println(summary(12, 15))
    val run = run { 12 + 3 }
    println(run)

    for ((key, value) in treeMap) {
        if (value in 1..20) {
            println("hello world")
        }
    }

    if ("Privet" in treeMap) {
        println("bye man")
    }
}


fun maybe(): Int? {
    return if (Random(1).nextInt() > 2) 1 else null
}



