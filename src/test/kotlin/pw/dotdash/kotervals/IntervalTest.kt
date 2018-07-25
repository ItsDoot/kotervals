package pw.dotdash.kotervals

import pw.dotdash.kotervals.unit.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IntervalTest {

    @Test
    fun `time conversions`() {

        assertEquals(1.weeks, 7[Day][Week])
        assertEquals(1.0, 7[Day][Week].value, "Failed day to week conversion.")
        assertEquals(5.days[Minute], 7200.minutes, "Failed day to minute conversion.")
    }

    @Test
    fun `more time conversions`() {
        assertEquals<Interval<TimeUnit>>(1.weeks, 7.days)
        assertEquals<Interval<TimeUnit>>(1.days, 24.hours)
        assertEquals<Interval<TimeUnit>>(1.hours, 60.minutes)
        assertEquals<Interval<TimeUnit>>(1.minutes, 60.seconds)
        assertEquals<Interval<TimeUnit>>(1.seconds, 1000.milliseconds)
    }

    @Test
    fun `convert all units to millis`() {
        assertEquals(604800000.0, 1.weeks.millis, "Failed week conversion.")
        assertEquals(86400000.0, 1.days.millis, "Failed day conversion.")
        assertEquals(3600000.0, 1.hours.millis, "Failed hour conversion.")
        assertEquals(60000.0, 1.minutes.millis, "Failed minute conversion.")
        assertEquals(1000.0, 1.seconds.millis, "Failed second conversion.")
        assertEquals(1.0, 1.milliseconds.millis, "Failed millisecond conversion.")
    }

    @Test
    fun `time comparisons`() {
        assertEquals<Interval<TimeUnit>>(1.days, 24.hours)
        assertTrue(32.days > 3.hours)
        assertTrue(6.weeks < 365.days)
        assertFalse(3.minutes > 1.hours)
    }

    @Test
    fun `time operators`() {
        assertEquals(2.days, 1.days + 24.hours)
        assertEquals(4.minutes, 6.minutes - 120.seconds)
        assertEquals(25.minutes, 5.minutes * 5)
        assertEquals(5.minutes, 30.minutes / 6)
        assertTrue(5.minutes in 2.days)
    }
}