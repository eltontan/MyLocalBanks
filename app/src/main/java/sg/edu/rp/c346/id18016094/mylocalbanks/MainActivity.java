package sg.edu.rp.c346.id18016094.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvDBS, tvOCBC, tvUOB;
    String click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       tvDBS = findViewById(R.id.textViewDBS);
       tvOCBC = findViewById(R.id.textViewOCBC);
       tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
        click = "";
    }
        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");

        if (v.getId() == tvDBS.getId()){
            click = "DBS";
        } else if (v.getId() == tvOCBC.getId()){
            click = "OCBC";
        } else if (v.getId() == tvUOB.getId()){
            click = "UOB";
        } else {
            click = "";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
            //code for action
            if (click.equals("DBS")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
                return true;
            } else if (click.equals("OCBC")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
                return true;
            } else if (click.equals("UOB")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
                return true;
            }
        } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
            if (click.equals("DBS")) {
                long DBSTel = Long.parseLong("18001111111");
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + DBSTel));
                startActivity(intentCall);
                return true;
            } else if (click.equals("OCBC")) {
                long OCBCTel = Long.parseLong("18003633333");
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + OCBCTel));
                startActivity(intentCall);
                return true;
            } else if (click.equals("UOB")) {
                long UOBTel = Long.parseLong("18002222121");
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + UOBTel));
                startActivity(intentCall);
                return true;
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
}