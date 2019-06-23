package db;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data // Lombok: adds getters and setters
@Entity // This tells Hibernate to make a table out of this class
public class Post {

    public Post(String content, String username) {
        this.content = content;
        this.username = username;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private final String content;

    private String username;

}

