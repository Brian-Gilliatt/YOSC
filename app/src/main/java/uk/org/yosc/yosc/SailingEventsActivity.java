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


        Event a = new Event("Mon 31 June 2017", "Newtown Creek Rally");
        eventList.add(a);

        a = new Event("Sat/Sun 15/16 July 2017", "Chichester Rally");
        eventList.add(a);

        mAdapter.notifyDataSetChanged();
    }
}
