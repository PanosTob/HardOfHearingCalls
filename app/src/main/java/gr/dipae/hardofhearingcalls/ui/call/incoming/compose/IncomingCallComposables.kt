package gr.dipae.hardofhearingcalls.ui.call.incoming.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import gr.dipae.hardofhearingcalls.R
import gr.dipae.hardofhearingcalls.domain.lobby.entity.Contact
import gr.dipae.hardofhearingcalls.ui.base.compose.VerticalSpacerQuarter
import gr.dipae.hardofhearingcalls.ui.call.incoming.IncomingCallViewModel
import gr.dipae.hardofhearingcalls.ui.theme.*
import gr.dipae.hardofhearingcalls.utils.compose.AutoSizeText

@Composable
fun IncomingCallScreen(viewModel: IncomingCallViewModel) {
    val contact by viewModel.contact.observeAsState()

    IncomingCallContent(contact = contact)
}

@Composable
fun IncomingCallContent(
    contact: Contact?
) {
    contact?.let {
        val contactChar = contact.firstName.firstOrNull() ?: ""

        Box(
            Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(primaryColor, secondaryColor)
                    )
                )
                .padding(vertical = SpacingTriple_48dp, horizontal = SpacingDouble_32dp)
        ) {
            Column(Modifier.align(Alignment.TopCenter)) {
                Icon(
                    modifier = Modifier
                        .fillMaxWidth(0.05f)
                        .aspectRatio(1f),
                    painter = painterResource(id = R.drawable.ic_camera),
                    contentDescription = ""
                )
                VerticalSpacerQuarter()
                Text(stringResource(id = R.string.incoming_call_title, backgroundColor))
            }

            Column(Modifier.align(Alignment.Center)) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.35f)
                        .aspectRatio(1f)
                        .background(ColorDivider, CircleShape)
                ) {
                    AutoSizeText(text = contactChar.toString(), maxFontSize = 16.sp)
                }
                Text(text = "${contact.firstName} ${contact.lastName}", fontWeight = FontWeight.Bold)
                Text(text = contact.email, fontWeight = FontWeight.Normal)
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Box(
                    Modifier
                        .fillMaxWidth(0.2f)
                        .aspectRatio(1f)
                        .background(Color.Green, CircleShape)
                        .padding(SpacingQuarter_4dp)
                ) {
                    Icon(
                        modifier = Modifier
                            .fillMaxSize()
                            .aspectRatio(1f)
                            .clickable {},
                        painter = painterResource(id = R.drawable.ic_check),
                        tint = backgroundColor,
                        contentDescription = ""
                    )
                }
                Box(
                    Modifier
                        .fillMaxWidth(0.2f)
                        .aspectRatio(1f)
                        .background(Color.Red, CircleShape)
                        .padding(SpacingQuarter_4dp)
                ) {
                    Icon(
                        modifier = Modifier
                            .fillMaxSize()
                            .aspectRatio(1f)
                            .clickable {},
                        painter = painterResource(id = R.drawable.ic_close),
                        tint = backgroundColor,
                        contentDescription = ""
                    )
                }
            }
        }
    }
}