package csueb.zeta.zwriter.zwriter2017f;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.security.SecureRandom;
import java.util.Date;


import android.os.Environment;


/**
 * Created by andy on 11/21/17.
 */

public class dataManager {
    /**
     * Usage:
     dm = new dataManager();
     fn = "foobar";
     File[] fileList = dm.getFileList(fn);
     **/

    // generate a dummy folder and several dummy files inside
    public static void genDummy(String folderN) {
        createFolder(folderN);
        createFile(folderN, "baz note");
        createFile(folderN, "bar note");
        createFile(folderN, randomString(900));
        createFile(folderN, randomString(70));
    }
    // dummy function to get some empty folders
    public static void genDummyFolders() {
        createFolder("foobar");
        createFolder("barbaz");
        createFolder("bazfoo");
        createFolder("zetafolder");
    }

    public static String [] getFolderList() {
        String path = Environment.getExternalStorageDirectory().toString()
                + File.separator
                + "zwriter";

        File folder = new File(path);
        return folder.list();
    }

    public static String [] getFileList(String folderN) {
        genDummy(folderN);                           // #TODO remove this
        String path = Environment.getExternalStorageDirectory().toString()
                + File.separator
                + "zwriter"
                + File.separator
                + folderN;

        File folder = new File(path);
        return folder.list();
    }

    public static String readNote (String folderN, String fileN) {

        String path = Environment.getExternalStorageDirectory().toString()
                + File.separator
                + "zwriter"
                + File.separator
                + folderN;
        File aNote = new File(path, fileN);

        int length = (int) aNote.length();
        byte[] bytes = new byte[length];

        FileInputStream in = null;
        try {
            in = new FileInputStream(aNote);
            in.read(bytes);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String contents = new String(bytes);
        return contents;
    }

    // file name will be automatically generated using genFileName()
    public static void createFile(String folderN, String noteString) {
        createFolder(folderN);
        String path = Environment.getExternalStorageDirectory().toString()
                + File.separator
                + "zwriter"
                + File.separator
                + folderN;

        String fileN = genFileName();

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



        // String noteString = this.randomString(400);
        File aNote = new File(path, fileN);
        try {
            FileOutputStream oStream = new FileOutputStream(aNote);
            try {
                oStream.write(xmasString.getBytes());          // #TODO use real noteString
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                oStream.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void createFolder( String folderN) {
        File fo = new File (Environment.getExternalStorageDirectory().toString()
                            + File.separator
                            + "zwriter"
                            + File.separator
                            + folderN );

        if(!fo.exists() && !fo.isDirectory())       // #TODO add error message
                fo.mkdirs();

    }



    public static String randomString( int len ){
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }


    public static String genFileName() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd");
        Random rand = new Random();
        int r = rand.nextInt(4000) + 1000;
        Date now = new Date();
        return formatter.format(now) + Integer.toString(r) + ".txt";
    }


}
