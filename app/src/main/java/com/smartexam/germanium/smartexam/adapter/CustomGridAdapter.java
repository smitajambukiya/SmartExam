package com.smartexam.germanium.smartexam.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartexam.germanium.smartexam.R;

/**
 * Created by home on 7/24/2016.
 */

public class CustomGridAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;

    int val;

    public CustomGridAdapter(Activity activity, int val) {
        this.activity = activity;
        this.val = val;
    }

    @Override
    public int getCount() {
        return 5;
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
            convertView = inflater.inflate(R.layout.activity_grid_row, null);

        LinearLayout lnLinearLayout = (LinearLayout) convertView.findViewById(R.id.lnBackground);
        TextView grid_text = (TextView) convertView.findViewById(R.id.grid_text);

        grid_text.setText("" + position);

        if (val == 1) {
            lnLinearLayout.setBackgroundResource(R.drawable.round_1);
        } else if (val == 2) {
            lnLinearLayout.setBackgroundResource(R.drawable.round_2);
        } else if (val == 3) {
            lnLinearLayout.setBackgroundResource(R.drawable.round_3);
        } else if (val == 4) {
            lnLinearLayout.setBackgroundResource(R.drawable.round_4);
        }

        return convertView;
    }

}
