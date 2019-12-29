package com.krokofillLl.singlePageApp.service;

import com.krokofillLl.singlePageApp.domain.Tag;
import com.krokofillLl.singlePageApp.repos.ITagRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TagService {

    @Autowired
    private ITagRepo tagRepo;

    private final static Logger logger = LoggerFactory.getLogger(TagService.class);

    public void addTags(Map<String, String> map) {

        for(Map.Entry<String, String> entry: map.entrySet()) {

            Tag tagFromDB = tagRepo.findTagByName(entry.getKey());
            if(tagFromDB == null) {
                Tag tag = new Tag();
                tag.setName(entry.getKey());
                tag.setUrl(entry.getValue());
                tagRepo.save(tag);
            }

//            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
