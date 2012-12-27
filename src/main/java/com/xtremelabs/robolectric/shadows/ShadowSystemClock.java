package com.xtremelabs.robolectric.shadows;

import android.os.SystemClock;

import com.xtremelabs.robolectric.internal.Implementation;
import com.xtremelabs.robolectric.internal.Implements;

@Implements(SystemClock.class)
public class ShadowSystemClock {
    private static long start;
    
    static {
        start = System.currentTimeMillis();
    }
    
    @Implementation
    public static long uptimeMillis() {
        return System.currentTimeMillis() - start;
    }
    
}