package com.krokofillLl.singlePageApp.repos;

import com.krokofillLl.singlePageApp.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITagRepo extends JpaRepository<Tag, Long> {
    Tag findTagByName(String name);
}
