package com.example.allen.criminalintent;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.Display;
import android.widget.ImageView;

/**
 * PictureUtils
 *
 * @author: Allen
 * @time: 2016/2/26 13:53
 */
public class PictureUtils {
    public static BitmapDrawable getScaledDrawable(Activity a, String path) {
        Display display = a.getWindowManager().getDefaultDisplay();
        float destWidth = display.getWidth();
        float destHeight = display.getHeight();

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        float scrWidth = options.outWidth;
        float scrHeight = options.outHeight;

        int inSimpleSize = 1;
        if (scrHeight > destHeight || scrWidth > destWidth) {
            if (scrHeight > destHeight) {
                inSimpleSize = Math.round(scrHeight / destHeight);
            } else {
                inSimpleSize = Math.round(scrWidth / destWidth);
            }
        }

        options = new BitmapFactory.Options();
        options.inSampleSize = inSimpleSize;

        Bitmap bitmap = BitmapFactory.decodeFile(path, options);
        return new BitmapDrawable(a.getResources(), bitmap);
    }

    public static void cleanImageView(ImageView imageView) {        //清理工作
        if ( !(imageView.getDrawable() instanceof BitmapDrawable))
            return;
        BitmapDrawable b = (BitmapDrawable)imageView.getDrawable();
        b.getBitmap().recycle();        //主动调用recycle()，释放内存
        imageView.setImageDrawable(null);
    }
}
