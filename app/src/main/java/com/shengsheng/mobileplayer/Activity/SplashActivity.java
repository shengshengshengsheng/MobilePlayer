package com.shengsheng.mobileplayer.Activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;

import com.shengsheng.mobileplayer.R;

public class SplashActivity extends Activity {
    private static final String TAG=SplashActivity.class.getSimpleName();
    //通过SplashActivity.class.getSimpleName()这种方式来获取类名字避免以后更改类名字之后再手动去修改TAG
   private Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         *  new Handler().postDelayed()设置点击启动应用程序后进入主界面的延迟时间
         */
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //延迟2000ms之后在进行run（）操作
                //执行在主线程当中
                startMainActivity();
                Log.e(TAG,"当前线程名称=="+Thread.currentThread().getName());
            }
        },2000);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        /**
         *用户一点击程序就进入主页面，无需等待
         */
        Log.e(TAG,"onTouchEvent==Action"+event.getAction());
        startMainActivity();
        return super.onTouchEvent(event);
    }
    @Override
    protected void onDestroy()
    {
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
    /**
     *startMainActivity函数跳转到主页面，并且关闭当前页面
     */
    private void startMainActivity()
    {
        //启动一个新的页面
        Intent intent=new Intent(SplashActivity.this,MainActivity.class);
        startActivity(intent);
        finish();//关闭当前页面
    }
}
