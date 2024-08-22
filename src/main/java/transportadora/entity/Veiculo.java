package transportadora.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
public @Data class Veiculo implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero_placa", nullable = false, unique = true)
    private String numeroPlaca;

    @ManyToOne
    @JoinColumn(name = "tipo_veiculo_id", nullable=false)
    private TipoVeiculo tipoVeiculo;

    @ManyToOne
    @JoinColumn(name = "filial_id", nullable = false)
    private Filial filial;
}
