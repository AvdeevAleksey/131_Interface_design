package example.com.a131_interface_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

}