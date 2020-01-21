package service;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    Node head;
    Node tail;
    Map<Long, Node> map = null;
    int capacity = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public String get(long key) {

        if (map.get(key) == null) {
            return null;
        }

        Node item = map.get(key);
        // move to right position according to frequency
        removeNode(item);
        item.frequency = item.frequency + 1;
        addNodeWithUpdatedFrequency(item);

        return item.news;
    }

    public void put(Long key, String news) {

        if (map.containsKey(key)) {
            Node item = map.get(key);
            item.news = news;
            item.frequency = item.frequency + 1;
            // move to right position according to frequency
            removeNode(item);
            addNodeWithUpdatedFrequency(item);
        } else {
            if (map.size() >= capacity) {
                // delete head with least frequency and least recently used
                map.remove(head.key);
                removeNode(head);
            }

            // move to right position according to frequency
            Node node = new Node(key, news, 1);
            addNodeWithUpdatedFrequency(node);
            map.put(key, node);
        }
    }

    private void removeNode(Node node) {

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void addNodeWithUpdatedFrequency(Node node) {

        if (tail != null && head != null) {
            Node temp = head;
            while (temp != null) {
                if (temp.frequency > node.frequency) {
                    if (temp == head) {
                        node.next = temp;
                        temp.prev = node;
                        head = node;
                        break;
                    } else {
                        node.next = temp;
                        node.prev = temp.prev;
                        temp.prev.next = node;
                        node.prev = temp.prev;
                        break;
                    }
                } else {
                    temp = temp.next;
                    if (temp == null) {
                        tail.next = node;
                        node.prev = tail;
                        node.next = null;
                        tail = node;
                        break;
                    }
                }
            }
        } else {
            tail = node;
            head = tail;
        }
    }
}