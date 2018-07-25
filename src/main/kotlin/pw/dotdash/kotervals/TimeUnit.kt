package pw.dotdash.kotervals

interface TimeUnit {
    val millisecondsPerUnit: Long
}

inline fun TimeUnit.conversionRate(that: TimeUnit): Long = this.millisecondsPerUnit / that.millisecondsPerUnit