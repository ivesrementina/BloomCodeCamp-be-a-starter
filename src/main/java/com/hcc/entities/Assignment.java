package com.hcc.entities;

import javax.persistence.*;

@Entity
@Table(name = "assignments")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "statuses")
    private String status;
    @Column(name = "numbers")
    private Integer number;
    @Column(name = "github_url")
    private String githubUrl;
    @Column(name = "branchs")
    private String branch;
    @Column(name = "review_video_url")
    private String reviewVideoUrl;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "reviewer_id")
    private User codeReviewer;

    public Assignment(String status, Integer number, String githubUrl, String branch, String reviewVideoUrl, User user, User codeReviewer) {
        this.status = status;
        this.number = number;
        this.githubUrl = githubUrl;
        this.branch = branch;
        this.reviewVideoUrl = reviewVideoUrl;
        this.user = user;
        this.codeReviewer = codeReviewer;
    }

    public Assignment() {
    }

    public Long getId() {
        return id;
    }

    public Assignment setId(Long id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Assignment setStatus(String status) {
        this.status = status;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public Assignment setNumber(Integer number) {
        this.number = number;
        return this;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public Assignment setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
        return this;
    }

    public String getBranch() {
        return branch;
    }

    public Assignment setBranch(String branch) {
        this.branch = branch;
        return this;
    }

    public String getReviewVideoUrl() {
        return reviewVideoUrl;
    }

    public Assignment setReviewVideoUrl(String reviewVideoUrl) {
        this.reviewVideoUrl = reviewVideoUrl;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Assignment setUser(User user) {
        this.user = user;
        return this;
    }

    public User getCodeReviewer() {
        return codeReviewer;
    }

    public Assignment setCodeReviewer(User codeReviewer) {
        this.codeReviewer = codeReviewer;
        return this;
    }
}
