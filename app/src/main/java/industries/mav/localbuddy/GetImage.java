package industries.mav.localbuddy;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by Andrew on 9/10/16.
 */
public class GetImage extends AsyncTask<String, Void, Drawable> {

    private final String TAG = "GetImage";

    @Override
    protected Drawable doInBackground(String... strings) {
        Log.d(TAG, "MAV ANDREW ITS MAV --> url: " + strings[0]);
        try {
            InputStream is = (InputStream) new URL(strings[0]).getContent();
            return Drawable.createFromStream(is, "src name");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
