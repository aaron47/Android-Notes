package com.aaron.notes.entities;


public class Note {

    private String title;
    private boolean isChecked;


    public Note(String title, boolean isChecked) {
        this.title = title;
        this.isChecked = isChecked;
    }

    public Note(String title) {
        this.title = title;
        this.isChecked = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
