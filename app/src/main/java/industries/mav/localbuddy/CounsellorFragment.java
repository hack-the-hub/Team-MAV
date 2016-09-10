package industries.mav.localbuddy;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

/**
 * Created by Andrew on 9/10/16.
 */
public class CounsellorFragment extends Fragment {

    private static final String TAG = "CounsellorFragment";

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef1 = database.getReference("counsellors");

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


        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                Log.d(TAG, "Datasnapshot value: " + dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, "Failed to read value --- " + databaseError);
            }
        });

        FirebaseRecyclerAdapter adapter =
                new FirebaseRecyclerAdapter<Counsellor, TestViewHolder>(
                        Counsellor.class,
                        R.layout.card_counsellor,
                        TestViewHolder.class,
                        myRef1
                ) {

                    @Override
                    protected void populateViewHolder(TestViewHolder viewHolder, Counsellor model, int position) {
                        Log.d(TAG, "AAC --> Populating viewholder");
                        viewHolder.setName(model.getMemberName());
                        viewHolder.setParty(model.getPartyAbbreviation());
                        viewHolder.setMotto(model.getConstituencyName());
                    }
                };

        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onPause() {
        super.onPause();
    }


    public static class TestViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mImageView;
        private TextView mName, mParty, mMotto;
        private String mNameString, mPartyString, mMottoString;

        public TestViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.picture);
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

        @Override
        public void onClick(View view) {

        }

//        @Override
//        public void onClick(View view) {
//            Intent viewInfo = new Intent(view.getContext(), InfoActivity.class);
//            viewInfo.putExtra(InfoActivity.EXTRA_NAME, mNameString)
//                    .putExtra(InfoActivity.EXTRA_PARTY, mPartyString)
//                    .putExtra(InfoActivity.EXTRA_MOTTO, mMottoString);
//            view.getContext().startActivity(viewInfo);
//        }
    }

}
