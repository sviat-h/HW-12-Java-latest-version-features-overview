package service;

class Node {

    long key;
    String news;
    int frequency;
    Node prev;
    Node next;

    Node(long key, String news, int frequency) {
        this.key = key;
        this.news = news;
        this.frequency = frequency;
    }
}
