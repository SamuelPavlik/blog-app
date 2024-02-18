package com.pavlik.blog.repository

import com.pavlik.blog.entity.Author
import org.springframework.data.repository.CrudRepository

interface AuthorRepository : CrudRepository<Author, Long> {
    fun findByLogin(login: String): Author?
}