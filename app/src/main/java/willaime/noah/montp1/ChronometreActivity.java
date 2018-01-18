package willaime.noah.montp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ChronometreActivity extends AppCompatActivity {
    protected long time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronometre);
        Toast.makeText(this, "Vous avez demandé un chronomètre ?", Toast.LENGTH_LONG).show();
        Button start = (Button)findViewById(R.id.bouton_start);
        Button stop = (Button)findViewById(R.id.bouton_stop);
        stop.setEnabled(false);
        start.setOnClickListener((v)->{
            Calendar c = new GregorianCalendar();
            Toast.makeText(this, c.getTime()+"", Toast.LENGTH_SHORT).show();
            time = c.getTimeInMillis();
            stop.setEnabled(true);
            start.setEnabled(false);
        });
        stop.setOnClickListener((v)->{
            Calendar c = new GregorianCalendar();
            double fin = c.getTimeInMillis() - time;
            Toast.makeText(this, "Temps écoulé : "+fin/1000+" secondes", Toast.LENGTH_SHORT).show();
            stop.setEnabled(false);
            start.setEnabled(true);
        });
    }
}
