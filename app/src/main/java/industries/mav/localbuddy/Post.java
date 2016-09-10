package industries.mav.localbuddy;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by MNevi on 10/09/2016.
 */
public class Post
{
    private String Title;
    private String Content;
    private String Status;
    private String Type;
    private String Date;
    private String Author;

    private static final String InitStatus = "Open";

    public Post() {}

    // Constructor
    public Post(String Title, String Content, String Type, String Author)
    {
        this.Title = Title;
        this.Content = Content;
        this.Type = Type;
        this.Author = Author;

        this.Status = InitStatus;
        this.Date = currentDate();
    }

    public void setStatus(String Status) { this.Status = Status; }

    public String getTitle() { return this.Title; }
    public String getContent() { return this.Content; }
    public String getType() { return this.Type; }
    public String getAuthor() { return this.Author; }
    public String getStatus() { return this.Status; }
    public String getDate() { return this.Date; }

    // Method for getting current time
    // <returns> Curret Date / time
    private String currentDate()
    {
        Calendar c  = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyy");
        return df.format(c.getTime());
    }
}
