package fr.diginamic.enumerations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class SaisonTest {

    @ParameterizedTest
    @ValueSource(strings = { "printemps", "été", "AUTOMNE", "hiver" })
    public void testValueOfLibelleSuccess(String libelle) {
        Saison actual = Saison.valueOfLibelle(libelle);

        assertEquals(libelle.toLowerCase(), actual.getLibelle().toLowerCase());
    }

    // NOT NOMINAL TESTS
    @Test
    public void testValueOfLibelleNullArg() {
        assertNull(Saison.valueOfLibelle(null));
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = { "", " ", "auto", "h" })
    public void testValueOfLibelleWrongLibelle(String libelle) {
        assertNull(Saison.valueOfLibelle(libelle));
    }
}