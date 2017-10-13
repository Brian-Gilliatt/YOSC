package uk.org.yosc.yosc;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;



/**
 * Created by Brian on 25/06/2017.
 */

public class Participant {

    private String mDate;
    private String mRally;
    private String mSkipper;
    private String mBoat;

    public Participant (String date, String rally, String skipper, String boat) {
        mDate = date;
        mRally = rally;
        mSkipper = skipper;
        mBoat = boat;

    }

    public Date getDate() {

        Calendar c = Calendar.getInstance();
        Date d = c.getTime();
        String tDate = mDate.replace('-',' ');
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.UK);
        try {
            d = df.parse(tDate + " 2017");
        }
        catch (Exception ex) {
            String msg =  ex.getMessage();
//            throw new Exception(msg);
        }


        return d;
    }

    public String getRally() {
        return mRally;
    }

    public String getSkipper() {
        return mSkipper;
    }

    public String getBoat() {
        return mBoat;
    }

    public String  toString() {
        return mDate + " 2017, " + mRally + ", "+mSkipper+", "+ mBoat;
    }


}
