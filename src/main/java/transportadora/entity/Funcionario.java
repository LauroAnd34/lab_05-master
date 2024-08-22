package transportadora.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;
import java.util.HashSet;

@Entity
public @Data  class Funcionario extends PessoaFisica implements EntidadeBase{

    @Column(nullable = false, unique = true)
    private Integer matricula;

    @ManyToOne
    @JoinColumn(nullable = false)
    @EqualsAndHashCode.Exclude
    private Filial filial;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    private Set<Dependente> dependentes;

    @Override
    public String toString() {
        return "Funcionario: " + (filial != null ? filial.getNome() : "N/A");
    }

    public void adicionarDependente(Dependente dependente) {
        if (dependentes == null) {
            dependentes = new HashSet<>();
        }
        dependentes.add(dependente);
        dependente.setFuncionario(this);
    }

    public void removerDependente(Dependente dependente) {
        if (dependentes != null && dependentes.contains(dependente)) {
            dependentes.remove(dependente);
            dependente.setFuncionario(null);
        }
    }

}
