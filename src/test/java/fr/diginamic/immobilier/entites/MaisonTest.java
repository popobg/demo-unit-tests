package fr.diginamic.immobilier.entites;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MaisonTest {
    // attributs de classe
    Chambre chambre1 = new Chambre(2, 12);
    Chambre chambre2 = new Chambre(1, 20);
    Cuisine cuisine = new Cuisine (0, 10);
    SalleDeBain sdb = new SalleDeBain(1, 14);
    WC wc = new WC(0, 5);

    Maison maison = new Maison();
    Maison maisonConstruite = new Maison(chambre1, chambre2, cuisine, sdb, wc);

    // Supprimer les pièces de la maison pour manipuler une maison vide
    // dans les différents tests.
    @BeforeEach
    public void testDetruirePieces() {
        maison.detruirePieces();
    }

    @Test
    public void testAjouterPieceSuccess() {
        Maison expected = new Maison(chambre1);

        maison.ajouterPiece(chambre1);

        assertEquals(expected, maison);
    }

    @Test
    public void testAjouterPieceNull() {
        Maison expected = new Maison(chambre1);

        try {
            maison.ajouterPiece(null);
        }
        catch (IllegalArgumentException e) {
            assertEquals("La valeur passée en paramètre est null. Ce devrait être un objet de type Piece.", e.getMessage());
        }
    }

    @Test
    public void testNbPiecesSuccess1() {
        int actual = maisonConstruite.nbPieces();

        assertEquals(5, actual);
    }

    @Test
    public void testNbPiecesSuccess2() {
        int actual = maison.nbPieces();

        assertEquals(0, actual);
    }

    @Test
    public void testSuperficieEtageSuccess() {
        double actual = maisonConstruite.superficieEtage(1);

        assertEquals(34, actual);
    }

    @Test
    public void testSuperficieEtageNonExistant() {
        double actual = maisonConstruite.superficieEtage(-1);

        assertEquals(0, actual);
    }

    @Test
    public void testSuperficieTypePieceSuccess() {
        double actual = maisonConstruite.superficieTypePiece("Chambre");

        assertEquals(32, actual);
    }

    @Test
    public void testSuperficieTypePieceNull() {
        double actual = maisonConstruite.superficieTypePiece(null);

        assertEquals(-1, actual);
    }

    @Test
    public void testSuperficieTypePieceEmpty() {
        double actual = maisonConstruite.superficieTypePiece("");

        assertEquals(-1, actual);
    }

    @Test
    public void testSuperficieTypePieceNonExistante() {
        double actual = maisonConstruite.superficieTypePiece("salon");

        assertEquals(0, actual);
    }

    @Test
    public void testCalculerSurfaceSuccess1() {
        double actual = maisonConstruite.calculerSurface();

        assertEquals(61, actual);
    }

    @Test
    public void testCalculerSurfaceSuccess2() {
        double actual = maison.calculerSurface();

        assertEquals(0, actual);
    }

    @Test
    public void testGetPiecesSuccess1() {
        Piece[] expected = { chambre1, chambre2, cuisine, sdb, wc };

        Piece[] actual = maisonConstruite.getPieces();

        assertTrue(Arrays.equals(expected, actual));
    }

    @Test
    public void testGetPiecesSuccess2() {
        Piece[] expected = new Piece[0];

        Piece[] actual = maison.getPieces();

        assertTrue(Arrays.equals(expected, actual));
    }
}