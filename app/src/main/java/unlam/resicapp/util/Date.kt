package unlam.resicapp.util

import java.time.DayOfWeek
import java.time.LocalDateTime

sealed class Date(val isEvening: Boolean) {
    class DayOfTheWeek(isEvening: Boolean = false): Date(isEvening)
    class Weekend(isEvening: Boolean = false): Date(isEvening)

    companion object {
        fun getDay(date: LocalDateTime): Date {
            val dayOfWeek = date.dayOfWeek
            return when (dayOfWeek) {
                DayOfWeek.SATURDAY, DayOfWeek.SUNDAY -> {
                    Weekend(getIfEvening(date))
                }
                else -> {
                    DayOfTheWeek(getIfEvening(date))
                }
            }
        }
        private fun getIfEvening(date: LocalDateTime): Boolean {
            val hour = date.hour
            val minute = date.minute
            // Evening: from 15:00hs to 22:30hs
            return when (hour) {
                in 15..21 -> true
                22 -> minute <= 30
                else -> false
            }
        }
    }

}