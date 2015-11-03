package com.example.android.trailers;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by 517107 on 11/3/2015.
 */
public class VolleyControl {
    private static VolleyControl volleyControl =null;
    private RequestQueue requestQueue;

    private VolleyControl(){
        requestQueue = Volley.newRequestQueue(MyApplication.getAppContext());
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
}
