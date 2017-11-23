package csueb.zeta.zwriter.zwriter2017f;

import android.view.MenuItem;
import android.graphics.Color;
import android.widget.RelativeLayout;

import com.example.wenjin.zwriter.R;





import static com.example.wenjin.zwriter.R.id.bg;

/**
 * Created by Wenjin on 11/21/2017.
 */

public class backgroundUtil {

    public static void changeBackgroundColor(MenuItem item, RelativeLayout bg) {
        if (item.getItemId()== R.id.backgroundcolor){
            int redColor;
            int greenColor;
            int blueColor;

            redColor = (int) (Math.random()*256);
            greenColor = (int) (Math.random()*256);
            blueColor = (int) (Math.random()*256);
            bg.setBackgroundColor(Color.rgb(redColor, greenColor, blueColor));
        }
    }
}

