package pw.dotdash.kotervals

class Interval<out T : TimeUnit>(val unit: T, value: Number) {

    val value: Double = value.toDouble()

    val millis: Double = this.value * unit.millisecondsPerUnit

    fun <Other : TimeUnit> convert(thatUnit: Other): Interval<Other> =
            Interval(thatUnit, this.millis / thatUnit.millisecondsPerUnit)

    inline operator fun <reified Other : TimeUnit> get(thatUnit: Other): Interval<Other> =
            this.convert(thatUnit)

    operator fun plus(that: Interval<TimeUnit>): Interval<T> =
            Interval(this.unit, (this.millis + that.millis) / this.unit.millisecondsPerUnit)

    operator fun minus(that: Interval<TimeUnit>): Interval<T> =
            Interval(this.unit, (this.millis - that.millis) / this.unit.millisecondsPerUnit)

    operator fun times(that: Number): Interval<T> =
            Interval(this.unit, this.value * that.toDouble())

    operator fun div(that: Number): Interval<T> =
            Interval(this.unit, this.value / that.toDouble())

    operator fun inc(): Interval<T> =
            Interval(this.unit, this.value + 1)

    operator fun dec(): Interval<T> =
            Interval(this.unit, this.value + 1)

    operator fun contains(other: Interval<TimeUnit>): Boolean =
            this.millis >= other.millis

    operator fun compareTo(other: Interval<TimeUnit>): Int =
            this.millis.compareTo(other.millis)

    override operator fun equals(other: Any?): Boolean =
            if (other != null && other is Interval<TimeUnit>) {
                this.millis == other.millis
            } else {
                false
            }

    override fun hashCode(): Int =
            this.millis.hashCode()

    override fun toString(): String =
            "$value $unit"
}

inline operator fun <reified T : TimeUnit> Number.get(unit: T): Interval<T> = Interval(unit, this)