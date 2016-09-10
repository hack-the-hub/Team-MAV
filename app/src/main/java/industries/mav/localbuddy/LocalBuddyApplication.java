package industries.mav.localbuddy;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Andrew on 9/10/16.
 */
public class LocalBuddyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }

}
