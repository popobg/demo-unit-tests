package fr.diginamic.utils;

/**
 * Classe qui fournit des services de traitements de chaines de caractères
 * 
 * @author DIGINAMIC
 */
public final class StringUtils {

	/**
	 * Retourne la distance de Levenshtein entre 2 chaines de caractères,
	 * sans se soucier de la casse.
	 *
	 * Retourne -1 si la chaîne est vide ou constituée uniquement d'espaces.
	 * Lève une exception si au moins un des éléments est null.
	 *
	 * @param lhs chaine 1
	 * @param rhs chaine 2
	 * @return distance
	 */
	public static int levenshteinDistance(String lhs, String rhs) throws NullPointerException {
		// Error cases
		if (lhs == null || rhs == null) {
			throw new NullPointerException("Au moins une des chaînes est nulle.");
		}

		lhs = lhs.trim().toLowerCase();
		rhs = rhs.trim().toLowerCase();

		if (lhs.isEmpty() || rhs.isEmpty()
		|| lhs.isBlank() || rhs.isBlank()) {
			return -1;
		}

		int len0 = lhs.length() + 1;
		int len1 = rhs.length() + 1;

		int[] cost = new int[len0];
		int[] newcost = new int[len0];

		for (int i = 0; i < len0; i++) {
			cost[i] = i;
		}

		for (int j = 1; j < len1; j++) {
			newcost[0] = j;

			for (int i = 1; i < len0; i++) {
				int match = (lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1;

				int costReplace = cost[i - 1] + match;
				int costInsert = cost[i] + 1;
				int costDelete = newcost[i - 1] + 1;

				newcost[i] = Math.min(Math.min(costInsert, costDelete), costReplace);
			}

			int[] swap = cost;
			cost = newcost;
			newcost = swap;
		}
		return cost[len0 - 1];
	}
}
