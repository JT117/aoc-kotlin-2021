import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

class Utils{}
/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Utils::class.java.classLoader.getResource("$name.txt")!!.readText().lines()
fun readInputToInt(name: String) = Utils::class.java.classLoader.getResource("$name.txt")!!.readText().lines().map{ it.toInt() }

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)
