import kotlin.math.sqrt

class Line(var x_1: Double, var y_1: Double, var x_2: Double, var y_2: Double) {
    fun getX1(): Double {
        return x_1
    }

    //test
    fun testGetX1() {
        val ln = Line(-3.0, 2.0, 3.0, 2.0)
        val expected = -3.0
        val actual = ln.getX1()
        if (expected == actual) {
            println("testGetX1 OK")
        }else {
            println("testGetX1 FAILED")
        }
    }

    fun setX1(newX1: Double) {
        x_1 = newX1
    }

    //test
    fun testSetX1() {
        val ln = Line(-3.0, 2.0, 3.0, 2.0)
        ln.setX1(2.0)
        val expected = 2.0
        val actual = ln.getX1()
        if (expected == actual) {
            println("testSetX1 OK")
        }else {
            println("testSetX1 FAILED")
        }
    }

    fun getY1(): Double {
        return y_1
    }

    //test
    fun testGetY1() {
        val ln = Line(-3.0, 2.0, 3.0, 2.0)
        val expected = 2.0
        val actual = ln.getY1()
        if (expected == actual) {
            println("testGetY1 OK")
        }else {
            println("testGetY1 FAILED")
        }
    }

    fun setY1(newY1: Double) {
        y_1 = newY1
    }

    //test
    fun testSetY1() {
        val ln = Line(-3.0, 2.0, 3.0, 2.0)
        ln.setY1(3.0)
        val expected = 3.0
        val actual = ln.getY1()
        if (expected == actual) {
            println("testSetY1 OK")
        }else {
            println("testSetY1 FAILED")
        }
    }

    fun getX2(): Double {
        return x_2
    }

    //test
    fun testGetX2() {
        val ln = Line(-3.0, 2.0, 3.0, 2.0)
        val expected = 3.0
        val actual = ln.getX2()
        if (expected == actual) {
            println("testGetX2 OK")
        }else {
            println("testGetX2 FAILED")
        }
    }

    fun setX2(newX2: Double) {
        x_2 = newX2
    }

    //test
    fun testSetX2() {
        val ln = Line(-3.0, 2.0, 3.0, 2.0)
        ln.setX2(2.0)
        val expected = 2.0
        val actual = ln.getX2()
        if (expected == actual) {
            println("testSetX2 OK")
        }else {
            println("testSetX2 FAILED")
        }
    }

    fun getY2(): Double {
        return y_2
    }

    //test
    fun testGetY2() {
        val ln = Line(-3.0, 2.0, 3.0, 2.0)
        val expected = 2.0
        val actual = ln.getY2()
        if (expected == actual) {
            println("testGetY2 OK")
        }else {
            println("testGetY2 FAILED")
        }
    }

    fun setY2(newY2: Double) {
        y_2 = newY2
    }

    //test
    fun testSetY2() {
        val ln = Line(-3.0, 2.0, 3.0, 2.0)
        ln.setY2(-1.0)
        val expected = -1.0
        val actual = ln.getY2()
        if (expected == actual) {
            println("testSetY2 OK")
        }else {
            println("testSetY2 FAILED")
        }
    }

    override fun toString(): String {
        return "Line($x_1, $y_1, $x_2, $y_2) \n Length = ${length()}"
    }

    //test
    fun testToString() {
        val ln = Line(-3.0, 2.0, 3.0, 2.0)
        val expected = "Line(-3.0, 2.0, 3.0, 2.0) \n Length = ${ln.length()}"
        val actual = ln.toString()
        if (expected == actual) {
            println("testToString OK")
        }else {
            println("testToString FAILED")
        }
    }
}

fun Line.length(): Double {
    return sqrt((this.x_2 - this.x_1) * (this.x_2 - this.x_1) + (this.y_2 - this.y_1) * (this.y_2 - this.y_1))
}

//test
fun testLength() {
    val ln = Line(0.0, 0.0, 3.0, 4.0)
    val expected = 5.0
    val actual = ln.length()
    if (expected == actual) {
        println("testLength OK")
    }else {
        println("testLength FAILED")
    }
}

fun main() {
    println("TESTS:")
    val line = Line(-3.0, 2.0, 3.0, 2.0)
    line.testGetX1()
    line.testSetX1()
    line.testGetY1()
    line.testSetY1()
    line.testGetX2()
    line.testSetX2()
    line.testGetY2()
    line.testSetY2()
    line.testToString()
    testLength()

    val line1 = Line(0.0, 0.0, 3.0, 2.0)
    val line2 = Line(3.0, 2.0, 3.0, -2.0)
    val line3 = Line(3.0, -2.0, -3.0, -2.0)
    val line4 = Line(-3.0, -2.0, -3.0, 2.0)
    val line5 = Line(-3.0, 2.0, 0.0, 5.0)
    val line6 = Line(-3.0, 2.0, 0.0, 0.0)
    val line7 = Line(0.0, 5.0, 3.0, 2.0)
    val line8 = Line(-3.0, 2.0, 3.0, 2.0)

    println()
    println(line1)
    println(line2)
    println(line3)
    println(line4)
    println(line5)
    println(line6)
    println(line7)
    println(line8)
}

