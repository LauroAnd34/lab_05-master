package transportadora.teste;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import transportadora.entity.*;
import transportadora.repository.FreteRepository;
import transportadora.service.CadastroFreteService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class TesteCadastroFrete {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab_05");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        ItemFrete item1 = new ItemFrete("Livro", 1.0f);
        ItemFrete item2 = new ItemFrete("Notebook", 2.0f);
        ItemFrete item3 = new ItemFrete("Livro", 1.0f);


        Frete frete = new Frete();
        frete.setCategoriaFrete(em.find(CategoriaFrete.class, 1));
        frete.setNumeroNotaFiscal(1248596);
        frete.setCliente(em.find(Cliente.class, 1));
        frete.setVeiculo(em.find(Veiculo.class, 1));
        frete.setCidadeOrigem(em.find(Cidade.class, 1));
        frete.setCidadeDestino(em.find(Cidade.class, 2));
        frete.setFuncionarioResponsavel("Fernando Fernandes");
        frete.getItens().add(item1);
        frete.getItens().add(item2);


        Frete frete2 = new Frete();
        frete2.setCategoriaFrete(em.find(CategoriaFrete.class, 1));
        frete2.setNumeroNotaFiscal(12474);
        frete2.setCliente(em.find(Cliente.class, 1));
        frete2.setVeiculo(em.find(Veiculo.class, 1));
        frete2.setCidadeOrigem(em.find(Cidade.class, 2));
        frete2.setCidadeDestino(em.find(Cidade.class, 1));
        frete2.setFuncionarioResponsavel("Cirilo Andrade");
        frete2.getItens().add(item1);
        frete2.getItens().add(item2);

        Frete frete3 = new Frete();
        frete3.setCategoriaFrete(em.find(CategoriaFrete.class, 1));
        frete3.setNumeroNotaFiscal(12642);
        frete3.setCliente(em.find(Cliente.class, 1));
        frete3.setVeiculo(em.find(Veiculo.class, 1));
        frete3.setCidadeOrigem(em.find(Cidade.class, 2));
        frete3.setCidadeDestino(em.find(Cidade.class, 1));
        frete3.setFuncionarioResponsavel("Lucas Lucco");
        frete3.getItens().add(item1);
        frete3.getItens().add(item3);

        tx.commit();

        CadastroFreteService cadastroService = new CadastroFreteService(em);

        Frete salvo1 = cadastroService.cadastrarFrete(frete);
        System.out.println("Frete cadastrado: " + salvo1);

        Frete salvo2 = cadastroService.cadastrarFrete(frete2);
        System.out.println("Frete cadastrado: " + salvo2);

        Frete salvo3 = cadastroService.cadastrarFrete(frete3);
        System.out.println("Frete cadastrado: " + salvo3);

        em.close();
        emf.close();
    }
}
