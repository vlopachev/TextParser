package com.epam.parser.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class PartText implements Comparable{

    private static long countId;
    private long id;
    private String text;
    private List<PartText> listPartsText = new ArrayList<>();

    protected PartText() {
        this.id = ++countId;
    }

    protected PartText(String text) {
        this();
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<PartText> getListPartsText() {

        return listPartsText;
    }

    @Override
    public int compareTo(Object o) {
        PartText other = (PartText) o;
        return this.getText().length() - other.getText().length();
    }

    protected abstract void parse ();
}
