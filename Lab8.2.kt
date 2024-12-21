interface Animal {
    fun speak(): String
    fun eat(): String
}

class Dog : Animal {
    override fun speak(): String {
        return "Woof woof!"
    }

    override fun eat(): String {
        return "Dog is eating dog food."
    }
}

class Cat : Animal {
    override fun speak(): String {
        return "Meow meow!"
    }

    override fun eat(): String {
        return "Cat is eating cat food."
    }
}

class Bird : Animal {
    override fun speak(): String {
        return "Tweet tweet!"
    }

    override fun eat(): String {
        return "Bird is eating seeds."
    }
}

//test
fun testAnimalClasses() {
    println("Testing Animal classes:")

    val dog: Animal = Dog()
    val cat: Animal = Cat()
    val bird: Animal = Bird()

    val dogSpeakExpected = "Woof woof!"
    val dogEatExpected = "Dog is eating dog food."
    if (dog.speak() == dogSpeakExpected && dog.eat() == dogEatExpected) {
        println("Dog tests OK")
    } else {
        println("Dog tests FAILED")
    }

    val catSpeakExpected = "Meow meow!"
    val catEatExpected = "Cat is eating cat food."
    if (cat.speak() == catSpeakExpected && cat.eat() == catEatExpected) {
        println("Cat tests OK")
    } else {
        println("Cat tests FAILED")
    }

    val birdSpeakExpected = "Tweet tweet!"
    val birdEatExpected = "Bird is eating seeds."
    if (bird.speak() == birdSpeakExpected && bird.eat() == birdEatExpected) {
        println("Bird tests OK")
    } else {
        println("Bird tests FAILED")
    }
}

fun main() {
    testAnimalClasses()
    println()

    val dog: Animal = Dog()
    println(dog.speak())
    println(dog.eat())
    println()

    val cat: Animal = Cat()
    println(cat.speak())
    println(cat.eat())
    println()

    val bird: Animal = Bird()
    println(bird.speak())
    println(bird.eat())
}
