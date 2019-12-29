package com.krokofillLl.singlePageApp.repos;

import com.krokofillLl.singlePageApp.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArticleRepo  extends JpaRepository<Article, Long> {
    Article findArticleByText(String text);
}
