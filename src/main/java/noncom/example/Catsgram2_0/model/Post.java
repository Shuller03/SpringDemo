package noncom.example.Catsgram2_0.model;

import lombok.Data;
import noncom.example.Catsgram2_0.controller.UserController;

import java.time.Instant;

@Data
public class Post {

    private Integer id;
    private String author;
    private final Instant creationDate = Instant.now();
    private String description;
    private String photoUrl;

//    UserController userController;

    public Post(Integer id,String author, String description, String photoUrl) {
//        this.userController = userController;
        this.id = hashCode();
        this.description = description;
        this.photoUrl = photoUrl;
        this.author = author;
    }
}
