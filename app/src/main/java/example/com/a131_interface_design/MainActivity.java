package example.com.a131_interface_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnPressurePulseClicked (View view) {
        Intent intent = new Intent(MainActivity.this, PrassurePulse.class);
        startActivity(intent);
    }

    public void btnVitalsClicked (View view) {
        Intent intent = new Intent(MainActivity.this, Vitals.class);
        startActivity(intent);
    }

    public void btnSaveClicked (View view) {
        try {
            String newUserFio = findViewById(R.id.editTextFio).toString();
            int newUserAge = Integer.parseInt(findViewById(R.id.editTextAge).toString());
            User newUser = new User(newUserFio,newUserAge);
        } catch (Exception ex) {
            String text = getString(R.string.main_invalid_input);
            SpannableStringBuilder biggerText = new SpannableStringBuilder(text);
            biggerText.setSpan(new RelativeSizeSpan(1.35f), 0, text.length(), 0);
            Toast toast = Toast.makeText(this,biggerText,Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
            toast.show();
        }

    }
}