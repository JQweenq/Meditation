package com.example.learning.data.remotly;

import java.util.List;

public class FeelingsResponse {

    public boolean success;
    public List<FeelingsDataEntry> data;

    public class FeelingsDataEntry {
        public int id;
        public String title;
        public String image;
        public int position;
    }
}
