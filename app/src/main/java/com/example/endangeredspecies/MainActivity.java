package com.example.endangeredspecies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewLarge;
    // These are your image resource IDs. Make sure these match the names in res/drawable.
    private Integer[] endangeredSpeciesImages = {
            R.drawable.asian_elephant,
            R.drawable.mountain_gorilla,
            R.drawable.leopard,
            R.drawable.giant_panda,
            R.drawable.polar_bear,
            R.drawable.rhinoceros
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewLarge = findViewById(R.id.imageViewLarge);

        // Instantiate the GridView and set the adapter
        GridView gridView = findViewById(R.id.gridView);
        ImageAdapter adapter = new ImageAdapter(this, endangeredSpeciesImages);
        gridView.setAdapter(adapter);

        // Listen for item (thumbnail) clicks
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Update the large ImageView with the selected image
                imageViewLarge.setImageResource(endangeredSpeciesImages[position]);

                // Show a toast message
                Toast.makeText(MainActivity.this,
                        "Selected Species " + (position + 1),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
