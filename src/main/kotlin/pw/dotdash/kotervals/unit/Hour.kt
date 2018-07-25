package pw.dotdash.kotervals.unit

import pw.dotdash.kotervals.Interval
import pw.dotdash.kotervals.TimeUnit
import pw.dotdash.kotervals.get

object Hour : TimeUnit, StandardTimeUnit {
    override val millisecondsPerUnit: Long = 3600000

    override fun toString(): String = "hours"
}

inline fun <T : TimeUnit> Interval<T>.toHours(): Interval<Hour> = this[Hour]

inline val Number.hours: Interval<Hour>
    get() = this[Hour]