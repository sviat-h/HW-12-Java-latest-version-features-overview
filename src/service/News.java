package service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class News {
    Map<String, String> newsList = new HashMap<>();

    public void putToNewsList() {
        newsList.put("News #1", "The popular tourist destinations Hawaii and Thailand now join the growing group of states that has decided to ban a range of single-use plastic.");
        newsList.put("News #2", "The Norwegian city of Bergen now holds the world record for electric vehicles. 19.1 percent of the city’s cars are electric.");
        newsList.put("News #3", "The number of yearly deaths caused by air pollution in Europe has more than halved since 1990.");
        newsList.put("News #4", "In a move to curb child marriage, Indonesia has raised the minimum age for marriage from 16 to 19 years.");
        newsList.put("News #5", "A tiny blue-tailed lizard became extinct in the wild 10 years ago, but 1,500 lizards have been bred in captivity. They will be released on a safe island.");
        newsList.put("News #6", "The number of people worldwide without access to electricity decreased last year from 1000 million to 860 million. Most of the progress happened in India.");
        newsList.put("News #7", "The world has generally become significantly more tolerant of sexual minorities over the last decade, according to a survey conducted in 167 countries.");
        newsList.put("News #8", "Since 2014, the countries of the world have cleared around 800 square kilometres of landmines.");
        newsList.put("News #9", "The total use of coal to generate electricity is set to decrease by 3 percent this year. This amounts to the total coal use by Germany, UK, and Spain combined.");
        newsList.put("News #10", "Since 2016, organised Pakistani schoolgirls have helped diagnose more than million tuberculosis patients and referred them to treatment.");
    }

    public String getNews(String key) {
        return newsList.get(key);
    }


    @Override
    public String toString() {
        return "News{" +
                "newsList=" + newsList +
                '}';
    }
}
