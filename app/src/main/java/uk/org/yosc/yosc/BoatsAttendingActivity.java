package uk.org.yosc.yosc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.io.Console;
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

    Event mEvent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boats_attending);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();
        String dateString = intent.getStringExtra("uk.org.yosc.yosc.eventDate");
        Date rallyDate = GetRallyDate(dateString);
/*
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
*/
/*
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
*/

/*
//        String delims = "\\t\\n\\r\\f";
//       String delims = "\t\n\r\f";
        String delims = "\r\n|\r|\n";
        StringTokenizer st2 = new StringTokenizer(rawRallyBoats, delims);
        List<String> lines = new ArrayList<String>();
        try {
            while (st2.hasMoreElements()) {
                String line = (String) st2.nextElement();
                lines.add(line);
            }
        } catch (Exception ex) {
            String msg = ex.getMessage();
        }
*/
        Pattern pt = Pattern.compile("\t\n\r\f", 0);
/*
        String tag = "BoatsAttendingActivity";
        int count = lines.size();

        List<Participant> participants = new ArrayList<Participant>();
        try {
            int base = 0;
            for (int j = 0; j < lines.size(); j++) {
                String message4 = "No. of lines = " + String.valueOf(lines.size()) + " Line No. = " + String.valueOf(j);
                Log.d(tag, message4);

                base = 0;
                String x = lines.get(j);
                int l = x.length();

                String[] words1 = split(x, ",");
                if (words1.length < 5) continue;
                boolean more = true;
                while (more) {
                    String a = words1[base];
                    if ((base == 0) && (a.length() < 6)) {
                        more = false;
                        continue;
                    }
                    String b = words1[base + 1];
                    String c = words1[base + 2];
                    String d = words1[base + 3];
                    String e = words1[base + 4];
                    String f = words1[base + 5];

                    String message = b + " " + c + " " + d + " " + e + " " + f;
                    Log.d(tag, message);
                    String message2 = "No. of words = " + String.valueOf(words.length);
                    Log.d(tag, message2);
                    Participant p = new Participant(b, c, d, e);
                    participants.add(p);
                    base = base + 7;
                    String message3 = "Base = " + String.valueOf(base);
                    Log.d(tag, message3);
                    if (words1.length < (base + 2)) more = false;
                }
            }
        } catch (Exception ex) {
            String msg = ex.getMessage();
        }
*/
        List<Participant> participants = GetParticipants();
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

    public void SetEvent(Event event) {
        mEvent = event;
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


    public Date GetRallyDate(String dateString) {
        String[] words = new String[6];
        StringTokenizer st = new StringTokenizer(dateString);
        int i = 0;
            while(st.hasMoreTokens())

        {
            String word = st.nextToken();
            words[i++] = word;
        }

        String year = "";
        String mth = "";
        String day = "";
            for(
        int j = 5;
        j >=0;j--)

        {
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

            for(
        int k = 0;
        k< 5;k++)

        {
            if (words[k] != null) {
                {
                    day = words[k];
                    break;
                }
            }
        }

        int index = day.indexOf('-');
            if(index >0)

        {
            String newDay = day.substring(0, index);
            day = newDay;
        }

        Calendar cal = Calendar.getInstance();
        Date rallyDate = cal.getTime();
        String dt = day + " " + mth + " " + year;
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.UK);
            try

        {
            rallyDate = df.parse(dt);
        } catch(
        Exception ex)

        {
            String msg = ex.getMessage();
    //            throw new Exception(msg);
        }
        return rallyDate;
    }


    public List<Participant> GetParticipants() {
        String[] words = new String[6];

        CharSequence s = getResources().getText(R.string.boats_attending);

        final StringBuilder sb = new StringBuilder(s.length());
        sb.append(s);
        String rawRallyBoats = sb.toString();
        //        String delims = "\\t\\n\\r\\f";
//       String delims = "\t\n\r\f";
        String delims = "\r\n|\r|\n";
        StringTokenizer st2 = new StringTokenizer(rawRallyBoats, delims);
        List<String> lines = new ArrayList<String>();
        try {
            while (st2.hasMoreElements()) {
                String line = (String) st2.nextElement();
                lines.add(line);
            }
        } catch (Exception ex) {
            String msg = ex.getMessage();
        }
        String tag = "BoatsAttendingActivity";
        int count = lines.size();

        List<Participant> participants = new ArrayList<Participant>();
        try {
            int base = 0;
            for (int j = 0; j < lines.size(); j++) {
                String message4 = "No. of lines = " + String.valueOf(lines.size()) + " Line No. = " + String.valueOf(j);
                Log.d(tag, message4);

                base = 0;
                String x = lines.get(j);
                int l = x.length();

                String[] words1 = split(x, ",");
                if (words1.length < 5) continue;
                boolean more = true;
                while (more) {
                    String a = words1[base];
                    if ((base == 0) && (a.length() < 6)) {
                        more = false;
                        continue;
                    }
                    String b = words1[base + 1];
                    String c = words1[base + 2];
                    String d = words1[base + 3];
                    String e = words1[base + 4];
                    String f = words1[base + 5];

                    String message = b + " " + c + " " + d + " " + e + " " + f;
                    Log.d(tag, message);
                    String message2 = "No. of words = " + String.valueOf(words.length);
                    Log.d(tag, message2);
                    Participant p = new Participant(b, c, d, e);
                    participants.add(p);
                    base = base + 7;
                    String message3 = "Base = " + String.valueOf(base);
                    Log.d(tag, message3);
                    if (words1.length < (base + 2)) more = false;
                }
            }
        } catch (Exception ex) {
            String msg = ex.getMessage();
        }
        return  participants;
    }

}
