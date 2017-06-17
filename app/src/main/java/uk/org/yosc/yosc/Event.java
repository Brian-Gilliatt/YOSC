package  uk.org.yosc.yosc;

import java.util.Date;

/**
 * Created by Brian on 13/06/2017.
 */

public class Event {

    private String _date;
    private String _description;

    public Event(String date, String desc) {
        this._date = date;
        this._description = desc;

    }

    public String getDate() {
        return _date;
    }

    public String getDescription() {
        return _description;
    }
}
