package industries.mav.localbuddy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by vincekearney on 10/09/2016.
 */
public class AboutFragment extends Fragment
{
    private TextView firstText;
    private TextView secondText;
    private ImageView mapImage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_fragment, container, false);
        this.firstText = (TextView) view.findViewById(R.id.textOne);
        this.firstText.setText("Belfast");
        this.secondText = (TextView) view.findViewById(R.id.textTwo);
        this.secondText.setText("Go to Wikipedia _andrewaac says!");
        this.mapImage = (ImageView) view.findViewById(R.id.imageView);
        this.mapImage.setImageResource(R.mipmap.map_image);
        return view;
    }
}
