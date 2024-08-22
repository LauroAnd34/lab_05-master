package transportadora.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
public @Data class TipoVeiculo implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String descricao;

    @Column(name = "peso_maximo")
    private float pesoMaximo;
}
