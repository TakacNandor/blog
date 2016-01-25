package sk.ness.interview.service;

import java.io.File;

import java.io.IOException;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import sk.ness.interview.comment.Comment;
import sk.ness.interview.dao.ArticleDAO;
import sk.ness.interview.domain.Article;

/**
 * Service should be used as a gateway to {@link Article} world and handle all
 * article related manipulation.
 *
 * @author michal.kmetka
 *
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	@Resource
	private ArticleDAO articleDAO;

	@Override
	public Article findByID(final Integer articleId) {
		return this.articleDAO.findByID(articleId);
	}

	@Override
	public List<Article> findAll() {
		return this.articleDAO.findAll();
	}

	@Override
	public List<Article> search(String word) {
		return articleDAO.search(word);
	}

	@Override
	public void createArticle(final Article article) {
		this.articleDAO.persist(article);
	}


	@SuppressWarnings("deprecation")
	@Override
	public void ingestArticles(final String jsonArticles) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonFactory factory = new JsonFactory();
			List<Article> jsonList = null;
			JsonParser parser = factory.createJsonParser(new File(jsonArticles));
			TypeReference<List<Article>> typeRef = new TypeReference<List<Article>>() {
			};
			jsonList = mapper.readValue(parser, typeRef);
			for (Article article : jsonList) {
				createArticle(article);
			}

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Comment> findByIdWithComments(Integer articleId) {
		
		return this.articleDAO.findByIdWithComments(articleId);
	}

}
