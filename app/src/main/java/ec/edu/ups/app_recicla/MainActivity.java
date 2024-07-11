package ec.edu.ups.app_recicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import ec.edu.ups.app_recicla.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'app_recicla' library on application startup.
    static {
        System.loadLibrary("app_recicla");
    }

    private ActivityMainBinding binding;
    Button btnNavigate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        //TextView tv = binding.sampleText;
        //tv.setText(stringFromJNI());

        btnNavigate=findViewById(R.id.button);

        btnNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }

    /**
     * A native method that is implemented by the 'app_recicla' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}