/**
 *
 */
package com.microsoft.practice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
/**
 * @author sudhe
 *
 */
public class WordLadder2LCSol {
    Map<String, List<String>> map = new HashMap<>();
    class Pair<k,V>{
        String word;
        int level;
        public Pair(String pWord, int pLevel){
            word = pWord;
            level = pLevel;
        }
    }
    public void ladderLength(String beginWord, String endWord, List<String> wordList) {

        Map<String, List<String>> allComb = new HashMap<>();

        //Generate all possible combinations of words and add them dict
        for(String word:wordList){
             for(int i=0; i<word.length(); i++){
                 //Generate possible combinations of the word'
                     String newWord = word.substring(0,i) + "*" +word.substring(i+1,word.length());
                     List<String> combs = allComb.getOrDefault(newWord, new ArrayList<>());
                     combs.add(word);
                     allComb.put(newWord,combs);
             }
        }

        //now get the begin word, generate all possible combinations and check the word availability in map
        //if combination available , get the word and check if its end word else add all the possible combinations to Q
       Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        //use visited to  track visited words
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while(!q.isEmpty()){

            Pair<String,Integer> pair = q.poll();
            String word = pair.word;
            int level = pair.level;
            //generate combs for given word
            for(int i=0; i<word.length(); i++){
                 String newWord = word.substring(0, i) + '*' + word.substring(i + 1, word.length());

                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComb.getOrDefault(newWord, new ArrayList<>())) {

                   /*  if (adjacentWord.equals(endWord)) {
                        return level + 1;
                      }*/

                     if (!visited.containsKey(adjacentWord)) {
                          visited.put(adjacentWord, true);

                          if (map.containsKey(adjacentWord))// Build Adjacent Graph
                              map.get(adjacentWord).add(word);
                          else {
                              List<String> l = new LinkedList<String>();
                              l.add(word);
                              map.put(adjacentWord, l);
                          }
                          q.add(new Pair(adjacentWord, level + 1));
                      }

                }


            }
        }
      // return 0;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        WordLadder2LCSol wl= new WordLadder2LCSol();
        List<String> dict = new ArrayList<>();
        //wordList = ["hot","dot","dog","lot","log","cog"]
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        dict.add("cog");
        wl.ladderLength("hit", "cog", dict);
        System.out.println(wl.map);
    }

}
