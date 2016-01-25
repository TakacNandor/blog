package sk.ness.interview;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.activation.CommandInfo;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import sk.ness.interview.comment.Comment;
import sk.ness.interview.config.DatabaseConfig;
import sk.ness.interview.dao.CommentHibernateDAO;
import sk.ness.interview.domain.Article;
import sk.ness.interview.service.ArticleService;
import sk.ness.interview.service.CommentService;

/**
 * Application runner that initializes necessary parts of the system.
 *
 * @author michal.kmetka
 *
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "sk.ness.interview", excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = ApplicationRunner.class) })
@Import(DatabaseConfig.class)
public class ArticleIngester {

	public static void main(final String[] args) throws FileNotFoundException, IOException {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ArticleIngester.class)) {
			context.registerShutdownHook();

			final ArticleService articleService = context.getBean(ArticleService.class);
			//CommentHibernateDAO c = new CommentHibernateDAO();
			
			final CommentService commentService = context.getBean(CommentService.class);
			

			// Load file with articles and ingest

			
			articleService.ingestArticles("articles_to_ingest.txt");
			
			//Comment comment = new Comment();
			//comment.setAuthor("Viliam");
			//comment.setText("Skusobny komentar, pokus druhy");
			//comment.setArticleId(articleService.findByID(11));
			
			
			
			//commentService.createComment(comment);
			 
			
		}
	}
}
