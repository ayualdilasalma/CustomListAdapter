package id.dila.mod_3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;

/**
 * Created by dilacim on 3/19/2017.
 */

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private List<Komponen> listKomponen;

    public CustomAdapter(Context context, List<Komponen> listKomponen) {
        this.context = context;
        this.listKomponen = listKomponen;
    }

    @Override
    public int getCount() {
        return listKomponen.size();
    }

    @Override
    public Object getItem(int position) {
        return listKomponen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listKomponen.indexOf(getItem(position));
    }

    private class ViewHolder {
        ImageView gambar;
        TextView namaKomponen;
        TextView descKomponen;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if ( convertView == null ) {
            convertView = inflater.inflate(R.layout.custom_adapter, null);
            holder = new ViewHolder();

            holder.namaKomponen = (TextView) convertView.findViewById(R.id.jenisText);
            holder.descKomponen = (TextView) convertView.findViewById(R.id.descText);
            holder.gambar = (ImageView) convertView.findViewById(R.id.imgIcon);

            Komponen comp_pos = listKomponen.get(position);

            holder.gambar.setImageResource(comp_pos.getGambar());
            holder.namaKomponen.setText(comp_pos.getNama());
            holder.descKomponen.setText(comp_pos.getDescripsi());

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }
}
