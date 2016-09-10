package industries.mav.localbuddy;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private final TypeReference<Map<String, String>> type = new TypeReference<Map<String, String>>() {
    };


    //Views
    private RecyclerView mRecyclerView;

    //Firebase
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef1 = database.getReference("Counsellors");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


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
                new FirebaseRecyclerAdapter<counsellor, TestViewHolder>(
                        counsellor.class,
                        R.layout.card_counsellor,
                        TestViewHolder.class,
                        myRef1
                ) {

                    @Override
                    protected void populateViewHolder(TestViewHolder viewHolder, counsellor model, int position) {
                        Log.d(TAG, "AAC --> Populating viewholder");
                        String name = model.getName();
                        Drawable profile;
                        if (name.contains("Andrew")) {
                            profile = getResources().getDrawable(R.drawable.andrew);
                            Bitmap b = ((BitmapDrawable)profile).getBitmap();
                            Bitmap bitmapResized = Bitmap.createScaledBitmap(b, 100, 100, false);
                            profile = new BitmapDrawable(getResources(), bitmapResized);
                        } else if (name.contains("Arlene")) {
                            profile = getResources().getDrawable(R.drawable.arlene);
                        } else if (name.contains("Gerry")) {
                            profile = getResources().getDrawable(R.drawable.gerry);
                        } else if (name.contains("Marc")) {
                            profile = getResources().getDrawable(R.drawable.marc);
                        } else if (name.contains("Vince")) {
                            profile = getResources().getDrawable(R.drawable.vince);
                        } else if (name.contains("Jimmy")) {
                            profile = getResources().getDrawable(R.drawable.jimmy);
                        } else {
                            profile = null;
                        }
                        viewHolder.setImageView(profile);
                        viewHolder.setName(model.getName());
                        viewHolder.setParty(model.getParty());
                        viewHolder.setMotto(model.getMotto());
                    }
                };

        mRecyclerView.setAdapter(adapter);
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
