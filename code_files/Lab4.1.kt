import kotlin.math.pow
import kotlin.math.sqrt

fun main(args: Array<String>) {
    try {
        if (args.size != 3) {
            throw IllegalArgumentException("Incorrect number of parameters. The call should be in the format: operator operand_1 operand_2")
        }

        val operator = args[0]
        val operand_1 = args[1].toDouble()
        val operand_2 = args[2].toDouble()

        val result = when (operator) {
            "+" -> operand_1 + operand_2
            "-" -> operand_1 - operand_2
            "*" -> operand_1 * operand_2
            "/" -> {
                if (operand_2 == 0.0) {
                    throw ArithmeticException("Division by zero")
                }
                operand_1 / operand_2
            }

            "pow" -> operand_1.pow(operand_2)
            "sqrt" -> {
                if (operand_1 < 0) {
                    throw ArithmeticException("Square root of a negative number")
                }
                sqrt(operand_1)
            }

            else -> throw IllegalArgumentException("Unknown operator: $operator")
        }

        println("Result: $result")
    } catch (e: NumberFormatException) {
        println("Error: Invalid number format")
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    } catch (e: ArithmeticException) {
        println("Arithmetic error: ${e.message}")
    }
}


