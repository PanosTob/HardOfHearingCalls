package gr.dipae.hardofhearingcalls.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import gr.dipae.hardofhearingcalls.R

val openSansFontFamily = FontFamily(
    Font(R.font.open_sans_semi_bold)
)

val futuraFontFamily = FontFamily(
    Font(R.font.open_sans_regular),
    Font(R.font.open_sans_light, FontWeight.Light),
    Font(R.font.open_sans_bold, FontWeight.Bold),
    Font(R.font.open_sans_extra_bold, FontWeight.ExtraBold)
)

val hardOfHearingCallsTypography = Typography(
    h1 = TextStyle(
        color = primaryDarkColor,
        fontFamily = futuraFontFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 32.sp
    ),
    h2 = TextStyle(
        fontFamily = futuraFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    h3 = TextStyle(
        fontFamily = futuraFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    h4 = TextStyle(
        color = primaryDarkColor,
        fontFamily = futuraFontFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp
    ),
    h5 = TextStyle(
        color = primaryDarkColor,
        fontFamily = futuraFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    h6 = TextStyle(
        color = primaryDarkColor,
        fontFamily = futuraFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    body1 = TextStyle(
        color = primaryDarkColor,
        fontFamily = futuraFontFamily,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        color = primaryDarkColor,
        fontFamily = futuraFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    button = TextStyle(
        fontFamily = futuraFontFamily,
        fontWeight = FontWeight.Bold
    )
)