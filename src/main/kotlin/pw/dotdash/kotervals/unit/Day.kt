package pw.dotdash.kotervals.unit

import pw.dotdash.kotervals.Interval
import pw.dotdash.kotervals.TimeUnit
import pw.dotdash.kotervals.get

object Day : TimeUnit, StandardTimeUnit {
    override val millisecondsPerUnit: Long = 86400000

    override fun toString(): String = "days"
}

inline fun <T : TimeUnit> Interval<T>.toDays(): Interval<Day> = this[Day]

inline val Number.days: Interval<Day>
    get() = this[Day]