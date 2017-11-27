package csueb.zeta.zwriter.zwriter2017f;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.wenjin.zwriter.R;

/**
 * Created by kevin on 11/20/17.
 */

public class EditActivity extends AppCompatActivity {
    private LinearLayout bodyLayout;
    private BodyText bb, cc;

    private Button fontSize, fontType, boldButton, italicsButton, trashButton;
    private Bundle bundle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        // Attach views to respective ids
        ScrollView noteBarScrollView = (ScrollView) findViewById(R.id.noteBar); // ScrollView for note toolbar
        ScrollView bodyScrollView = (ScrollView) findViewById(R.id.bodyScroll); // ScrollView for note body
        fontSize = (Button) findViewById(R.id.fontSize); // Button; used in note toolbar
        fontType = (Button) findViewById(R.id.fontType); // Button; used in note toolbar
        boldButton = (Button) findViewById(R.id.fontBold); // Button; used in note toolbar
        italicsButton = (Button) findViewById(R.id.fontItalics); // Button; used in note toolbar
        trashButton = (Button) findViewById(R.id.trashButton);
        bodyLayout = (LinearLayout) findViewById(R.id.bodyContent); // LinearLayout containing all note objects

        bb = new BodyText(this);
        cc = new BodyText(this);
        final Button merge = new Button(this);

        bodyLayout.addView(bb);
        bodyLayout.addView(cc);
        bodyLayout.addView(merge);

        trashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bb.mergeBodyText(cc);
                bodyLayout.removeView(merge);
            }
        });

        fontSize.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                PopupMenu popupMenu = new PopupMenu(EditActivity.this, fontSize);
                popupMenu.getMenuInflater().inflate(R.menu.font_size, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick (MenuItem item) {
                        Toast.makeText(EditActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        //

                        return true;
                    }
                });

                popupMenu.show();
            }

        });

        // font type refers to the actual font
        // possible fonts include: Droid serif, Droid sans, Wingdings
        fontType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(EditActivity.this, fontType);
                popupMenu.getMenuInflater().inflate(R.menu.font_type, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick (MenuItem item) {
                        Toast.makeText(EditActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        //
                        return true;
                    }
                });

                popupMenu.show();
            }
        });

        boldButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View a = bodyLayout.findFocus();
                if (a.getClass().getName() == "BodyText") {
                    BodyText text = (BodyText) a;
                    text.boldSwitch();
                }
            }
        });

        italicsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View a = bodyLayout.findFocus();
                if (a.getClass().getName() == "BodyText") {
                    BodyText text = (BodyText) a;
                    text.italicsSwitch();
                }
            }
        });


        noteBarScrollView.canScrollVertically(0);








    }



}
