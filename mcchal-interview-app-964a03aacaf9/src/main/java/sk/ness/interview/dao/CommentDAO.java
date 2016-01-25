package sk.ness.interview.dao;

import java.util.List;

import sk.ness.interview.comment.Comment;

public interface CommentDAO {

	/** Returns {@link Comment}s by article ID */
	List<Comment> findByArticleID(int commendId);

	/** Persists {@link Comment} into the DB */
	void persist(Comment comment);

	/** Returns all available {@link Comment}s  */
	List<Comment> showAllComments();

}
