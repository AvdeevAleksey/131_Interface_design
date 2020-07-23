package example.com.a131_interface_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PrassurePulse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prassure_pulse);
    }

    public void btnSaveClicked (View view) {
        Intent intent = new Intent(PrassurePulse.this, MainActivity.class);
        startActivity(intent);
    }
}