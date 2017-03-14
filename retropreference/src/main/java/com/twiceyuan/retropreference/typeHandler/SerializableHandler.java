package com.twiceyuan.retropreference.typeHandler;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Type;

/**
 * Created by twiceYuan on 09/02/2017.
 * <p>
 * Serializable 对象存储。实际为保存对象到文件，并非使用 preference
 */
public class SerializableHandler extends BaseTypeHandler<Object> {

    private static final String SERIALIZABLE_FILE_PREFIX = "RetroPreference_";

    private Context mContext;
    private String  mPreferencesName;
    private Type    mObjectType;

    public SerializableHandler(SharedPreferences preferences,
                               String preferencesName,
                               Context context,
                               Type objectType) {
        super(preferences);
        mPreferencesName = preferencesName;
        mContext = context;
        mObjectType = objectType;
    }

    /**
     * 写入对象到文件
     */
    public void setValue(String key, Object value) {
        File objectFile = getObjectFile(key);
        if (objectFile == null) return;
        try {
            FileOutputStream fileOutput = new FileOutputStream(objectFile);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取文件中的对象
     */
    public Object get(String key, Object defaultValue) {
        File objectFile = getObjectFile(key);
        if (objectFile == null) return defaultValue;
        try {
            FileInputStream fileInput = new FileInputStream(objectFile);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            Object o = objectInput.readObject();
            return ((Class) mObjectType).cast(o);
        } catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    private File getObjectFile(String key) {
        File dir = mContext.getDir(SERIALIZABLE_FILE_PREFIX + mPreferencesName, Context.MODE_PRIVATE);
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                return null;
            }
        }
        return new File(dir, key);
    }
}
