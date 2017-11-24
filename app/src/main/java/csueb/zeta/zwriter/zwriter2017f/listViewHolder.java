package csueb.zeta.zwriter.zwriter2017f;

import android.view.View;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;


/**
 * Created by andy on 11/24/17.
 */

public class listViewHolder extends ViewHolder implements View.OnClickListener {
    public listViewHolder(View v) {
        super(v);
        v.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(),
                        ((TextView) v).getText(),
                        Toast.LENGTH_LONG).show();}
}
