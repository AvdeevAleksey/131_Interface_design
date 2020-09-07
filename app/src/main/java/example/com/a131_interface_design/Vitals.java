package example.com.a131_interface_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Vitals extends AppCompatActivity {
    EditText weight;
    EditText steps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitals);

        weight = findViewById(R.id.vitalsEditTextWeight);
        steps = findViewById(R.id.vitalsEditTextSteps);
    }

    public void btnSaveClicked (View view) {
        if (weight.getText().toString().equals("") || steps.getText().toString().equals("")) {
            Toster.showMyMessage(R.string.Not_all_values_are_entered,this);
        } else {
            try {
                int newWeight = Integer.parseInt(weight.getText().toString());
                int newSteps = Integer.parseInt(steps.getText().toString());
                WeightSteps newWeightSteps = new WeightSteps(newWeight, newSteps);
                Intent intent = new Intent(Vitals.this, MainActivity.class);
                startActivity(intent);
            } catch (Exception ex) {
                Toster.showMyMessage(R.string.pressure_invalid_input,this);
            }
        }
    }
}