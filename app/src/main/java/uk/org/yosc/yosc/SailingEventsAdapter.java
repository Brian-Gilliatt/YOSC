package  uk.org.yosc.yosc;



/**
 * Created by Brian on 13/06/2017.
 */

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SailingEventsAdapter extends RecyclerView.Adapter<SailingEventsAdapter.MyViewHolder> {

        private Context mContext;
        private ArrayList<Event> mEventList;

        public static class MyViewHolder extends RecyclerView.ViewHolder {

            CardView cr;
            public TextView eventDate;
            TextView desc;
            TextView organiser;
//            public ImageView thumbnail, overflow;

            public MyViewHolder(View view) {
                super(view);
//                cr = (CardView) view.findViewById(R.id.card_view);
                eventDate = (TextView) view.findViewById(R.id.event_date);
                desc = (TextView) view.findViewById(R.id.event_desc);
                organiser = (TextView) view.findViewById(R.id.event_organiser);

//                thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
//                overflow = (ImageView) view.findViewById(R.id.overflow);
            }
        }


        public SailingEventsAdapter(Context mContext, ArrayList<Event> eventsList) {
            this.mContext = mContext;
            this.mEventList = eventsList;
        }

        @Override
        public SailingEventsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
           View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.event_card, parent, false);

            return new MyViewHolder(itemView);
        }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }



        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
            Boolean error;
            Event event = mEventList.get(position);
            if ((position < 0 ) || (position > 1))
            {
                error = true;
            }
                holder.eventDate.setText(event.getDate());
                holder.desc.setText(event.getDescription());
                holder.organiser.setText(event.getOrganizer());



            // loading album cover using Glide library
//            Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);
/*
            holder.overflow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showPopupMenu(holder.overflow);
                }
            });
*/
        }



        @Override
        public int getItemCount() {
            return mEventList.size();
        }
    }

