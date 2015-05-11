package com.arm.satornjanac.esspressotestsexamples;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by satornjanac on 5/6/15.
 */
public class RequestsAdapter extends BaseAdapter {

    private ArrayList<ChangeTeamRequest> mChangeTeamRequests = new ArrayList<>();
    private Context mContext;

    public RequestsAdapter(Context context){
        mContext = context;
        mChangeTeamRequests.addAll(ChangeTeamRequest.requests);
    }

    @Override
    public int getCount() {
        return mChangeTeamRequests.size();
    }

    @Override
    public Object getItem(int position) {
        return mChangeTeamRequests.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater)
                mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.request_item, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.request_name);
            holder.gender = (TextView) convertView.findViewById(R.id.gender);
            holder.fromTo = (TextView) convertView.findViewById(R.id.from_to);
            holder.technology = (TextView) convertView.findViewById(R.id.request_tech);
            holder.level = (TextView) convertView.findViewById(R.id.request_level);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        ChangeTeamRequest request = (ChangeTeamRequest) getItem(position);
        holder.name.setText(request.getName() + " " + request.getSurname());
        holder.gender.setText(request.isMan() ? mContext.getResources().getString(
                R.string.male_label) : mContext.getResources().getString(R.string.female_label));
        holder.fromTo.setText(request.getCurrentTeam() + "->" + request.getNewTeam());
        holder.technology.setText(request.getTechnology());
        holder.level.setText(request.getLevel());
        return convertView;
    }

    public class ViewHolder {
        TextView name;
        TextView gender;
        TextView fromTo;
        TextView technology;
        TextView level;
    }
}
