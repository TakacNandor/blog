package sk.ness.interview.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import sk.ness.interview.comment.Comment;

/**
 * DAO for {@link Comment} related DB operations
 *
 * @author nandor.takac
 *
 */
@Repository
public class CommentHibernateDAO implements CommentDAO {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> findByArticleID(int commentId) {
		return this.sessionFactory.getCurrentSession().createSQLQuery("select * from comments where id=:id")
				.addEntity(Comment.class).setParameter("id", commentId).list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> showAllComments() {
		return this.sessionFactory.getCurrentSession().createSQLQuery("select * from comment").addEntity(Comment.class)
				.list();

	}

	@Override
	public void persist(Comment comment) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(comment);

	}

}
