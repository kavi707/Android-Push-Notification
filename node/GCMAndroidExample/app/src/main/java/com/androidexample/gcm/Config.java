package com.androidexample.gcm;

/**
 * Created by kavi on 1/22/14.
 */
public interface Config {

    // CONSTANTS
    static final String YOUR_SERVER_URL =
            "http://192.168.8.89/gcm-php-app/register.php";

    // Google project id
    static final String GOOGLE_SENDER_ID = "202817437739";

    /**
     * Tag used on log messages.
     */
    static final String TAG = "GCM Android Example";

    static final String DISPLAY_MESSAGE_ACTION =
            "com.androidexample.gcm.DISPLAY_MESSAGE";

    static final String EXTRA_MESSAGE = "message1";
}
