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

    val p = Point().apply {
        color = "blue"
        isFilled = false
    }
    val l = Line().apply {
        color = "red"
        isFilled = false
    }
    val c = Circle().apply {
        color = "green"
        isFilled = true
    }
    val r = Rectangle().apply {
        color = "yellow"
        isFilled = true
    }
    val t = Triangle().apply {
        color = "orange"
        isFilled = false
    }

    canvas.addShape(p)
    canvas.addShape(l)
    canvas.addShape(c)
    canvas.addShape(r)
    canvas.addShape(t)

    canvas.paint()
    println()

    println(l.erase())
    println(c.transform())

    println("\nTESTS:\n")
    if (p.draw() != "Drawing point with color: blue, fill: no") {
        println("Test p.draw() FAILED")
    } else {
        println("Test p.draw() OK")
    }

    if (l.draw() != "Drawing line with color: red, fill: no") {
        println("Test l.draw() FAILED")
    } else {
        println("Test l.draw() OK")
    }

    if (c.draw() != "Drawing a circle with color: green, fill: yes") {
        println("Test c.draw() FAILED")
    } else {
        println("Test c.draw() OK")
    }

    if (r.draw() != "Drawing a rectangle with color: yellow, fill: yes") {
        println("Test r.draw() FAILED")
    } else {
        println("Test r.draw() OK")
    }

    if (t.draw() != "Drawing a triangle with color: orange, fill: no") {
        println("Test t.draw() FAILED")
    } else {
        println("Test t.draw() OK")
    }

    // Тесты для getColorShape()
    if (p.getColorShape() == "blue" &&
        l.getColorShape() == "red" &&
        c.getColorShape() == "green" &&
        r.getColorShape() == "yellow" &&
        t.getColorShape() == "orange"
    ) {
        println("Test getColorShape() OK")
    } else {
        println("Test getColorShape() FAILED")
    }

    // Тесты для setIsFilled()
    p.setIsFilled(true)  // Устанавливаем filled для p
    c.setIsFilled(false) // Устанавливаем filled для c

    if (p.getIsFilled() && !c.getIsFilled()) {
        println("Test setIsFilled() OK")
    } else {
        println("Test setIsFilled() FAILED")
    }

    // Тесты для setColorShape()
    c.setColorShape("blue")
    r.setColorShape("purple")
    t.setColorShape("pink")

    if (c.getColorShape() == "blue" &&
        r.getColorShape() == "purple" &&
        t.getColorShape() == "pink"
    ) {
        println("Test setColorShape() OK")
    } else {
        println("Test setColorShape() FAILED")
    }

    // Тесты для getIsFilled()
    if (p.getIsFilled() && // p был изменен на заполненный
        !c.getIsFilled() && // c был изменен на незаполненный
        !t.getIsFilled() // t изначально не заполнен
    ) {
        println("Test getIsFilled() OK")
    } else {
        println("Test getIsFilled() FAILED")
    }
}


