package com.cms.entity;

import javax.persistence.*;

/**
 * Created by HOZANDUNG on 17/5/15.
 */
@Entity
@Table(name = "sys_content")
public class SysContent {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "userid",nullable = false)
    private int userid;

    @Column(name = "category")
    private int category;

    @Column(name = "title",nullable = true)
    private String title;

    @Lob
    @Column(name = "content",nullable = true)
    private String content;

    @Column(name = "author")
    private String author;

    @Lob
    @Column(name = "time")
    private String time;

    @Column(name = "file_path",nullable = true)
    private String file_path;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }
}
