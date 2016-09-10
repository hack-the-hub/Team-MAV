package industries.mav.localbuddy;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
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
public class TwitterFeedFragment extends android.support.v4.app.Fragment
{
    private static final String TAG = "TwitterFeedFragment";
    private RecyclerView mRecyclerView;
    private List<Tweets> myList = new ArrayList<>();
    private TwitterFeedAdapter twitterFeedAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_counsellors, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        // Create the fake tweets first so we can populate the recycler view
        this.createTweets();

        this.twitterFeedAdapter = new TwitterFeedAdapter(this.myList);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.mRecyclerView.setAdapter(this.twitterFeedAdapter);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return view;
    }

    private void createTweets()
    {
        Tweets tweet1 = new Tweets("Steven Agnew", "Absolutely starving! Might head to Stix'n'Stones!", "twitter");
        myList.add(tweet1);
        Tweets tweet2 = new Tweets("Sydney Anderson", "Could do with a can of Coke", "twitter");
        myList.add(tweet2);
        Tweets tweet3 = new Tweets("Kellie Armstrong", "Has anyone watched Stranger Things?", "facebook");
        myList.add(tweet3);
        Tweets tweet4 = new Tweets("Alex Attwood", "Deadpool was the best movie this year!", "facebook");
        myList.add(tweet4);
        Tweets tweet5 = new Tweets("Clare Bailey", "Anyone up for a glass of wine?", "twitter");
        myList.add(tweet5);
        Tweets tweet6 = new Tweets("Paula Bradley", "Pizza Hut has to be the best pizza!", "facebook");
        myList.add(tweet6);
        Tweets tweet7 = new Tweets("Keith Buchanan", "Head hurting a bit tonight after last night!", "twitter");
        myList.add(tweet7);
        Tweets tweet8 = new Tweets("Gerry Carroll", "How's everyone today?!", "twitter");
        myList.add(tweet8);
        Tweets tweet9 = new Tweets("Alan Chambers", "Where did everyone go on holidays this year?", "facebook");
        myList.add(tweet9);
        Tweets tweet10 = new Tweets("Stewart Dickson", "iPhone 7 worth it?", "facebook");
        myList.add(tweet10);
        Tweets tweet11 = new Tweets("Alex Easton", "Samsung Notebook 7 really let us all down!", "facebook");
        myList.add(tweet11);
    }
}
