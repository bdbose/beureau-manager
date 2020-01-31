package com.godu.test2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class ItemArrayAdapter extends ArrayAdapter<String[]> {
    private List<String[]> datalist = new ArrayList<String[]>();


    static class ItemViewHolder {
        TextView state;
        TextView region;
    }

    public ItemArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public void add(String[] object) {
        datalist.add(object);
        super.add(object);


    }

    @Override
    public int getCount() {
        return this.datalist.size();
    }

    @Override
    public String[] getItem(int index) {
        return this.datalist.get(index);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ItemViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.item, parent, false);
            viewHolder = new ItemViewHolder();
            viewHolder.state = (TextView) row.findViewById(R.id.State);
            viewHolder.region = (TextView) row.findViewById(R.id.Murder);

            row.setTag(viewHolder);
        } else {
            viewHolder = (ItemViewHolder)row.getTag();
        }
        String[] stat = getItem(position);
        viewHolder.state.setText(stat[0]);
        viewHolder.region.setText(stat[1]);
        return row;
    }
}