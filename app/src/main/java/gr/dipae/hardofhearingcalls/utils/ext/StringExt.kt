package gr.dipae.hardofhearingcalls.utils.ext

val String?.isNullOrEmptyOrBlank: Boolean
    get() = isNullOrEmpty() || this.isBlank()