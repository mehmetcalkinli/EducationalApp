package com.example.ourproject;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.app.Activity;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

public class BallActivity extends AppCompatActivity implements SurfaceHolder.Callback {

    private SurfaceHolder surfaceHolder;
    private GameThread gameThread;
    private SurfaceView surfaceView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ball);
        surfaceView = findViewById(R.id.surfaceView);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback((SurfaceHolder.Callback) this);

        // Find the button view
        Button buttonback = findViewById(R.id.button_back);

// Set an OnClickListener
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open a new screen or activity here
                Intent intent = new Intent(BallActivity.this, PlayingActivity.class);
                startActivity(intent);
            }
        });


    }





    @Override
    protected void onResume() {
        super.onResume();
        if (gameThread != null) {
            gameThread.setRunning(true);
        }
//        surfaceView = findViewById(R.id.surfaceView);
//        surfaceHolder = surfaceView.getHolder();
//        gameThread = new GameThread(surfaceHolder);
//        gameThread.setScreenSize(surfaceView.getWidth(), surfaceView.getHeight()); // Add this line
//
//        gameThread.setRunning(true);
//        gameThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (gameThread != null) {
            gameThread.setRunning(false);
            try {
                gameThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void surfaceCreated(SurfaceHolder holder) {
        gameThread = new GameThread(holder);
        gameThread.setScreenSize(surfaceView.getWidth(), surfaceView.getHeight());
        gameThread.start();
    }


    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // No implementation needed
    }


    public void surfaceDestroyed(SurfaceHolder holder) {
        if (gameThread != null) {
            gameThread.setRunning(false);
            try {
                gameThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private class GameThread extends Thread {
        private SurfaceHolder surfaceHolder;
        private boolean running;
        private int screenWidth;
        private int screenHeight;
        private int ballRadius;
        private int ballX;
        private int ballY;
        private int directionX;
        private int directionY;
        private int lineSpacing;

        public GameThread(SurfaceHolder surfaceHolder) {
            this.surfaceHolder = surfaceHolder;
            running = true;
            directionX = 1;
            directionY = 1;
            lineSpacing = 100; // Adjust this value for the desired spacing between lines
        }

        @Override
        public void run() {
            while (running) {
                Canvas canvas = null;
                try {
                    canvas = surfaceHolder.lockCanvas();
                    if (canvas != null) {
                        // Update game logic
                        // Draw ball on the canvas
                        updateGameLogic();
                        drawBall(canvas);
                    }
                } finally {
                    if (canvas != null) {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                }
            }
        }


        private void updateGameLogic() {
            // Update ball position
            ballX += directionX*7;



            // Check boundaries and change position if necessary
            if (ballX + ballRadius > screenWidth) {
                // Reached the right boundary, move to the left of the next line
                ballX = -ballRadius;
                ballY += lineSpacing;

                // Reverse direction vertically for alternating lines
                directionY *= -1;
            }

            // Reverse direction if ball reaches the top or bottom boundary
            if (ballY + ballRadius > screenHeight || ballY - ballRadius < 0) {
                directionY *= -1;
            }
        }

        private void drawBall(Canvas canvas) {
            canvas.drawColor(Color.WHITE); // Clear canvas

            Paint paint = new Paint();
            paint.setColor(Color.RED); // Set ball color

            canvas.drawCircle(ballX, ballY, ballRadius, paint);
        }

        public void setRunning(boolean running) {
            this.running = running;
        }

        public void setScreenSize(int width, int height) {
            screenWidth = width;
            screenHeight = height;
            ballRadius = Math.min(screenWidth, screenHeight) / 20; // Adjust ball size if necessary
            ballX = ballRadius;
            ballY = ballRadius;
        }

    }





}
