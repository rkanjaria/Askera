package com.ai.askera.core.presentation.util

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone


fun String.toMillis(): Long {
    return try {
        val date = Calendar.getInstance()
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault())
        date.time = format.parse(this.replace("Z$".toRegex(), "+0000")) as Date
        date.timeInMillis
    } catch (e: Exception) {
        0
    }
}

fun String.toDateWithFullYear(): String {

    var formattedDate = ""
    val format = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
    format.timeZone = TimeZone.getDefault()
    var date: Date? = null
    try {
        val isoFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault())
        date = isoFormat.parse(this.replace("Z$".toRegex(), "+0000"))
        formattedDate = format.format(date as Date)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return formattedDate
}

fun String.toSimpleDate(): String {

    var formattedDate = ""
    val format = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
    format.timeZone = TimeZone.getDefault()
    var date: Date? = null
    try {
        val isoFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        date = isoFormat.parse(this)
        formattedDate = format.format(date as Date)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return formattedDate
}

fun Long.toSimpleDate(): String {

    var formattedDate = ""
    val format = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
    format.timeZone = TimeZone.getDefault()
    try {
        val date = Date(this)
        formattedDate = format.format(date)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return formattedDate
}

fun String.toOnlyYear(): String {

    var formattedDate = ""
    val format = SimpleDateFormat("yyyy", Locale.getDefault())
    format.timeZone = TimeZone.getDefault()
    var date: Date? = null
    try {
        val isoFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        date = isoFormat.parse(this)
        formattedDate = format.format(date as Date)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return formattedDate
}

fun String.getTimeAgo(): String {

    val seconds = 1
    val minute = 60 * seconds
    val hour = 60 * minute
    val day = 24 * hour
    val month = 30 * day
    val year = 12 * month

    val time = this.toMillis()
    val now = Calendar.getInstance().timeInMillis

    val diff = (now - time) / 1000 // Convert to seconds

    return when {
        diff < minute -> "Just now"
        diff < 2 * minute -> "A minute ago"
        diff < 60 * minute -> "${diff / minute} minutes ago"
        diff < 2 * hour -> "An hour ago"
        diff < 24 * hour -> "${diff / hour} hours ago"
        diff < 2 * day -> "Yesterday"
        diff < 30 * day -> "${diff / day} days ago"
        diff < 2 * month -> "A month ago"
        diff < 12 * month -> "${diff / month} months ago"
        diff < 2 * year -> "A year ago"
        else -> "${diff / year} years ago"
    }
}