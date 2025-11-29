package trie;

public class CountDistinctSubstrings {
    public static void main(String[] args) {
        Node node;
        String word = "abab";
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            node = Trie.getRoot();
            for (int j = i; j < word.length(); j++) {
                char ch = word.charAt(j);
                if (!node.containsKey(ch)) {
                    count++;
                    node.put(ch, new Node());
                }
                node = node.get(ch);
            }
        }
        System.out.println("Total distinct substrings for string: " + word + " is " + (count + 1));
    }

    static class Trie {
        private static Node root;

        Trie() {
            root = new Node();
        }

        public static Node getRoot() {
            return root;
        }
    }

    static class Node {
        Node[] links;

        Node() {
            this.links = new Node[26];
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
    }
}
