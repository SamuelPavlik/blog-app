package com.pavlik.blog.repository

import com.pavlik.blog.entity.Author
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class AuthorRepositoryTest @Autowired constructor(
    val entityManager: TestEntityManager,
    val authorRepository: AuthorRepository
) {
    @Test
    fun `When findByLogin then return Author`() {
        val johnDoe = Author("johnDoe", "John", "Doe")
        entityManager.persist(johnDoe)
        entityManager.flush()
        val user = authorRepository.findByLogin(johnDoe.login)
        Assertions.assertThat(user).isEqualTo(johnDoe)
    }

}