package gr.dipae.hardofhearingcalls.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

@Composable
fun HardOfHearingCallsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) darkColorsPalette else lightColorsPalette

    val rippleCustomTheme = object : RippleTheme {
        @Composable
        override fun defaultColor() = RippleTheme.defaultRippleColor(Color.Black, lightTheme = true)

        @Composable
        override fun rippleAlpha(): RippleAlpha = RippleTheme.defaultRippleAlpha(Color.Black, lightTheme = true)
    }

    MaterialTheme(
        colors = colors,
        typography = hardOfHearingCallsTypography,
        shapes = shapes,
        content = { CompositionLocalProvider(LocalRippleTheme provides rippleCustomTheme) { content() } }
    )
}