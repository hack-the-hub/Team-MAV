package industries.mav.localbuddy;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by MNevi on 10/09/2016.
 */
public class HandlerFinder {

    private Context context;
    private static final String TAG = "WTF";
    private String m_csv = "elected-candidates.csv";
    private static final String comma = ",";
    private String lineIn = "";

    public HandlerFinder()
    {

    }

    /**
     * Method to find the MLA's twitter handler (if it exists)
     * @param firstName MLA first name
     * @param lastName  MLA last name
     * @return MLA's Handle
     */
    public String FindHandle(Context context, String firstName, String lastName)
    {
        this.context = context;
        String handle = "";
        BufferedReader br = null;
        AssetManager assetManager = context.getAssets();
        try
        {
            br = new BufferedReader(new FileReader(String.valueOf(assetManager.open("elected-candidates.csv"))));
            while ((lineIn = br.readLine()) != null)
            {
                // use the comma sperator
                String[] line = lineIn.split(comma);
                if (line[11] == lastName)
                {
                    if (line[12] == firstName)
                    {
                        handle = line[13];
                    }
                }
            }
        }
        catch (FileNotFoundException e)
        {
            Log.d(TAG, "FindHandle: FileNotFoundException");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            Log.d(TAG, "FindHandle: IOException");

            e.printStackTrace();
        }
        finally
        {
            if (br != null)
            {
                    try {
                        br.close();
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
            }
        }

        return handle;
    }




}
