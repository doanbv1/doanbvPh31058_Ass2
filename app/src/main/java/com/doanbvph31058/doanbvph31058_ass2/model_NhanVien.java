package com.doanbvph31058.doanbvph31058_ass2;

import java.io.Serializable;

public class model_NhanVien implements Serializable {

        private String idNV;
        private String nameNV;
        private String phongBan;

    public model_NhanVien(String idNV, String nameNV, String phongBan) {
        this.idNV = idNV;
        this.nameNV = nameNV;
        this.phongBan = phongBan;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getNameNV() {
        return nameNV;
    }

    public void setNameNV(String nameNV) {
        this.nameNV = nameNV;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }
}
