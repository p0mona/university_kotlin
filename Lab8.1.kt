fun isPrime(num: Int): Boolean {
    if (num == 1) return true
    if (num < 2) return false
    for (i in 2 until Math.sqrt(num.toDouble()).toInt() + 1) {
        if (num % i == 0) {
            return false
        }
    }
    return true
}

//test
fun testIsPrime() {
    val testCases = arrayOf(
        Pair(1, true),
        Pair(2, true),
        Pair(3, true),
        Pair(4, false),
        Pair(5, true),
        Pair(10, false),
        Pair(13, true),
        Pair(29, true),
        Pair(97, true),
        Pair(11057, true)
    )
    var allTestsPassed = true

    for ((num, expected) in testCases) {
        val actual = isPrime(num)
        if (actual != expected) {
            println("testIsPrime FAILED for num = $num: expected $expected, got $actual")
            allTestsPassed = false
        }
    }

    if (allTestsPassed) {
        println("testIsPrime OK")
    } else {
        println("testIsPrime FAILED")
    }
}

fun main() {
    testIsPrime()
    var maxLimit = 2
    var power = 1

    outer@ while (true) {
        maxLimit = Math.pow(2.0, power.toDouble()).toInt()
        val primes = mutableListOf<Int>()
        for (num in 1..maxLimit) {
            if (isPrime(num)) {
                if (num == 13) {
                    continue
                }
                if (num == 11057) {
                    break@outer
                }
                primes.add(num)
            }
        }

        if (primes.isNotEmpty()) {
            println("Prime numbers <= $maxLimit: ${primes.joinToString(", ")}")
        }
        power += 1
    }
}
