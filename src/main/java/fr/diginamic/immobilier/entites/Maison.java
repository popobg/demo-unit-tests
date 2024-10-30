package fr.diginamic.immobilier.entites;

import java.util.Arrays;

/** Représente une maison avec toutes ses pièces
 * @author DIGINAMIC
 *
 */
public class Maison {
	
	/** pieces : tableau de pièces de la maison */
	private Piece[] pieces;
	
	/**
	 * Constructeur
	 */
	public Maison(){
		// Initialisation du tableau de pièces
		pieces = new Piece[0];
	}

	/**
	 * Constructeur
	 * @param pieces tableau d'objet Piece
	 */
	public Maison(Piece... pieces) {
		this.pieces = pieces;
	}

	/**
	 * Méthode permettant de comparer deux objets Maison.
	 * @param obj Objet
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Maison)) {
			return false;
		}

		Maison autre = (Maison)obj;

		if (this.pieces.length != autre.nbPieces()) {
			return false;
		}

		return Arrays.equals(autre.getPieces(), this.pieces);
	}

	/** Ajoute une pièce à la maison.
	 * @param nvPiece nouvelle pièce à ajouter
	 */
	public void ajouterPiece(Piece nvPiece) throws IllegalArgumentException {
		if (nvPiece == null) {
			throw new IllegalArgumentException("La valeur passée en paramètre est null. Ce devrait être un objet de type Piece.");
		}

		// On est obligé d'agrandir le tableau initial de 1 à chaque ajout
		// d'une nouvelle pièce
		
		// On commence donc par créer un tableau temporaire appelé newTab
		// qui a une taille égale à la tableau du tableau pieces+1
		Piece[] newTab = new Piece[pieces.length+1];
		
		// On déverse toutes les pièces du tableau pieces dans newTab
        System.arraycopy(pieces, 0, newTab, 0, pieces.length);
		
		// On place en dernière position dans le nouveau tableau la nouvelle
		// pièce
		newTab[newTab.length-1]=nvPiece;
		
		// Enfin on affecte newTab à pieces
		this.pieces=newTab;
	}
	
	public int nbPieces() {
		return pieces.length;
	}

	/** Retourne la superficie totale d'un étage.
	 * Si le numéro de l'étage n'est pas reconnu ou null, retourne -1.
	 * @param choixEtage choix de l'étage
	 * @return double
	 */
	public double superficieEtage(int choixEtage) {
		if (pieces.length == 0) {
			return 0;
		}

		double superficieEtage = 0;

        for (Piece piece : pieces) {
            if (choixEtage == piece.getNumEtage()) {
                superficieEtage += piece.getSuperficie();
            }
        }

		return superficieEtage;
	}
	
	/** Retourne la superficie totale pour un type de pièce donné.
	 * Si le type de pièce n'est pas reconnu ou null, retourne -1.
	 * @param typePiece type de pièce
	 * @return double
	 */
	public double superficieTypePiece(String typePiece) {
		if (typePiece == null
				|| typePiece.isEmpty()) {
			return -1;
		}

		if (pieces.length == 0) {
			return 0;
		}

		double superficie = 0;

		for (Piece piece: pieces) {
			if (typePiece.equals(piece.getType())) {
				superficie += piece.getSuperficie();
			}
		}

		return superficie;
	}

	/** Retourne la surface totale des pièces de la maison.
	 * @return double
	 */
	public double calculerSurface() {
		if (pieces.length == 0) {
			return 0;
		}

		double superficieTot = 0;

        for (Piece piece : pieces) {
            superficieTot += piece.getSuperficie();
        }

		return superficieTot;
	}

	/**
	 * Supprime les pièces de la maison.
	 */
	public void detruirePieces() {
		pieces = new Piece[0];
	}

	/** Getter pour l'attribut pieces
	 * @return the pieces
	 */
	public Piece[] getPieces() {
		return pieces;
	}

}