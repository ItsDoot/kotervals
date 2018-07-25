package pw.dotdash.kotervals.unit

import pw.dotdash.kotervals.Interval
import pw.dotdash.kotervals.TimeUnit
import pw.dotdash.kotervals.get

object Millisecond : TimeUnit, StandardTimeUnit {
    override val millisecondsPerUnit: Long = 1

    override fun toString(): String = "milliseconds"
}

inline fun <T : TimeUnit> Interval<T>.toMilliseconds(): Interval<Millisecond> = this[Millisecond]

inline val Number.milliseconds: Interval<Millisecond>
    get() = this[Millisecond]