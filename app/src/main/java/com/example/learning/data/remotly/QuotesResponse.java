package com.example.learning.data.remotly;

import java.util.List;

public class QuotesResponse {

    public boolean success;
    public List<DataEntry> data;

    private class DataEntry{
        public int id;
        public String title;
        public String image;
        public String description;
    }
}
