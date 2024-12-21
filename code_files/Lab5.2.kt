import kotlin.random.Random

class Point(private var x: Double = 0.0, private var y: Double = 0.0) {
    fun move(dx: Double, dy: Double) {
        x += dx
        y += dy
    }

    //test
    fun testMove(){
        val p = Point(3.0, 4.0)
        val initialX = p.getX()
        val initialY = p.getY()
        p.move(2.0, -1.0)
        val expectedX = initialX + 2.0
        val expectedY = initialY - 1.0

        if (p.getX() == expectedX && p.getY() == expectedY) {
            println("testMove OK")
        }else {
            println("testMove FAILED")
        }
    }

    override fun toString(): String {
        return "Point($x, $y)"
    }

    //test
    fun testToString() {
        val p = Point(3.0, 4.0)
        val expected = "Point(3.0, 4.0)"
        val actual = p.toString()
        if (expected == actual) {
            println("testToString OK")
        }else {
            println("testToString FAILED")
        }
    }

    fun getX(): Double {
        return x
    }

    //test
    fun testGetX() {
        val p = Point(3.0, 4.0)
        val expected = 3.0
        val actual = p.getX()
        if (expected == actual) {
            println("testGetX OK")
        }else {
            println("testGetX FAILED")
        }
    }

    fun setX(newX: Double) {
        x = newX
    }

    //test
    fun testSetX() {
        val p = Point(3.0, 4.0)
        p.setX(2.0)
        val expected = 2.0
        val actual = p.getX()
        if (expected == actual) {
            println("testSetX OK")
        }else {
            println("testSetX FAILED")
        }
    }

    fun getY(): Double {
        return y
    }

    //test
    fun testGetY() {
        val p = Point(3.0, 4.0)
        val expected = 4.0
        val actual = p.getY()
        if (expected == actual) {
            println("testGetY OK")
        }else {
            println("testGetY FAILED")
        }
    }

    fun setY(newY: Double) {
        y = newY
    }

    //test
    fun testSetY() {
        val p = Point(3.0, 4.0)
        p.setY(2.0)
        val expected = 2.0
        val actual = p.getY()
        if (expected == actual) {
            println("testSetY OK")
        }else {
            println("testSetY FAILED")
        }
    }
}

fun main() {
    val p = Point(y = Random.nextDouble(), x = Random.nextDouble())
    println("TESTS:\n")
    p.testMove()
    p.testGetX()
    p.testSetX()
    p.testGetY()
    p.testSetY()
    p.testToString()

    val p1 = Point(y = Random.nextDouble(), x = Random.nextDouble())
    val p2 = Point(y = Random.nextDouble(), x = Random.nextDouble())
    val p3 = Point()

    println("\nPoint 1: ${p1.toString()}")
    println("Point 2: ${p2.toString()}")
    println("Point 3: ${p3.toString()}")
    println()

    val dx = Random.nextDouble()
    val dy = Random.nextDouble()

    p1.move(dx, dy)
    p2.move(dx, dy)
    p3.move(dx, dy)

    println("Points after displacement by vector ($dx, $dy):")
    println()
    println("Point 1: ${p1.toString()}")
    println("Point 2: ${p2.toString()}")
    println("Point 3: ${p3.toString()}")
}