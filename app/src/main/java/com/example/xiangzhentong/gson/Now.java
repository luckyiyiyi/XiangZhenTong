package com.example.xiangzhentong.gson;

import com.google.gson.annotations.SerializedName;

public class Now {

    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    @SerializedName("wind_dir")
    public String wind;
    @SerializedName("wind_sc")
    public String windsc;

    public class More {

        @SerializedName("txt")
        public String info;

    }

}
