/**
 * Created by vincekearney on 10/09/2016.
 */

package industries.mav.localbuddy;

import android.app.ListActivity;
import android.os.Bundle;

import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

public class UsersTimelineActivity extends ListActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twitter_activity);

        final UserTimeline userTimeline = new UserTimeline.Builder().screenName("_andrewaac").build();
        LocalBuddyApplication.getTweetMan().loadJSONTweets();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(this).setTimeline(userTimeline).build();
        setListAdapter(adapter);
    }
}