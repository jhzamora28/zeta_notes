package csueb.zeta.zwriter.zwriter2017f;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by arbeitandy on 11/21/17.
 */

public class dataManager {

    public File[] getFileList(String folderName) {
        File folder = new File(folderName);
        File[] fileList = folder.listFiles();
        return fileList;
    }
}
/**
 * Usage:
  dm = new dataManager();

  String home = Environment.getExternalStorageDirectory().toString() + "/zwriter/" + folderName;
  File[] fileList = dm.getFileList(home);
  **/