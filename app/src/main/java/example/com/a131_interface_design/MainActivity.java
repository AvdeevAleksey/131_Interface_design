package example.com.a131_interface_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextFio;
    private EditText editTextAge;
    String newUserFio;
    int newUserAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextFio = findViewById(R.id.editTextFio);
        editTextAge = findViewById(R.id.editTextAge);
    }

    public void btnPressurePulseClicked (View view) {
        if (!editTextFio.getText().toString().equals("") && !editTextAge.getText().toString().equals("")) {
            try {
                newUserFio = editTextFio.getText().toString();
                newUserAge = Integer.parseInt(editTextAge.getText().toString());
                User newUser = new User(newUserFio,newUserAge);
                Intent intent = new Intent(MainActivity.this, PrassurePulse.class);
                startActivity(intent);
            } catch (Exception ex) {
                showMyMessage(R.string.pressure_invalid_input);
            }
        } else {
            showMyMessage(R.string.Not_all_values_are_entered);
        }
        /*if (!editTextFio.getText().toString().equals("") && !editTextAge.getText().toString().equals("")) {
            try {
                newUserFio = editTextFio.getText().toString();
                newUserAge = Integer.parseInt(editTextAge.getText().toString());
                Intent intent = new Intent(MainActivity.this, PrassurePulse.class);
                startActivity(intent);
            } catch (Exception ex) {
                showMyMessage(R.string.pressure_invalid_input);
            }
        } else {
            showMyMessage(R.string.Not_all_values_are_entered);
        }*/
    }

    public void btnVitalsClicked (View view) {
        if (!editTextFio.getText().toString().equals("") && !editTextAge.getText().toString().equals("")) {
            try {
                newUserFio = editTextFio.getText().toString();
                newUserAge = Integer.parseInt(editTextAge.getText().toString());
                Intent intent = new Intent(MainActivity.this, Vitals.class);
                startActivity(intent);
            } catch (Exception ex) {
                showMyMessage(R.string.pressure_invalid_input);
            }
        } else {
            showMyMessage(R.string.Not_all_values_are_entered);
        }
    }

    public void btnSaveClicked(View view) {
        if (!editTextFio.getText().toString().equals("") && !editTextAge.getText().toString().equals("")) {
            try {
                newUserFio = editTextFio.getText().toString();
                newUserAge = Integer.parseInt(editTextAge.getText().toString());
                User newUser = new User(newUserFio, newUserAge);
            } catch (Exception ex) {
                showMyMessage(R.string.pressure_invalid_input);
            }
        } else {
            showMyMessage(R.string.Not_all_values_are_entered);
        }
    }
    public void showMyMessage(int massage) {
        String text = getString(massage);
        SpannableStringBuilder biggerText = new SpannableStringBuilder(text);
        biggerText.setSpan(new RelativeSizeSpan(1.35f), 0, text.length(), 0);
        Toast toast = Toast.makeText(this, biggerText, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }
}