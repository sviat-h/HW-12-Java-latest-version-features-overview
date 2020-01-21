package service;

public class Node {

    long key;
    String news;
    int frequency;
    Node prev;
    Node next;

    public Node(long key, String news, int frequency){
        this.key   = key;
        this.news = news;
        this.frequency = frequency;
    }
}
