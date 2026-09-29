package ru.kre4.cursedcalculator.ui.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.kre4.cursedcalculator.logic.CalculatorKey

@Composable
fun ButtonLayout(modifier: Modifier = Modifier, keyHandler: (CalculatorKey) -> Unit) {
    val defaultKeyOrder = listOf(
        CalculatorKey.Clear,
        CalculatorKey.OpenBracket,
        CalculatorKey.ClosedBracket,
        CalculatorKey.Backspace,
        CalculatorKey.Digit(7),
        CalculatorKey.Digit(8),
        CalculatorKey.Digit(9),
        CalculatorKey.Multiplication,
        CalculatorKey.Digit(4),
        CalculatorKey.Digit(5),
        CalculatorKey.Digit(6),
        CalculatorKey.Minus,
        CalculatorKey.Digit(1),
        CalculatorKey.Digit(2),
        CalculatorKey.Digit(3),
        CalculatorKey.Plus,
        CalculatorKey.Digit(0),
        CalculatorKey.Dot,
        CalculatorKey.Division,
        CalculatorKey.Evaluate,
    )
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        defaultKeyOrder.chunked(4).forEach { rowKeys ->
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                rowKeys.forEach { key ->
                    KeyButton(
                        key = key,
                        onClick = keyHandler,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                    )
                }
            }
        }
    }
}