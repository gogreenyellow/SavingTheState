package com.gogreenyellow.savingthestate.recycler;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gogreenyellow.savingthestate.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by wkjan_000 on 07.02.2018.
 */

public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.Holder> {

    private Context context;
    private JSONArray model;

    public SampleAdapter(Context context) {
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.layout_recyclerview_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(final Holder holder, int position) {
        final String labelKey = "label";
        final String photoKey = "imageUrl";
        final String secondaryTextKey = "secondaryText";
        final String colorKey = "color";

        try {
            JSONObject itemJson = model.getJSONObject(position);

            holder.labelTextView.setText(itemJson.getString(labelKey));
            holder.secondaryTextView.setText(itemJson.getString(secondaryTextKey));
            Picasso.with(context)
                    .load(itemJson.getString(photoKey))
                    .resize(250, 250)
                    .centerCrop()
                    .into(new Target() {
                        @Override
                        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                            RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(context.getResources(), bitmap);
                            drawable.setCircular(true);
                            holder.imageView.setImageDrawable(drawable);
                        }

                        @Override
                        public void onBitmapFailed(Drawable errorDrawable) {
                        }

                        @Override
                        public void onPrepareLoad(Drawable placeHolderDrawable) {
                        }
                    });
            holder.imageView.setColorFilter(Color.parseColor(itemJson.getString(colorKey)));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return model == null ? 0 : model.length();
    }

    public void swapModel(JSONArray jsonArray) {
        this.model = jsonArray;
        notifyDataSetChanged();
    }

    class Holder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView labelTextView;
        TextView secondaryTextView;

        public Holder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.rvi_image);
            labelTextView = itemView.findViewById(R.id.rvi_primary_text);
            secondaryTextView = itemView.findViewById(R.id.rvi_secondary_text);
        }
    }
}
