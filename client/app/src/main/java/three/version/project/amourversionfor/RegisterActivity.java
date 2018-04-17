package three.version.project.amourversionfor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.lang.reflect.Array;

import io.ghyeok.stickyswitch.widget.StickySwitch;

/**
 * Created by Ibraim on 02.03.2018.
 */

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG="RegisterActivity";
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nextButton=(Button)findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this,RegisterActivityTwo.class);
                startActivity(intent);
            }
        });
        setupSpinnerAge();
        setupSpinnerCity();
        setupSpinnerQuestion();
        setupStickySwitch();



    }
    private void setupSpinnerCity(){
        final Spinner spinner=(Spinner) findViewById(R.id.spinnerCity);

        ArrayAdapter<?> adapter= ArrayAdapter.createFromResource(this,R.array.city_register,R.layout.spinner_simple_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

    }
    private void setupSpinnerAge(){
        final Spinner spinner=(Spinner) findViewById(R.id.ageSpinner);

        ArrayAdapter<?> adapterAge= ArrayAdapter.createFromResource(this,R.array.age_people,R.layout.spinner_simple_item);
        adapterAge.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapterAge);

    }
    private void setupSpinnerQuestion(){
        final Spinner spinner=(Spinner) findViewById(R.id.questionResetPassword);

        ArrayAdapter<?> adapterQuestion= ArrayAdapter.createFromResource(this,R.array.question_for_the_password,R.layout.spinner_simple_item);
        adapterQuestion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapterQuestion);

    }
    private  void setupStickySwitch(){
        StickySwitch stickySwitch=(StickySwitch) findViewById(R.id.sticky_switch);
        stickySwitch.setOnSelectedChangeListener(new StickySwitch.OnSelectedChangeListener() {
            @Override
            public void onSelectedChange(StickySwitch.Direction direction, String s) {
                Log.d(TAG, "Now Selected : " + direction.name() + ", Current Text : " + s);
            }
        });
    }
}
