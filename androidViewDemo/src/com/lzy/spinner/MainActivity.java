package com.lzy.spinner;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	ImageView imageView2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// spinner幅值
		Spinner spinner = (Spinner) this.findViewById(R.id.spinner1);
		final String[] data = this.getResources().getStringArray(
				R.array.spinnerData);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, data);
		spinner.setAdapter(adapter);

		// 动画测试
		ImageView imageView = (ImageView) findViewById(R.id.imageView1);
		// 设置背景图
		imageView.setBackgroundResource(R.drawable.test_anim);
		// 创建AnimationDrawable对象
		final AnimationDrawable anim = (AnimationDrawable) imageView
				.getBackground();
		anim.stop();
		anim.start();
		// ImageView 设置点击事件的时候 触发动画
		imageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				anim.stop(); // 首先需要将动画停止
				v.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						Toast.makeText(MainActivity.this,
								"我被点击了" + v.getContentDescription(),
								Toast.LENGTH_SHORT).show();
					}
				});
				anim.start(); // 然后开始动画
			}
		});
		
		
		/**
		 * 动画效果测试
		 */
		 imageView2 = (ImageView) findViewById(R.id.imageView2);  
	        //图片点击的时候，启动动画效果    
		 imageView2.setOnClickListener(new OnClickListener() {  
	  
	            @Override  
	            public void onClick(View v) {  
	                //AnimationSet类是一个Animation集合，里面可以许多Animation，  
	                //且在AnimationSet中设置的属性适用于里面的所有Animation。  
	                //参数true 则共享@Interpolator  
	                AnimationSet set = new AnimationSet(true);  
	  
	                //透明  
	                Animation alphaAnim = getAlphaAnimation();  
	                set.addAnimation(alphaAnim);  
	  
	                //缩放  
	                Animation scalegetAnim = getScaleAnimation();  
	                set.addAnimation(scalegetAnim);  
	  
	                //旋转  
	                Animation rotateAnim = getRotateAnimation();  
	                set.addAnimation(rotateAnim);  
	  
	                //移动 上面三个动画是同时进行的，我现在需要让移动这个动画在上面的动画之后执行  
	                //需要使用setStartOffset 设置动画开始的时间  
	                Animation translateAnim = getTranslateAnimation();  
	                translateAnim.setStartOffset(500);  
	                set.addAnimation(translateAnim);  
	  
	                v.startAnimation(set);  
	            }  
	        });  
	  
	}
	
	 /** 
     * 透明效果 
     * @return 
     */  
    public Animation getAlphaAnimation() {  
        //实例化 AlphaAnimation 主要是改变透明度  
        //透明度 从 1-不透明 0-完全透明   
        Animation animation = new AlphaAnimation(1.0f, 0.8f);  
        //设置动画插值器 被用来修饰动画效果,定义动画的变化率   
        animation.setInterpolator(new DecelerateInterpolator());  
        //设置动画执行时间  
        animation.setDuration(1000);  
        return animation;  
    }  
  
    /** 
     * 缩放动画 
     * @return 
     */  
    public Animation getScaleAnimation() {  
        //实例化 ScaleAnimation 主要是缩放效果  
        //参数：fromX-动画开始前，x坐标   toX-动画结束后x坐标  
        //fromY-动画开始前，Y坐标  toY-动画结束后Y坐标  
        //pivotXType - 为动画相对于物件的X坐标的参照物   pivotXValue - 值  
        //pivotYType - 为动画相对于物件的Y坐标的参照物   pivotYValue - 值  
        Animation animation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f,  
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,  
                0.5f);  
        //设置动画插值器 被用来修饰动画效果,定义动画的变化率   
        animation.setInterpolator(new DecelerateInterpolator());  
        //设置动画执行时间  
        animation.setDuration(1000);  
        return animation;  
    }  
  
    /** 
     * 旋转 
     * @return 
     */  
    public Animation getRotateAnimation() {  
        //实例化RotateAnimation  
        //以自身中心为圆心，旋转360度  正值为顺时针旋转，负值为逆时针旋转  
        RotateAnimation animation = new RotateAnimation(0, 360,  
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,  
                0.5f);  
        //设置动画插值器 被用来修饰动画效果,定义动画的变化率   
        animation.setInterpolator(new DecelerateInterpolator());  
        //设置动画执行时间  
        animation.setDuration(1000);  
        return animation;  
    }  
  
    /** 
     * 移动 
     * @return 
     */  
    public Animation getTranslateAnimation() {  
    	 //以自身为坐标系和长度单位，从(0,0)移动到(1,1)  
        TranslateAnimation animation = new TranslateAnimation(  
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,  
                1.0f, Animation.RELATIVE_TO_SELF, 0.0f,  
                Animation.RELATIVE_TO_SELF, 1.0f);  
        //设置动画插值器 被用来修饰动画效果,定义动画的变化率   
        animation.setInterpolator(new DecelerateInterpolator());  
        //设置重复动画  
        animation.setRepeatCount(2);   
        //设置动画执行时间  
        animation.setDuration(1000);  
        //设置监听器  
        animation.setAnimationListener(new AnimationListener() {  
              
            @Override  
            public void onAnimationStart(Animation animation) {  
                //动画开始前  
                Toast.makeText(getBaseContext(), "Strart!", Toast.LENGTH_SHORT).show();    
            }  
              
            @Override  
            public void onAnimationRepeat(Animation animation) {  
                //重复动画的时候，  
                Toast.makeText(getBaseContext(), "Repeat!", Toast.LENGTH_SHORT).show();    
            }  
              
            @Override  
            public void onAnimationEnd(Animation animation) {  
                // 结束动画的时候  
                Toast.makeText(getBaseContext(), "End!", Toast.LENGTH_SHORT).show();   
                //动画结束后，清除动画
                imageView2.clearAnimation();  
            }  
        });  
        return animation;   
    }  
    
    public void seeFlingGalleryAction(View view){
    	Intent intent=new Intent();
    	intent.setAction("android.intent.action.FlingGalleryActivity");
    	startActivity(intent);
    }
  
}
