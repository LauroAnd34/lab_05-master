package transportadora.service;

import transportadora.repository.DistanciaRepository;

import transportadora.entity.Frete;
import transportadora.entity.Distancia;

import java.util.List;

public class CalculoValorFreteService {

    private final DistanciaRepository distanciaRepository;

    public CalculoValorFreteService(DistanciaRepository distanciaRepository) {
        this.distanciaRepository = distanciaRepository;
    }

    public double calcular(Frete frete) {
        List<Distancia> distancias = distanciaRepository.buscaPorCidadeOrigemEDestino(
                frete.getCidadeOrigem().getId(), frete.getCidadeDestino().getId());

        if (distancias.isEmpty()) {
            throw new IllegalArgumentException("Distância entre cidades não encontrada.");
        }

        double distanciaKm = distancias.get(0).getQuilometros();
        frete.calculaFrete(distanciaKm);
        return frete.getValorFrete();
    }
}
