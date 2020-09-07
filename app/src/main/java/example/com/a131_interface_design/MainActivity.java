package example.com.a131_interface_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextFio;
    private EditText editTextAge;
    String newUserFio;
    int newUserAge;
    private static final String TAGMAIN = "Мониторинг здоровья";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextFio = findViewById(R.id.editTextFio);
        editTextAge = findViewById(R.id.editTextAge);
    }

    public void btnPressurePulseClicked (View view) {
        Log.i(TAGMAIN, "Пользователь нажал на кнопку 'Давление, Пульс'");
        if (!editTextFio.getText().toString().equals("") && !editTextAge.getText().toString().equals("")) {
            try {
                newUserFio = editTextFio.getText().toString();
                newUserAge = Integer.parseInt(editTextAge.getText().toString());
                User newUser = new User(newUserFio,newUserAge);
                Intent intent = new Intent(MainActivity.this, PrassurePulse.class);
                startActivity(intent);
            } catch (Exception ex) {
                Toster.showMyMessage(R.string.pressure_invalid_input, this);
                Log.i(TAGMAIN, "Пользователь некорректно ввел данные");
            }
        } else {
            Toster.showMyMessage(R.string.Not_all_values_are_entered, this);
            Log.i(TAGMAIN, "Пользователь ввел не все значения");
        }
    }

    public void btnVitalsClicked (View view) {
        Log.i(TAGMAIN, "Пользователь нажал на кнопку 'Жизненные показатели'");
        if (!editTextFio.getText().toString().equals("") && !editTextAge.getText().toString().equals("")) {
            try {
                newUserFio = editTextFio.getText().toString();
                newUserAge = Integer.parseInt(editTextAge.getText().toString());
                Intent intent = new Intent(MainActivity.this, Vitals.class);
                startActivity(intent);
            } catch (Exception ex) {
                Toster.showMyMessage(R.string.pressure_invalid_input, this);
                Log.i(TAGMAIN, "Пользователь некорректно ввел данные");
            }
        } else {
            Toster.showMyMessage(R.string.Not_all_values_are_entered, this);
            Log.i(TAGMAIN, "Пользователь ввел не все значения");
        }
    }

    public void btnSaveClicked(View view) {
        Log.i(TAGMAIN, "Пользователь нажал на кнопку 'Сохранить'");
        if (!editTextFio.getText().toString().equals("") && !editTextAge.getText().toString().equals("")) {
            try {
                newUserFio = editTextFio.getText().toString();
                newUserAge = Integer.parseInt(editTextAge.getText().toString());
                User newUser = new User(newUserFio, newUserAge);
            } catch (Exception ex) {
                Toster.showMyMessage(R.string.pressure_invalid_input, this);
                Log.i(TAGMAIN, "Пользователь некорректно ввел данные");
            }
        } else {
            Toster.showMyMessage(R.string.Not_all_values_are_entered, this);
            Log.i(TAGMAIN, "Пользователь ввел не все значения");
        }
    }

}