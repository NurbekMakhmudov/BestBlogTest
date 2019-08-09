package uz.nursoft.nurbek.makhmudov.kurs.bestblogtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.fragments.FrLogin;
import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.fragments.FrProfile;
import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.fragments.FrReg;
import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.retmet.RetMet;

public class AcAccount extends AppCompatActivity {

    private String appData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.ac_account);

        setAppData(getIntent().getStringExtra("appData"));
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (getAppData().equals("reg")) {
            RetMet.getInstance(this)
                    .replaceFragment(getSupportFragmentManager(), new FrReg(), R.id.acAccountBasicContainer);

        } else if (getAppData().equals("profile")) {
            RetMet.getInstance(this)
                    .replaceFragment(getSupportFragmentManager(), new FrProfile(), R.id.acAccountBasicContainer);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public String getAppData() {
        return appData;
    }

    public void setAppData(String appData) {
        this.appData = appData;
    }
}
