package  uk.org.yosc.yosc;

import android.app.ActionBar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

public class SailingEventsActivity extends AppCompatActivity {

    private ArrayList<Event> eventList;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sailing_events);

       android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//       mRecyclerView.setHasFixedSize(true);    //????

       eventList = new ArrayList<>();
       mAdapter = new EventsAdapter(this, eventList);


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


        Event a = new Event("10-11 June 2017", "Newtown Beech Barbecue");
        eventList.add(a);

        a = new Event("24 June to 8 July 2017", "Summer Cruise to Brittany");
        eventList.add(a);

        a = new Event("22-24 July 2017", "Wight Trophy - Round The Island sailing time trial in association with other local yacht clubs with dinner at the Royal Solent Yacht Club, Yarmouth");
        eventList.add(a);

        a = new Event("5-6 August 2017", "Lymington Rally");
        eventList.add(a);

        a = new Event("19 to 28 August 2017", "Autumn Cruise westwards to Weymouth");
        eventList.add(a);

        a = new Event("9-10 September 2017", "Littlehampton Rally");
        eventList.add(a);

        a = new Event("13-24 September 2017", "Beaulieu River Rally to Ginns Farm pontoon");
        eventList.add(a);

        a = new Event("7-8 October 2017", "Chichester Rally");
        eventList.add(a);

        a = new Event("21-22 October 2017", "Laying Up Supper");
        eventList.add(a);

        mAdapter.notifyDataSetChanged();
    }
}
