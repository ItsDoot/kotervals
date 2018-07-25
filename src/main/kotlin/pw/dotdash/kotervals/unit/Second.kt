package pw.dotdash.kotervals.unit

import pw.dotdash.kotervals.Interval
import pw.dotdash.kotervals.TimeUnit
import pw.dotdash.kotervals.get

object Second : TimeUnit, StandardTimeUnit {
    override val millisecondsPerUnit: Long = 1000

    override fun toString(): String = "seconds"
}

inline fun <T : TimeUnit> Interval<T>.toSeconds(): Interval<Second> = this[Second]

inline val Number.seconds: Interval<Second>
    get() = this[Second]