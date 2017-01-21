package com.twiceyuan.retropreference.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by twiceYuan on 21/01/2017.
 *
 * 当没有使用该注解时，RetroPreference 默认使用定义的方法名作为 key。建议这样做，因为更直观而且从编译时就确保了不会有重复的 Key 存在。
 *
 * 如果有自己额外定义 key name 的需求，比如使用数字开头作为 key，可以使用该注解。
 */
@Documented
@Retention(RUNTIME)
public @interface KeyName {
    String value();
}
