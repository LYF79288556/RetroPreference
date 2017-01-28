package com.twiceyuan.retropreference.typeHandler;

import android.content.SharedPreferences;

/**
 * Created by twiceYuan on 20/01/2017.
 *
 * Long handler
 */
class LongHandler extends BaseTypeHandler<Long> {

    LongHandler(SharedPreferences preferences) {
        super(preferences);
    }

    @Override
    public void setValue(String key, Long value) {
        mPreferences.edit().putLong(key, value).apply();
    }

    @Override
    public Long get(String key, Long defaultValue) {
        return mPreferences.getLong(key, defaultValue);
    }

    @Override
    public Long defaultValue() {
        return 0L;
    }
}
