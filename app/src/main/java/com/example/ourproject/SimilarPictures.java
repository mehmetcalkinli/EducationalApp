 package com.example.ourproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimilarPictures extends AppCompatActivity implements View.OnClickListener {

    private List<Integer> imageResources;
    private List<ImageView> selectedImages;
    private int correctPairsCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_similar_pictures);

        // Initialize image resources
        imageResources = new ArrayList<>();
        imageResources.add(R.drawable.plane1);
        imageResources.add(R.drawable.plane2);
        imageResources.add(R.drawable.mountain1);
        imageResources.add(R.drawable.mountain2);
        imageResources.add(R.drawable.newyork1);
        imageResources.add(R.drawable.newyork2);
        imageResources.add(R.drawable.road1);
        imageResources.add(R.drawable.road2);
        imageResources.add(R.drawable.space1);
        imageResources.add(R.drawable.space2);

        // Shuffle the images
        Collections.shuffle(imageResources);

        // Initialize selected images list
        selectedImages = new ArrayList<>();

        // Set up the image views
        ImageView plane1 = findViewById(R.id.plane1);
        ImageView plane2 = findViewById(R.id.plane2);
        ImageView mountain1 = findViewById(R.id.mountain1);
        ImageView mountain2 = findViewById(R.id.mountain2);
        ImageView newyork1 = findViewById(R.id.newyork1);
        ImageView newyork2 = findViewById(R.id.newyork2);
        ImageView road1 = findViewById(R.id.road1);
        ImageView road2 = findViewById(R.id.road2);
        ImageView space1 = findViewById(R.id.space1);
        ImageView space2 = findViewById(R.id.space2);

        plane1.setTag(R.drawable.plane1);
        plane1.setOnClickListener(this);

        plane2.setTag(R.drawable.plane2);
        plane2.setOnClickListener(this);

        mountain1.setTag(R.drawable.mountain1);
        mountain1.setOnClickListener(this);

        mountain2.setTag(R.drawable.mountain2);
        mountain2.setOnClickListener(this);

        newyork1.setTag(R.drawable.newyork1);
        newyork1.setOnClickListener(this);

        newyork2.setTag(R.drawable.newyork2);
        newyork2.setOnClickListener(this);

        space1.setTag(R.drawable.space1);
        space1.setOnClickListener(this);

        space2.setTag(R.drawable.space2);
        space2.setOnClickListener(this);

        road1.setTag(R.drawable.road1);
        road1.setOnClickListener(this);

        road2.setTag(R.drawable.road2);
        road2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v instanceof ImageView) {
            handleImageClick((ImageView) v);
        }
    }

    private void handleImageClick(ImageView imageView) {
        if (selectedImages.size() < 2) {
            // Show the selected image
            imageView.setVisibility(View.INVISIBLE);

            // Add the image view to the selected images list
            selectedImages.add(imageView);

            if (selectedImages.size() == 2) {
                // Check if the selected pair matches
                checkPair();
            }
        }
    }

    private void checkPair() {
        ImageView firstImage = selectedImages.get(0);
        ImageView secondImage = selectedImages.get(1);

        int firstImageResource = (int) firstImage.getTag();
        int secondImageResource = (int) secondImage.getTag();

        if ((firstImageResource == R.drawable.plane1 && secondImageResource == R.drawable.plane2) ||
                (firstImageResource == R.drawable.plane2 && secondImageResource == R.drawable.plane1) ||
                (firstImageResource == R.drawable.mountain1 && secondImageResource == R.drawable.mountain2) ||
                (firstImageResource == R.drawable.mountain2 && secondImageResource == R.drawable.mountain1) ||
                (firstImageResource == R.drawable.newyork1 && secondImageResource == R.drawable.newyork2) ||
                (firstImageResource == R.drawable.newyork2 && secondImageResource == R.drawable.newyork1) ||
                (firstImageResource == R.drawable.space1 && secondImageResource == R.drawable.space2) ||
                (firstImageResource == R.drawable.space2 && secondImageResource == R.drawable.space1) ||
                (firstImageResource == R.drawable.road1 && secondImageResource == R.drawable.road2) ||
                (firstImageResource == R.drawable.road2 && secondImageResource == R.drawable.road1)) {
            // Images are the correct match
            Toast.makeText(this, "Matched!(Eşleşti!)", Toast.LENGTH_SHORT).show();

            // Remove the matched images
            firstImage.setVisibility(View.GONE);
            secondImage.setVisibility(View.GONE);

            // Clear the selected images list
            selectedImages.clear();

            // Increment the count of correct pairs
            correctPairsCount++;

            // Check if all correct pairs have been found
            if (correctPairsCount == 5) {
                Toast.makeText(this, "Congratulations! You found all the pairs.(Tebrikler!)", Toast.LENGTH_SHORT).show();
            }
        } else {
            // Images are not a match
            Toast.makeText(this, "Not a match. Try again.(Tekrar deneyin)", Toast.LENGTH_SHORT).show();

            // Show the hidden images again
            firstImage.setVisibility(View.VISIBLE);
            secondImage.setVisibility(View.VISIBLE);

            // Clear the selected images list
            selectedImages.clear();
        }
    }
}