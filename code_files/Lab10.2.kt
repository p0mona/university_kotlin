abstract class Shape {
    var color: String = "black"
    var isFilled: Boolean = false

    fun getColorShape(): String {
        return color
    }

    fun setColorShape(newColor: String) {
        color = newColor
    }

    fun getIsFilled(): Boolean {
        return isFilled
    }

    fun setIsFilled(filled: Boolean) {
        isFilled = filled
    }

    abstract fun draw(): String
    abstract fun erase(): String
    abstract fun transform(): String
}
class Point : Shape() {
    override fun draw(): String {
        return "Drawing point with color: $color, fill: ${if (isFilled) "yes" else "no"}"
    }

    override fun erase(): String {
        return "Deleting point with color: $color, fill: ${if (isFilled) "yes" else "no"}"
    }

    override fun transform(): String {
        return "Transform point with color: $color, fill: ${if (isFilled) "yes" else "no"}"
    }
}


class Line : Shape() {
    override fun draw(): String {
        return "Drawing line with color: $color, fill: ${if (isFilled) "yes" else "no"}"
    }

    override fun erase(): String {
        return "Deleting line with color: $color, fill: ${if (isFilled) "yes" else "no"}"
    }

    override fun transform(): String {
        return "Transform line with color: $color, fill: ${if (isFilled) "yes" else "no"}"
    }
}

class Circle : Shape() {
    override fun draw(): String {
        return "Drawing a circle with color: $color, fill: ${if (isFilled) "yes" else "no"}"
    }

    override fun erase(): String {
        return "Deleting a circle with color: $color, fill: ${if (isFilled) "yes" else "no"}"
    }

    override fun transform(): String {
        return "Circle transformation with color: $color, fill: ${if (isFilled) "yes" else "no"}"
    }
}

class Rectangle : Shape() {
    override fun draw(): String {
        return "Drawing a rectangle with color: $color, fill: ${if (isFilled) "yes" else "no"}"
    }

    override fun erase(): String {
        return "Deleting a rectangle with color: $color, fill: ${if (isFilled) "yes" else "no"}"
    }

    override fun transform(): String {
        return "Rectangle transformation with color: $color, fill: ${if (isFilled) "yes" else "no"}"
    }
}

class Triangle : Shape() {
    override fun draw(): String {
        return "Drawing a triangle with color: $color, fill: ${if (isFilled) "yes" else "no"}"
    }

    override fun erase(): String {
        return "Deleting a triangle with color: $color, fill: ${if (isFilled) "yes" else "no"}"
    }

    override fun transform(): String {
        return "Triangle transformation with color: $color, fill: ${if (isFilled) "yes" else "no"}"
    }
}

class Canvas {
    private val shapes = mutableListOf<Shape>()

    fun addShape(shape: Shape) {
        shapes.add(shape)
    }

    fun paint() {
        for (shape in shapes) {
            println(shape.draw())
        }
    }
}

fun main() {
    val canvas = Canvas()

    val point = Point().apply {
        color = "blue"
        isFilled = false
    }

    val line = Line().apply {
        color = "red"
        isFilled = false
    }

    val circle = Circle().apply {
        color = "green"
        isFilled = true
    }

    val rectangle = Rectangle().apply {
        color = "yellow"
        isFilled = true
    }

    val triangle = Triangle().apply {
        color = "orange"
        isFilled = false
    }

    canvas.addShape(point)
    canvas.addShape(line)
    canvas.addShape(circle)
    canvas.addShape(rectangle)
    canvas.addShape(triangle)

    canvas.paint()
    println()

    println(Line().erase())
    println(Circle().transform())

    println("\nTESTS:\n")
    val p = Point().apply {
        color = "blue"
        isFilled = false
    }
    if (p.draw() != "Drawing a point with color: blue, fill: no") {
        println("Test p.draw() FAILED")
    } else {
        println("Test p.draw() OK")
    }
    if (p.erase() != "Erasing a point with color: blue, fill: no") {
        println("Test p.erase() FAILED")
    } else {
        println("Test p.erase() OK")
    }
    if (p.transform() != "Transforming a point with color: blue, fill: no") {
        println("Test p.transform() FAILED")
    } else {
        println("Test p.transform() OK")
    }

    val l = Line().apply {
        color = "red"
        isFilled = false
    }
    if (l.draw() != "Drawing a line with color: red, fill: no") {
        println("Test l.draw() FAILED")
    } else {
        println("Test l.draw() OK")
    }
    if (l.erase() != "Erasing a line with color: red, fill: no") {
        println("Test l.erase() FAILED")
    } else {
        println("Test l.erase() OK")
    }
    if (l.transform() != "Transforming a line with color: red, fill: no") {
        println("Test l.transform() FAILED")
    } else {
        println("Test l.transform() OK")
    }

    val c = Circle().apply {
        color = "green"
        isFilled = true
    }
    if (c.draw() != "Drawing a circle with color: green, fill: yes") {
        println("Test c.draw() FAILED")
    } else {
        println("Test c.draw() OK")
    }
    if (c.erase() != "Erasing a circle with color: green, fill: yes") {
        println("Test c.erase() FAILED")
    } else {
        println("Test c.erase() OK")
    }
    if (c.transform() != "Transforming a circle with color: green, fill: yes") {
        println("Test c.transform() FAILED")
    } else {
        println("Test c.transform() OK")
    }

    val r = Rectangle().apply {
        color = "yellow"
        isFilled = true
    }
    if (r.draw() != "Drawing a rectangle with color: yellow, fill: yes") {
        println("Test r.draw() FAILED")
    } else {
        println("Test r.draw() OK")
    }
    if (r.erase() != "Erasing a rectangle with color: yellow, fill: yes") {
        println("Test r.erase() FAILED")
    } else {
        println("Test r.erase() OK")
    }
    if (r.transform() != "Transforming a rectangle with color: yellow, fill: yes") {
        println("Test r.transform() FAILED")
    } else {
        println("Test r.transform() OK")
    }

    val t = Triangle().apply {
        color = "orange"
        isFilled = false
    }
    if (t.draw() != "Drawing a triangle with color: orange, fill: no") {
        println("Test t.draw() FAILED")
    } else {
        println("Test t.draw() OK")
    }
    if (t.erase() != "Erasing a triangle with color: orange, fill: no") {
        println("Test t.erase() FAILED")
    } else {
        println("Test t.erase() OK")
    }
    if (t.transform() != "Transforming a triangle with color: orange, fill: no") {
        println("Test t.transform() FAILED")
    } else {
        println("Test t.transform() OK")
    }


    val pTest = Point()
    val lTest = Line()
    val cTest = Circle()
    val rTest = Rectangle()
    val tTest = Triangle()

    if (pTest.getColorShape() == "black" &&
        lTest.getColorShape() == "black" &&
        cTest.getColorShape() == "black"
    ) {
        println("Test getColorShape() OK")
    } else {
        println("Test getColorShape() FAILED")
    }


    cTest.setColorShape("green")
    rTest.setColorShape("yellow")
    tTest.setColorShape("orange")

    if (cTest.getColorShape() == "green" &&
        rTest.getColorShape() == "yellow" &&
        tTest.getColorShape() == "orange"
    ) {
        println("Test setColorShape() OK")
    } else {
        println("Test setColorShape() FAILED")
    }

    if (!point.getIsFilled() &&
        circle.getIsFilled() &&
        !triangle.getIsFilled()
    ) {
        println("Test getIsFilled() OK")
    } else {
        println("Test getIsFilled() FAILED")
    }
    pTest.setIsFilled(true)
    cTest.setIsFilled(false)

    if (pTest.getIsFilled() &&
        !cTest.getIsFilled()
    ) {
        println("Test setIsFilled() OK")
    } else {
        println("Test setIsFilled() FAILED")
    }

}
