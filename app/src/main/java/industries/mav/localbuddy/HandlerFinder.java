package industries.mav.localbuddy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by MNevi on 10/09/2016.
 */
public class HandlerFinder {

    private static final String m_csv = "..\\..\\..\\..\\..\\..\\build\\generated\\assets\\elected-candidates";
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
    public String FindHandle(String firstName, String lastName)
    {
        String handle = "";
        BufferedReader br = null;

        try
        {
            br = new BufferedReader(new FileReader(m_csv));
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
            e.printStackTrace();
        }
        catch (IOException e)
        {
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
