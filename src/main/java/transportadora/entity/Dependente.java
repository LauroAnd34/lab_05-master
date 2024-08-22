package transportadora.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
public @Data class Dependente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "dt_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario funcionario;
}
