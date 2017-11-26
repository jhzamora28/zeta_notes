package csueb.zeta.zwriter.zwriter2017f;

import android.content.Intent;
import android.os.Bundle;
import android.graphics.Color;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wenjin.zwriter.R;

import java.util.Arrays;
import java.util.List;

import android.util.Log;



public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        displayFab();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        displayTitle ();
        displayFileList();

    }


    public void displayFab () {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // change to intent of creating a note
                Snackbar.make(view, "Created some dummy notes", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
    public void displayTitle (){
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // tv: Capture the layout's TextView and set the string as text passed from previous
        View v = findViewById(R.id.dummyText);
        TextView tv = (TextView) v;
        tv.setShadowLayer(1.2f,-3,3,Color.GRAY);

        tv.setText(message);
    }

    public void displayFileList() {

        RecyclerView rvFiles;
        RecyclerView.Adapter adapter;
        RecyclerView.LayoutManager layoutManager;

        // #TODO change dummy name to current folder name

        final List<String> fileNameL = Arrays.asList(dataManager.getFileList("baz"));

        // rv: file list
        rvFiles = (RecyclerView) findViewById(R.id.file_list);
        layoutManager = new LinearLayoutManager(this);
        rvFiles.setLayoutManager(layoutManager);
        rvFiles.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));

        rvFiles.setAdapter(new RecyclerView.Adapter <listViewHolder> () {

            @Override
            public listViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(
                        android.R.layout.simple_list_item_1,
                        parent,
                        false);
                listViewHolder vh = new listViewHolder(v);
                return vh;
            }

            @Override
            public void onBindViewHolder(listViewHolder vh, int position) {
                TextView tv = (TextView) vh.itemView;
                tv.setText(fileNameL.get(position));
                tv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_star, 0, 0, 0);
                tv.setShadowLayer(1.2f,-3,3,Color.DKGRAY);
            }

            @Override
            public int getItemCount() {
                return fileNameL.size();
            }
        });
    }

}
