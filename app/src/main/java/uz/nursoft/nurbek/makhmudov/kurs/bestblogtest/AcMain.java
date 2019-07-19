package uz.nursoft.nurbek.makhmudov.kurs.bestblogtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AcMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);

        startActivity(new Intent(this, AcBasic.class));
        finish();







    }
}
