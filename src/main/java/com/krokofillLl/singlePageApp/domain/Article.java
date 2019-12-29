package com.krokofillLl.singlePageApp.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "article_table")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String text;
    private String link;
    @ManyToMany
    private Set<Tag> tags;

    public Article() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}
