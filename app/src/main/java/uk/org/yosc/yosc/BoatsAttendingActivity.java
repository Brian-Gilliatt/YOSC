package uk.org.yosc.yosc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.text.TextUtils.split;

public class BoatsAttendingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boats_attending);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        }        );
        */


        Intent intent = getIntent();
        String dateString = intent.getStringExtra("uk.org.yosc.yosc.eventDate");

        String[] words = new String[6];
        StringTokenizer st = new StringTokenizer(dateString);
        int i = 0;
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            words[i++] = word;
        }
        String year = "";
        String mth = "";
        String day = "";
        for (int j = 5; j >= 0; j--) {
            if (words[j] != null) {
                if (year == "") {
                    year = words[j];
                } else {
                    if (mth == "") {
                        mth = words[j];
                        break;
                    }
                }
            }
        }

        for (int k = 0; k < 5; k++) {
            if (words[k] != null) {
                {
                    day = words[k];
                    break;
                }
            }
        }
        int index = day.indexOf('-');
        if (index > 0) {
            String newDay = day.substring(0, index);
            day = newDay;
        }

        Calendar cal = Calendar.getInstance();
        Date rallyDate = cal.getTime();
        String dt = day + " " + mth + " " + year;
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.UK);
        try {
            rallyDate = df.parse(dt);
        } catch (Exception ex) {
            String msg = ex.getMessage();
//            throw new Exception(msg);
        }


        int id = R.string.boats_attending;
        CharSequence s = getResources().getText(R.string.boats_attending);

        final StringBuilder sb = new StringBuilder(s.length());
        sb.append(s);
        String rawRallyBoats = sb.toString();

        int x2 = 0;
        int linecount = 0;
        do  {
            x2 = rawRallyBoats.indexOf('\n',x2+1);
            linecount++;
        } while (x2 > 0);

/*
        int linecount2 = 0;
        for (int ii = 0; ii < rawRallyBoats.length();ii++) {
//            if ((rawRallyBoats.charAt(ii ) == '\n') || (rawRallyBoats.charAt(ii ) == '\r'))  linecount2++;
            if (rawRallyBoats.charAt(ii ) == '\r')  linecount2++;
        }
*/



//        String delims = "\\t\\n\\r\\f";
//       String delims = "\t\n\r\f";
        String delims = "\r\n|\r|\n";
        StringTokenizer st2 = new StringTokenizer(rawRallyBoats, delims);
//        StringTokenizer st2 = new StringTokenizer(rawRallyBoats);
        List<String> lines = new ArrayList<String>();
        try {
            while (st2.hasMoreElements()) {
                String line = (String) st2.nextElement();
                lines.add(line);
            }
        }

        catch (Exception ex) {
            String msg = ex.getMessage();
        }



        Pattern pt = Pattern.compile("\t\n\r\f",0);

//        String array[] = hello.split(DIVIDER_PATTERN);





//        String sss = findMatch(rawRallyBoats, delims, 0);





/*
        rawRallyBoats.replace('"',' ');
        int u = Pattern.UNIX_LINES;
//        String[] lines = split(rawRallyBoats, "\\r?\\n");
        String delims = "\\n";
        String[] lines = split(rawRallyBoats, delims);
*/
        int count = lines.size();

        List<Participant> participants = new ArrayList<Participant>();
        try {
            for (int j = 0; j < lines.size(); j++) {

                String x = lines.get(j);
                int l = x.length();

                String[] words1 = split(x, ",");
                if (words1.length < 5) continue;
                String a = words1[0];
                if (a.length() > 5) {
                    String b = words1[1];
                    String c = words1[2];
                    String d = words1[3];
                    String e = words1[4];
                    String f = words1[5];

                    Participant p = new Participant(b, c, d, e);
                    participants.add(p);
                }
                if (words1.length > 8) {
 //                   String a1 = words1[8];
 //                   if (a1.length() > 5) {
                        String b = words1[8];
                        String c = words1[9];
                        String d = words1[10];
                        String e = words1[11];
                        String f = words1[12];

                        Participant p1 = new Participant(b, c, d, e);
                        participants.add(p1);
//                    }
                }
            }
        } catch (Exception ex) {
            String msg = ex.getMessage();
        }

        int pCount = participants.size();

        List<Participant> rallyBoats = new ArrayList<Participant>();
        for (Participant p : participants) {
            String detail = p.toString();
            Date bd = p.getDate();
            int comp = bd.compareTo(rallyDate);
            if (comp == 0) rallyBoats.add(p);
        }
        int rc = rallyBoats.size();
    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
/*
    public static String findMatch(String input, String regex, int resultGroup) {
        Matcher matcher = Pattern.compile(regex, Pattern.UNIX_LINES).matcher(input);
        boolean hasFound = matcher.find();
        if(!hasFound) {
            return null;
        }
        return matcher.group(resultGroup);
    }
 */
}
