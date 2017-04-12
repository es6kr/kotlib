package kr.or.lightsalt

import org.joda.time.LocalDate
import org.joda.time.LocalTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormat.forPattern
import java.util.*

val longDatePattern by lazy { DateTimeFormat.patternForStyle("L-", Locale.getDefault())!! }
val monthAndDayPattern by lazy { longDatePattern.replace("y+[\\S]*".toRegex(), "").trim() }

val shortTimePattern by lazy { DateTimeFormat.shortTime()!! }

val Date.simpleDate: String
	get () = LocalDate(time).simpleDate

val LocalDate.simpleDate: String
	get () = forPattern(if (year == LocalDate().year) monthAndDayPattern else longDatePattern)
			.print(this)

val LocalTime.shortTime: String
	get () = shortTimePattern.print(this)
