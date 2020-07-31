package example.com.a131_interface_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editTextFio = findViewById(R.id.editTextFio);
        EditText editTextAge = findViewById(R.id.editTextAge);    }

    public void btnPressurePulseClicked (View view) {
        Intent intent = new Intent(MainActivity.this, PrassurePulse.class);
        startActivity(intent);
    }

    public void btnVitalsClicked (View view) {
        Intent intent = new Intent(MainActivity.this, Vitals.class);
        startActivity(intent);
    }

    public void btnSaveClicked (View view, EditText editTextFio, EditText editTextAge) {
        try {
            String newUserFio = editTextFio.getText().toString();
            int newUserAge = Integer.parseInt(editTextAge.getText().toString());
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