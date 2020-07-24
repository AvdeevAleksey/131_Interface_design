package example.com.a131_interface_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.LocaleData;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PrassurePulse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prassure_pulse);
        TextView txtdateTime = findViewById(R.id.actPressureTxtDateTimeNow);
        txtdateTime.setText(new SimpleDateFormat("hh:mm ' ' dd.MM.yyyy").format(new Date()));

    }

    public void btnSaveClicked (View view) {
        Intent intent = new Intent(PrassurePulse.this, Vitals.class);
        startActivity(intent);
    }
}