package aakashgupt98.navifragment;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class FacultyHomeScreen extends AppCompatActivity implements View.OnClickListener {

    TextView s1,s2,s3,s4;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_home_screen);

        s1=(TextView)findViewById(R.id.s1);
        s2=(TextView)findViewById(R.id.s2);
        s3=(TextView)findViewById(R.id.s3);
        s4=(TextView)findViewById(R.id.s4);

        s1.setOnClickListener(this);
        s2.setOnClickListener(this);
        s3.setOnClickListener(this);
        s4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.s1:
                url="https://github.com/Ayush10298/Let-Us-C-Solutions-Edition-13";
                break;

            case R.id.s2:
                url="https://github.com/Ayush10298/ViewPagerTrial";
                break;

            case R.id.s3:
                url="https://github.com/Ayush10298/ClickMechanic";
                break;

            case R.id.s4:
                url="https://github.com/Ayush10298/TrialVolley";
                break;
        }
        openGitHub(url);
    }

    public void openGitHub(String url) {
        try {
            Uri project = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, project);
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No URL found",  Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

}
