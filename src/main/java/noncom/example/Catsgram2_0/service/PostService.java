package noncom.example.Catsgram2_0.service;

import lombok.Getter;
import noncom.example.Catsgram2_0.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class PostService {
    private final List<Post> posts = new ArrayList<>();

    public List<Post> findAll(){
        return posts;
    }

    public Post create(Post post){
        posts.add(post);
        return post;
    }
}
