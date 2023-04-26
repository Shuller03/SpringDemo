package noncom.example.Catsgram2_0.model;

import lombok.Data;

@Data
public class User {
    private String id;
    private String username;
    private String nickname;

    public User(String id, String username, String nickname){
        this.id = id;
        this.username = username;
        this.nickname = nickname;
    }
}
