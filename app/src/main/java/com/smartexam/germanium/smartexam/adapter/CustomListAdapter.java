package com.smartexam.germanium.smartexam.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.smartexam.germanium.smartexam.R;

/**
 * Created by home on 7/24/2016.
 */

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;

    String sub[];

    public CustomListAdapter(Activity activity, String sub[]) {
        this.activity = activity;
        this.sub = sub;
    }

    @Override
    public int getCount() {
        return sub.length;
    }

    @Override
    public Object getItem(int location) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.activity_examhistory_row_item, null);


        TextView title = (TextView) convertView.findViewById(R.id.tvId);
        TextView tvSubject = (TextView) convertView.findViewById(R.id.tvSubject);


        title.setText("" + position);
        if (position % 2 == 0) {

        } else {
            tvSubject.setText("Maths [English]");
        }


        return convertView;
    }

}
