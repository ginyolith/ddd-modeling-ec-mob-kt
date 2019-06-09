package action.impl

import action.Authenticate
import auth.Authentication
import auth.repository.AuthenticationRepository

class AuthenticateImpl(private val repo : AuthenticationRepository) : Authenticate {
    override fun execute(input: String): Authentication
        = repo.createOrGetAuthentication(input)
}