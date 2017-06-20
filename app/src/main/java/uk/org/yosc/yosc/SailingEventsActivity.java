package  uk.org.yosc.yosc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
       mAdapter = new SailingEventsAdapter(this, eventList);


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
        a.setOrganiser("Organiser - Tony Nemeth");
        eventList.add(a);

        a = new Event("24 June to 8 July 2017", "Summer Cruise to Brittany");
        a.setOrganiser("Organiser - Ian Booker");
        eventList.add(a);

        a = new Event("22-24 July 2017", "Wight Trophy - Round The Island sailing time trial in association with other local yacht clubs with dinner at the Royal Solent Yacht Club, Yarmouth");
        a.setOrganiser("Organisers - Chris Wright & Ian Booker");
        eventList.add(a);

        a = new Event("5-6 August 2017", "Lymington Rally");
        a.setOrganiser("Organiser -Mike Purdy");
        eventList.add(a);

        a = new Event("19 to 28 August 2017", "Autumn Cruise westwards to Weymouth");
        a.setOrganiser("Organiser - Chris Wright");
        eventList.add(a);

        a = new Event("9-10 September 2017", "Littlehampton Rally");
        a.setOrganiser("Organiser - Pam Ward");
        eventList.add(a);

        a = new Event("13-24 September 2017", "Beaulieu River Rally to Ginns Farm pontoon");
        a.setOrganiser("Organiser - Chris Wright");
        eventList.add(a);

        a = new Event("7-8 October 2017", "Chichester Rally");
        a.setOrganiser("Organiser -Ian Skinner");
        eventList.add(a);

        a = new Event("21-22 October 2017", "Laying Up Supper");
        eventList.add(a);

        mAdapter.notifyDataSetChanged();
    }
}
