package com.projectakhir_fenny.model;

import java.io.Serializable;

public class Masyarakat implements Serializable{
    private int id;
    private String nik, nama;

    public int getId() {//untuk mendapatkan id
        return id;
    }

    public void setId(int id) {//untuk membuuat id
        this.id = id;
    }
    public String getNik() {//untuk mendapatkan NIK
        return nik;
    }
    public void  setNik(String nik) {//untuk membuat NIK
        this.nik = nik;
    }
    public String getNama() {//untuk mendapatkan Nama
        return nama;
    }
    public void setNama(String nama) {//untuk mambuat Nama
        this.nama = nama;
    }

}
