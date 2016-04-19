package pl.hypeapp.fixmath;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FragmentTimeAttack extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v1 = inflater.inflate(R.layout.time_attack_fragment, container, false);
        View dots = inflater.inflate(R.layout.activity_menu, container, false);
        ImageView firstDot = (ImageView) dots.findViewById(R.id.imageDot2);
        firstDot.setImageResource(R.drawable.yellow_dot);

        return v1;
    }


}