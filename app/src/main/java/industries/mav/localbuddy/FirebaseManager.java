package industries.mav.localbuddy;

/**
 * Created by vincekearney on 10/09/2016.
 */

import android.util.Log;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseManager
{
    private static final String TAG = "FirebaseManager";
    public DatabaseReference dataBase;

    public FirebaseManager()
    {
        this.dataBase = FirebaseDatabase.getInstance().getReference("counsellors");
        dataBase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                Log.d(TAG, "Datasnapshot value: " + dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, "Failed to read value --- " + databaseError);
            }
        });
    }
}
