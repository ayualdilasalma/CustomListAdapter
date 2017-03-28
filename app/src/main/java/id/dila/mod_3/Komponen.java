package id.dila.mod_3;

/**
 * Created by dilacim on 3/19/2017.
 */

public class Komponen {

    private String nama, descripsi;
    private int gambar;

    public Komponen(String nama, String desc, int gambar) {
        this.nama = nama;
        this.descripsi = desc;
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDescripsi() {
        return descripsi;
    }

    public void setDescripsi(String descripsi) {
        this.descripsi = descripsi;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}
