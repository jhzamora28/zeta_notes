package csueb.zeta.zwriter.zwriter2017f;


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
    Button deleteFolder1;
    Button deleteFolder2;
    Button deleteFolder3;
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
        deleteFolder3 = (Button) findViewById(R.id.deleteFolder3);
        deleteFolder2 = (Button) findViewById(R.id.deleteFolder2);
        deleteFolder1 = (Button) findViewById(R.id.deleteFolder1);
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
                        backgroundUtil.changeBackgroundColor(item, bg);
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
                        addFolder.createNewFolder(item, folder1,folder2,folder3);
                        deleteFolder.removeFolder(item, deleteFolder3,deleteFolder2,deleteFolder1,folder3,folder2,folder1);
                        Toast.makeText(MainActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popupMenu.show();
            }

        });

        deleteFolder1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, deleteFolder1);
                popupMenu.getMenuInflater().inflate(R.menu.deletemenu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick (MenuItem item) {
                        confirmation.confirm(item, folder1, deleteFolder1, deleteFolder2, deleteFolder3);
                        Toast.makeText(MainActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popupMenu.show();
            }

        });


    }

}
