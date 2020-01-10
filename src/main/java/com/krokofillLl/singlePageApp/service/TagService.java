package com.krokofillLl.singlePageApp.service;

import com.krokofillLl.singlePageApp.domain.Tag;
import com.krokofillLl.singlePageApp.repos.ITagRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class TagService {

    @Autowired
    private ITagRepo tagRepo;

    private final static Logger logger = LoggerFactory.getLogger(TagService.class);

    public void addTags(Map<String, String> map, String section) {

        for(Map.Entry<String, String> entry: map.entrySet()) {

            Tag tagFromDB = tagRepo.findTagByName(entry.getKey());
            if(tagFromDB == null) {
                Tag tag = new Tag();
                tag.setSection(section);
                tag.setName(entry.getKey());
                tag.setUrl(entry.getValue());
                tagRepo.save(tag);
            }

//            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public Set<Tag> getDevelopTags() {
        return tagRepo.findTagBySection("Разработка");
    }
    public Set<Tag> getAdminTags() {
        return tagRepo.findTagBySection("Администрирование");
    }
    public Set<Tag> getDesignTags() {
        return tagRepo.findTagBySection("Дизайн");
    }
    public Set<Tag> getManagementTags() {
        return tagRepo.findTagBySection("Менеджмент");
    }
    public Set<Tag> getMarketingTags() {
        return tagRepo.findTagBySection("Маркетинг");
    }
    public Set<Tag> getGeektimesTags() {
        return tagRepo.findTagBySection("Гиктаймс");
    }
    public Set<Tag> getMiscTags() {
        return tagRepo.findTagBySection("Разное");
    }
}
