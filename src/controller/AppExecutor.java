package controller;

import service.LFUCache;
import service.News;

public class AppExecutor {
    private News news = new News();

    public void runApp() {
        news.putToNewsList();

        LFUCache cache = new LFUCache(5);

        for (long i = 1L; i <= 10L; i++) {

            cache.put(i, news.getNews("News #" + i));
            cache.put(2L, news.getNews("News #1"));
            cache.put(3L, news.getNews("News #2"));
        }

        for (long i = 1L; i <= 10L; i++) {
            if (cache.get(i) != null) {
                System.out.println("Frequently used value for the key: " + i + " is " +
                        cache.get(i));
            }
        }
    }
}
