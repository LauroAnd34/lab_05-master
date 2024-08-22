package transportadora.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
public @Data class Cidade implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String uf;

    @Column(nullable = false)
    private String nome;

    private String estado;
}
