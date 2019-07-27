package com.retrocalls;

import android.media.Image;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ImageResponses {
    @SerializedName("page")
    @Expose
    private int page;


    @SerializedName("results")
    @Expose
    private ArrayList<Images> results;

    @SerializedName("total_pages")
    @Expose
    private int totalPages;

    public ImageResponses(int page, ArrayList<Images> results, int totalPages) {
        this.page = page;
        this.results = results;
        this.totalPages = totalPages;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public ArrayList<Images> getResults() {
        return results;
    }

    public void setResults(ArrayList<Images> results) {
        this.results = results;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
