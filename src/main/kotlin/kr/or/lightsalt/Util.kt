package kr.or.lightsalt

import java.util.*

val String?.uuid: UUID
	get() {
		return if (isNullOrBlank()) UUID.randomUUID()
		else UUID.nameUUIDFromBytes(this!!.toByteArray())
	}

inline fun <T> Array<T>.each(action: T.() -> Unit) {
	for (element in this) element.action()
}

inline fun <T> Iterable<T>.each(action: T.() -> Unit) {
	for (element in this) element.action()
}
