package transportadora.entity;
import jakarta.persistence.*;
import lombok.Data;
import transportadora.entity.enums.TipoEntrega;

@Entity
public @Data class CategoriaFrete implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoEntrega tipoEntrega;

    public double calcularPercentualAdicional() {
        return tipoEntrega.getPercentualAumento();
    }

}
