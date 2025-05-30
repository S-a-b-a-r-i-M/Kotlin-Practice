package advance

import java.security.SecureRandom
import java.util.Base64
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec

private const val ALGORITHM = "PBKDF2WithHmacSHA512"
private const val ITERATIONS = 120_000
private const val KEY_LENGTH = 256
private const val SALT_LENGTH = 16 // 128 bits

object PasswordHasher {
    private fun generateRandomSalt(): ByteArray {
        val salt = ByteArray(SALT_LENGTH)
        SecureRandom().nextBytes(salt)
        return salt
    }

    private fun getHash(password: String, salt: ByteArray): ByteArray {
        val factory = SecretKeyFactory.getInstance(ALGORITHM)
        val spec = PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH)
        return factory.generateSecret(spec).encoded
    }

    fun getHashPassword(password: String): String {
        // Get Salt & Password's Hash
        val salt: ByteArray = generateRandomSalt()
        val hash: ByteArray = getHash(password, salt)

        // Encode to String
        val encoder = Base64.getEncoder()
        return "${encoder.encodeToString(salt)}:${encoder.encodeToString(hash)}"
    }

    fun checkPasswordMatch(plainPassword: String, hashPassword: String): Boolean {
        val parts = hashPassword.split(":")
        if (parts.size != 2) {
            println("Invalid hash password format!!!")
            return false
        }

        val decoder = Base64.getDecoder()
        val salt = decoder.decode(parts[0])
        val existingPasswordHash = decoder.decode(parts[1])

        // Hash Input & Compare
        val inputPasswordHash: ByteArray = getHash(plainPassword, salt)
        return existingPasswordHash.contentEquals(inputPasswordHash)
    }
}

fun main() {
    println("-------------------- Password 1 --------------------")
    var password = "myPasswordis998877"
    var hashedPassword = PasswordHasher.getHashPassword(password)
    println("hashedPassword: $hashedPassword")

    println("passwordMatch with valid: ${PasswordHasher.checkPasswordMatch(password, hashedPassword)}")
    println("passwordMatch with invalid: ${PasswordHasher.checkPasswordMatch("myPasswordis99887", hashedPassword)}")
    println("passwordMatch with invalid: ${PasswordHasher.checkPasswordMatch("998877myPasswordis", hashedPassword)}")

    println("\n-------------------- Password 2 --------------------")
    password = "S@bari2002"
    hashedPassword = PasswordHasher.getHashPassword(password)
    println("hashedPassword: $hashedPassword")

    println("passwordMatch with valid: ${PasswordHasher.checkPasswordMatch(password, hashedPassword)}")
    println("passwordMatch with invalid: ${PasswordHasher.checkPasswordMatch("S@bari2oo2", hashedPassword)}")
    println("passwordMatch with invalid: ${PasswordHasher.checkPasswordMatch("s@bari2002", hashedPassword)}")
}