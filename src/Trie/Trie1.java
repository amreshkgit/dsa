package Trie;
import java.util.*;

/**
 *
 * Explanation of the Code:
 * TrieNode Class:
 * children: A Map<Character, TrieNode> to store child nodes.
 * count: An integer representing the frequency of the word ending at this node.
 * isEndOfWord: A boolean to check if this node marks the end of a valid word.
 * Trie Class:
 * insert(String word): Inserts a word into the Trie and increments the frequency count at the last node of the word.
 * search(String word): Searches for a word in the Trie. It returns true if the word exists and false otherwise.
 * delete(String word): Deletes a word from the Trie. The method recursively deletes nodes, and only removes a
 * node if it is no longer needed (i.e., it has no children and doesn't mark the end of a word).
 * getTop5Words(String prefix): This method finds the top 5 most frequent words starting with the given prefix.
 * It performs a DFS traversal from the node corresponding to the prefix, adding words to a priority queue.
 * The queue keeps track of the k most frequent words.
 * PriorityQueue (Min-Heap):
 * The PriorityQueue is used to store the top k words based on frequency. We use a custom comparator to ensure that the least
 * frequent word is at the top of the queue and can be removed if the queue size exceeds k.
 * DFS Traversal:
 * The dfs method is used to recursively explore all words starting from the given node.
 * It adds the words to the PriorityQueue and ensures that only the top k most frequent words are kept.
 * WordCount Class:
 * A helper class to store the word and its frequency for the priority queue.
 */
class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    int count = 0;
    boolean isEndOfWord = false; // Flag to check if it's the end of a word
}

// Trie Class
public class Trie1 {
    private TrieNode root;

    public Trie1() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.count++;  // Increment count at the end of the word
        node.isEndOfWord = true;
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.get(c);
            if (node == null) {
                return false;
            }
        }
        return node.isEndOfWord;
    }

    // Delete a word from the Trie
    public boolean delete(String word) {
        return deleteHelper(root, word, 0);
    }

    // Helper function to delete a word
    private boolean deleteHelper(TrieNode node, String word, int index) {
        if (index == word.length()) {
            if (!node.isEndOfWord) {
                return false; // Word not found
            }
            node.isEndOfWord = false;  // Mark word as not complete
            return node.children.isEmpty(); // Return true if no more children
        }

        char c = word.charAt(index);
        TrieNode child = node.children.get(c);
        if (child == null) {
            return false; // Word not found
        }

        boolean shouldDeleteChild = deleteHelper(child, word, index + 1);

        if (shouldDeleteChild) {
            node.children.remove(c);
            return node.children.isEmpty() && !node.isEndOfWord;
        }

        return false;
    }

    // Get top 5 words starting with the given prefix
    public List<String> getTop5Words(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.children.get(c);
            if (node == null) {
                return new ArrayList<>();  // No words with this prefix
            }
        }

        PriorityQueue<WordCount> pq = new PriorityQueue<>((a, b) -> a.count - b.count); // Min-heap
        dfs(node, prefix, pq, 5); // Perform DFS to find words

        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(0, pq.poll().word);  // Add to the front to keep highest frequency words first
        }

        return result;
    }

    // Helper function for DFS traversal
    private void dfs(TrieNode node, String prefix, PriorityQueue<WordCount> pq, int k) {
        if (node.isEndOfWord) {
            pq.add(new WordCount(prefix, node.count));

            if (pq.size() > k) {
                pq.poll();  // Remove the least frequent word if we exceed k
            }
        }

        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            dfs(entry.getValue(), prefix + entry.getKey(), pq, k);
        }
    }

    // Helper class to store the word and its frequency
    static class WordCount {
        String word;
        int count;

        WordCount(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Trie1 trie = new Trie1();

        // Insert words into the Trie
        String[] words = {"apple", "banana", "apple", "apple", "banana", "gra", "gre", "grape", "pear"};
        for (String word : words) {
            trie.insert(word);
        }

        // Search for a word
        System.out.println("Search 'apple': " + trie.search("apple")); // Should return true
        System.out.println("Search 'banana': " + trie.search("banana")); // Should return true
        System.out.println("Search 'orange': " + trie.search("orange")); // Should return false

        // Delete a word
        System.out.println("Delete 'banana': " + trie.delete("banana")); // Should return true
        System.out.println("Search 'banana': " + trie.search("banana")); // Should return false

        // Get the top 5 words starting with the prefix "gr"
        List<String> topWords = trie.getTop5Words("gr");
        System.out.println("Top 5 words starting with 'gr': " + topWords);
    }
}
