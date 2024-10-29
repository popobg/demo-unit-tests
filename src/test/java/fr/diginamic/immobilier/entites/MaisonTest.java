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

    @Test
    public void testAjouterPieceSuccess() {
        maison.ajouterPiece(chambre1);
    }

    @Test
    public void testNbPiecesSuccess() {
        int actual = maisonConstruite.nbPieces();

        assertEquals(5, actual);
    }

    @Test
    public void testSuperficieEtageSuccess() {

    }

    @Test
    public void testSuperficieTypePieceSuccess() {

    }

    @Test
    public void testCalculerSurfaceSuccess() {

    }

    @Test
    public void testGetPiecesSuccess() {
        Piece[] expected = { chambre1, chambre2, cuisine, sdb, wc };

        Piece[] actual = maisonConstruite.getPieces();

        assertTrue(Arrays.equals(expected, actual));
    }
}