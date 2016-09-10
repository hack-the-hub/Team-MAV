package industries.mav.localbuddy;

/**
 * Created by vincekearney on 10/09/2016.
 */

import android.content.Context;
import android.os.AsyncTask;
import android.os.NetworkOnMainThreadException;
import android.util.Log;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Coordinates;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.StatusesService;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

import io.fabric.sdk.android.Kit;
import retrofit2.Call;

public class TwitterManager
{
    private static final String TWITTER_KEY = "8TDcXwwgslXxAjG3BDLzpl7iD";
    private static final String TWITTER_SECRET = "ROFj6kqUrskyxophqbIXeTVQMb4k1iKOZlZzMmQ9cRQthWChFx";
    private TwitterAuthConfig authConfig;

    public TwitterManager() {
        this.authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
    }

    public Kit getKits()
    {
        if(authConfig != null)
            return new Twitter(this.authConfig);
        else
            return null;
    }

    public void testTwitterAPI()
    {
        TwitterApiClient twitterApiClient = TwitterCore.getInstance().getApiClient();
        // Can also use Twitter directly: Twitter.getApiClient()
        StatusesService statusesService = twitterApiClient.getStatusesService();
        Call<Tweet> call = statusesService.show(524971209851543553L, null, null, null);
        call.enqueue(new Callback<Tweet>() {
            @Override
            public void success(Result<Tweet> result) {
                //Do something with result
                Log.i("Test Twitter Success", "The tweet result is --> " + result);
            }

            public void failure(TwitterException exception) {
                //Do something on failure
                Log.i("Test Twitter Fail", "God damn it");
            }
        });
    }

    public void loadJSONTweets() {
        Log.d("Vince", "loadTweets");
        RetrieveTweets retrieveTweets = new RetrieveTweets(){
            @Override
            protected void onPostExecute(ArrayList<JSONObject> jsonObjects) {
                for(JSONObject jsonObject : jsonObjects){
                    Log.d("Vince", "onPostExecute: " + jsonObject);
                }
            }
        };
        retrieveTweets.execute();
    }

    class RetrieveTweets extends AsyncTask<Void, Void, ArrayList<JSONObject>>
    {
        @Override
        protected ArrayList<JSONObject> doInBackground(Void... voids)
        {
            Log.i("doInBackground", "Just doing it now");
            ArrayList<JSONObject> tweets = new ArrayList<>();
            try
            {
                HttpClient hc = new DefaultHttpClient();
                HttpGet get = new HttpGet("http://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=_andrewaac&count=3");
                HttpResponse rp = hc.execute(get);

                Log.i("doInBackground", "HttpRespone = " + rp);
                Log.i("doInBackground", "Response status code -->" + (rp.getStatusLine().getStatusCode()));

                if(rp.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
                {
                    Log.i("doInBackground", "Seems the HttpStatus was ok");
                    String result = EntityUtils.toString(rp.getEntity());
                    JSONObject root = new JSONObject(result);
                    JSONArray sessions = root.getJSONArray("results");
                    for (int i = 0; i < sessions.length(); i++)
                    {
                        JSONObject session = sessions.getJSONObject(i);
                        tweets.add(session);
                        Log.i("JSON", "\nReponse:" + session + "\n");
//                    Tweet tweet = new Tweet();
//                    tweet.content = session.getString("text");
//                    tweet.author = session.getString("from_user");
//                    tweets.add(tweet);
                    }
                }
            } catch (NetworkOnMainThreadException e) {
                Log.e("NetworkOnMainThread", "Fuck it.");
                e.printStackTrace();
            }
            catch (Exception e) {
                Log.e("TwitterFeedActivity", "Error loading JSON", e);
            }
            return tweets;
        }
    }
}
