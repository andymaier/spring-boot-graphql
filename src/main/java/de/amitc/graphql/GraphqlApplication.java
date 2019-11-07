package de.amitc.graphql;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.amitc.graphql.models.Post;
import de.amitc.graphql.models.PostDao;

@SpringBootApplication
public class GraphqlApplication {

	@Autowired
	PostDao postDao;

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

	@PostConstruct
	public void setup() {        
        for (int postId = 0; postId < 10; ++postId) {
            for (int authorId = 0; authorId < 10; ++authorId) {
                Post post = new Post();
                post.setId("Post" + authorId + postId);
                post.setTitle("Post " + authorId + ":" + postId);
                post.setText("Post " + postId + " + by author " + authorId);
                post.setAuthorId("Author" + authorId);				
				postDao.savePost(post);
				System.out.println(post);
            }
        }
       
    }
}
