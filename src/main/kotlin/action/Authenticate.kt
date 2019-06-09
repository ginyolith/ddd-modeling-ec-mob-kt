package action

import auth.Authentication

interface Authenticate : UseCase<String, Authentication>