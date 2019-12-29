package com.krokofillLl.singlePageApp.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tag_table")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String url;
//    @ManyToMany
//    private Set<Article> article;

    public Tag() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

//    public Set<Article> getArticle() {
//        return article;
//    }
//
//    public void setArticle(Set<Article> article) {
//        this.article = article;
//    }
}
