package gr.dipae.hardofhearingcalls.utils.ext

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import gr.dipae.hardofhearingcalls.R

/*
 * prevent open 2 times
 */
fun NavController.singleNavigate(destinationResId: Int, args: Bundle? = null, navOptions: NavOptions? = null) {
    if (currentDestination?.id != destinationResId) {
        navigate(destinationResId, args, navOptions)
    }
}

/*
 * prevent quick-double-tap crash
 */
fun NavController.safeNavigate(action: NavDirections, currentId: Int) {
    if (currentDestination?.id == currentId) {
        navigate(action)
    }
}

fun NavController.safeNavigate(action: NavDirections, extras: Navigator.Extras, currentId: Int) {
    if (currentDestination?.id == currentId) {
        navigate(action, extras)
    }
}

/*
 * navigate directly to a specific destination within a nested graph
 */
fun NavController.navigateNestedGraphDeepLink(
    destinationUri: String,
    currentId: Int,
    navOptions: NavOptions? = slideNavOptions(),
    navigatorExtras: Navigator.Extras? = null
) {
    if (currentDestination?.id == currentId) {
        val uri = Uri.parse(destinationUri)
        navigate(uri, navOptions, navigatorExtras)
    }
}

/*
 * pop from back stack otherwise single navigate
 */
fun NavController.checkBackStackNavigate(
    destinationResId: Int,
    bundle: Bundle? = null,
    inclusive: Boolean = false,
    navOptions: NavOptions = slideNavOptions(destinationResId, true),
) {
    if ((currentDestination?.id != destinationResId && !popBackStack(destinationResId, inclusive))) {
        navigate(destinationResId, bundle, navOptions)
    }
}

fun slideBottomNavOptions(popToId: Int? = null, inclusive: Boolean = false): NavOptions {
    val navOptionsBuilder = NavOptions.Builder()
        .setEnterAnim(R.anim.slide_in_bottom)
        .setExitAnim(androidx.navigation.ui.R.anim.nav_default_enter_anim)
        .setPopEnterAnim(androidx.navigation.ui.R.anim.nav_default_pop_enter_anim)
        .setPopExitAnim(R.anim.slide_out_bottom)

    // check popTo
    popToId?.let {
        navOptionsBuilder.setPopUpTo(it, inclusive)
    }

    return navOptionsBuilder.build()
}

fun slideNavOptions(popToId: Int? = null, inclusive: Boolean = false): NavOptions {
    val navOptionsBuilder = NavOptions.Builder()
        .setEnterAnim(R.anim.slide_in_right)
        .setExitAnim(R.anim.slide_out_left)
        .setPopEnterAnim(R.anim.slide_in_left)
        .setPopExitAnim(R.anim.slide_out_right)

    // check popTo
    popToId?.let {
        navOptionsBuilder.setPopUpTo(it, inclusive)
    }

    return navOptionsBuilder.build()
}

fun fadeNavOptions(popToId: Int? = null, inclusive: Boolean = false): NavOptions {
    val navOptionsBuilder = NavOptions.Builder()
        .setEnterAnim(R.anim.fade_in)
        .setExitAnim(R.anim.fade_out)
        .setPopEnterAnim(R.anim.fade_in)
        .setPopExitAnim(R.anim.fade_out)

    // check popTo
    popToId?.let {
        navOptionsBuilder.setPopUpTo(it, inclusive)
    }

    return navOptionsBuilder.build()
}

fun defaultNavOptions(popToId: Int? = null, inclusive: Boolean = false): NavOptions {
    val navOptionsBuilder = NavOptions.Builder()
        .setEnterAnim(androidx.navigation.ui.R.anim.nav_default_enter_anim)
        .setExitAnim(androidx.navigation.ui.R.anim.nav_default_exit_anim)
        .setPopEnterAnim(androidx.navigation.ui.R.anim.nav_default_pop_enter_anim)
        .setPopExitAnim(androidx.navigation.ui.R.anim.nav_default_pop_exit_anim)

    // check popTo
    popToId?.let {
        navOptionsBuilder.setPopUpTo(it, inclusive)
    }

    return navOptionsBuilder.build()
}