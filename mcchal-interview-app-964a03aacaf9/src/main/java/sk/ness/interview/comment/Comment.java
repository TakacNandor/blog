package sk.ness.interview.comment;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import sk.ness.interview.domain.Article;


@Entity
@Table(name = "comment")
@SequenceGenerator(name = "comment_seq_store", sequenceName = "comment_seq", allocationSize = 1)
public class Comment {

	public Comment() {
		this.date = new Date();
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, precision = 10, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq_store")
	private Integer id;

	@Column(name = "author", length = 250)
	private String author;

	@Column(name = "text", length = 2000)
	private String text;

	@Column(name = "create_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "id_article", referencedColumnName = "id") 
	private Article articleId;

	public void setId(Integer id) {
		this.id = id;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public String getText() {
		return text;
	}

	public Article getArticleId() {
		return articleId;
	}

	public void setArticleId(Article articleId) {
		this.articleId = articleId;
	}

	

	
	

}