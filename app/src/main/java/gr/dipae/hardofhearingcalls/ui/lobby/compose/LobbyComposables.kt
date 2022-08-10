package gr.dipae.hardofhearingcalls.ui.lobby.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import gr.dipae.hardofhearingcalls.R
import gr.dipae.hardofhearingcalls.domain.lobby.entity.Contact
import gr.dipae.hardofhearingcalls.ui.base.compose.HorizontalSpacerHalf
import gr.dipae.hardofhearingcalls.ui.base.compose.VerticalSpacerEighth
import gr.dipae.hardofhearingcalls.ui.lobby.LobbyViewModel
import gr.dipae.hardofhearingcalls.ui.theme.ColorDivider
import gr.dipae.hardofhearingcalls.ui.theme.SpacingDefault_16dp
import gr.dipae.hardofhearingcalls.ui.theme.SpacingHalf_8dp
import gr.dipae.hardofhearingcalls.ui.theme.secondaryDarkColor
import gr.dipae.hardofhearingcalls.utils.compose.AutoSizeText

@Composable
fun LobbyScreen(viewModel: LobbyViewModel) {
    val contacts by viewModel.contactItems.observeAsState()
    LobbyContent(
        contacts,
        viewModel::handleContactClicked
    )
}

@Composable
fun LobbyContent(
    contacts: List<Contact>?,
    onItemClicked: (Contact) -> Unit
) {
    if (contacts.isNullOrEmpty()) {
        LobbyEmptyContacts()
        return
    }
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(items = contacts, key = { item -> item.id }) { item ->
            ContactItem(item = item, onItemClicked)
        }
    }
}

@Composable
fun ContactItem(
    item: Contact,
    onItemClicked: (Contact) -> Unit
) {
    val contactChar = item.firstName.firstOrNull() ?: ""
    Row(
        Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .padding(vertical = SpacingHalf_8dp, horizontal = SpacingDefault_16dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Box(modifier = Modifier.background(secondaryDarkColor, CircleShape)) {
                AutoSizeText(text = contactChar.toString(), maxFontSize = 16.sp)
            }
            HorizontalSpacerHalf()
            Column {
                Text(text = "${item.firstName} ${item.lastName}", fontWeight = FontWeight.Bold)
                VerticalSpacerEighth()
                Text(text = item.email, color = ColorDivider)
            }
        }
        Icon(modifier = Modifier
            .fillMaxWidth(0.1f)
            .aspectRatio(1f)
            .clickable { onItemClicked(item) }, painter = painterResource(id = R.drawable.ic_camera), contentDescription = "")
    }
    Divider(color = ColorDivider)
}

@Composable
fun LobbyEmptyContacts() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = SpacingDefault_16dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = stringResource(id = R.string.lobby_empty_view_text))
    }
}