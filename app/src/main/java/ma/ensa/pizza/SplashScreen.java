package ma.ensa.pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    ImageView image;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        image = findViewById(R.id.logo);
        Animation rotation = AnimationUtils.loadAnimation(this, R.anim.anim);
        image.startAnimation(rotation);
        Thread t1 = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent intent = new Intent(SplashScreen.this, HomeActivity.class);
                    startActivity(intent);
                    SplashScreen.this.finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
    }

}

//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

// progressbar = findViewById(R.id.progressbar);
//textView = findViewById(R.id.pourcentage);

//  progressbar.setMax(100);
/// progressbar.setScaleY(3f);







// private void progressAnimation() {
//  ProgressBarAnimation animation = new ProgressBarAnimation(this,progressbar,textView,0f,100f);
//   animation.setDuration(5000);
//   progressbar.setAnimation(animation);

// }