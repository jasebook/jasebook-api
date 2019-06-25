package com.makersacademy.acebook.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "POSTS")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @Column(name = "postedTime", updatable=false)
    @CreationTimestamp
    private Timestamp postedTime;

    private Post() {}

    public Post(String content) {
        this.content = content;
    }

}
