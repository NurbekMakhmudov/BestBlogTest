package uz.nursoft.nurbek.makhmudov.kurs.bestblogtest;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.app_locale.MyContextWrapperLanguage;
import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.networks.ServerConnectionServiceR1;
import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.retmet.RetMet;
import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.shp.ShP;

public class AcWrite extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(MyContextWrapperLanguage.wrap(newBase, ShP.getInstance(newBase).getLang()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.ac_write);

        toolbar();

    }

    private void toolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.acWriteToolbar);
        toolbar.setTitle(getResources().getString(R.string.write_story));
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ac_write_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_camera) {
            Toast.makeText(this, "Camera", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.action_audio) {
            Toast.makeText(this, "Audio", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.action_send) {
            Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
            addDataToServer();
        }

        return super.onOptionsItemSelected(item);
    }
    
    private void addDataToServer(){
        if (RetMet.getInstance(this).checkInternetConnection()) {
            ServerConnectionServiceR1.getInstance().getServerApiR1().test(
                    "",
                    new Callback<Response>() {
                        String out = "";

                        @Override
                        public void success(Response response, Response response2) {
                            try {
                                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getBody().in()));
                                out = reader.readLine();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            jsonParser(out);
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            Log.d("MyTag", getClass().getName() + " >> failure: RetrofitError  = " + error.getMessage());
                        }
                    }
            );
        } else {
            RetMet.getInstance(this).toast(R.string.problem_internet, 1);
        }
    }

    private void jsonParser(String json){
        Log.d("MyTag", getClass().getName() + " >> jsonParser: JSON = " + json);
    }
}
