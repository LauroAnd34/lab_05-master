package transportadora.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import transportadora.entity.enums.TipoEntrega;
import transportadora.repository.*;

import java.time.LocalDate;

public class Test {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab_05");
        EntityManager em = emf.createEntityManager();

        CidadeRepository cidadeRepository = new CidadeRepository(em);
        FilialRepository filialRepository = new FilialRepository(em);
        ClienteRepository clienteRepository = new ClienteRepository(em);
        FuncionarioRepository funcionarioRepository = new FuncionarioRepository(em);
        VeiculoRepository veiculoRepository = new VeiculoRepository(em);
        TipoVeiculoRepository tipoVeiculoRepository = new TipoVeiculoRepository(em);
        CategoriaFreteRepository categoriaFreteRepository = new CategoriaFreteRepository(em);
        DistanciaRepository distanciaRepository = new DistanciaRepository(em);


        Cidade cidade1 = new Cidade();
        Cidade cidade2 = new Cidade();
        cidade1.setNome("São Paulo");
        cidade1.setUf("SP");
        cidade1.setEstado("São Paulo");
        cidade2.setNome("São Luis");
        cidade2.setUf("MA");
        cidade2.setEstado("Maranhão");
        cidadeRepository.salvaOuAtualiza(cidade1);
        cidadeRepository.salvaOuAtualiza(cidade2);


        Cliente cliente1 = new Cliente();
        cliente1.setNome("João da Silva");
        cliente1.setCpf("12345678901");
        cliente1.setEmail("joao.silva@example.com");
        cliente1.setTelefone("1122334455");
        cliente1.setContato("1122334456");
        cliente1.setAtivo(true);
        cliente1.setEndereco("rua da alegria");
        clienteRepository.salvaOuAtualiza(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Fernando Carlos");
        cliente2.setCpf("12947178901");
        cliente2.setEmail("fernando.calors@example.com");
        cliente2.setTelefone("1175684455");
        cliente2.setContato("1197634456");
        cliente2.setAtivo(true);
        cliente2.setEndereco("rua da felicidade");
        clienteRepository.salvaOuAtualiza(cliente2);

        Filial f1 = new Filial();
        f1.setNome("Fulano");
        f1.setEndereco("Rua são joão");
        f1.setTelefone("3212345678");
        filialRepository.salvaOuAtualiza(f1);


        Dependente d1 = new Dependente();
        d1.setNome("José Filho");
        d1.setDataNascimento(LocalDate.of(2002, 1, 10));


        Funcionario funcionario = new Funcionario();
        funcionario.setNome("João José");
        funcionario.setCpf("12345678919");
        funcionario.setEmail("joaojose@gmail.com");
        funcionario.setTelefone("98912345689");
        funcionario.setMatricula(15243);
        funcionario.setFilial(f1);
        funcionario.adicionarDependente(d1);
        funcionarioRepository.salvaOuAtualiza(funcionario);


        f1.definirResponsavel(funcionario);
        filialRepository.salvaOuAtualiza(f1);


        TipoVeiculo tipoVeiculo = new TipoVeiculo();
        tipoVeiculo.setDescricao("Caminhão");
        tipoVeiculoRepository.salvaOuAtualiza(tipoVeiculo);


        Veiculo veiculo = new Veiculo();
        veiculo.setNumeroPlaca("ABC-1234");
        veiculo.setFilial(f1);
        veiculo.setTipoVeiculo(tipoVeiculo);
        veiculoRepository.salvaOuAtualiza(veiculo);


        CategoriaFrete categoriaFrete = new CategoriaFrete();
        categoriaFrete.setDescricao("Entrega Rápida");
        categoriaFrete.setTipoEntrega(TipoEntrega.RAPIDA);
        categoriaFreteRepository.salvaOuAtualiza(categoriaFrete);

        CategoriaFrete categoriaFrete2 = new CategoriaFrete();
        categoriaFrete2.setDescricao("Entrega Normal");
        categoriaFrete2.setTipoEntrega(TipoEntrega.NORMAL);
        categoriaFreteRepository.salvaOuAtualiza(categoriaFrete2);


        //Cidade cidade1 = cidadeRepository.buscaPorId(1);
        //Cidade cidade2 = cidadeRepository.buscaPorId(2);

        Distancia distancia = new Distancia();
        distancia.setCidadeOrigem(cidade1);
        distancia.setCidadeDestino(cidade2);
        distancia.setQuilometros(2000);
        distanciaRepository.salvaOuAtualiza(distancia);

        Distancia distancia2 = new Distancia();
        distancia2.setCidadeOrigem(cidade2);
        distancia2.setCidadeDestino(cidade1);
        distancia2.setQuilometros(2020);
        distanciaRepository.salvaOuAtualiza(distancia2);

        em.close();
        emf.close();
    }
}
