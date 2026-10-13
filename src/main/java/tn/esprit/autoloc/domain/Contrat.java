
package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.List;
@Entity
@Table(name = "contrat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    @Column(nullable = false)
    private LocalDate dateSignature;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal montantTotal;

    @Column(nullable = false)
    private boolean valide;
    @OneToOne
    @JoinColumn(name = "id_reservation", unique = true, nullable = false)
     Reservation reservation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client", nullable = false)
     Client client;

    @OneToMany(mappedBy = "contrat", cascade = CascadeType.ALL, orphanRemoval = true)
     List<Paiement> paiementlist;
}
