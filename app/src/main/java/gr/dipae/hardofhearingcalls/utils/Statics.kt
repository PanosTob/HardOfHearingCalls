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