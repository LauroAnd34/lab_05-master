package transportadora.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
public @Data class Cliente extends PessoaFisica implements EntidadeBase {

    @Column(nullable = false)
    private String contato;

    @Column(nullable = false)
    private boolean ativo;

    @Column(nullable = false)
    private String endereco;

    public boolean isClienteAtivo() {
        return this.ativo;
    }
}
