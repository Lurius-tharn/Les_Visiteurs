package model;


import com.lurius.les_visiteurs.model.Visite;
import junit.framework.TestCase;
import org.junit.jupiter.api.DisplayName;

public class VisiteTest extends TestCase {
    private Visite visite;

    public VisiteTest() {
        this.visite = new Visite(1, "Nom", "23/11/2022", 20, 3);
    }

    @DisplayName("Devrait instancier une nouvelle instance avec des param\ufffdtres")
    public void testVisite() {
        final String visiteToString = "Visite{id=1, nom='Nom', note=20, date='23/11/2022', idPlanning=3}";
        assertEquals(this.visite.toString(), visiteToString);
    }

    @DisplayName("Devrait retourner un ID ")
    public void testId() {
        assertEquals(this.visite.getId(), 1);
    }

    @DisplayName("Devrait retourner une date ")
    public void testDate() {
        assertEquals(this.visite.getDate(), "23/11/2022");
    }

    @DisplayName("Devrait retourner un num de planning ")
    public void testIdPlanning() {
        assertEquals(this.visite.getIdPlanning(), 3);
    }

    @DisplayName("Devrait setter  une note ")
    public void testNewNote() {
        this.visite.setNote(5);
        assertEquals(this.visite.getNote(), 5);
    }

    @DisplayName("Devrait setter  une date ")
    public void testNewDate() {
        this.visite.setDate("30/12/2020");
        assertEquals(this.visite.getDate(), "30/12/2020");
    }

    @DisplayName("Devrait setter  un nom ")
    public void testNewNom() {
        this.visite.setNom("NomTest2");
        assertEquals(this.visite.getNom(), "NomTest2");
    }

    @DisplayName("Devrait convertir une date donn\ufffd au format FR en une date au format US ")
    public void testDateFRtoUS() {
        assertEquals(Visite.dateFRtoUS(this.visite.getDate()), "2022-11-23");
        assertEquals(Visite.dateUStoFR("2022-11-23"), this.visite.getDate());
    }

    @DisplayName("Devrait convertir une date donn\ufffd au format US en une date au format FR ")
    public void testDateUStoFR() {
        assertEquals(Visite.dateUStoFR("2022-11-23"), this.visite.getDate());
    }

}