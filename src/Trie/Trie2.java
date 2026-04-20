package Trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Explanation of Operations
 * Insert:
 * Traverse the Trie, creating new nodes if necessary, and mark the last
 * node of the word as isEndOfWord = true.
 *
 * Search:
 * Traverse the Trie based on the characters of the word. Return true if
 * the end node exists and isEndOfWord = true.
 *
 * Delete:
 * Recursively traverse to the end of the word, unmark isEndOfWord, and
 * clean up nodes if they are no longer part of any word.
 * Get First K Words:
 * Use Depth-First Search (DFS) to traverse the Trie in lexicographical order.
 * Keep adding words to the result list until it contains k words.
 *
 * Explanation of getKWords with a Prefix
 * Traversal to Prefix Node:
 * Start at the root and follow the nodes corresponding to each character in the prefix.
 * If a character node doesn't exist, return an empty list as no words match the prefix.
 * DFS from Prefix Node:
 * Use a depth-first search to explore all child nodes starting from the prefix node.
 * Build each word by appending characters to the prefix.
 * Stop once k words are found.
 * Result Construction:
 * Add words to the result list when reaching a node marked as isEndOfWord.
 */
class Trie2 {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
        }
    }

    private final TrieNode root;

    public Trie2() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isEndOfWord;
    }

    // Get the first K words that start with the given prefix
    public List<String> getKWords(String prefix, int k) {
        TrieNode current = root;
        List<String> result = new ArrayList<>();
        StringBuilder prefixBuilder = new StringBuilder(prefix);

        // Traverse to the node corresponding to the prefix
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return result; // Prefix not found
            }
            current = current.children[index];
        }

        // Collect words from the current node
        collectWords(current, prefixBuilder, result, k);
        return result;
    }

    private void collectWords(TrieNode node, StringBuilder prefix, List<String> result, int k) {
        if (node == null || result.size() >= k) {
            return;
        }

        if (node.isEndOfWord) {
            result.add(prefix.toString());
        }

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                prefix.append((char) ('a' + i));
                collectWords(node.children[i], prefix, result, k);
                prefix.deleteCharAt(prefix.length() - 1); // Backtrack
            }
        }
    }

    public static void main(String[] args) {
        Trie2 trie = new Trie2();

        // Insert words
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        trie.insert("appetite");
        trie.insert("bat");
        trie.insert("ball");
        trie.insert("cat");

        // Get first K words with a prefix
        System.out.println("First 3 words with prefix 'app': " + trie.getKWords("app", 3)); // [app, apple, appetite]
        System.out.println("First 2 words with prefix 'ba': " + trie.getKWords("ba", 2));   // [ball, bat]
        System.out.println("First 2 words with prefix 'z': " + trie.getKWords("z", 2));     // []
    }
}
