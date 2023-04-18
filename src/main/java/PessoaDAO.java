import model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PessoaDAO {

    private EntityManager entityManager = null;

    public PessoaDAO() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bd2");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public List<Pessoa> list(){
        String sql = "FROM "+Pessoa.class.getName();
        return entityManager.createQuery(sql, Pessoa.class).getResultList();
    }

    public Pessoa listById(Long i) {
        Pessoa pessoa = null;
        entityManager.getTransaction().begin();
        pessoa = entityManager.find(Pessoa.class, i);
        entityManager.getTransaction().commit();
        return pessoa;
    }


    public void crete(Pessoa pessoa) {
        entityManager.getTransaction().begin();
        entityManager.persist(pessoa);
        entityManager.getTransaction().commit();
    }

    public void update(Pessoa pessoa){
        entityManager.getTransaction().begin();
        entityManager.merge(pessoa);
        entityManager.getTransaction().commit();
    }

    public void delete(Long i){
        entityManager.getTransaction().begin();
        Pessoa pessoa = entityManager.find(Pessoa.class, i);
        entityManager.remove(pessoa);
        entityManager.getTransaction().commit();
    }

}
