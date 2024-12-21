import kotlin.random.Random

class Fraction(private var nominator: Int, private var denominator: Int) {

    init {
        require(denominator != 0) { "Denominator cannot be zero." }
        reducingAFraction()
    }

    private fun gcdFraction(x: Int, y: Int): Int {
        return if (y == 0) x else gcdFraction(y, x % y)
    }

    private fun reducingAFraction() {
        val gcd = gcdFraction(nominator, denominator)
        nominator /= gcd
        denominator /= gcd
    }

    fun add(other: Fraction): Fraction {
        val resNumerator = nominator * other.denominator + other.nominator * denominator
        val resDenominator = denominator * other.denominator
        return Fraction(resNumerator, resDenominator)
    }

    fun sub(other: Fraction): Fraction {
        val resNumerator = nominator * other.denominator - other.nominator * denominator
        val resDenominator = denominator * other.denominator
        return Fraction(resNumerator, resDenominator)
    }

    fun mul(other: Fraction): Fraction {
        val resNumerator = nominator * other.nominator
        val resDenominator = denominator * other.denominator
        return Fraction(resNumerator, resDenominator)
    }

    fun div(other: Fraction): Fraction {
        require(other.nominator != 0) { "Cannot divide by a fraction with a zero numerator." }
        val resNumerator = nominator * other.denominator
        val resDenominator = denominator * other.nominator
        return Fraction(resNumerator, resDenominator)
    }

    fun inv(): Fraction {
        require(nominator != 0) { "Cannot invert a zero fraction." }
        return Fraction(denominator, nominator)
    }

    override fun toString(): String {
        val wholePart = nominator / denominator
        val remainder = nominator % denominator
        return when {
            remainder == 0 -> wholePart.toString()
            wholePart != 0 -> "$wholePart ${kotlin.math.abs(remainder)}/$denominator"
            else -> "$nominator/$denominator"
        }
    }
}

fun main() {
    val fraction1 = Fraction(Random.nextInt(1, 100), Random.nextInt(1, 100))
    val fraction2 = Fraction(Random.nextInt(1, 100), Random.nextInt(1, 100))

    val sum = fraction1.add(fraction2)
    val difference = fraction1.sub(fraction2)
    val product = fraction1.mul(fraction2)
    val quotient = fraction1.div(fraction2)
    val inverse1 = fraction1.inv()
    val inverse2 = fraction2.inv()

    try {
        val fractionList = listOf(sum, difference, product, quotient, inverse1, inverse2)
        for (i in fractionList) {
            println(i)
        }
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}







