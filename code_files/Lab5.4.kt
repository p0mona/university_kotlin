fun add(a: Int, b: Int): Int {
    return a + b
}

//test
fun testAddInt() {
    val a = 5
    val b = 10
    val expected = 15
    val result = add(a, b)
    if (result == expected) {
        println("testAddInt OK")
    }else {
        println("testAddInt FAILED")
    }
}

fun add(a: Double, b: Double): Double {
    return a + b
}

//test
fun testAddDouble() {
    val a = 5.0
    val b = 10.0
    val expected = 15.0
    val result = add(a, b)
    if (result == expected) {
        println("testAddDouble OK")
    }else {
        println("testAddDouble FAILED")
    }
}

class Frac(var nominator: Int, var denominator: Int) {
    init {
        require(denominator != 0) { "The denominator cannot be 0." }
        reducingAFraction()
    }
    //test
    fun testFractionInitialization() {
        val fraction = Frac(1, 2)
        if(fraction.nominator == 1 && fraction.denominator == 2){
            println("testFractionInitialization OK")
        }else {
            println("testFractionInitialization FAILED")
        }
    }

    //test
    fun testZeroDenominator(): Boolean {
        try {
            Frac(3, 0)
            return false
        } catch (e: IllegalArgumentException) {
            println("testZeroDenominator OK")
            return true
        }
    }
    fun gcdFraction(x: Int, y: Int): Int {
        return if (y == 0) x else gcdFraction(y, x % y)
    }
    //test
    fun testGcdFraction(){
        if(gcdFraction(2, 4) == 2 ) {
            println("testGcdFraction OK")
        }else {
            println("testGcdFraction FAILED")
        }
    }
    fun reducingAFraction() {
        val gcd = gcdFraction(nominator, denominator)
        nominator /= gcd
        denominator /= gcd
    }
    //test
    fun testReducingAFraction() {
        val fraction = Frac(8, 12)
        fraction.reducingAFraction()
        if(fraction.nominator == 2 && fraction.denominator == 3){
            println("testReducingAFraction OK")
        }else {
            println("testReducingAFraction FAILED")
        }
    }

    override fun toString(): String {
        val wholePart = nominator / denominator
        val remainder = nominator % denominator
        return when {
            remainder == 0 -> wholePart.toString()
            wholePart != 0 -> "($wholePart $remainder/$denominator)"
            else -> "($remainder/$denominator)"
        }
    }
    //test
    fun testToString(): Boolean {
        val fraction1 = Frac(3, 4)
        val fraction2 = Frac(5, 2)
        val fraction3 = Frac(-2, 3)
        val result1 = fraction1.toString() == "(3/4)"
        val result2 = fraction2.toString() == "(2 1/2)"
        val result3 = fraction3.toString() == "(-2/3)"
        val allTestsPassed = result1 && result2 && result3
        if (allTestsPassed) {
            println("testToString OK")
        } else {
            println("testToString FAILED")
        }
        return allTestsPassed
    }
}

fun add(a: Frac, b: Frac): Frac {
    val newNumerator = a.nominator * b.denominator + b.nominator * a.denominator
    val newDenominator = a.denominator * b.denominator
    return Frac(newNumerator, newDenominator).apply { reducingAFraction() }
}

//test
fun testAddFrac() {
    val frac1 = Frac(1, 2)
    val frac2 = Frac(3, 4)
    val result = add(frac1, frac2)
    val expectedNumerator = 5
    val expectedDenominator = 4
    if (result.nominator == expectedNumerator && result.denominator == expectedDenominator) {
        println("testAddFrac OK")
    }else {
        println("testAddFrac FAILED")
    }
}

fun main() {
    println("TESTS:\n")
    val f = Frac(1,2)
    f.testFractionInitialization()
    f.testZeroDenominator()
    f.testGcdFraction()
    f.testReducingAFraction()
    f.testToString()
    testAddInt()
    testAddDouble()
    testAddFrac()

    println()
    println(add(1, 2))
    println(add(1.0, 2.0))
    println(add(Frac(1,2), Frac(3,4)))
//  println(add(1, 2.0))
}
