package controller;

import service.LFUCache;
import service.News;

public class AppExecutor {
    private static final int INITIAL_CAPACITY_FOR_CACHE = 5;
    private static final int NUMBER_OF_NEWS = 10;
    private News news = new News();
    private LFUCache cache = new LFUCache(INITIAL_CAPACITY_FOR_CACHE);

    public void runApp() {
        news.putToNewsList();

        for (int i = 1; i <= NUMBER_OF_NEWS; i++) {
            cache.put(i, news.getNews("News #" + i));
            cache.put(2, news.getNews("News #2"));
            cache.put(3, news.getNews("News #3"));
        }

        for (int i = 1; i <= NUMBER_OF_NEWS; i++) {
            if (cache.contains(i)) {
                System.out.println("Frequently used value for the key: " + i + " is " +
                        cache.get(i));
            }
        }
    }
}
