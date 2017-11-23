package csueb.zeta.zwriter.zwriter2017f;
import android.view.MenuItem;
import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Button;
import com.example.wenjin.zwriter.R;

/**
 * Created by Wenjin on 11/21/2017.
 */

public class addFolder {
    public static void createNewFolder(MenuItem item, Button folder1, Button folder2, Button folder3) {
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
    }
}
