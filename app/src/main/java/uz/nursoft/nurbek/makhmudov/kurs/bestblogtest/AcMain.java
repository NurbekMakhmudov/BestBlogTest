package uz.nursoft.nurbek.makhmudov.kurs.bestblogtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.concurrent.TimeUnit;

import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.app_locale.MyContextWrapperLanguage;
import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.shp.ShP;

public class AcMain extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(MyContextWrapperLanguage.wrap(newBase, ShP.getInstance(newBase).getLang()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);

        startBasic();
    }

    private void startBasic() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    startActivity(new Intent(getApplication(), AcBasic.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
