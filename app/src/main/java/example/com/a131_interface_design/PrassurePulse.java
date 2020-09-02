package example.com.a131_interface_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.LocaleData;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PrassurePulse extends AppCompatActivity {
    EditText highPressure;
    EditText lowerPressure;
    EditText pulse;
    Switch tachicardia;
    TextView txtdateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prassure_pulse);

        highPressure = findViewById(R.id.actPressureEditTextHigh);
        lowerPressure = findViewById(R.id.actPressureEditTextLower);
        pulse = findViewById(R.id.actPressureEditTextPulse);
        tachicardia = findViewById(R.id.actPressureSwitchTachicardia);
        txtdateTime = findViewById(R.id.actPressureTxtDateTimeNow);
        txtdateTime.setText(new SimpleDateFormat("HH:mm ' ' dd.MM.yyyy").format(new Date()));
    }

    public void btnSaveClicked (View view) {
        if (highPressure.getText().equals("") && lowerPressure.getText().equals("") && pulse.getText().equals("")) {
            //new MainActivity().showMyMessage(R.string.Not_all_values_are_entered);
            String text = getString(R.string.Not_all_values_are_entered);
            SpannableStringBuilder biggerText = new SpannableStringBuilder(text);
            biggerText.setSpan(new RelativeSizeSpan(1.35f), 0, text.length(), 0);
            Toast toast = Toast.makeText(this, biggerText, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();

        } else {

            try {
                int newHighPressure = Integer.parseInt(highPressure.getText().toString());
                int newLowerPressure = Integer.parseInt(lowerPressure.getText().toString());
                int newPulse = Integer.parseInt(pulse.getText().toString());
                boolean newTachicardia = tachicardia.isChecked();
                String newDateTime = txtdateTime.getText().toString();
                Pressure newPressure = new Pressure(newHighPressure, newLowerPressure, newPulse, newTachicardia, newDateTime);
                Intent intent = new Intent(PrassurePulse.this, Vitals.class);
                startActivity(intent);
            } catch (Exception ex) {
                //new MainActivity().showMyMessage(R.string.pressure_invalid_input);
                String text = getString(R.string.pressure_invalid_input);
                SpannableStringBuilder biggerText = new SpannableStringBuilder(text);
                biggerText.setSpan(new RelativeSizeSpan(1.35f), 0, text.length(), 0);
                Toast toast = Toast.makeText(this, biggerText, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();
            }
        }

    }
}