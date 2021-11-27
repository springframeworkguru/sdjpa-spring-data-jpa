package guru.springframework.jdbc.dao;

import guru.springframework.jdbc.domain.Author;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by jt on 11/27/21.
 */
public class AuthorDaoHibernate implements AuthorDao {

    private final EntityManagerFactory emf;

    public AuthorDaoHibernate(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    @Override
    public List<Author> findAllAuthorsByLastName(String lastname, Pageable pageable) {
        EntityManager em = getEntityManager();

        try {
            String hql = "SELECT a FROM Author a where a.lastName = :lastName ";

            if (pageable.getSort().getOrderFor("firstname") != null) {
                hql = hql + " order by a.firstName " + pageable.getSort().getOrderFor("firstname")
                        .getDirection().name();
            }

            TypedQuery<Author> query = em.createQuery(hql, Author.class);

            query.setParameter("lastName", lastname);
            query.setFirstResult(Math.toIntExact(pageable.getOffset()));
            query.setMaxResults(pageable.getPageSize());

            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Author getById(Long id) {
        return null;
    }

    @Override
    public Author findAuthorByName(String firstName, String lastName) {
        return null;
    }

    @Override
    public Author saveNewAuthor(Author author) {
        return null;
    }

    @Override
    public Author updateAuthor(Author author) {
        return null;
    }

    @Override
    public void deleteAuthorById(Long id) {

    }
}
