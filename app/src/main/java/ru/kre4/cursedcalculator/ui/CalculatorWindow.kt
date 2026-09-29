package ru.kre4.cursedcalculator.ui

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import net.objecthunter.exp4j.ExpressionBuilder
import ru.kre4.cursedcalculator.logic.CalculatorKey
import ru.kre4.cursedcalculator.ui.elements.ButtonLayout
import ru.kre4.cursedcalculator.ui.theme.grannyText

@Composable
fun CalculatorWindow(modifier: Modifier = Modifier) {
    var expression by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current
    Column(modifier = modifier) {
        Text(
            text = expression,
            textAlign = TextAlign.Right,
            style = MaterialTheme.typography.grannyText,
            modifier = Modifier
                .weight(1f)
                .padding(10.dp)
                .wrapContentHeight()
                .fillMaxWidth()
                .testTag("result")
        )
        ButtonLayout(
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth(),
            keyHandler = { key ->
                expression = when (key) {
                    CalculatorKey.Backspace -> expression.dropLast(1)
                    CalculatorKey.Clear -> ""
                    CalculatorKey.Evaluate ->
                        try {
                            ExpressionBuilder(expression).build().evaluate().toString()
                        } catch (e: Exception) {
                            Log.e("EvalLog", e.message, e)
                            Toast.makeText(context, "Evaluation error", Toast.LENGTH_SHORT).show()
                            expression
                        }
                    else -> expression + key.displayText
                }

            }
        )
    }
}