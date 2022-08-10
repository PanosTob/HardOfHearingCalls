package gr.dipae.hardofhearingcalls.ui.call.compose

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import gr.dipae.hardofhearingcalls.ui.call.VideoTranslationViewModel
import gr.dipae.hardofhearingcalls.ui.theme.SpacingDefault_16dp

@Composable
fun VideoTranslationScreen(viewModel: VideoTranslationViewModel) {
    VideoTranslationContent()
}

@Composable
fun VideoTranslationContent() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(
                start = SpacingDefault_16dp,
                end = SpacingDefault_16dp
            ),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        /*AndroidView(
            factory = { context ->
                JitsiMeetView(context)
                val options: JitsiMeetConferenceOptions = Builder()
                    .setRoom("https://meet.jit.si/test123")
                    .build()
                view.join(options)
            },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )*/
    }
}