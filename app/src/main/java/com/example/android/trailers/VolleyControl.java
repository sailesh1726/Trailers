package com.example.android.trailers;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class VolleyControl {
    private static VolleyControl volleyControl =null;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;


    private VolleyControl(){
        requestQueue = Volley.newRequestQueue(MyApplication.getAppContext());
        imageLoader =new ImageLoader(requestQueue, new ImageLoader.ImageCache(){

            private LruCache<String,Bitmap> cache = new LruCache<>((int)(Runtime.getRuntime().maxMemory()/1024)/8);

            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url,bitmap);
            }
        });
    }

    public static synchronized VolleyControl getInstance(){
        if(volleyControl==null){
            volleyControl = new VolleyControl();
        }
        return volleyControl;
    }

    public RequestQueue getRequestQueue(){
       return requestQueue;
    }

    public ImageLoader getImageLoader(){
        return imageLoader;
    }
}
