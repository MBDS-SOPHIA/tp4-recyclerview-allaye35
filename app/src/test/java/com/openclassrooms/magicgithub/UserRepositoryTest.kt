package com.openclassrooms.magicgithub

import com.openclassrooms.magicgithub.api.FakeApiServiceGenerator.FAKE_USERS
import com.openclassrooms.magicgithub.api.FakeApiServiceGenerator.FAKE_USERS_RANDOM
import com.openclassrooms.magicgithub.di.Injection
import com.openclassrooms.magicgithub.model.User
import com.openclassrooms.magicgithub.repository.UserRepository
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.Assert.*
import com.openclassrooms.magicgithub.api.FakeApiService
import com.openclassrooms.magicgithub.api.FakeApiServiceGenerator


/**
 * Unit test, which will execute on a JVM.
 * Testing UserRepository.
 */
@RunWith(JUnit4::class)
class UserRepositoryTest {
    private lateinit var userRepository: UserRepository

    // Liste mutable pour stocker les utilisateurs
    private val users = FakeApiServiceGenerator.FAKE_USERS.toMutableList()

    @Before
    fun setup() {
        val apiService = FakeApiService()
        userRepository = UserRepository(apiService)
    }

    @Test
    fun getUsersWithSuccess() {
        val usersActual = userRepository.getUsers()
        val usersExpected = FakeApiServiceGenerator.FAKE_USERS
        assertEquals(
            "Les utilisateurs attendus et réels ne correspondent pas.",
            usersExpected,
            usersActual
        )
    }

    @Test
    fun generateRandomUserWithSuccess() {
        val initialSize = userRepository.getUsers().size
        userRepository.addRandomUser()
        val newSize = userRepository.getUsers().size
        assertEquals(
            "La taille de la liste après l’ajout ne correspond pas.",
            initialSize + 1,
            newSize
        )
        val lastUser = userRepository.getUsers().last()
        assertTrue(
            "L’utilisateur ajouté ne provient pas de la liste FAKE_USERS_RANDOM.",
            FakeApiServiceGenerator.FAKE_USERS_RANDOM.contains(lastUser)
        )
    }

    @Test
    fun deleteUserWithSuccess() {
        val userToDelete = userRepository.getUsers().first()
        userRepository.deleteUser(userToDelete)
        assertFalse(
            "L’utilisateur n’a pas été supprimé de la liste.",
            userRepository.getUsers().contains(userToDelete)
        )
    }


    /**
 * Retourne la liste des utilisateurs.
 */
 fun getUsers(): List<User> {
    return users
}

/**
 * Ajoute un utilisateur aléatoire à la liste.
 */
fun addRandomUser() {
    val randomUser = FakeApiServiceGenerator.FAKE_USERS_RANDOM.random()
    users.add(randomUser)
}

/**
 * Supprime un utilisateur de la liste.
 */
fun deleteUser(user: User) {
    users.remove(user)
}}

