package com.gogreenyellow.savingthestate.recycler;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.gogreenyellow.savingthestate.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * The sample adapter.
 *
 * @author wjanuszek
 */
public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.Holder> {

    /**
     * Holds the user choices.
     */
    private boolean[] selection;
    private Context context;
    /**
     * The server's response.
     * The app did not require creating any custom models.
     */
    private JSONArray model;

    public SampleAdapter(Context context) {
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.layout_recyclerview_item, parent, false);
        final Holder holder = new Holder(view);

        holder.selectionImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                selection[position] = !selection[position];
                holder.setSelection(selection[position]);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(final Holder holder, int position) {
        final String labelKey = "label";
        final String photoKey = "imageUrl";
        final String secondaryTextKey = "secondaryText";

        try {
            JSONObject itemJson = model.getJSONObject(position);

            holder.labelTextView.setText(itemJson.getString(labelKey));
            holder.secondaryTextView.setText(itemJson.getString(secondaryTextKey));
            holder.loadImage(itemJson.getString(photoKey));
            holder.setSelection(selection[position]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return model == null ? 0 : model.length();
    }

    public void swapModel(JSONArray jsonArray, boolean[] selection) {
        this.model = jsonArray;
        this.selection = selection;
        notifyDataSetChanged();
    }

    public boolean[] getSelection() {
        return selection;
    }

    class Holder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView labelTextView;
        TextView secondaryTextView;
        ImageButton selectionImageButton;

        public Holder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.rvi_image);
            labelTextView = itemView.findViewById(R.id.rvi_primary_text);
            secondaryTextView = itemView.findViewById(R.id.rvi_secondary_text);
            selectionImageButton = itemView.findViewById(R.id.rvi_toggle_button);
        }

        void setSelection(boolean selected) {
            if (selected) {
                selectionImageButton.setImageResource(R.drawable.ic_star);
            } else {
                selectionImageButton.setImageResource(R.drawable.ic_star_outline);
            }
        }

        void loadImage(String photoUrl){
            Picasso.with(context)
                    .load(photoUrl)
                    .resize(250, 250)
                    .centerCrop()
                    .into(new Target() {
                        @Override
                        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                            RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(context.getResources(), bitmap);
                            drawable.setCircular(true);
                            imageView.setImageDrawable(drawable);
                        }

                        @Override
                        public void onBitmapFailed(Drawable errorDrawable) {
                        }

                        @Override
                        public void onPrepareLoad(Drawable placeHolderDrawable) {
                        }
                    });
        }
    }
}
