package com.krokofillLl.singlePageApp.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class JsoupService {
    @Autowired
    private TagService tagService;
    private static boolean isAddTags = false;
    private final static Logger logger = LoggerFactory.getLogger(JsoupService.class);


    public void addTags() {
        Document document = null;
        Map<String, String> map = new HashMap();
        boolean a = true;

        for (int i = 1; i > 0; i++) {
            try {
                document = Jsoup.connect("https://qna.habr.com/tags/by_watchers?page=" + i)
                        .userAgent("Chrome/4.0.249.0 Safari/532.5")
                        .referrer("http://www.google.com")
                        .get();
            } catch (IOException e) {
                logger.info("The end of parsing");
                i = -1;
                a = false;
            }

            if(a) {
                Elements elements = document.select(".card__head-title");

                if (elements.isEmpty()) {
                    logger.info("The end of parsing");
                    i = -1;
                }
                for(Element element : elements.select("a")) {
                    map.put(element.text(), element.attr("href"));
                }
                logger.info("Added " + i + "tag page");
            }
        }
        tagService.addTags(map);
    }

    public static void setAddTags(boolean isAddTags) {
        JsoupService.isAddTags = isAddTags;
    }

    public static boolean isAddTags() {
        return isAddTags;
    }
}
