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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JsoupService {
    @Autowired
    private TagService tagService;
    private static boolean isAddTags = false;
    private final static Logger logger = LoggerFactory.getLogger(JsoupService.class);
    private final static Map<String, String> urlMap;

    static {
        urlMap = new HashMap<>();
        urlMap.put("Разное", "https://habr.com/ru/flows/misc/hubs/page");
        urlMap.put("Гиктаймс", "https://habr.com/ru/flows/geektimes/hubs/page");
        urlMap.put("Маркетинг", "https://habr.com/ru/flows/marketing/hubs/page");
        urlMap.put("Менеджмент", "https://habr.com/ru/flows/management/hubs/page");
        urlMap.put("Дизайн", "https://habr.com/ru/flows/design/hubs/page");
        urlMap.put("Администрирование", "https://habr.com/ru/flows/admin/hubs/page");
        urlMap.put("Разработка", "https://habr.com/ru/flows/develop/hubs/page");
    }


    public void addTags() {
        Document document = null;

        for (Map.Entry<String, String> entry : urlMap.entrySet()) {
            Map<String, String> map = new HashMap();
            boolean a = true;
            String currentUrl = entry.getValue();
            for (int i = 1; i > 0; i++) {
                try {
                    document = Jsoup.connect(currentUrl + i + "/")
                            .userAgent("Chrome/4.0.249.0 Safari/532.5")
                            .referrer("http://www.google.com")
                            .get();
                } catch (IOException e) {
                    logger.info("The end of parsing");
                    i = -1;
                    a = false;
                }

                if (a) {
                    Elements elements = document.select(
                            ".list-snippet__title-link");

                    if (elements.isEmpty()) {
                        logger.info("The end of parsing");
                        i = -1;
                    }
                    for (Element element : elements.select("a")) {
                        map.put(element.text(), element.attr("href"));
                    }
                    logger.info("Added " + entry.getKey());
                    tagService.addTags(map, entry.getKey());
                }
            }
        }

    }

    public static void setAddTags(boolean isAddTags) {
        JsoupService.isAddTags = isAddTags;
    }

    public static boolean isAddTags() {
        return isAddTags;
    }
}
