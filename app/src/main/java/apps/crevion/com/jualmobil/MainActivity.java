package apps.crevion.com.jualmobil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String[][] data = new String[][]{
            {"Honda, Brio, 1.2L CKD S A/T, 2015",
                    "http://imgcdn.rajamobil.com:8080/resize2/public/media/images/databasemobil/original/2015/06/14/honda-brio-baru-mobil-dijual-jakarta-selatan-img_1-1434276927_346414789.jpg?v=250","19 Juta", "Jakarta Selatan"},
            {"Honda, Jazz, RS 1.5 A/T, 2015",
                    "http://imgcdn.rajamobil.com:8080/resize2/public/media/images/databasemobil/original/2015/06/14/honda-jazz-baru-mobil-dijual-jakarta-selatan-img_1-1434276414_1604643849.jpg?v=250","19 Juta", "Jakarta Selatan"},
            {"Mazda, Mazda2, V 1.5 M/T, 2014",
                    "http://imgcdn.rajamobil.com:8080/resize2/public/media/images/databasemobil/original/2015/06/13/2015-05-26-IMG-20150412-160046_1432608769933.JPG?v=250","Rp. 223.100.000", "Tangerang"},
            {"Honda, Jazz, A 1.5 M/T, 2015",
                    "http://imgcdn.rajamobil.com:8080/resize2/public/media/images/databasemobil/original/2015/06/05/honda-jazz-baru-mobil-dijual-jakarta-barat-img_1-1433491685_1515042903.jpg?v=250","Rp. 207.500.000", "Jakarta Barat"},
            {"Mitsubishi, Outlander, Sport PX, 2015",
                    "http://imgcdn.rajamobil.com:8080/resize2/public/media/images/databasemobil/original/2015/06/05/mitsubishi-outlander-baru-mobil-dijual-tangerang-img_1-1433491064_1220499493.jpg?v=250","Call", "Tangerang"}
    };

    private ListView listView;
    private ArrayList listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lv_item);
        listItem = new ArrayList<>();

        MobilModel mobil = null;

        for (int i = 0; i < data.length; i++) {
            mobil = new MobilModel();
            mobil.setTitle(data[i][0]);
            mobil.setImage(data[i][1]);
            mobil.setHarga(data[i][2]);
            mobil.setLokasi(data[i][3]);

            listItem.add(mobil);
        }

        MobilAdapter mobilAdapter = new MobilAdapter(MainActivity.this, listItem);
        listView.setAdapter(mobilAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MobilModel mobil = (MobilModel) listItem.get(i);

                Intent intent = new Intent(MainActivity.this, DetailMobilActivity.class);
                intent.putExtra(DetailMobilActivity.KEY_ITEM, mobil);
                startActivityForResult(intent, 0);
            }
        });
    }
}
