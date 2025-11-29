package trie;

public class Trie2 {
    public static void main(String[] args) {
        String[] words = {"apple", "apple", "a", "be"};
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        trie.erase("be");
        trie.erase("app");

        for (String word : words) {
            trie.print(word);
        }
    }

    static class Trie {
        Node root;

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
                node.incrementPrefixCount();
            }
            node.setEnd();
        }

        void erase(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.containsKey(ch)) {
                    node = node.get(ch);
                    node.decrementPrefixCount();
                } else {
                    return;
                }
            }
            node.decrementEnd();
        }

        void print(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.containsKey(ch)) {
                    node = node.get(ch);
                    System.out.println("Character " + ch + " is present with prefixCount: " + node.getPrefixCount() + " and endsWithCount: " + node.getEndsWithCount());
                } else {
                    System.out.println("Does not contain character: " + ch);
                    break;
                }
            }
        }
    }

    static class Node {
        Node[] links;
        int endsWithCount;
        int prefixCount;

        Node() {
            links = new Node[26];
            endsWithCount = 0;
            prefixCount = 0;
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

        void incrementPrefixCount() {
            prefixCount += 1;
        }

        void decrementPrefixCount() {
            if (prefixCount > 0)
                prefixCount -= 1;
        }

        public int getEndsWithCount() {
            return endsWithCount;
        }

        public int getPrefixCount() {
            return prefixCount;
        }

        void setEnd() {
            endsWithCount += 1;
        }

        void decrementEnd() {
            if (endsWithCount > 0)
                endsWithCount -= 1;
        }
    }
}
