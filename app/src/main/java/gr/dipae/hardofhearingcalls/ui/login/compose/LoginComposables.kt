package gr.dipae.hardofhearingcalls.ui.login.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import gr.dipae.hardofhearingcalls.R
import gr.dipae.hardofhearingcalls.ui.base.compose.VerticalSpacerDefault
import gr.dipae.hardofhearingcalls.ui.base.compose.VerticalSpacerDouble
import gr.dipae.hardofhearingcalls.ui.base.compose.VerticalSpacerHalf
import gr.dipae.hardofhearingcalls.ui.base.compose.VerticalSpacerQuarter
import gr.dipae.hardofhearingcalls.ui.login.LoginViewModel
import gr.dipae.hardofhearingcalls.ui.theme.*
import gr.dipae.hardofhearingcalls.utils.compose.AutoSizeText

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    LoginContent(viewModel::handleRegisterClicked)
}

@Composable
fun LoginContent(
    onRegisterClicked: () -> Unit
) {
    var emailTextValue by remember { mutableStateOf(TextFieldValue()) }
    var passwordTextValue by remember { mutableStateOf(TextFieldValue()) }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .imePadding()
            .padding(horizontal = SpacingDefault_16dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        VerticalSpacerDouble()
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(R.string.login_welcome),
            style = hardOfHearingCallsTypography.h1,
            color = secondaryDarkColor,
            textAlign = TextAlign.Center
        )
        VerticalSpacerHalf()
        Text(
            text = stringResource(R.string.login_welcome_sub),
            style = hardOfHearingCallsTypography.body2,
            color = secondaryDarkColor,
            textAlign = TextAlign.Center
        )
        VerticalSpacerDouble()
        Text(
            text = stringResource(R.string.login_sign_in_title),
            style = hardOfHearingCallsTypography.h3
        )
        VerticalSpacerDefault()
        Column(
            Modifier
                .fillMaxWidth()
                .background(backgroundColor, shapes.medium)
                .padding(top = SpacingHalf_8dp, bottom = SpacingDefault_16dp, start = SpacingHalf_8dp, end = SpacingHalf_8dp)
        ) {
            Text(modifier = Modifier.padding(start = SpacingDefault_16dp), text = stringResource(id = R.string.login_email_input_label), color = secondaryDarkColor)
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(backgroundColor),
                value = emailTextValue,
                onValueChange = { emailTextValue = it },
                singleLine = true,
                textStyle = TextStyle(
                    fontSize = 16.sp
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = backgroundColor,
                    textColor = accentColor,
                    cursorColor = accentColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                placeholder = {
                    Text(stringResource(id = R.string.login_email_placeholder_text))
                }
            )
            VerticalSpacerHalf()
            Text(modifier = Modifier.padding(start = SpacingDefault_16dp), text = stringResource(id = R.string.login_password_input_label), color = secondaryDarkColor)
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(backgroundColor),
                value = passwordTextValue,
                onValueChange = { passwordTextValue = it },
                singleLine = true,
                textStyle = TextStyle(
                    fontSize = 16.sp
                ),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (passwordVisible)
                        painterResource(id = R.drawable.ic_visibility_on)
                    else painterResource(id = R.drawable.ic_visibility_off)

                    // Please provide localized description for accessibility services
                    val description = if (passwordVisible) "Hide password" else "Show password"

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(painter = image, description, tint = secondaryColor)
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = backgroundColor,
                    textColor = accentColor,
                    cursorColor = accentColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                placeholder = {
                    Text(stringResource(id = R.string.login_password_placeholder_text))
                }
            )
        }
        VerticalSpacerDefault()
        Box(
            Modifier
                .fillMaxWidth()
                .background(secondaryDarkColor, shapes.medium)
                .padding(vertical = SpacingQuarter_4dp),
            contentAlignment = Alignment.Center
        ) {
            AutoSizeText(text = stringResource(id = R.string.login_sign_in_button_text), style = hardOfHearingCallsTypography.button, maxFontSize = 18.sp, color = backgroundColor)
        }
        VerticalSpacerDefault()
        VerticalSpacerHalf()
        Text(text = stringResource(id = R.string.login_sign_up_question), style = hardOfHearingCallsTypography.body1, color = secondaryDarkColor)
        VerticalSpacerQuarter()
        Text(
            modifier = Modifier.clickable { onRegisterClicked() },
            text = stringResource(id = R.string.login_sign_up_button_text),
            style = hardOfHearingCallsTypography.button,
            color = accentColor,
            fontSize = 18.sp
        )
    }
}