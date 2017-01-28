package com.twiceyuan.retropreference.typeHandler;

import android.content.SharedPreferences;

/**
 * Created by twiceYuan on 20/01/2017.
 *
 * Float handler
 */
class FloatHandler extends BaseTypeHandler<Float> {

    FloatHandler(SharedPreferences preferences) {
        super(preferences);
    }

    @Override
    public void setValue(String key, Float value) {
        mPreferences.edit().putFloat(key, value).apply();
    }

    @Override
    public Float get(String key, Float defaultValue) {
        return mPreferences.getFloat(key, defaultValue);
    }

    @Override
    public Float defaultValue() {
        return 0f;
    }
}
