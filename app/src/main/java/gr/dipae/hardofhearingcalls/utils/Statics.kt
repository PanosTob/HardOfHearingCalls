package gr.dipae.hardofhearingcalls.utils

import android.Manifest

const val VIDEO_CALL_ACTION = "VIDEO_CALL_ACTION"

//Generic Error Codes
const val APPLICATION_ERROR_CODE = -10000
const val AUTHENTICATION_ERROR_CODE = -10001
const val NETWORK_ERROR_CODE = -10002
const val GENERAL_ERROR_CODE = -20000
const val SUCCESS_RESPONSE_CODE = 200
const val INVALID_PAYLOAD = -48000
const val INVALID_LOGIN_CREDENTIALS = 7
const val INVALID_TOKEN_ERROR = 1
const val PAYMENT_ERROR = -10003
const val PASSWORD_WEAK_CODE = -10004
const val USER_ALREADY_EXISTS_CODE = -10005
const val TEMPORAL_BLOCKED_ERROR_CODE = -10006
const val USER_CURRENTLY_UNAVAILABLE = -10007
const val PAYMENT_NOT_INITIALIZED = -10008
const val API_CANT_BE_REACHED = -10010

//Shared Preferences Keys
const val HARD_OF_HEARING_PREFS = "HARD_OF_HEARING_PREFS"
const val UUID = "UUID"

// Kotlin
const val PERMISSION_REQ_ID_RECORD_AUDIO = 22
const val PERMISSION_REQ_ID_CAMERA = PERMISSION_REQ_ID_RECORD_AUDIO + 1

val REQUESTED_VIDEO_PERMISSIONS = arrayOf(
    Manifest.permission.RECORD_AUDIO,
    Manifest.permission.CAMERA
)

//Firestore Database
const val USERS_TABLE = "users"
const val USER_FIRSTNAME_KEY = "firstName"
const val USER_LASTNAME_KEY = "lastName"
const val USER_USERNAME_KEY = "username"
const val USER_DEVICE_ID_KEY = "deviceID"


const val APP_ID = "3f8f0ecfc29443948ecc6b1fa1505ad6"
const val TOKEN =
    "007eJxTYNCKX3zGabVe9ZUzn05+qJ/59ODZ1LXRF86b3Vc+8zWB/fMbBQbjNIs0g9TktGQjSxMTY0sTi9TkZLMkw7REQ1MD08QUM0c+/eRD8QbJrRXpjIwMEAji8zCEpBaXKDhnJOblpeYwMAAA11EnSw=="
const val CHANNEL = "Test Channel"