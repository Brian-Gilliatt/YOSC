package  uk.org.yosc.yosc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class SocialEventsActivity extends AppCompatActivity {

    private ArrayList<Event> eventList;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_events);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//       mRecyclerView.setHasFixedSize(true);    //????

        eventList = new ArrayList<>();
        mAdapter = new SocialEventsAdapter(this, eventList);


        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setAdapter(mAdapter);

        prepareEvents();

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    private void prepareEvents() {


        Event a = new Event("17 July 2017", "Portsmouth and Southampton – a Maritime Contrast — a return visit from Blue Badge Guide, Graham Horn with a talk about these two maritime cities with very different histories, military Portsmouth  and mercantile Southampton. Graham will explain how the geography of the area led to their taking on different roles in our history and tell of some of the famous and less famous people who have influenced and shaped them.");
        eventList.add(a);

        a = new Event("24 August 2017", "Barbecue at Blackwater Valley Golf Centre GU46 7SZ");
        eventList.add(a);

        a = new Event("4 September 2017", "Fire Safety in Boats—a talk by Andy Piper");
        eventList.add(a);

        a = new Event("5-6 August 2017", "Lymington Rally");
        eventList.add(a);

        a = new Event("2 October 2017", "Memories of a Cruise to Scotland —a talk by YOSC Member, Brian Pickles");
        eventList.add(a);

        a = new Event("6 November 2017", "26th Annual General Meeting at SSC");
        eventList.add(a);

        a = new Event("4 December 2017", "Christmas Party at SSC");
        eventList.add(a);



        mAdapter.notifyDataSetChanged();
    }
}
