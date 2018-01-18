package willaime.noah.montp1;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final static int PHOTO = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bonjour = (Button)findViewById(R.id.bouton_bonjour);
        Button chrono = (Button)findViewById(R.id.bouton_chrono);
        Button photo = (Button)findViewById(R.id.bouton_photo);
        Log.i("MainActivity", "info random");
        bonjour.setOnClickListener((v)->{
            Toast.makeText(MainActivity.this, "Bonjour !", Toast.LENGTH_SHORT).show();
        });
        chrono.setOnClickListener((v)->{
            Intent ic = new Intent(MainActivity.this, ChronometreActivity.class);
            startActivity(ic);
        });
        photo.setOnClickListener((v)->{
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (i.resolveActivity(getPackageManager()) != null){
                startActivityForResult(i, PHOTO);
            }
        });
    }
}
