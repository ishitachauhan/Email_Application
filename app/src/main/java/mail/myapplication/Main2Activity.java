package mail.myapplication;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Button email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String[] TO={""};
        String[] CC={""};
        email = (Button) findViewById(R.id.buuton30);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] TO={"gupta2_ajay@ongc.co.in"};
                String[] CC={""};
                final Intent emailIntent=new Intent(Intent.ACTION_SEND);
                final EditText date = (EditText) findViewById(R.id.editText1);
                final EditText time = (EditText) findViewById(R.id.editText2);
                final EditText workstation = (EditText) findViewById(R.id.editText3);
                final EditText block = (EditText) findViewById(R.id.editText4);
                final EditText project = (EditText) findViewById(R.id.editText5);
                final EditText software = (EditText) findViewById(R.id.editText6);
                emailIntent.setData(Uri.parse("mail to:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                emailIntent.putExtra(Intent.EXTRA_CC,CC);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "System Utilization - " );
                emailIntent.putExtra(Intent.EXTRA_TEXT, "date:" + date.getText().toString() + '\n' + "time:" + time.getText().toString() + '\n' + "workstation:" + workstation.getText().toString() + '\n' + "block:" + block.getText().toString() + '\n' + "project:" + project.getText().toString() + '\n' + "software:" + software.getText().toString() );
                try {
                    startActivity(Intent.createChooser(emailIntent,"send mail..."));
                    finish();
                }catch (ActivityNotFoundException ex){
                    Toast.makeText(Main2Activity.this,"there is no email client installed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
