
# MethodInterceptProxy

>### 基于dexmaker的Android切面拦截框架。
>MethodInterceptProxy for Android.It is used by AOP, testing, data access frameworks to generate dynamic proxy objects and intercept field access.
> API compatible with **Android 2.3+**

# Usage 
# java

```
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

```
# More use 
```
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
```


---
### About me

An Android Developer in ZhengZhou.

【[**我的简书地址**](http://www.jianshu.com/users/3c751e06dc32/latest_articles)】

【[**我的CSDN地址**](http://blog.csdn.net/zhangke3016)】

---

### Thanks
---

[cglib](https://github.com/cglib/cglib)

[dexmaker](https://github.com/linkedin/dexmaker)

[CGLib-for-Android](https://github.com/leo-ouyang/CGLib-for-Android)

### License

---

Copyright  2016  zhangke

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at 
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
