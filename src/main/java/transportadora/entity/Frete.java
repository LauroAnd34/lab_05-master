package transportadora.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public @Data class Frete implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(name = "numero_nota_fiscal", unique = true, nullable = false)
    private int numeroNotaFiscal;

    private static final BigDecimal VALOR_PADRAO_KM_RODADO = new BigDecimal("1.50");
    @Column(name = "valor_km_rodados")
    private BigDecimal valorKmRodado = VALOR_PADRAO_KM_RODADO;

    @ManyToOne
    @JoinColumn(name = "categoria_frete_id", nullable = false)
    private CategoriaFrete categoriaFrete;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "cidade_origem_id", nullable = false)
    private Cidade cidadeOrigem;

    @ManyToOne
    @JoinColumn(name = "cidade_destino_id", nullable = false)
    private Cidade cidadeDestino;

    @Column(name = "funcionario_responsavel", nullable = false)
    private String funcionarioResponsavel;

    @ElementCollection
    @CollectionTable(name = "ItemFrete", joinColumns = @JoinColumn(name = "frete_id"))
    private List<ItemFrete> itens = new ArrayList<>();

    @Column(name = "valor_frete")
    private double valorFrete;

    @PrePersist
    @PreUpdate
    private void validar() {
        if (categoriaFrete == null || cliente == null || veiculo == null || cidadeOrigem == null || cidadeDestino == null || funcionarioResponsavel == null || itens == null || itens.isEmpty()) {
            throw new IllegalArgumentException("Todos os atributos devem ser fornecidos e deve haver pelo menos um ItemFrete.");
        }
    }

    public void calculaFrete(double distanciaKm) {
        double valorBase = distanciaKm * this.valorKmRodado.doubleValue();
        this.valorFrete = valorBase + (valorBase * categoriaFrete.calcularPercentualAdicional());
    }

    @Override
    public Integer getId() {
        return 0;
    }
}
