package uz.nursoft.nurbek.makhmudov.kurs.bestblogtest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.app_locale.MyContextWrapperLanguage;
import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.shp.ShP;

public class AcRead extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(MyContextWrapperLanguage.wrap(newBase, ShP.getInstance(newBase).getLang()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_read);
    }
}
