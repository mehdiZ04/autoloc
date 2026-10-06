package tn.esprit.autoloc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.math.BigDecimal;

@SpringBootApplication
public class AutolocApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutolocApiApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(VehiculeRepository vehiculeRepository) {
        return args -> {

            if (!vehiculeRepository.existsByImmatriculation("123-TUN-456")) {
                Vehicule v1 = new Vehicule();

                v1.setImmatriculation("123-TUN-456");
                v1.setMarque("Toyota");
                v1.setModele("Yaris");
                v1.setCategorie(CategorieVehicule.CITADINE);
                v1.setTarifJournalier(new BigDecimal("80.00"));
                v1.setStatut(StatutVehicule.DISPONIBLE);

                vehiculeRepository.save(v1);
            }

            if (!vehiculeRepository.existsByImmatriculation("456-TUN-789")) {
                Vehicule v2 = new Vehicule();

                v2.setImmatriculation("456-TUN-789");
                v2.setMarque("BMW");
                v2.setModele("Serie 3");
                v2.setCategorie(CategorieVehicule.BERLINE);
                v2.setTarifJournalier(new BigDecimal("180.00"));
                v2.setStatut(StatutVehicule.DISPONIBLE);

                vehiculeRepository.save(v2);
            }

            if (!vehiculeRepository.existsByImmatriculation("789-TUN-123")) {
                Vehicule v3 = new Vehicule();

                v3.setImmatriculation("789-TUN-123");
                v3.setMarque("Peugeot");
                v3.setModele("3008");
                v3.setCategorie(CategorieVehicule.SUV);
                v3.setTarifJournalier(new BigDecimal("120.00"));
                v3.setStatut(StatutVehicule.MAINTENANCE);

                vehiculeRepository.save(v3);
            }
        };
    }
}