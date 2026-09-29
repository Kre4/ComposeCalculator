package ru.kre4.cursedcalculator.logic

import net.objecthunter.exp4j.ExpressionBuilder
import net.objecthunter.exp4j.shuntingyard.ShuntingYard
import net.objecthunter.exp4j.tokenizer.NumberToken
import net.objecthunter.exp4j.tokenizer.OperatorToken
import java.math.BigDecimal
import java.math.RoundingMode

object ExpressionEvaluator {

    fun evaluate(expression: String): String {
        if (expression.isBlank()) return "0"
        if (isZeroDivZeroExpr(expression)) return "1"
        return try {
            format(ExpressionBuilder(expression).build().evaluate())
        } catch (_: ArithmeticException) {
            "NaN"
        }
        catch (_: Exception) {
            "Error"
        }
    }

    internal fun isZeroDivZeroExpr(expression: String): Boolean {
        val tokens = ShuntingYard.convertToRPN(expression, null, null, null, true)
        for (i in 0..tokens.size - 3) {
            val left = tokens[i]
            val right = tokens[i+1]
            val op = tokens[i+2]
            if (op is OperatorToken && op.operator.symbol == "/") {
                if (left is NumberToken && left.value == 0.0)
                    if (right is NumberToken && right.value == 0.0)
                        return true
            }
        }
        return false
    }

    internal fun format(value: Double): String {
        if (value.isNaN()) return "Nan"
        if (value.isInfinite()) return "Infinite"
        return BigDecimal.valueOf(value)
            .setScale(12, RoundingMode.HALF_UP)
            .stripTrailingZeros()
            .toPlainString()
    }
}
