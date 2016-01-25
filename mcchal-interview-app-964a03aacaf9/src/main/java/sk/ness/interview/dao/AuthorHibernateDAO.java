package sk.ness.interview.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import sk.ness.interview.dto.Author;
import sk.ness.interview.dto.AuthorStats;

/**
 * DAO for {@link Author} related DB operations
 *
 * @author michal.kmetka
 *
 */
@Repository
public class AuthorHibernateDAO implements AuthorDAO {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Author> findAll() {
		return this.sessionFactory.getCurrentSession()
				.createSQLQuery("select distinct a.author as name from articles a ")
				.addScalar("name", StringType.INSTANCE)
				.setResultTransformer(new AliasToBeanResultTransformer(Author.class)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AuthorStats> stats() {
		return this.sessionFactory.getCurrentSession()
				.createSQLQuery("select a.author, count(*) from articles a group by a.author").list();
	}

}
