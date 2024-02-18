package com.pavlik.blog.config

import com.pavlik.blog.entity.Article
import com.pavlik.blog.entity.Author
import com.pavlik.blog.repository.ArticleRepository
import com.pavlik.blog.repository.AuthorRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitializer(authorRepository: AuthorRepository,
                            articleRepository: ArticleRepository
    ) = ApplicationRunner {

        val johnDoe = authorRepository.save(Author("johnDoe", "John", "Doe"))
        articleRepository.save(
            Article(
            title = "Lorem",
            headline = "Lorem",
            content = "dolor sit amet",
            author = johnDoe
        )
        )
        articleRepository.save(
            Article(
            title = "Ipsum",
            headline = "Ipsum",
            content = "dolor sit amet",
            author = johnDoe
        )
        )
    }
}
