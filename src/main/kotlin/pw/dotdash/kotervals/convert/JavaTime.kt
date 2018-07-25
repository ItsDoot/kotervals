package pw.dotdash.kotervals.convert

import pw.dotdash.kotervals.Interval
import pw.dotdash.kotervals.TimeUnit
import pw.dotdash.kotervals.unit.*
import java.time.Duration
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalUnit

////////////////////////////////////////
// Instant
////////////////////////////////////////

operator fun <T : TimeUnit> Instant.plus(interval: Interval<T>): Instant =
        this.plusMillis(interval.millis.toLong())

operator fun <T : TimeUnit> Instant.minus(interval: Interval<T>): Instant =
        this.minusMillis(interval.millis.toLong())

////////////////////////////////////////
// Duration
////////////////////////////////////////

inline fun <reified T : TimeUnit> Interval<T>.toDuration(): Duration =
        Duration.ofMillis(this.millis.toLong())

inline fun <reified T : TimeUnit> Duration.toInterval(unit: T): Interval<T> =
        Interval(unit, this.toMillis() / unit.millisecondsPerUnit)

inline fun <reified T : StandardTimeUnit> T.toTemporalUnit(): TemporalUnit =
        when (this) {
            Millisecond -> ChronoUnit.MILLIS
            Second -> ChronoUnit.SECONDS
            Minute -> ChronoUnit.MINUTES
            Hour -> ChronoUnit.HOURS
            Day -> ChronoUnit.DAYS
            Week -> ChronoUnit.WEEKS
            else -> throw UnsupportedOperationException("TemporalUnit conversion is unsupported")
        }