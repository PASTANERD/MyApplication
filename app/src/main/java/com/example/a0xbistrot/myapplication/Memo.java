package com.example.a0xbistrot.myapplication;

public class Memo {
    String title;
    String content;


    Memo() {
    }

    Memo(String title, String content){
        this.title = title;
        this.content = content;
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
}
