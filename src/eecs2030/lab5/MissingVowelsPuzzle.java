package eecs2030.lab5;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * <p>
 * A word puzzle where the letters 'a', 'e', 'i', 'o', and 'u' are missing from
 * the puzzle word and replaced with an underscore '_'. For example:
 * </p>
 * 
 * <pre>
 * MissingVowelsPuzzle p = new MissingVowelsPuzzle("facetious");
 * System.out.println(p);
 * </pre>
 * 
 * <p>
 * outputs:
 * 
 * <p>
 * {@code f_c_t___s : facetious}
 * 
 * <p>
 * A second example where the puzzle has multiple solutions:
 * 
 * <pre>
 * MissingVowelsPuzzle p = new MissingVowelsPuzzle("cat", "cot", "cut");
 * System.out.println(p);
 * </pre>
 * 
 * <p>
 * outputs:
 * 
 * <p>
 * {@code c_t : cat, cot, cut}
 * 
 * 
 */
public class MissingVowelsPuzzle extends AbstractWordPuzzle {

	/**
	 * The set of solution words
	 */
	private SortedSet<String> solutions;

	/**
	 * Constructs a missing vowels word puzzle for the solution word
	 * {@code solution}. The puzzle word is the solution word with the
	 * letters 'a', 'e', 'i', 'o', and 'u' replaced with an underscore '_'.
	 * 
	 * @param solution
	 *            a solution word
	 */
	public MissingVowelsPuzzle(String solution) {
		// COMPLETE THIS
		super(computePuzzleWord(solution));
		this.solutions = new TreeSet<>();
		// make sure it is in the set
		this.solutions.add(solution);
	}

	/**
	 * Constructs a missing vowels word puzzle for the solution word
	 * {@code solution}. All other possible solutions should also be
	 * provided.
	 * 
	 * <p>
	 * The additional solutions provided in {@code otherSolutions} are
	 * checked to confirm that they produce the same puzzle word as
	 * {@code solution} and an exception is thrown if one or more of
	 * the words in {@code otherSolutions} does not produce the same
	 * puzzle word as {@code solution}
	 * 
	 * @param solution
	 *            a solution word
	 * @param otherSolutions
	 *            all other solutions to the puzzle
	 * @throws IllegalArgumentException
	 *             if a word in otherSolutions is incompatible
	 *             with solution
	 */
	public MissingVowelsPuzzle(String solution, String[] otherSolutions) {
		// COMPLETE THIS
		this(solution);
		for (String sol: otherSolutions) {
			if (!computePuzzleWord(sol).equals(this.getPuzzleWord()))
				throw new IllegalArgumentException(sol + "is not a solution for " + this.getPuzzleWord());
			this.solutions.add(sol);
		}
	}

	/**
	 * Get the solution word. If there is more than one solution this method
	 * returns the solution that comes first in dictionary order.
	 * 
	 * @return the solution word that comes first in dictionary order
	 */
	@Override
	public String getSolution() {
		// COMPLETE THIS
		return this.solutions.first();
	}

	/**
	 * Get a sorted set of all of the solution words.
	 * 
	 * <p>
	 * The set returned by this method cannot be used to modify the solutions
	 * for this puzzle.
	 * 
	 * @return a sorted set of solution words
	 */
	@Override
	public SortedSet<String> getSolutions() {
		// COMPLETE THIS
		// get use of tree set clone to make shadow copy because string is not mutable type
		SortedSet<String> result = (SortedSet) ((TreeSet) this.solutions).clone();
		return result;
	}

	/**
	 * Compute the puzzle word corresponding to a {@code solution} word.
	 * The puzzle word is the solution word with the letters 'a', 'e', 'i', 'o',
	 * and 'u' replaced with an underscore '_'.
	 * 
	 * @param solution
	 *            a solution word
	 * @return the puzzle word
	 */
	private static String computePuzzleWord(String solution) {
		// COMPLETE THIS
		return solution.replaceAll("[aeiouAEIOU]", "_");
	}
}
