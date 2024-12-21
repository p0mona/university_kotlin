class Line(private var x1: Double, private var y1: Double, private var x2: Double, private var y2: Double){
    override fun toString(): String {
        return "Line($x1, $y1, $x2, $y2)"
    }

    fun getX1(): Double {
        return x1
    }

    fun setX1(newX1: Double) {
        x1 = newX1
    }

    fun getY1(): Double {
        return y1
    }

    fun setY1(newY1: Double) {
        y1 = newY1
    }

    fun getX2(): Double {
        return x2
    }

    fun setX2(newX2: Double) {
        x2 = newX2
    }

    fun getY2(): Double {
        return y2
    }

    fun setY2(newY2: Double) {
        y2 = newY2
    }
}

fun main() {
    val line1 = Line(0.0, 0.0, 3.0, 2.0)
    val line2 = Line(3.0, 2.0, 3.0, -2.0)
    val line3 = Line(3.0, -2.0, -3.0, -2.0)
    val line4 = Line(-3.0, -2.0, -3.0, 2.0)
    val line5 = Line(-3.0, 2.0, 0.0, 5.0)
    val line6 = Line(-3.0, 2.0, 0.0, 0.0)
    val line7 = Line(0.0, 5.0, 3.0, 2.0)
    val line8 = Line(-3.0, 2.0, 3.0, 2.0)

    println(line1)
    println(line2)
    println(line3)
    println(line4)
    println(line5)
    println(line6)
    println(line7)
    println(line8)
}
