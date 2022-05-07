package com.example.blog;

import com.example.blog.model.Article;
import com.example.blog.model.User;
import com.example.blog.repo.ArticleRepository;
import com.example.blog.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class ScriptsTests extends ConfigTest{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ArticleRepository articleRepository;

	@Test
	void testUserScript() {
		User user = userRepository.findByLogin(userLogin);
		Boolean exist = userRepository.existsByLogin(userLogin);
		assertThat(user).isNotNull();
		assertThat(exist).isTrue();
	}

	@Test
	void testArticleScript() {
		Article article = articleRepository.findById("1").orElse(null);
		assertThat(article).isNotNull();
	}

}
