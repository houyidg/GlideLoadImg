package com.glidedemo.zhuxiao.glidedemo.utils;

import android.content.Context;
import android.net.Uri;

/**
 * Created by zhuxiao on 2016/5/11.
 */
public class CommonUtils {

    public static final String ANDROID_RESOURCE = "android.resource://";
    public static final String FOREWARD_SLASH = "/";

    public static Uri resourceIdToUri(Context context, int resourceId) {
        return Uri.parse(ANDROID_RESOURCE + context.getPackageName() + FOREWARD_SLASH + resourceId);
    }
}
