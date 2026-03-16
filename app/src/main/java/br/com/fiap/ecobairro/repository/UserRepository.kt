package br.com.fiap.ecobairro.repository

import br.com.fiap.ecobairro.model.User

interface UserRepository {

    fun saveUser(user: User)
    fun getUser(): User
    fun getUserByEmail(email: String): User?
    fun login(email: String, password: String): Boolean
}