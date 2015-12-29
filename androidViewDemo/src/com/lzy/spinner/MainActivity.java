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
		// spinner��ֵ
		Spinner spinner = (Spinner) this.findViewById(R.id.spinner1);
		final String[] data = this.getResources().getStringArray(
				R.array.spinnerData);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, data);
		spinner.setAdapter(adapter);

		// ��������
		ImageView imageView = (ImageView) findViewById(R.id.imageView1);
		// ���ñ���ͼ
		imageView.setBackgroundResource(R.drawable.test_anim);
		// ����AnimationDrawable����
		final AnimationDrawable anim = (AnimationDrawable) imageView
				.getBackground();
		anim.stop();
		anim.start();
		// ImageView ���õ���¼���ʱ�� ��������
		imageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				anim.stop(); // ������Ҫ������ֹͣ
				v.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						Toast.makeText(MainActivity.this,
								"�ұ������" + v.getContentDescription(),
								Toast.LENGTH_SHORT).show();
					}
				});
				anim.start(); // Ȼ��ʼ����
			}
		});
		
		
		/**
		 * ����Ч������
		 */
		 imageView2 = (ImageView) findViewById(R.id.imageView2);  
	        //ͼƬ�����ʱ����������Ч��    
		 imageView2.setOnClickListener(new OnClickListener() {  
	  
	            @Override  
	            public void onClick(View v) {  
	                //AnimationSet����һ��Animation���ϣ�����������Animation��  
	                //����AnimationSet�����õ��������������������Animation��  
	                //����true ����@Interpolator  
	                AnimationSet set = new AnimationSet(true);  
	  
	                //͸��  
	                Animation alphaAnim = getAlphaAnimation();  
	                set.addAnimation(alphaAnim);  
	  
	                //����  
	                Animation scalegetAnim = getScaleAnimation();  
	                set.addAnimation(scalegetAnim);  
	  
	                //��ת  
	                Animation rotateAnim = getRotateAnimation();  
	                set.addAnimation(rotateAnim);  
	  
	                //�ƶ� ��������������ͬʱ���еģ���������Ҫ���ƶ��������������Ķ���֮��ִ��  
	                //��Ҫʹ��setStartOffset ���ö�����ʼ��ʱ��  
	                Animation translateAnim = getTranslateAnimation();  
	                translateAnim.setStartOffset(500);  
	                set.addAnimation(translateAnim);  
	  
	                v.startAnimation(set);  
	            }  
	        });  
	  
	}
	
	 /** 
     * ͸��Ч�� 
     * @return 
     */  
    public Animation getAlphaAnimation() {  
        //ʵ���� AlphaAnimation ��Ҫ�Ǹı�͸����  
        //͸���� �� 1-��͸�� 0-��ȫ͸��   
        Animation animation = new AlphaAnimation(1.0f, 0.8f);  
        //���ö�����ֵ�� ���������ζ���Ч��,���嶯���ı仯��   
        animation.setInterpolator(new DecelerateInterpolator());  
        //���ö���ִ��ʱ��  
        animation.setDuration(1000);  
        return animation;  
    }  
  
    /** 
     * ���Ŷ��� 
     * @return 
     */  
    public Animation getScaleAnimation() {  
        //ʵ���� ScaleAnimation ��Ҫ������Ч��  
        //������fromX-������ʼǰ��x����   toX-����������x����  
        //fromY-������ʼǰ��Y����  toY-����������Y����  
        //pivotXType - Ϊ��������������X����Ĳ�����   pivotXValue - ֵ  
        //pivotYType - Ϊ��������������Y����Ĳ�����   pivotYValue - ֵ  
        Animation animation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f,  
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,  
                0.5f);  
        //���ö�����ֵ�� ���������ζ���Ч��,���嶯���ı仯��   
        animation.setInterpolator(new DecelerateInterpolator());  
        //���ö���ִ��ʱ��  
        animation.setDuration(1000);  
        return animation;  
    }  
  
    /** 
     * ��ת 
     * @return 
     */  
    public Animation getRotateAnimation() {  
        //ʵ����RotateAnimation  
        //����������ΪԲ�ģ���ת360��  ��ֵΪ˳ʱ����ת����ֵΪ��ʱ����ת  
        RotateAnimation animation = new RotateAnimation(0, 360,  
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,  
                0.5f);  
        //���ö�����ֵ�� ���������ζ���Ч��,���嶯���ı仯��   
        animation.setInterpolator(new DecelerateInterpolator());  
        //���ö���ִ��ʱ��  
        animation.setDuration(1000);  
        return animation;  
    }  
  
    /** 
     * �ƶ� 
     * @return 
     */  
    public Animation getTranslateAnimation() {  
    	 //������Ϊ����ϵ�ͳ��ȵ�λ����(0,0)�ƶ���(1,1)  
        TranslateAnimation animation = new TranslateAnimation(  
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,  
                1.0f, Animation.RELATIVE_TO_SELF, 0.0f,  
                Animation.RELATIVE_TO_SELF, 1.0f);  
        //���ö�����ֵ�� ���������ζ���Ч��,���嶯���ı仯��   
        animation.setInterpolator(new DecelerateInterpolator());  
        //�����ظ�����  
        animation.setRepeatCount(2);   
        //���ö���ִ��ʱ��  
        animation.setDuration(1000);  
        //���ü�����  
        animation.setAnimationListener(new AnimationListener() {  
              
            @Override  
            public void onAnimationStart(Animation animation) {  
                //������ʼǰ  
                Toast.makeText(getBaseContext(), "Strart!", Toast.LENGTH_SHORT).show();    
            }  
              
            @Override  
            public void onAnimationRepeat(Animation animation) {  
                //�ظ�������ʱ��  
                Toast.makeText(getBaseContext(), "Repeat!", Toast.LENGTH_SHORT).show();    
            }  
              
            @Override  
            public void onAnimationEnd(Animation animation) {  
                // ����������ʱ��  
                Toast.makeText(getBaseContext(), "End!", Toast.LENGTH_SHORT).show();   
                //�����������������
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
