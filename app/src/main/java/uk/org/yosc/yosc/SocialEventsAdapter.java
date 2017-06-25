package uk.org.yosc.yosc;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import com.bumptech.glide.Glide;

/**
 * Created by Brian on 20/06/2017.
 */


    import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import java.util.ArrayList;

    public class SocialEventsAdapter extends RecyclerView.Adapter<uk.org.yosc.yosc.SocialEventsAdapter.MyViewHolder> {

        private Context mContext;
        private ArrayList<Event> mEventList;

        public static class MyViewHolder extends RecyclerView.ViewHolder {

            CardView cr;
            public TextView eventDate;
            TextView desc;
            ImageView thumbnail;
            ImageView moreVert;

            public MyViewHolder(View view) {
                super(view);
                eventDate = (TextView) view.findViewById(R.id.event_date);
                desc = (TextView) view.findViewById(R.id.event_desc);
                thumbnail = (ImageView)  view.findViewById(R.id.event_thumbnail);
                moreVert = (ImageView)  view.findViewById(R.id.overflow);
            }
        }


        public SocialEventsAdapter(Context mContext, ArrayList<Event> eventsList) {
            this.mContext = mContext;
            this.mEventList = eventsList;
        }

        @Override
        public uk.org.yosc.yosc.SocialEventsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.event_card, parent, false);

            return new uk.org.yosc.yosc.SocialEventsAdapter.MyViewHolder(itemView);
        }

        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
        }


        @Override
        public void onBindViewHolder(final uk.org.yosc.yosc.SocialEventsAdapter.MyViewHolder holder, int position) {
            Boolean error;
            Event event = mEventList.get(position);
            if ((position < 0) || (position > 1)) {
                error = true;
            }
            holder.eventDate.setText(event.getDate());
            holder.desc.setText(event.getDescription());
//            holder.thumbnail.setImageBitmap(R.drawable.yosc_talk);
            try {
                Glide.with(mContext).load(R.drawable.yosc_talk).into((ImageView) holder.thumbnail );
            } catch (Exception e) {
                e.printStackTrace();
            }

            holder.moreVert.setVisibility(View.INVISIBLE);


        }


        @Override
        public int getItemCount() {
            return mEventList.size();
        }
    }



