package trie;

public class ImplementTrie {
    static class Trie {
        private static Node root;

        Trie() {
            root = new Node();
        }

        void insert(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.containsKey(ch)) {
                    node.put(ch, new Node());
                }
                node = node.get(ch);
            }
            node.setEnd();
        }

        boolean search(String word) {
            boolean result = true;
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.containsKey(ch)) {
                    node = node.get(ch);
                } else {
                    result = false;
                    break;
                }
            }
            if (result) {
                result = node.getEnd();
            }
            return result;
        }

    }

    static class Node {
        Node[] links;
        boolean flag;

        Node() {
            this.links = new Node[26];
            flag = false;
        }

        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        Node get(char ch) {
            return links[ch - 'a'];
        }

        void setEnd() {
            flag = true;
        }

        boolean getEnd() {
            return flag;
        }
    }
}
