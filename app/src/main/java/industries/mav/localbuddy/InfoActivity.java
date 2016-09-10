package industries.mav.localbuddy;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.twitter.sdk.android.core.models.Card;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

import org.w3c.dom.Text;

import java.util.zip.CheckedOutputStream;

import io.fabric.sdk.android.Fabric;

public class InfoActivity extends Activity {

    public final String COUNSELLOR = "COUNSELLOR";
    private static final String TAG = "InfoActivity";

    private de.hdodenhof.circleimageview.CircleImageView profilePic;
    private TextView name, party;
    private CardView button;

    private Counsellor counsellor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        counsellor = (Counsellor) getIntent().getSerializableExtra(COUNSELLOR);

        Fabric.with(this, LocalBuddyApplication.getTweetMan().getKits());
    }

    @Override
    protected void onResume() {
        super.onResume();

        name = (TextView) findViewById(R.id.cName);
        party = (TextView) findViewById(R.id.pName);
        profilePic = (de.hdodenhof.circleimageview.CircleImageView) findViewById(R.id.profilePic);
        button = (CardView) findViewById(R.id.contactButton);

        name.setText(counsellor.getMemberFullName());
        party.setText(counsellor.getPartyName());

        final Drawable[] icon = {null};
        GetImage getImage = new GetImage() {
            @Override
            protected void onPostExecute(Drawable drawable) {
                icon[0] = drawable;
                Log.d(TAG, "AAC --> icon:" + icon[0]);
                profilePic.setImageDrawable(icon[0]);
            }
        };
        getImage.execute(counsellor.getMemberImgUrl());


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TweetComposer.Builder builder = new TweetComposer.Builder(view.getContext())
                        .text("." + counsellor.getTwitterHandle() + "just setting up my Fabric.");
                builder.show();
            }
        });


    }
}
