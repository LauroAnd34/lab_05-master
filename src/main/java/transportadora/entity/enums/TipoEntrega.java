package transportadora.entity.enums;

public enum TipoEntrega {
    NORMAL(0),
    RAPIDA(0.10),
    SUPER_RAPIDA(0.30);

    private final double percentualAumento;

    TipoEntrega(double percentualAumento) {
        this.percentualAumento = percentualAumento;
    }

    public double getPercentualAumento() {
        return percentualAumento;
    }
}