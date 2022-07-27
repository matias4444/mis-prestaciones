package com.example.myapplication;

public class Prestaciones {

    private String Prestaciones;
    private int PicId;


    public Prestaciones(String prestaciones, int picId) {
        Prestaciones = prestaciones;
        PicId = picId;
    }

    public String getPrestaciones() {
        return Prestaciones;
    }

    public int getPicId() {
        return PicId;
    }


}
