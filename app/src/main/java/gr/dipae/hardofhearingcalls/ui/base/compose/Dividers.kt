package gr.dipae.hardofhearingcalls.ui.base.compose

import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import gr.dipae.hardofhearingcalls.R
import gr.dipae.hardofhearingcalls.ui.theme.ColorDivider

@Composable
fun DividerHorizontal(modifier: Modifier) {
    Divider(
        modifier = modifier,
        color = ColorDivider,
        thickness = 1.dp
    )
}

