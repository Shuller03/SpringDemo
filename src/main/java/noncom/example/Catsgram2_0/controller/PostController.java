package noncom.example.Catsgram2_0.controller;

import noncom.example.Catsgram2_0.model.Post;
import noncom.example.Catsgram2_0.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> findAll(){
        return postService.findAll();
    }

    @PostMapping(value = "/post")
    public Post create(@RequestBody Post post){
        return postService.create(post);
    }

    @GetMapping("/posts/{postId}")
    public Optional<Post> findById (@PathVariable int postId){
        return postService.getPosts().stream()
                .filter(x -> x.getId() == postId)
                .findFirst();
    }

    @GetMapping("/posts/search")
    public List<Post> searchPosts(@RequestParam String author,
                                  @RequestParam
                                  @DateTimeFormat(pattern = "yyyy-MM-dd")
                                  LocalDate date){
        System.out.format("Ищем посты пользователя %s и опубликованные %s",
                author,
                date);
        return new ArrayList<Post>();
    }
}
