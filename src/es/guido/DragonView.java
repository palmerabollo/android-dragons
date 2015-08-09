package es.guido;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class DragonView extends RelativeLayout {
	private AnimatedImageView imageDragon;
	private RandomAnimation moveAnimation;
	
    public DragonView(Context context) {
        super(context);
		
		// layout
        imageDragon = new AnimatedImageView(context);
        imageDragon.setBackgroundResource(R.drawable.animation);
        
        android.widget.LinearLayout.LayoutParams params = new android.widget.LinearLayout.LayoutParams(100, 100);
        imageDragon.setLayoutParams(params);
        addView(imageDragon);
        
        imageDragon.post(new Runnable() {
			@Override
			public void run() {
				imageDragon.animate();
			}
		});
		
        // screen metrics
        DisplayMetrics metrics = new DisplayMetrics();
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		wm.getDefaultDisplay().getMetrics(metrics);
		
		// screen move animation
		moveAnimation = new RandomAnimation(imageDragon, metrics);
		moveAnimation.setDuration(5000);
		moveAnimation.setRepeatCount(Animation.INFINITE);
		moveAnimation.setRepeatMode(Animation.REVERSE);
    
		imageDragon.startAnimation(moveAnimation);
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	float x = event.getX();
    	float y = event.getY();
    	
    	boolean dragonHit =  x >= imageDragon.getLeft()
    			&& x <= imageDragon.getRight()
    			&& y >= imageDragon.getTop()
    			&& y <= imageDragon.getBottom();
    			
		if (dragonHit) {
			Toast.makeText(getContext(), "HIT", Toast.LENGTH_SHORT).show();
		}
    	
        return true;
    }
}