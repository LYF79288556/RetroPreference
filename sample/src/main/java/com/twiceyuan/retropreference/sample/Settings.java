package com.twiceyuan.retropreference.sample;

import com.twiceyuan.retropreference.Preference;

/**
 * Created by twiceYuan on 20/01/2017.
 *
 * Mock Settings
 */
public interface Settings {

    /**
     * Mark launch count
     */
    Preference<Integer> launchCount();

    /**
     * Save current user instance
     */
    Preference<User> currentUser();
}
