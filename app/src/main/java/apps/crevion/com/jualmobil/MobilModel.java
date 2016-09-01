package apps.crevion.com.jualmobil;

import java.io.Serializable;

/**
 * Created by skyshidev on 29/08/16.
 */
public class MobilModel implements Serializable{
    private String harga;
    private String title;
    private String image;
    private String lokasi;

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
}
