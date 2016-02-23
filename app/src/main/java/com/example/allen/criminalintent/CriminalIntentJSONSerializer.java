package com.example.allen.criminalintent;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 * CriminalIntentJSONSerializer
 *
 * @author: Allen
 * @time: 2016/2/24 0:39
 */
public class CriminalIntentJSONSerializer {
    private Context mContext;
    private String mFilename;

    public CriminalIntentJSONSerializer(Context c, String s) {
        mContext = c;
        mFilename = s;
    }

    public void saveCrimes(ArrayList<Crime> crimes) throws JSONException, IOException {
        JSONArray array = new JSONArray();
        for (Crime c : crimes)
            array.put(c.toJSON());

        Writer writer = null;
        try {
//           Context.openFileOutput()方法会将传入的文件名附加到应用沙盒文件目录路径
//            形成一个新的路径，然后在新的路径下创建并打开文件，等待数据写入
            OutputStream out = mContext.openFileOutput(mFilename, Context.MODE_PRIVATE);
//            获得OutputStream对象，用其创建OutputStreamWriter对象，writer.write()方法写入数据
            writer = new OutputStreamWriter(out);
            writer.write(array.toString());
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}
