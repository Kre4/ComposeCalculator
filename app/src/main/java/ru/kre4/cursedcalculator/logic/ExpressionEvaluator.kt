package ru.kre4.cursedcalculator.logic

import net.objecthunter.exp4j.ExpressionBuilder
import java.math.BigDecimal
import java.math.RoundingMode

object ExpressionEvaluator {

    fun evaluate(expression: String): String {
        if (expression.isBlank()) return "0"
        return try {
            format(ExpressionBuilder(expression).build().evaluate())
        } catch (_: ArithmeticException) {
            "NaN"
        }
        catch (_: Exception) {
            "Error"
        }
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
