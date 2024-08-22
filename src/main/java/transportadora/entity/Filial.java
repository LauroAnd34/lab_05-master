package transportadora.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;
import java.util.HashSet;

@Entity
public @Data class Filial implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column
    private String endereco;

    @Column
    private String telefone;

    @OneToMany(mappedBy = "filial")
    private Set<Veiculo> veiculos = new HashSet<>();

    public void adicionarVeiculo(Veiculo veiculo) {
        if (veiculos.contains(veiculo)) {
            throw new IllegalArgumentException("Veículo já adicionado.");
        }
        veiculos.add(veiculo);
        veiculo.setFilial(this);
    }

    public void removerVeiculo(Veiculo veiculo) {
        if (!veiculos.contains(veiculo)) {
            throw new IllegalArgumentException("Veículo não encontrado.");
        }
        veiculos.remove(veiculo);
        veiculo.setFilial(null);
    }

    @OneToOne
    @JoinColumn(name = "funcionario_responsavel_id")
    private Funcionario responsavel;

    @Override
    public String toString() {
        return "Filial [name=" + nome + "]";
    }
    public void definirResponsavel(Funcionario funcionario) {
        this.responsavel = funcionario;
        funcionario.setFilial(this);
    }


}
