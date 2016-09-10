package industries.mav.localbuddy;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by Andrew on 9/10/16.
 */
public class CounsellorFragment extends Fragment {
    private static final String TAG = "CounsellorFragment";
    private RecyclerView mRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_counsellors, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        FirebaseRecyclerAdapter adapter =
                new FirebaseRecyclerAdapter<Counsellor, TestViewHolder>(
                        Counsellor.class,
                        R.layout.card_counsellor,
                        TestViewHolder.class,
                        LocalBuddyApplication.getDbManager().dataBase
                ) {

                    @Override
                    protected void populateViewHolder(final TestViewHolder viewHolder, Counsellor model, int position) {
                        Log.d(TAG, "MAV --> Populating viewholder");
                        viewHolder.setModel(model);
                        viewHolder.setName(model.getMemberFullName());
                        viewHolder.setParty(model.getPartyAbbreviation());
                        viewHolder.setMotto(model.getConstituencyName());

                        final Drawable[] icon = {null};
                        GetImage getImage = new GetImage() {
                            @Override
                            protected void onPostExecute(Drawable drawable) {
                                icon[0] = drawable;
                                Log.d(TAG, "AAC --> icon:" + icon[0]);
                                viewHolder.setImageView(icon[0]);
                            }
                        };
                        getImage.execute(model.getMemberImgUrl());
                    }


                    class GetImage extends AsyncTask<String, Void, Drawable> {
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
                };

        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public static class TestViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //        private ImageView mImageView;
        private Counsellor counsellor;
        private TextView mName, mParty, mMotto;
        private String mNameString, mPartyString, mMottoString;
        private de.hdodenhof.circleimageview.CircleImageView mImageView;

        public TestViewHolder(View itemView) {
            super(itemView);
            mImageView = (de.hdodenhof.circleimageview.CircleImageView) itemView.findViewById(R.id.picture);
            mName = (TextView) itemView.findViewById(R.id.name);
            mParty = (TextView) itemView.findViewById(R.id.party);
            mMotto = (TextView) itemView.findViewById(R.id.motto);
            itemView.setOnClickListener(this);
        }

        public void setImageView(Drawable drawable) {
            mImageView.setImageDrawable(drawable);
        }

        public void setName(String name) {
            mNameString = name;
            mName.setText(name);
        }

        public void setParty(String party) {
            mPartyString = party;
            mParty.setText(party);
        }

        public void setMotto(String motto) {
            mMottoString = motto;
            mMotto.setText(motto);
        }

        public void setModel(Counsellor counsellor) {
            this.counsellor = counsellor;
        }

        @Override
        public void onClick(View view) {
//            Intent viewInfo = new Intent(view.getContext(), InfoActivity.class)
//                    .putExtra("COUNSELLOR", (Serializable) counsellor);
//            view.getContext().startActivity(viewInfo);
            LocalBuddyApplication.getTweetMan().testTwitterAPI();
        }

    }
}
