package transportadora.entity;
import jakarta.persistence.*;
import lombok.Data;


@Embeddable
public @Data class ItemFrete {

    @Column(nullable = false)
    private String descricao;

    private float peso;

    public ItemFrete() {
    }

    public ItemFrete(String descricao, float peso) {
        this.descricao = descricao;
        this.peso = peso;
    }
}
