package csueb.zeta.zwriter.zwriter2017f;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.security.SecureRandom;
import java.util.Date;


import android.os.Environment;
import android.util.Log;


/**
 * Created by andy on 11/21/17.
 */

public class dataManager {
    public final static boolean DEBUG = false;

    /**
     * Usage:
     dm = new dataManager();
     fn = "foobar";
     File[] fileList = dm.getFileList(fn);
     **/
    private static final String TAG = Main2Activity.class.getSimpleName();


    // generate a dummy folder and several dummy files inside
    public static void genDummy(String folderN) {
        if (DEBUG)
            Log.d("GENDUMMY", "folderN: " + folderN);

        createFolder(folderN);
        createFile(folderN, "baz note");
        createFile(folderN, "bar note");
        createFile(folderN, randomString(42));
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
        File[] folders = folder.listFiles(fileFilterFolder);

        String [] aList = new String[folders.length];
        for (int i=0; i < folders.length; i++)
            aList[i] = folders[i].getName();

        return aList;

    }

    public static String [] getFileList(String folderN) {
        if (DEBUG)
            Log.d("GET FILELIST", "folderN: " + folderN);

        genDummy(folderN);                           // #TODO remove this
        String path = Environment.getExternalStorageDirectory().toString()
                + File.separator
                + "zwriter"
                + File.separator
                + folderN;

        File folder = new File(path);
        File[] files = folder.listFiles(fileFilterTxt);
        String [] aList = new String[files.length];
        for (int i=0; i < files.length; i++)
            aList[i] = files[i].getName();

        return aList;
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
        if (DEBUG) {
            Log.d("CREATE FILE", "folderN: " + folderN +
                    "\n noteString: " + noteString +
                    "\n #filename: " + fileN + "\n");
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



        // String noteString = this.randomString(400);
        File aNote = new File(path, fileN);
        try {
            FileOutputStream oStream = new FileOutputStream(aNote);
            try {
                oStream.write(xmasString.getBytes());          // #TODO use real noteString
            } catch (IOException e) {
                Log.d("ERROR writing file", e.toString());
            } finally {
                oStream.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void createFolder( String folderN) {
        if (DEBUG)
            Log.d("CREATING FOLDER", folderN);

        File fo = new File (Environment.getExternalStorageDirectory().toString()
                            + File.separator
                            + "zwriter"
                            + File.separator
                            , folderN );

        if(!fo.exists() && !fo.isDirectory())       // #TODO add error message
        {
            if (fo.mkdirs())
                Log.d("MAKEDIRS", fo.getName());
            else
                Log.d("FAILED: MAKEDIRS", fo.getName());

        }

        if (DEBUG) {
            String[] folders = getFolderList();
            for (String f : folders)
                Log.d("FOLDER CREATED", f);
        }
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

    public static FileFilter fileFilterTxt = new FileFilter() {
        public boolean accept(File file) {
            //if the file extension is .txt return true, else false
            if (file.getName().endsWith(".txt")) {
                return true;
            }
            return false;
        }
    };

    public static FileFilter fileFilterFolder = new FileFilter() {
        public boolean accept(File file) {
            return file.isDirectory();
        }
    };
}
