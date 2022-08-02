package gr.dipae.hardofhearingcalls.utils.ext

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.view.View
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.browser.customtabs.CustomTabsIntent
import gr.dipae.hardofhearingcalls.R

fun Activity.openToExternalBrowser(link: String) {
    when {
        link.isNotEmpty() -> {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            if (intent.isResolvable(packageManager)) {
                startActivity(intent)
            }
        }
    }
}

fun Activity.openToCustomTab(link: String, @ColorInt color: Int? = null) {
    val builder = CustomTabsIntent.Builder().apply {
        color?.let { setToolbarColor(it) }
        // add share button to overflow men
        addDefaultShareMenuItem()
        // show website title
        setShowTitle(true)

        val customTabsIntent = build()
        try {
            customTabsIntent.launchUrl(this@openToCustomTab, Uri.parse(link))
        } catch (e: Exception) {
            // try with native browser
            openToExternalBrowser(link)
        }
    }
}

fun Activity.actionToGoogleMaps(latitude: Double?, longitude: Double?) {
    val intent = Intent(
        Intent.ACTION_VIEW,
        Uri.parse("http://maps.google.com/maps?daddr=$latitude,$longitude")
    ).apply {
        setPackage("com.google.android.apps.maps")
    }
    if (intent.isResolvable(packageManager)) {
        startActivity(intent)
    }
}

fun Activity.performDialAction(phone: String?) {
    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${phone}"))
    if (intent.isResolvable(packageManager)) {
        startActivity(intent)
    }
}

fun Activity.actionToEmail(email: String) {
    val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$email"))
    if (intent.isResolvable(packageManager)) {
        startActivity(intent)
    }
}

fun Intent.isResolvable(packageManager: PackageManager): Boolean {
    return resolveActivity(packageManager) != null
}

fun Activity.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Activity.showToast(@StringRes messageId: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, messageId, duration).show()
}

fun Activity.showAlertDialog(@StringRes stringRes: Int, onPositive: () -> Unit = {}) {
    AlertDialog.Builder(this)
        .setMessage(stringRes)
        .setPositiveButton(R.string.dialog_action_ok) { _, _ ->
            onPositive()
        }
        .show()
}

fun Activity.openSettings(settingAction: String) {
    val intent = Intent(settingAction)
    if (intent.isResolvable(packageManager)) {
        startActivity(intent)
    }
}

fun Activity.hideSystemUI() {
    window?.decorView?.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            // Set the content to appear under the system bars so that the
            // content doesn't resize when the system bars hide and show.
            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            // Hide the nav bar and status bar
            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_FULLSCREEN)
}

fun Activity.drawBehindSystemUI() {
    window?.decorView?.systemUiVisibility =
        (View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
}

fun Activity.shareText(share: String?) {
    val sendIntent = Intent()
    sendIntent.action = Intent.ACTION_SEND
    sendIntent.putExtra(Intent.EXTRA_TEXT, share)
    sendIntent.type = "text/plain"
    this.startActivity(sendIntent)
}