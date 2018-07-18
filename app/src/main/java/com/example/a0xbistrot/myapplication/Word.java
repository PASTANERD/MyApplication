package com.example.a0xbistrot.myapplication;

public class Word {
    private String word;
    private String meaning;

    Word(String word, String meaning){
        this.word = word;
        this.meaning = meaning;
    }

    Word(){

    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
