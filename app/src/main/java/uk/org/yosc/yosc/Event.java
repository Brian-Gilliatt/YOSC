package  uk.org.yosc.yosc;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import android.os.Parcelable;

/**
 * Created by Brian on 13/06/2017.
 */

public class Event implements Parcelable {

    private String _date;
    private String _description;
    private String _organiser;

    public Event(String date, String desc) {
        this._date = date;
        this._description = desc;
        _organiser = "";
    }
    // In constructor you will read the variables from Parcel. Make sure to read them in the same sequence in which
//    you have written them in Parcel.
    public Event(Parcel in) {
        _date = in.readString();
        _description = in.readString();
        _organiser = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
// Write data in any order
        dest.writeString(_date);
        dest.writeString(_description);
        dest.writeString(_organiser);
    }

    @Override public int describeContents() {
        return 0;
    }




        // This is to de-serialize the object
        public static final Parcelable.Creator<Event> CREATOR = new Parcelable.Creator<Event>() {
            public Event createFromParcel(Parcel in) {
                return new Event(in);
            }

            public Event[] newArray(int size) {
                return new Event[size];
            }
        };

    public String getDate() {
        return _date;
    }

    public String getDescription() {
        return _description;
    }

    public String getOrganizer()  { return _organiser;}

    public void setOrganiser (String organiser) {_organiser = organiser;}
}
