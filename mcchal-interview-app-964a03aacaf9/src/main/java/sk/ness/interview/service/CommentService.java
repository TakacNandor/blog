package sk.ness.interview.service;

import java.util.List;

import sk.ness.interview.comment.Comment;
/**
 * Service should be used as a gateway to {@link Comment} world and handle all comment related manipulation.
 *
 * @author nandor.takac
 *
 */
public interface CommentService {

	  /** Returns all available {@link Comment}s */
	  List<Comment> findAll();

	  /** Creates new {@link Comment} */
	  void createComment(Comment comment);
	  
	  	  
}
