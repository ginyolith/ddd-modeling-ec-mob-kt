package auth

data class AuthenticationId(private val value : String) {
    override fun toString(): String {
        return value
    }
}