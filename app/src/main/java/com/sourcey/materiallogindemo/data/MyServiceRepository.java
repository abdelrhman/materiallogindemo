package com.sourcey.materiallogindemo.data;

import android.os.Handler;

/**
 * Created by talat on 29-07-2016.
 */
public class MyServiceRepository {

    private static final int SERVICE_LATENCY_IN_MILLIS = 2000;

    public void getUserToken(final ServiceCallback callback){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.success("task");
            }
        }, SERVICE_LATENCY_IN_MILLIS);
    }

    public  interface ServiceCallback{
        void success(String token);
        void fail();
    }


}
