package csueb.zeta.zwriter.zwriter2017f;

import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.wenjin.zwriter.R;

/**
 * Created by Wenjin on 11/21/2017.
 */


public class deleteFolder {
    public static void removeFolder(MenuItem item, Button deleteFolder3, Button deleteFolder2, final Button deleteFolder1, Button folder3, Button folder2, Button folder1) {
        if (item.getItemId()==R.id.delete){
            if (folder3.getVisibility() == View.VISIBLE){
                deleteFolder3.setVisibility(View.VISIBLE);
                deleteFolder2.setVisibility(View.VISIBLE);
                deleteFolder1.setVisibility(View.VISIBLE);
            }
            else if (folder2.getVisibility() == View.VISIBLE){
                deleteFolder2.setVisibility(View.VISIBLE);
                deleteFolder1.setVisibility(View.VISIBLE);
            }
            else if (folder1.getVisibility() == View.VISIBLE){
                deleteFolder1.setVisibility(View.VISIBLE);
            }
        }


    }
}
