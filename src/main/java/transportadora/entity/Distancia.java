package transportadora.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
public @Data class Distancia implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private int quilometros;

    @ManyToOne
    @JoinColumn(name = "cidade_origem_id", nullable = false)
    private Cidade cidadeOrigem;

    @ManyToOne
    @JoinColumn(name = "cidade_destino_id", nullable = false)
    private Cidade cidadeDestino;

    @PrePersist
    @PreUpdate
    private void validar() {
        if (cidadeOrigem == null || cidadeDestino == null || quilometros <= 0) {
            throw new IllegalArgumentException("Todos os atributos devem ser fornecidos e quilometragem deve ser positiva.");
        }
    }
}
