package three.version.project.amourversionfor.Search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;

import three.version.project.amourversionfor.R;

/**
 * Created by Ibraim on 07.03.2018.
 */

public class SettingsSerch extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serch_settings);
        setupCrystalSeekBar();
        setupSpinner();
    }

    private void setupCrystalSeekBar() {
        final CrystalRangeSeekbar rangeSeekbar = (CrystalRangeSeekbar) findViewById(R.id.rangeSeekbar1);

// get min and max text view
        final TextView tvMin = (TextView) findViewById(R.id.left_age);
        final TextView tvMax = (TextView) findViewById(R.id.right_age);

// set listener
        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText(String.valueOf(minValue));
                tvMax.setText(String.valueOf(maxValue));
            }
        });

// set final value listener
        rangeSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
            }
        });

    }

    private void setupSpinner(){
        final Spinner spinner=(Spinner) findViewById(R.id.spinnerCitySerch);
        ArrayAdapter<?> adapterNow= ArrayAdapter.createFromResource(this,R.array.city_register,R.layout.spinner_simple_item);
        adapterNow.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterNow);

    }

}
