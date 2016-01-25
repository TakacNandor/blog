package sk.ness.interview.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import sk.ness.interview.comment.Comment;

import sk.ness.interview.dao.CommentDAO;


/**
 * Service should be used as a gateway to {@link Comment} world and handle all comment related manipulation.
 *
 * @author nandor.takac
 *
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	@Resource
	private CommentDAO commentDAO;
	
	@Override
	public List<Comment> findAll() {
		
		return this.commentDAO.showAllComments();
	}

	@Override
	public void createComment(Comment comment) {
		this.commentDAO.persist(comment);
		
	}

}
