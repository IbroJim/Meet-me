package three.version.project.amourversionfor.Profile;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.TextView;

import three.version.project.amourversionfor.Home.HomeActivity;
import three.version.project.amourversionfor.R;
import three.version.project.amourversionfor.RegisterActivity;
import three.version.project.amourversionfor.Util.Permissions;

/**
 * Created by Ibraim on 22.03.2018.
 */

public class LoginActivity extends AppCompatActivity {

    private static final int VERIFY_PERMISSIONS_REQUEST=1;

  private AppCompatButton mButtonInput;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_login);


        if (checkPermissionsArray(Permissions.PERMISSIONS)){

        }else {
            verifyPermission(Permissions.PERMISSIONS);
        }


        TextView textView=(TextView) findViewById(R.id.createAccount);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
         mButtonInput=(AppCompatButton) findViewById(R.id.loginButton);
         mButtonInput.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent=new Intent(LoginActivity.this, HomeActivity.class);
                 startActivity(intent);
                 finish();
             }
         });



    }
    public void verifyPermission(String[] permissions){
        ActivityCompat.requestPermissions(LoginActivity.this,permissions,VERIFY_PERMISSIONS_REQUEST);
    }
    public boolean checkPermissionsArray(String[] permissions){
        for(int i=0;i<permissions.length;i++){
            String check=permissions[i];
            if (!checkPermission(check)){
                return false;
            }

        }
        return true;
    }

    public boolean checkPermission(String permissions) {

        int permissionRequest= ActivityCompat.checkSelfPermission(LoginActivity.this,permissions);
        if(permissionRequest!= PackageManager.PERMISSION_GRANTED){
            return false;
        }
        else {
            return true;
        }
    }

}
