package josh.sunyschoolinformation;

/**
 * Created by Josh on 11/4/2015.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splashScreen extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 700;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(splashScreen.this, MainActivity.class);
                startActivity(i);

                // close this activity, the splashScreen itself
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}
