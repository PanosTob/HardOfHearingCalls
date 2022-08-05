package gr.dipae.hardofhearingcalls.ui.onboarding.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import gr.dipae.hardofhearingcalls.R
import gr.dipae.hardofhearingcalls.ui.base.compose.VerticalSpacerDefault
import gr.dipae.hardofhearingcalls.ui.base.compose.VerticalSpacerDouble
import gr.dipae.hardofhearingcalls.ui.onboarding.RegisterViewModel
import gr.dipae.hardofhearingcalls.ui.theme.hardOfHearingCallsTypography
import gr.dipae.hardofhearingcalls.ui.theme.primaryColor

@Composable
fun RegisterScreen(viewModel: RegisterViewModel) {

}

@Composable
fun RegisterContent() {
    Column(
        Modifier
            .fillMaxSize()
            .background(primaryColor),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(R.string.register_welcome),
            style = hardOfHearingCallsTypography.h1
        )
        VerticalSpacerDefault()
        Text(
            text = stringResource(R.string.register_welcome_sub),
            style = hardOfHearingCallsTypography.h3
        )
        VerticalSpacerDouble()
        Text(
            text = stringResource(R.string.),
            style = hardOfHearingCallsTypography.h3
        )
    }
}