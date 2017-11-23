package csueb.zeta.zwriter.zwriter2017f;

import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.wenjin.zwriter.R;

/**
 * Created by andy on 11/22/2017.
 */


public class deleteFile {
    public static void removeFile(MenuItem item, Button deleteFile3, Button deleteFile2, final Button deleteFile1, Button file3, Button file2, Button file1) {
        if (item.getItemId()==R.id.delete){
            if (file3.getVisibility() == View.VISIBLE){
                deleteFile3.setVisibility(View.VISIBLE);
                deleteFile2.setVisibility(View.VISIBLE);
                deleteFile1.setVisibility(View.VISIBLE);
            }
            else if (file2.getVisibility() == View.VISIBLE){
                deleteFile2.setVisibility(View.VISIBLE);
                deleteFile1.setVisibility(View.VISIBLE);
            }
            else if (file1.getVisibility() == View.VISIBLE){
                deleteFile1.setVisibility(View.VISIBLE);
            }
        }


    }
}
