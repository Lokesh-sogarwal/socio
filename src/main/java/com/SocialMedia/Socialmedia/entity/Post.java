package com.SocialMedia.Socialmedia.entity;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String postId;  // Unique post identifier
    private String caption;  // Text content of the post
    private String image;  // URL of the media (e.g., image, video)
    private Timestamp createdat;  // Timestamp of when the post was created
    private int likesCount;  // Number of likes
    private int commentsCount;  // Number of comments

    // ManyToOne relationship with User, assuming each post is associated with one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Constructors, Getters, and Setters

    public Post() {
        this.likesCount = 0;
        this.commentsCount = 0;
        this.createdat = new Timestamp(System.currentTimeMillis());  // Default to current timestamp
    }

    public Long getId() {
        return id;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public Timestamp getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Timestamp createdat) {
        this.createdat = createdat;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}