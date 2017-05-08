package com.mdit.example.test;

import android.content.Context;
import android.widget.Toast;

/**
 * <pre>
 *     author : zhangke
 *     e-mail : zhangke3016@gmail.com
 *     time   : 2017/05/08
 *     desc   :
 * </pre>
 */

public class Test {

    public void toast1(Context ctx){
        Toast.makeText(ctx, "--111111----", Toast.LENGTH_SHORT).show();
    }

    public String test(){
        return "aabbcc";
    }
    public void toast2(Context ctx){
        int aa = 333;
        Toast.makeText(ctx, "--222222----"+aa, Toast.LENGTH_SHORT).show();
    }

    public void toast3(Context ctx){
        Toast.makeText(ctx, "--333333----", Toast.LENGTH_SHORT).show();
    }


}
