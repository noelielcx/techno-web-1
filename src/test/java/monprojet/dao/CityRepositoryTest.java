package monprojet.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.log4j.Log4j2;
import monprojet.entity.City;
import monprojet.entity.Country;

@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class CityRepositoryTest {

    @Autowired
    private CountryRepository countryDAO;
    @Autowired
    private CityRepository cityDAO;

    @Test
    void onTrouveLePaysDesVilles() {
        log.info("On vérifie que les pays des villes sont bien récupérés");
        City toulouse = cityDAO.findByName("Toulouse");
        Country france = countryDAO.findById(1).orElseThrow();
        assertEquals(france, toulouse.getCountry(), "Toulouse est en France");
    }

    @Test

    void onTrouveLesVillesDesPays() {
        log.info("On vérifie que les villes d'un pays sont accessibles");
        City toulouse = cityDAO.findByName("Toulouse");
        Country france = countryDAO.findById(1).orElseThrow();
        assertTrue( france.getCity().contains(toulouse), "France contient Toulouse");
    }

}