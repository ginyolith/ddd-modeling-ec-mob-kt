package auth.repository

import auth.Authentication

interface AuthenticationRepository {
    fun createOrGetAuthentication(input: String): Authentication
}