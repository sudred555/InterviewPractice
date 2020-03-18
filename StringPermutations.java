/**
 *
 */
package com.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author sudhe
 *
 */
public class StringPermutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringPermutations sp = new StringPermutations();
		System.out.println("permutations--> "+sp.permutations("aabc"));
		System.out.println("-------------------------------------");
		System.out.println("combinations--> "+sp.combinations("aabc"));

	}

	public List<String> permutations(String s) {
		List<String> result = new ArrayList<>();
		calculatePermutations("", s, result);
		Collections.sort(result);
		return result;
	}

	public Set<String> combinations(String s) {
        Set<String> result = new TreeSet<>();
        calculateCombinations("", s, result);
       // Collections.sort(result);
        return result;
    }

	/**
	 * Calculate permutations.
	 *
	 * @param prefix the prefix
	 * @param suffix the suffix
	 * @param results the results
	 */
	private void calculatePermutations(String prefix, String suffix, List<String> results) {

		if (suffix.length() == 0) {
			results.add(prefix);
		} else {
			for (int i = 0; i < suffix.length(); i++) {
				/*System.out.println("prefix-->"+ prefix);
				System.out.println("suffix-->"+ suffix);
				System.out.println("prefix string-->"+prefix + suffix.charAt(i));
				System.out.println("suffix string-->"+suffix.substring(0, i) + suffix.substring(i + 1, suffix.length()));
				System.out.println("---------------------");*/
				calculatePermutations(prefix + suffix.charAt(i),
						suffix.substring(0, i) + suffix.substring(i + 1, suffix.length()), results);

			}


		}

	}

	   /**
   	 * Generate  combinations which has duplicate results.
   	 *
   	 * @param prefix the prefix
   	 * @param suffix the suffix
   	 * @param results the results
   	 */
   	private void calculateCombinations(String prefix, String suffix, Set<String> results) {

	        if (suffix.length() < 0) {
	           // results.add(prefix);
	            return;
	        } else {
	            results.add(prefix);
	            for (int i = 0; i < suffix.length(); i++) {
	              /*  System.out.println("prefix-->"+ prefix);
	                System.out.println("suffix-->"+ suffix);
	                System.out.println("prefix string-->"+prefix + suffix.charAt(i));
	                System.out.println("suffix string-->"+suffix.substring(0, i) + suffix.substring(i + 1, suffix.length()));
	                System.out.println("---------------------");*/
	                calculateCombinations(prefix + suffix.charAt(i),
	                        suffix.substring(0, i) + suffix.substring(i + 1, suffix.length()), results);

	            }


	        }

	    }

}
