package gr.dipae.hardofhearingcalls.ui.base.compose

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import gr.dipae.hardofhearingcalls.R

@Composable
fun VerticalSpacerQuadruple() {
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.margin_quadruple_64dp)))
}

@Composable
fun VerticalSpacerDouble() {
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.margin_double_32dp)))
}

@Composable
fun VerticalSpacerDefault() {
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.margin_default_16dp)))
}

@Composable
fun VerticalSpacerHalfDouble() {
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.margin_half_double_12dp)))
}

@Composable
fun VerticalSpacerHalf() {
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.margin_half_8dp)))
}

@Composable
fun VerticalSpacerQuarter() {
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.margin_quarter_4dp)))
}

@Composable
fun VerticalSpacerEighth() {
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.margin_eighth_2dp)))
}

@Composable
fun HorizontalSpacerQuadruple() {
    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.margin_quadruple_64dp)))
}

@Composable
fun HorizontalSpacerDouble() {
    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.margin_double_32dp)))
}

@Composable
fun HorizontalSpacerDefault() {
    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.margin_default_16dp)))
}

@Composable
fun HorizontalSpacerHalf() {
    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.margin_half_8dp)))
}

@Composable
fun HorizontalSpacerQuarter() {
    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.margin_quarter_4dp)))
}

@Composable
fun HorizontalSpacerEighth() {
    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.margin_eighth_2dp)))
}

