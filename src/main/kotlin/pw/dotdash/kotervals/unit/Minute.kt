package pw.dotdash.kotervals.unit

import pw.dotdash.kotervals.Interval
import pw.dotdash.kotervals.TimeUnit
import pw.dotdash.kotervals.get

object Minute : TimeUnit, StandardTimeUnit {
    override val millisecondsPerUnit: Long = 60000

    override fun toString(): String = "minutes"
}

inline fun <T : TimeUnit> Interval<T>.toMinutes(): Interval<Minute> = this[Minute]

inline val Number.minutes: Interval<Minute>
    get() = this[Minute]