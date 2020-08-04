//Shivi Bhatt : 1027605

package assignment10Q2D;

import java.util.Random;

/**
 *
 * @author shivi Bhatt
 */
class Individual {

	int fitness = 0;
	int[] genes = new int[10];
	int geneLength = 10;

	public Individual() {
		Random rn = new Random();

		// Set genes randomly for each individual
		for (int i = 0; i < genes.length; i++) {
			genes[i] = Math.abs(rn.nextInt() % 2);
		}

		fitness = 0;
	}

	// Calculate fitness
	public void calcFitness() {

		fitness = 0;
		for (int i = 0; i < 10; i++) {
			if (genes[i] == 1) {
				++fitness;
			}
		}
	}

}