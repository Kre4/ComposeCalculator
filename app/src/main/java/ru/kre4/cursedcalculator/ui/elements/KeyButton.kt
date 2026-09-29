package ru.kre4.cursedcalculator.ui.elements

import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.kre4.cursedcalculator.logic.CalculatorKey
import ru.kre4.cursedcalculator.ui.theme.calculatorKey

@Composable
fun KeyButton(
    key: CalculatorKey,
    onClick: (CalculatorKey) -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = modifier,
        onClick = { onClick(key) }
    ) {
        Text(
            text = key.displayText,
            style = MaterialTheme.typography.calculatorKey
        )
    }
}