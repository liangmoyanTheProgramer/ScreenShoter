package com.mystudio.moshui.screenshoter.util;

import android.graphics.Bitmap;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Created by lianghuiyu on 2017/11/5.
 */

public class Recordable {

    public boolean shot(View window, String FilePath) throws IOException{
        try{
            window.setDrawingCacheEnabled(true);
            window.buildDrawingCache();

            File returnFile = new File(FilePath);
            FileOutputStream fileOutputStream = new FileOutputStream(returnFile);


            Bitmap bmp = window.getDrawingCache();
            boolean success = bmp.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream);

            if (!success) throw new IOException("Assertion:Compress Failed");

            fileOutputStream.flush();
            fileOutputStream.close();


        }catch (IOException e){
            //Ignore
        }
        return true;

    }


}
