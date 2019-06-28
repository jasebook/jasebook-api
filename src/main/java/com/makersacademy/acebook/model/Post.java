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
    private Long user_id;

    @ManyToOne(optional=false)
    @JoinColumn(name="user_id", insertable=false, updatable=false)
    private User users;

    @Column(name = "postedTime", updatable=false)
    @CreationTimestamp
    private Timestamp postedTime;

    private Post() {}



    public Post(String content, Long user_id) {
        this.content = content;
        this.user_id = user_id;
    }

}
