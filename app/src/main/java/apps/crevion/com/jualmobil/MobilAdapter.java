package apps.crevion.com.jualmobil;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by skyshidev on 29/08/16.
 */
public class MobilAdapter extends BaseAdapter {
    ArrayList listItem;
    Activity activity;

    public MobilAdapter(Activity activity, ArrayList listItem){
        this.activity = activity;
        this.listItem = listItem;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int i) {
        return listItem.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;

        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_list, null);
            viewHolder.textTitle = (TextView) view.findViewById(R.id.txt_item_title);
            viewHolder.textHarga = (TextView) view.findViewById(R.id.txt_item_harga);
            viewHolder.textLokasi = (TextView) view.findViewById(R.id.txt_item_lokasi);
            viewHolder.imageView = (ImageView) view.findViewById(R.id.img_item);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }

        MobilModel model = (MobilModel) getItem(i);
        viewHolder.textTitle.setText(model.getTitle());
        viewHolder.textLokasi.setText(model.getLokasi());
        viewHolder.textHarga.setText(model.getHarga());

        Picasso.with(activity).load(model.getImage()).into(viewHolder.imageView);
        return view;
    }

    private static class ViewHolder{
        ImageView imageView;
        TextView textTitle, textLokasi, textHarga;
    }
}
