package csueb.zeta.zwriter.zwriter2017f;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.wenjin.zwriter.R;


public class MainActivity extends AppCompatActivity {

    Button setting;
    RelativeLayout bg;
    Button sort;
    Button edit;
    Button folder3;
    Button folder2;
    Button folder1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setting = (Button) findViewById(R.id.setting);
        bg = (RelativeLayout) findViewById(R.id.bg);
        sort = (Button) findViewById(R.id.sort);
        edit = (Button) findViewById(R.id.edit);
        folder3 = (Button) findViewById(R.id.folder3);
        folder2 = (Button) findViewById(R.id.folder2);
        folder1 = (Button) findViewById(R.id.folder1);


        setting.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, setting);
                popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick (MenuItem item) {
                        if (item.getItemId()==R.id.backgroundcolor){
                            int redColor;
                            int greenColor;
                            int blueColor;

                            redColor = (int) (Math.random()*256);
                            greenColor = (int) (Math.random()*256);
                            blueColor = (int) (Math.random()*256);
                            bg.setBackgroundColor(Color.rgb(redColor, greenColor, blueColor));
                        }
                        Toast.makeText(MainActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popupMenu.show();
            }

        });

        sort.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, sort);
                popupMenu.getMenuInflater().inflate(R.menu.popup2, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick (MenuItem item) {
                        Toast.makeText(MainActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popupMenu.show();
            }

        });

        edit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, edit);
                popupMenu.getMenuInflater().inflate(R.menu.popup3, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick (MenuItem item) {
                        if (item.getItemId()==R.id.create){

                            if (folder1.getVisibility() == View.INVISIBLE){
                                folder1.setVisibility(View.VISIBLE);
                            }
                            else if (folder1.getVisibility() == View.VISIBLE){
                                folder2.setVisibility(View.VISIBLE);
                            }
                            else if (folder1.getVisibility() == View.VISIBLE && folder2.getVisibility() == View.VISIBLE){
                                folder3.setVisibility(View.VISIBLE);
                            }
                        }

                        //Delete
                        if (item.getItemId()==R.id.delete){
                            if (folder3.getVisibility() == View.VISIBLE){
                                folder3.setVisibility(View.INVISIBLE);
                            }
                            else if (folder2.getVisibility() == View.VISIBLE){
                                folder2.setVisibility(View.INVISIBLE);
                            }
                            else if (folder1.getVisibility() == View.VISIBLE){
                                folder1.setVisibility(View.INVISIBLE);
                            }
                        }
                        Toast.makeText(MainActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popupMenu.show();
            }

        });




    }

}
