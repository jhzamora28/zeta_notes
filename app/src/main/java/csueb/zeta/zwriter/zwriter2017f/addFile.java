package csueb.zeta.zwriter.zwriter2017f;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.wenjin.zwriter.R;

/**
 * Created by andy on 11/22/2017.
 */

public class addFile {
    public static void createNewFile(MenuItem item, Button file1, Button file2, Button file3) {
        if (item.getItemId()==R.id.create){

            if (file1.getVisibility() == View.INVISIBLE){
                file2.setVisibility(View.VISIBLE);
            }
            else if (file1.getVisibility() == View.VISIBLE){
                file2.setVisibility(View.VISIBLE);
            }
            else if (file1.getVisibility() == View.VISIBLE && file2.getVisibility() == View.VISIBLE){
                file3.setVisibility(View.VISIBLE);
            }
        }
    }
}
