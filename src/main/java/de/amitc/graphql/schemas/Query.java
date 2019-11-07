package de.amitc.graphql.schemas;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.amitc.graphql.models.Post;
import de.amitc.graphql.models.PostDao;

@Component
public class Query implements GraphQLQueryResolver {
    
    @Autowired
    private PostDao postDao;
    
    public List<Post> getAll() {
        return postDao.getAll();
    }

    public List<Post> getRecentPosts(int count, int offset) {
        return postDao.getRecentPosts(count, offset);
    }
}