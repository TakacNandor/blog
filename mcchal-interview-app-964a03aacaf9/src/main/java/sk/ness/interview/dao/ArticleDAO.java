package sk.ness.interview.dao;

import java.util.List;

import sk.ness.interview.comment.Comment;
import sk.ness.interview.domain.Article;

public interface ArticleDAO {

	/** Returns {@link Article} with provided ID */
	Article findByID(Integer articleId);

	/** Returns all available {@link Article}s */
	List<Article> findAll();

	/** Persists {@link Article} into the DB */
	void persist(Article article);

	/**
	 * Returns all available {@link Article}s containing selected
	 * {@link String}.
	 */
	List<Article> search(String word);

	/**
	 * Returns {@link Article} by ID and the article comments.
	 */
	List<Comment> findByIdWithComments(Integer articleId);
	
	

}
