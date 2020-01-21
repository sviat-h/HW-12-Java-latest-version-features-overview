import service.LFUCache;
import service.News;

public class Demo {
    public static void main(String[] args) {
        News news = new News();
        news.putToNewsList();

        System.err.println("Going to test the LFU Cache Implementation");
        LFUCache cache = new LFUCache(5);

        for (long i = 1L; i <= 10L; i++) {
            cache.put(i, news.getNews("News #" + i));
        }


        for (long i = 1L; i <= 10L; i++) {
            if (cache.get(i) != null) {
                System.out.println("Value for the key: " + i + " is " +
                        cache.get(i));
            }
        }
    }
}
