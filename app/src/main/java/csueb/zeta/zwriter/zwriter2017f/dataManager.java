package csueb.zeta.zwriter.zwriter2017f;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.security.SecureRandom;
import java.util.Date;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import android.os.Environment;


/**
 * Created by andy on 11/21/17.
 */

public class dataManager {
    /**
     * Usage:
     dm = new dataManager();

     String home = Environment.getExternalStorageDirectory().toString() + "/zwriter/" + folderName;
     File[] fileList = dm.getFileList(home);
     **/
    public File[] getFileList(String folderName) {
        File folder = new File(folderName);
        File[] fileList = folder.listFiles();
        return fileList;
    }

    public void writeDummyFile(String folderName) {
        // String noteString = this.randomString(400);
        String noteString = xmasString;
        String name = this.genFileName();
        File file;
        String home = Environment.getExternalStorageDirectory().toString() + "/zwriter/" + folderName;
        String fullFileName = home + name;
        FileOutputStream outputStream;
        try {
            file = new File(fullFileName);
            outputStream = new FileOutputStream(file);
            outputStream.write(noteString.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    String randomString( int len ){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

    String xmasString = "\r\n"

    +"          t"
    +"         .#."
    +"        .###."
    +"       .#%##%."
    +"       .%##%###."
    +"      .##%###%##."
    +"     .#%###%##%##."
    +"           #"
    +"           #"


    ;


    String genFileName() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd");
        Random rand = new Random();
        int r = rand.nextInt(4000) + 1000;
        Date now = new Date();
        return formatter.format(now) + Integer.toString(r) + ".txt";
    }
}
