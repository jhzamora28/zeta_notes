package csueb.zeta.zwriter.zwriter2017f;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.content.Intent;
import android.net.Uri;
import android.content.ActivityNotFoundException;

import com.example.wenjin.zwriter.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

    public static final String EXTRA_MESSAGE = "csueb.zeta.zwriter.zwriter2017f.MESSAGE";
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

        final String tutorialYoutubeId = "twZggnNbFqo";
        final String [] emailArray = new String[] {"zetagroup@csueb.edu"};
        final String emailSubject = new String("From Zwriter user");
        final String emailText = new String("I am using the Zwriter and on ") + this.getClass().getSimpleName();
        final String chooseClient = new String ("Please Choose a client: ");


        setting.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, setting);
                popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick (MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.backgroundcolor:
                                backgroundUtil.changeBackgroundColor(item, bg);
                                break;
                            case R.id.contactinfo:
                                sendEmail(MainActivity.this, emailArray, emailSubject, emailText, chooseClient);
                                break;
                            case R.id.tutorial:
                                youtubeTutorial(MainActivity.this, tutorialYoutubeId);
                                break;
                            default:
                                break;
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

        folder1.setOnClickListener(this);
        folder2.setOnClickListener(this);
        folder3.setOnClickListener(this);
    }

    @Override
    public void onClick (View view) {
        String message = "";
        switch (view.getId()) {
            case R.id.folder1:
                message = "folder1";
                break;
            case R.id.folder2:
                message = "folder2";
                break;
            case R.id.folder3:
                message = "folder3";
                break;
            default:
                break;
        }

        Intent fileListIntent = new Intent(MainActivity.this, Main2Activity.class);
        fileListIntent.putExtra(EXTRA_MESSAGE, message);
        startActivity(fileListIntent);
    }


    public void sendEmail(Context c,
                          String [] emailArray,
                          String subject,
                          String text,
                          String chooseClient) {
        Intent e = new Intent(Intent.ACTION_SEND);
        e.setType("message/rfc822");
        e.putExtra(Intent.EXTRA_EMAIL, emailArray );
        e.putExtra(Intent.EXTRA_SUBJECT, subject);
        e.putExtra(Intent.EXTRA_TEXT, text);

        c.startActivity(Intent.createChooser(e, chooseClient ));

    }

    public void youtubeTutorial(Context c, String id){
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=" + id));
        try {
            c.startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            c.startActivity(webIntent);
        }
    }

}
