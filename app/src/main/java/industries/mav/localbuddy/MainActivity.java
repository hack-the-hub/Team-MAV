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

import com.firebase.ui.database.FirebaseRecyclerAdapter;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerAdapter adapter =  new FirebaseRecyclerAdapter<Counsellor, TestViewHolder>(
                        Counsellor.class,
                        R.layout.card_counsellor,
                        TestViewHolder.class,
                        LocalBuddyApplication.getDbManager().dataBase
                ) {

                    @Override
                    protected void populateViewHolder(TestViewHolder viewHolder, Counsellor model, int position) {
                        Log.d(TAG, "AAC --> Populating viewholder");
                        viewHolder.setName(model.getMemberFullName());
                        viewHolder.setParty(model.getPartyAbbreviation());
                        viewHolder.setMotto(model.getConstituencyName());
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
