package industries.mav.localbuddy;

/**
 * Created by vincekearney on 10/09/2016.
 */

import android.content.Context;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Kit;

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
}
