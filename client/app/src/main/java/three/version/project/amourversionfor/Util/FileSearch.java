package three.version.project.amourversionfor.Util;


import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Ibraim on 19.03.2018.
 */

public class FileSearch {
    //isDerictory каталог файлов
 public static ArrayList<String> getDirectoryPath(String directory){
        ArrayList<String> pathArray=new ArrayList<>();
        File file=new File(directory);
        File[] listfiles=file.listFiles();

            for (int i = 0; i < listfiles.length; i++) {
                if (listfiles[i].isDirectory()) {
                    pathArray.add(listfiles[i].getAbsolutePath());
                }
            }

     return pathArray;

    }
    //isFile обьект является файлом а не каталогом
    public static ArrayList<String> getFilesPath(String directory){
       ArrayList<String> pathArray=new ArrayList<>();
        File file=new File(directory);
        File[] listfiles =file.listFiles();
            for (int i = 0; i < listfiles.length; i++) {
                if (listfiles[i].isFile()) {
                    pathArray.add(listfiles[i].getAbsolutePath());
                }
            }

        return pathArray;
    }
}
