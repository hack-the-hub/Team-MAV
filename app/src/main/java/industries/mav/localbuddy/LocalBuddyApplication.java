package industries.mav.localbuddy;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Andrew on 9/10/16.
 */
public class LocalBuddyApplication extends Application
{
    private static FirebaseManager dbManager = new FirebaseManager();
    private static TwitterManager tweetMan = new TwitterManager();

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }

    public static FirebaseManager getDbManager(){
        return  dbManager;
    }

    public static TwitterManager getTweetMan(){
        return  tweetMan;
    }
}
