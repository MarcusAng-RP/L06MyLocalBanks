package sg.edu.rp.c346.id22002222.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    String wordClicked ="";

    String colour = "" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDBS = findViewById(R.id.tvDBS);
        tvOCBC = findViewById(R.id.tvOCBC);
        tvUOB = findViewById(R.id.tvUOB);
        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //…
        getMenuInflater().inflate(R.menu.menu_bank, menu);
        if(v == tvDBS){
            wordClicked = "DBS";

        }
        else if(v == tvOCBC){
            wordClicked = "OCBC";
        }
        else if(v == tvUOB){
            wordClicked = "UOB";
        }



    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText(getString(R.string.DBS));
            tvUOB.setText(getString(R.string.UOB));
            tvOCBC.setText(getString(R.string.OCBC));
            return true;
        } else if (id == R.id.chineseSelection) {
            tvDBS.setText(getString(R.string.chineseDBS));
            tvOCBC.setText(getString(R.string.chineseOCBC));
            tvUOB.setText(getString(R.string.chineseUOB));
            return true;
        } else {
            tvDBS.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }






    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // …



        int id = item.getItemId();
        if(wordClicked.equalsIgnoreCase("DBS")) {
            if (id == R.id.URLSelection) {
                String link = getString(R.string.DBSlink);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                startActivity(intent);
                return true;
            } else if (id == R.id.PhoneSelection) {

                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.DBSPhone)));

                startActivity(intentCall);
                return true;
            }

        }

        if(wordClicked.equalsIgnoreCase("OCBC")) {
            if (id == R.id.URLSelection) {
                String link = getString(R.string.OCBClink);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                startActivity(intent);
                return true;
            } else if (id == R.id.PhoneSelection) {

                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.OCBCPhone)));

                startActivity(intentCall);
                return true;
            }

        }

        if(wordClicked.equalsIgnoreCase("UOB")) {
            if (id == R.id.URLSelection) {
                String link = getString(R.string.UOBlink);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                startActivity(intent);
                return true;
            } else if (id == R.id.PhoneSelection) {

                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.UOBPhone)));

                startActivity(intentCall);
                return true;
            }
        

        }
            return super.onContextItemSelected(item);
        }


}

