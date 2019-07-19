package uz.nursoft.nurbek.makhmudov.kurs.bestblogtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

public class AcWrite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
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

        }

        return super.onOptionsItemSelected(item);
    }
}
