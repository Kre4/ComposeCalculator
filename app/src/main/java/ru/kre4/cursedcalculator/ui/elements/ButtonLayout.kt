package ru.kre4.cursedcalculator.ui.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(defaultKeyOrder) { item ->
            KeyButton(key = item, onClick = keyHandler)
        }
    }
}