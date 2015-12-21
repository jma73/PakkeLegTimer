package dk.jpeace.pakkelegtimer.pakkelegtimer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Random;

import layout.fragmentCountdown;

public class MainActivity extends AppCompatActivity {

    private static final String LOGTAG = "MainActivity";
    private TextView textviewTimer;
    private TextView textviewTestHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        if(savedInstanceState == null)
        {
            Log.d(LOGTAG, "...savedInstanceState == null...");

            FragmentManager supportFragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.frameLayout, new fragmentCountdown());
            fragmentTransaction.commit();
        }


        textviewTimer = (TextView)findViewById(R.id.textviewTimer);
        textviewTestHolder = (TextView)findViewById(R.id.textviewTestHolder);

        Random random = new Random();
        int randomNummer = random.nextInt();
        textviewTestHolder.setText("jjj: " + randomNummer);

        createTimer();

    }

    private void createTimer() {
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                textviewTimer.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                textviewTimer.setText("done!");
            }
        }.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
