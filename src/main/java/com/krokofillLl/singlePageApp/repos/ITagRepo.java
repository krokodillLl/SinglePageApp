package com.krokofillLl.singlePageApp.repos;

import com.krokofillLl.singlePageApp.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ITagRepo extends JpaRepository<Tag, Long> {
    Tag findTagByName(String name);
    Set<Tag> findTagBySection(String name);
}
