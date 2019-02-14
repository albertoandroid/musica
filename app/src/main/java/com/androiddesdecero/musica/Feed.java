package com.androiddesdecero.musica;

import java.util.List;

/**
 * Created by albertopalomarrobledo on 14/2/19.
 */

public class Feed {

    private String title;
    private List<Result> results;

    public Feed(){

    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
