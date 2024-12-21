class Fraction(private var nominator: Int, private var denominator: Int) {

    init {
        require(denominator != 0) { "The denominator cannot be 0." }
        reducingAFraction()
    }

    //test
     fun testFractionInitialization() {
        val fraction = Fraction(1, 2)
        if(fraction.nominator == 1 && fraction.denominator == 2){
            println("testFractionInitialization OK")
        }
    }

    //test
    fun testZeroDenominator(): Boolean {
        try {
            Fraction(3, 0)
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
        }
    }

    fun reducingAFraction() {
        val gcd = gcdFraction(nominator, denominator)
        nominator /= gcd
        denominator /= gcd
    }

    //test
    fun testReducingAFraction() {
        val fraction = Fraction(8, 12)
        fraction.reducingAFraction()
        if(fraction.nominator == 2 && fraction.denominator == 3){
            println("testReducingAFraction OK")
        }
    }

    fun add(other: Fraction): Fraction {
        val resNumerator = nominator * other.denominator + other.nominator * denominator
        val resDenominator = denominator * other.denominator
        val resFraction = Fraction(resNumerator, resDenominator)
        resFraction.reducingAFraction()
        return resFraction
    }

    //test
    fun testAdd() {
        val fraction1 = Fraction(1, 2)
        val fraction2 = Fraction(1, 4)
        val sum = fraction1.add(fraction2)
        if (sum.nominator == 3 && sum.denominator == 4){
            println("testAdd OK")
        }

    }


    fun sub(other: Fraction): Fraction {
        val resNumerator = nominator * other.denominator - other.nominator * denominator
        val resDenominator = denominator * other.denominator
        val resFraction = Fraction(resNumerator, resDenominator)
        resFraction.reducingAFraction()
        return resFraction
    }

    //test
    fun testSub() {
        val fraction1 = Fraction(3, 4)
        val fraction2 = Fraction(1, 4)
        val difference = fraction1.sub(fraction2)
        if(difference.nominator == 1 && difference.denominator == 2){
            println("testSub OK")
        }
    }

    fun mul(other: Fraction): Fraction {
        val resNumerator = nominator * other.nominator
        val resDenominator = denominator * other.denominator
        val resFraction = Fraction(resNumerator, resDenominator)
        resFraction.reducingAFraction()
        return resFraction
    }

    //test
    fun testMul() {
        val fraction1 = Fraction(3, 4)
        val fraction2 = Fraction(1, 2)
        val product = fraction1.mul(fraction2)
        if (product.nominator == 3 && product.denominator == 8){
            println("testMul OK")
        }
    }

    fun div(other: Fraction): Fraction {
        val resNumerator = nominator * other.denominator
        val resDenominator = denominator * other.nominator
        val resFraction = Fraction(resNumerator, resDenominator)
        resFraction.reducingAFraction()
        return resFraction
    }

    //test
    fun testDiv(){
        val fraction1 = Fraction(3, 4)
        val fraction2 = Fraction(1, 2)
        val quotient = fraction1.div(fraction2)
        if(quotient.nominator == 3 && quotient.denominator == 2){
            println("testDiv OK")
        }
    }

    fun inv(): Fraction {
        require(nominator != 0) { "Cannot invert a zero fraction." }
        val resFraction = Fraction(denominator, nominator)
        resFraction.reducingAFraction()
        return resFraction
    }

    //test
    fun testInv(){
        val fraction = Fraction(3, 4)
        val inverse = fraction.inv()
        if(inverse.nominator == 4 && inverse.denominator == 3){
            println("testInv OK")
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
        val fraction1 = Fraction(3, 4)
        val fraction2 = Fraction(5, 2)
        val fraction3 = Fraction(-2, 3)

        val result1 = fraction1.toString() == "(3/4)"
        val result2 = fraction2.toString() == "(2 1/2)"
        val result3 = fraction3.toString() == "(-2/3)"

        val allTestsPassed = result1 && result2 && result3
        if (allTestsPassed) {
            println("testToString OK")
        } else {
            println("testToString Failed")
        }
        return allTestsPassed
    }


    fun sumFractions(vararg fractions: Fraction): Fraction {
        var result = fractions[0]
        for (i in 1 until fractions.size) {
            result = result.add(fractions[i])
        }
        return result
    }
    //test
    fun testSumFractions() {
        val fraction1 = Fraction(1, 2)
        val fraction2 = Fraction(1, 4)
        val fraction3 = Fraction(1, 8)
        val sum = sumFractions(fraction1, fraction2, fraction3)
        if(sum.nominator == 7 && sum.denominator == 8){
            println("testSumFractions OK")
        }
    }
}


fun main(){
    val fractionTester = Fraction(1,2)
    println("TESTS:\n")
    fractionTester.testFractionInitialization()
    fractionTester.testZeroDenominator()
    fractionTester.testGcdFraction()
    fractionTester.testReducingAFraction()
    fractionTester.testAdd()
    fractionTester.testSub()
    fractionTester.testMul()
    fractionTester.testDiv()
    fractionTester.testInv()
    fractionTester.testToString()
    fractionTester.testSumFractions()


    val fraction1 = Fraction(5,6)
    val fraction2 = Fraction(3,4)
    val fraction3 = Fraction(7,11)

    val sum = fraction1.add(fraction2)
    val difference = fraction1.sub(fraction2)
    val product = fraction1.mul(fraction2)
    val quotient = fraction1.div(fraction2)
    val inverse1 = fraction1.inv()
    val inverse2 = fraction2.inv()
    val sumFr = fraction1.sumFractions(fraction1, fraction2, fraction3)

    println("\nCALCULATIONS:\n")
    println("First fraction: $fraction1")
    println("Second fraction: $fraction2")
    println("Third fraction: $fraction3\n")

    println("Addition of fractions: $sum")
    println("Subtraction of fractions: $difference")
    println("Multiplication of fractions: $product")
    println("Division of fractions: $quotient")
    println("Inversion of the first fraction: $inverse1")
    println("Inversion of the second fraction: $inverse2")
    println("Sum of any number of fractions: $sumFr")

}



