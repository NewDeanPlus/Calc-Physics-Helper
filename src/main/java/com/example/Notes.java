package com.example;

public class Notes {

    String[] notesText;

    public Notes(String... notes){
        this.notesText = new String[notes.length];
        for(int i=0; i<notes.length; i++){
            this.notesText[i] = notes[i];
        }
    }
}
