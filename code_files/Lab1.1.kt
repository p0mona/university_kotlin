import kotlin.random.Random
class Point(private var x : Double, private var y : Double){
    fun move(dx: Double, dy: Double) {
        x += dx
        y += dy
    }

    override fun toString(): String {
        return "Point($x, $y)"
    }

    fun getX(): Double {
        return x
    }

    fun setX(newX: Double) {
        x = newX
    }

    fun getY(): Double {
        return y
    }

    fun setY(newY: Double) {
        y = newY
    }
}

fun main() {
    val p1 = Point(Random.nextDouble(), Random.nextDouble())
    val p2 = Point(Random.nextDouble(), Random.nextDouble())
    val p3 = Point(Random.nextDouble(), Random.nextDouble())

    println("Point 1: ${p1.toString()}")
    println("Point 2: ${p2.toString()}")
    println("Point 3: ${p3.toString()}")
    println()

    val dx = Random.nextDouble()
    val dy = Random.nextDouble()

    p1.move(dx, dy)
    p2.move(dx, dy)
    p3.move(dx, dy)

    println("Points after shifting by the vector ($dx, $dy):")
    println()
    println("Point 1: ${p1.toString()}")
    println("Point 2: ${p2.toString()}")
    println("Point 3: ${p3.toString()}")
}