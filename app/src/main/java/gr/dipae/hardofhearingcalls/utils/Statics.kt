package gr.dipae.hardofhearingcalls.utils

import android.Manifest

const val VIDEO_CALL_ACTION = "VIDEO_CALL_ACTION"

// Kotlin
const val PERMISSION_REQ_ID_RECORD_AUDIO = 22
const val PERMISSION_REQ_ID_CAMERA = PERMISSION_REQ_ID_RECORD_AUDIO + 1

val REQUESTED_VIDEO_PERMISSIONS = arrayOf(
    Manifest.permission.RECORD_AUDIO,
    Manifest.permission.CAMERA
)

const val APP_ID = "3f8f0ecfc29443948ecc6b1fa1505ad6"
const val TOKEN = "007eJxTYNCKX3zGabVe9ZUzn05+qJ/59ODZ1LXRF86b3Vc+8zWB/fMbBQbjNIs0g9TktGQjSxMTY0sTi9TkZLMkw7REQ1MD08QUM0c+/eRD8QbJrRXpjIwMEAji8zCEpBaXKDhnJOblpeYwMAAA11EnSw=="
const val CHANNEL = "Test Channel"