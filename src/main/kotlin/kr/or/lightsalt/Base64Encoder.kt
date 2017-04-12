package kr.or.lightsalt

import java.math.BigInteger
import java.util.*

abstract class Base64Encoder {
	abstract fun encode(byteArray: ByteArray): String

	fun encode(longValue: Long) = encode(BigInteger.valueOf(longValue).toByteArray())

	fun encode(uuid: UUID) = encode(uuid.mostSignificantBits) + encode(uuid.leastSignificantBits)
}
