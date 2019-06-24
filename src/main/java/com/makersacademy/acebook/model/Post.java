package com.makersacademy.acebook.model;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.repository.Temporal;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

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
