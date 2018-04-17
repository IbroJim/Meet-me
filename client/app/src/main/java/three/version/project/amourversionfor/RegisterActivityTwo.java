package three.version.project.amourversionfor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import me.gujun.android.taggroup.TagGroup;

/**
 * Created by Ibraim on 11.03.2018.
 */

public class RegisterActivityTwo extends AppCompatActivity {

    private ArrayList<String> tagsRegister;
    private EditText editText,editUrself;
    private TagGroup tagGroupRegister;
    private TextView oUrslef;
    Context mContext=RegisterActivityTwo.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_part_two);
        setupTagsExample();
        setupTagsRegister();
        setupUrselfAdd();

        AppCompatButton nextGallery=(AppCompatButton) findViewById(R.id.nextButtonGallery);
        nextGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivityTwo.this,GalleryActivity.class);
                startActivity(intent);
            }
        });
    }

    private  void addListTags(ArrayList<String> sad){
        sad.add("Кальян");
        sad.add("Бегаю по утрам");
        sad.add("Книги");
    }
    private void setupTagsExample(){
         final ArrayList<String> tagsExamle = new ArrayList<>();
        TagGroup tagGroupExample=findViewById(R.id.tagGroupExample);
        addListTags(tagsExamle);
        tagGroupExample.setTags(tagsExamle);

    }
    private void setupTagsRegister(){
        tagsRegister=new ArrayList<>();
        editText=(EditText) findViewById(R.id.editTag);
        tagGroupRegister=(TagGroup) findViewById(R.id.tagGroupRegister);
       ImageView addTagButton = (ImageView) findViewById(R.id.imageAddTag);
        addTagButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tagsRegister.add(editText.getText().toString());
                tagGroupRegister.setTags(tagsRegister);
                editText.setText(" ");

            }
        });

        TagGroup.OnTagClickListener tagClickListener=new TagGroup.OnTagClickListener() {
            @Override
            public void onTagClick(String tag) {
                tagsRegister.remove(tag);
                tagGroupRegister.setTags(tagsRegister);
            }
        };

    }

    private void setupUrselfAdd(){
        editUrself=(EditText) findViewById(R.id.urself);
        editUrself.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    Context context = getApplicationContext();
                     InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
                     imm.hideSoftInputFromWindow(editUrself.getWindowToken(), 0);

                    return true;
                }
                return false;

            }
        });
//        if((event!=null&&(event.getKeyCode()==KeyEvent.KEYCODE_ENTER))||(actionId== EditorInfo.IME_ACTION_DONE));
////                Context context = getApplicationContext();
////                InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
////                imm.hideSoftInputFromWindow(editUrself.getWindowToken(), 0);
//        Toast.makeText(RegisterActivityTwo.this, editUrself.getText(), Toast.LENGTH_SHORT).show();
//        return  true;
    }

}


