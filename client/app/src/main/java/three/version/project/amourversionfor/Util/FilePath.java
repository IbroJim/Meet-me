package three.version.project.amourversionfor.Util;

import android.os.Environment;

/**
 * Created by Ibraim on 19.03.2018.
 */

public class FilePath {
    //Путь к фотографиям
    public String ROOT_DIR= Environment.getExternalStorageDirectory().getPath();
    public String PICTURES=ROOT_DIR+"/Pictures";
    public String CAMERA=ROOT_DIR+"/DCIM/Camera";
}
