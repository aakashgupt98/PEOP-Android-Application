package aakashgupt98.navifragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity implements View.OnClickListener {

    private Button login;
    private EditText email;
    private EditText password;
   // private TextView signin;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
//        if(firebaseAuth.getCurrentUser()!=null){
//            finish();
//            startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
//        }

        login =(Button)findViewById(R.id.login);
        email=(EditText)findViewById(R.id.emaillogin);
        password=(EditText)findViewById(R.id.passwordlogin);
        //signin=(TextView)findViewById(R.id.signin);
        progressDialog=new ProgressDialog(this);
        firebaseAuth= FirebaseAuth.getInstance();


        login.setOnClickListener(this);
        //signin.setOnClickListener(this);
    }

    private void userLogin()
    {
        String putEmail = email.getText().toString().trim();
        String putPassword = password.getText().toString().trim();
        if(TextUtils.isEmpty(putEmail))
        {
            Toast.makeText(this,"Plaese enter the email",Toast.LENGTH_SHORT).show();
            return;

        }
        if (TextUtils.isEmpty(putPassword))
        {
            Toast.makeText(this,"Please enter the password",Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Please Wait");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(putEmail,putPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful())
                        {
                            finish();
                            startActivity(new Intent(getApplicationContext(),NaviActivity.class));
                        }
                        else
                        {
                            Toast.makeText(login.this,"login Failed please try again",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if(view == login)
        {
            userLogin();

        }
//        if(view == signin){
//            finish();
//            startActivity(new Intent(this,MainActivity.class));
//        }

    }

    public void resetpass(View v)
    {
        startActivity(new Intent(login.this,ForgotpasswordActivity.class));
    }
}
