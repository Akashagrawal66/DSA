package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxXor {
    public static void main(String[] args) {
        Trie trie = new Trie();
        int[] xor = {14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70};
        for (int i : xor) {
            trie.insert(i);
        }
        int maxXor = Integer.MIN_VALUE;
        for (int i : xor) {
            maxXor = Math.max(maxXor, trie.getMax(i));
        }
        System.out.println("The maximum xor in an array is: " + maxXor);
    }

    static class Trie {
        private static Node root;

        Trie() {
            root = new Node();
        }

        void insert(int num) {
            Node node = root;
            for (int i = 31; i >= 0; i--) {
                int temp = (num >> i) & 1;
                if (!node.containsKey(temp)) {
                    node.put(temp, new Node());
                }
                node = node.get(temp);
            }
        }

        int getMax(int num) {
            Node node = root;
            int maxNum = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.containsKey(1 - bit)) {
                    maxNum = maxNum | (1 << i);
                    node = node.get(1 - bit);
                } else {
                    node = node.get(bit);
                }
            }
            return maxNum;
        }
    }

    static class Node {
        Node[] links;

        Node() {
            this.links = new Node[2];
        }

        boolean containsKey(int bit) {
            return links[bit] != null;
        }

        void put(int bit, Node node) {
            links[bit] = node;
        }

        Node get(int bit) {
            return links[bit];
        }
    }
}
