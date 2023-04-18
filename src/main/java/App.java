import model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        PessoaDAO dao = new PessoaDAO();

        Pessoa p1 = new Pessoa();
        p1.setNome("Andre Dias");
        p1.setIdade(22);

        Pessoa p2 = new Pessoa();
        p2.setNome("Alice");
        p2.setIdade(19);

        System.out.println("------------- Create part -------------");
        dao.crete(p1);
        dao.crete(p2);

        System.out.println(dao.list());

        System.out.println("------------- List by id part -------------");
        System.out.println(dao.listById(1L));

        System.out.println("------------- List All -------------");
        System.out.println(dao.list());

        System.out.println("------------- Update part -------------");
        p1.setIdade(25);
        dao.update(p1);
        System.out.println(dao.list());

        System.out.println("------------- Delete part -------------");
        dao.delete(1L);
        System.out.println(dao.list());

    }
}
