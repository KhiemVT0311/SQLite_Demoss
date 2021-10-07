package com.eup.sqlitedemo.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Virus implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String name;
    @ColumnInfo
    private String cauTruc;
    @ColumnInfo
    private String ngayXuatHien;
    @ColumnInfo
    private String vacXin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCauTruc() {
        return cauTruc;
    }

    public void setCauTruc(String cauTruc) {
        this.cauTruc = cauTruc;
    }

    public String getNgayXuatHien() {
        return ngayXuatHien;
    }

    public void setNgayXuatHien(String ngayXuatHien) {
        this.ngayXuatHien = ngayXuatHien;
    }

    public String getVacXin() {
        return vacXin;
    }

    public void setVacXin(String vacXin) {
        this.vacXin = vacXin;
    }
}
