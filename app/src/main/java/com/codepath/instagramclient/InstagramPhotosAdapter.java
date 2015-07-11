
package com.codepath.instagramclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by MDE on 7/8/2015.
 */
public class InstagramPhotosAdapter extends ArrayAdapter<InstagramPhoto> {
    // what data we need from activity
    //contaext, data source
    public InstagramPhotosAdapter(Context context, List<InstagramPhoto> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
    }
    //what the item looks like
    //use the template to display each photo
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        InstagramPhoto photo = getItem(position);
        // Check if we are using a recycled view, if not we need to initiate
        if (convertView == null) {
            //create new view from template
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
        }
        // Look up the views for populating the data (image, caption, username, likes)
        TextView tvCaption = (TextView) convertView.findViewById(R.id.tvCaption);
        TextView tvLikesCount = (TextView) convertView.findViewById(R.id.tvLikesCount);
        TextView tvUsername = (TextView) convertView.findViewById(R.id.tvUsername);
        ImageView ivPhoto = (ImageView) convertView.findViewById(R.id.ivPhoto);
        // insert the model data
        tvCaption.setText(photo.caption);
        tvUsername.setText(photo.username);
        tvLikesCount.setText(String.valueOf(photo.likesCount));
        // Clear out the ImageView
        ivPhoto.setImageResource(0);
        // Insert the Image using Picasso
        Picasso.with(getContext()).load(photo.imageURL).into(ivPhoto);
        //return the created item
        return convertView;
    }
}