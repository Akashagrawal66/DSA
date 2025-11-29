package trie;

public class CompleteString {

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] words = {"a", "ap", "app", "appl", "apple", "appkef"};
        for (String word : words) {
            trie.insert(word);
        }
        String longest = "";
        for (String word : words) {
            if (trie.checkIfPrefixExists(word)) {
                if (word.length() > longest.length()) {
                    longest = word;
                } else if (word.length() == longest.length() && word.compareTo(longest) < 0) {
                    longest = word;
                }
            }
        }
        System.out.println("The longest complete String is: " + longest);
    }


    static class Trie {
        private static Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
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

        public boolean search(String word) {
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

        public boolean checkIfPrefixExists(String word) {
            Node node = root;
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.containsKey(ch)) {
                    node = node.get(ch);
                    flag &= node.getEnd();
                } else {
                    return false;
                }
            }
            return flag;
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
}
