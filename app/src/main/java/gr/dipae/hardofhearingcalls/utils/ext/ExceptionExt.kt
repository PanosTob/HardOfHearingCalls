package gr.dipae.hardofhearingcalls.utils.ext

import java.io.IOException

data class BaseException(
    val code: Int,
    override val message: String = "Κάτι πήγε στραβά"
) : Exception()

class NoInternetException : IOException()