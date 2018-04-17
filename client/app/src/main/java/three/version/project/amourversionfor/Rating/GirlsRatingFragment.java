package three.version.project.amourversionfor.Rating;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import three.version.project.amourversionfor.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GirlsRatingFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_girls_rating,container,false);
        return view;
    }
}
