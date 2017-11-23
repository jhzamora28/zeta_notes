package csueb.zeta.zwriter.zwriter2017f;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.wenjin.zwriter.R;


public class FileListActivity extends AppCompatActivity {

    Button setting;
    RelativeLayout bg;
    Button sort;
    Button edit;
    Button deleteFile1;
    Button deleteFile2;
    Button deleteFile3;
    Button file3;
    Button file2;
    Button file1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setting = (Button) findViewById(R.id.setting);
        bg = (RelativeLayout) findViewById(R.id.bg);
        sort = (Button) findViewById(R.id.sort);
        edit = (Button) findViewById(R.id.edit);
        deleteFile3 = (Button) findViewById(R.id.deleteFile3);
        deleteFile2 = (Button) findViewById(R.id.deleteFile2);
        deleteFile1 = (Button) findViewById(R.id.deleteFile1);
        file3 = (Button) findViewById(R.id.file3);
        file2 = (Button) findViewById(R.id.file2);
        file1 = (Button) findViewById(R.id.file1);


        setting.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                PopupMenu popupMenu = new PopupMenu(FileListActivity.this, setting);
                popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick (MenuItem item) {
                        backgroundUtil.changeBackgroundColor(item, bg);
                        Toast.makeText(FileListActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popupMenu.show();
            }

        });

        sort.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                PopupMenu popupMenu = new PopupMenu(FileListActivity.this, sort);
                popupMenu.getMenuInflater().inflate(R.menu.popup2, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick (MenuItem item) {
                        Toast.makeText(FileListActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popupMenu.show();
            }

        });

        edit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                PopupMenu popupMenu = new PopupMenu(FileListActivity.this, edit);
                popupMenu.getMenuInflater().inflate(R.menu.popup3, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick (MenuItem item) {
                        addFile.createNewFile(item, file1,file2,file3);
                        deleteFile.removeFile(item, deleteFile3,deleteFile2,deleteFile1,file3,file2,file1);
                        Toast.makeText(FileListActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popupMenu.show();
            }

        });

        deleteFile1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                PopupMenu popupMenu = new PopupMenu(FileListActivity.this, deleteFile1);
                popupMenu.getMenuInflater().inflate(R.menu.deletemenu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick (MenuItem item) {
                        confirmation.confirm(item, file1, deleteFile1, deleteFile2, deleteFile3);
                        Toast.makeText(FileListActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popupMenu.show();
            }

        });


    }

}
