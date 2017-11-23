package csueb.zeta.zwriter.zwriter2017f;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.wenjin.zwriter.R;

/**
 * Created by Wenjin on 11/22/2017.
 */

public class confirmation {
    public static void confirm(MenuItem item, Button folder1, Button deleteFolder1, Button deleteFolder2, Button deleteFolder3){
        if (item.getItemId()==R.id.confirm){
            folder1.setVisibility(View.INVISIBLE);
            deleteFolder1.setVisibility(View.INVISIBLE);
            deleteFolder2.setVisibility(View.INVISIBLE);
            deleteFolder3.setVisibility(View.INVISIBLE);
        }
        else {
            deleteFolder1.setVisibility(View.INVISIBLE);
            deleteFolder2.setVisibility(View.INVISIBLE);
            deleteFolder3.setVisibility(View.INVISIBLE);
        }

    }
}
