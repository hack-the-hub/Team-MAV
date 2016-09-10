package industries.mav.localbuddy;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vincekearney on 10/09/2016.
 */
public class TwitterFeedAdapter extends RecyclerView.Adapter<TwitterFeedAdapter.TestViewHolder>
{
    private List<Tweets> tweetsList = new ArrayList<>();

    public TwitterFeedAdapter(List<Tweets> list) {
        this.tweetsList = list;
        this.notifyDataSetChanged();
    }

    @Override
    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.tweet_layout, parent, false);
        return new TestViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TestViewHolder holder, int position) {
        holder.setTweet(getItem(position));
        holder.setBodyText(holder.tweet.getBody());
        holder.setNameText(holder.tweet.getName());
    }

    @Override
    public int getItemCount() {
        return this.tweetsList.size();
    }

    public Tweets getItem(int position) {
        return this.tweetsList.get(position);
    }

    public static class TestViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        //        private ImageView mImageView;
        public Tweets tweet;
        private TextView bodyText;
        private TextView nameText;
        private de.hdodenhof.circleimageview.CircleImageView mImageView;

        public TestViewHolder(View itemView) {
            super(itemView);
            mImageView = (de.hdodenhof.circleimageview.CircleImageView) itemView.findViewById(R.id.picture);
            nameText = (TextView) itemView.findViewById(R.id.body_text);
            bodyText = (TextView) itemView.findViewById(R.id.name);
            itemView.setOnClickListener(this);
        }

        public void setTweet(Tweets tweet) {
            this.tweet = tweet;
        }

        public void setImageView(Drawable drawable) {
            mImageView.setImageDrawable(drawable);
        }

        public void setBodyText(String body) {
            bodyText.setText(body);
        }

        public void setNameText(String name) {
            nameText.setText(name);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
