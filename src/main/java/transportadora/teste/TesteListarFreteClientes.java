package transportadora.teste;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import transportadora.entity.Frete;
import transportadora.service.ListarFretesClienteService;

import java.util.List;

public class TesteListarFreteClientes {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab_05");
        EntityManager em = emf.createEntityManager();

        Integer clienteId = (Integer) 1;

        ListarFretesClienteService listarService = new ListarFretesClienteService(em);
        List<Frete> fretes = listarService.listarFretesPorCliente(clienteId);

        System.out.println("Fretes do cliente " + clienteId + ":");
        for (Frete frete : fretes) {
            System.out.println(frete);
        }

        em.close();
        emf.close();
    }
}
