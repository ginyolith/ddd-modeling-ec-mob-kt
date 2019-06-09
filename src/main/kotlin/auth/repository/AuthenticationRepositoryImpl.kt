package auth.repository

import auth.Authentication
import auth.AuthenticationId

class AuthenticationRepositoryImpl : AuthenticationRepository {
    private val authenticationData = mutableMapOf<String, Authentication>()

    override fun createOrGetAuthentication(input: String): Authentication {
        return authenticationData[input].let {
            if (it == null) {
                // 認証情報がデータベースに存在しない場合、新しく認証情報を作成する
                val auth = Authentication(AuthenticationId(input))
                authenticationData[input] = auth
                auth
            } else {
                //　既にデータが存在する場合は既存の人所情報を返す
                it
            }
        }
    }

}