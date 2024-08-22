package transportadora.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public @Data class PessoaFisica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true)
    private String email;

    private String telefone;

    @Column(nullable = false, unique=true)
    private String cpf;
}