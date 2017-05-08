package com.mdit.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.mdit.example.test.Test;
import com.mdit.library.proxy.CallbackFilter;
import com.mdit.library.proxy.Enhancer;
import com.mdit.library.proxy.MethodInterceptor;
import com.mdit.library.proxy.MethodProxy;
import com.mdit.library.proxy.NoOp;

import java.lang.reflect.Method;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void click1(View v){

        Enhancer enhancer = new Enhancer(this);
        enhancer.setSuperclass(Test.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object object, Object[] args, MethodProxy methodProxy) throws Exception {
                Log.e("TAG","intercept  -- before---");
                Object obj = methodProxy.invokeSuper(object, args);
                Log.e("TAG","intercept  -- after---");
                return obj;
            }
        });
        Test test = (Test) enhancer.create();

        test.toast2(this);


    }

    public void click2(View v){

        Enhancer enhancer = new Enhancer(this);
        enhancer.setSuperclass(Test.class);
        enhancer.setCallbacks(new MethodInterceptor[]{NoOp.INSTANCE,new MethodInterceptor() {
            @Override
            public Object intercept(Object object, Object[] args, MethodProxy methodProxy) throws Exception {
                Log.e("TAG","intercept  -- before---");
                Object obj = methodProxy.invokeSuper(object, args);
                Log.e("TAG","intercept  -- after---");
                return obj;
            }
           }
        });
        enhancer.setCallbackFilter(new CallbackFilter() {
            @Override
            public int accept(Method method) {
                if (method.getName().equals("toast2"))
                    return 1;
                return 0;
            }
        });
        Test test = (Test) enhancer.create();

        test.toast3(this);

    }
}
