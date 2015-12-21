package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dk.jpeace.pakkelegtimer.pakkelegtimer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentCountdown extends Fragment {


    public fragmentCountdown() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rod = inflater.inflate(R.layout.fragment_countdown, container, false);





        return rod;
    }

}
