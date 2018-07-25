package pw.dotdash.kotervals.unit

import pw.dotdash.kotervals.Interval
import pw.dotdash.kotervals.TimeUnit
import pw.dotdash.kotervals.get

object Week : TimeUnit, StandardTimeUnit {
    override val millisecondsPerUnit: Long = 604800000

    override fun toString(): String = "weeks"
}

inline fun <T : TimeUnit> Interval<T>.toWeeks(): Interval<Week> = this[Week]

inline val Number.weeks: Interval<Week>
    get() = this[Week]