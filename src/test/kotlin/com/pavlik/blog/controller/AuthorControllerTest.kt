package com.pavlik.blog.controller

import com.ninjasquad.springmockk.MockkBean
import com.pavlik.blog.entity.Author
import com.pavlik.blog.repository.ArticleRepository
import com.pavlik.blog.repository.AuthorRepository
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
class AuthorControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    lateinit var authorRepository: AuthorRepository

    @MockkBean
    lateinit var articleRepository: ArticleRepository

    @Test
    fun `List authors`() {
        val johnDoe = Author("johnDoe", "John", "Doe")
        val janeDoe = Author("janeDoe", "Jane", "Doe")
        every { authorRepository.findAll() } returns listOf(johnDoe, janeDoe)
        mockMvc.perform(get("/api/user/").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.[0].login").value(johnDoe.login))
            .andExpect(jsonPath("\$.[1].login").value(janeDoe.login))
    }
}