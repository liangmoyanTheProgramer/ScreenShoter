package com.mystudio.moshui.screenshoter.util;

import android.graphics.Bitmap;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by lianghuiyu on 2017/11/5.
 */

public class Shotable {


    public  static void shot(View Window,String AndroidRoot,String FileRoot){
        try{
            Window.setDuplicateParentStateEnabled(true);
            Window.buildDrawingCache();

            File file = new File(AndroidRoot + FileRoot);

            FileOutputStream stream = new FileOutputStream(file);



            Bitmap bmp = Window.getDrawingCache();
            bmp.compress(Bitmap.CompressFormat.PNG,100,stream);

            stream.flush();
            stream.close();


        }catch (IOException e){

        }

    }
}
