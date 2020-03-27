package com.ds.trie;

public class WordCombinationsTester {

    public static void main(String[] args) {
        WordCombinationsTester tester = new WordCombinationsTester();
        TrieNode root = new TrieNode();
        String dictionary[] = { "hat", "ah", "ha", "th", "at", "a" };
        for (int i = 0; i < dictionary.length; i++) {
            root.insert(root, dictionary[i]);
        }
        String word = "hat";
        tester.wordBreakAll(root, word, word.length(), "");
    }

    // Result stores the current prefix with
    // spaces between words
    private void wordBreakAll(TrieNode root, String word, int n,
            String result) {
        // Process all prefixes one by one
        for (int i = 1; i <= n; i++) {

            // Extract subString from 0 to i in prefix
            String prefix = word.substring(0, i);

            // If trie conatins this prefix then check
            // for the remaining String.
            // Otherwise ignore this prefix
            if (root.search(root, prefix)) {

                // If no more elements are there then print
                // Add this element to the previous prefix
                result += prefix;

                // If(result == word) then return
                // If you don't want to print last word
                System.out.print("\t" + result + "\n");
                return;
            }
            wordBreakAll(root, word.substring(i, n), n - i,
                    result + prefix + " ");
        }
    }
}
