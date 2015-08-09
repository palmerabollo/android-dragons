package es.guido;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;

class AnimatedImageView extends ImageView {
    public AnimatedImageView(Context context) {
		super(context);
	}

    public void animate() {
    	AnimationDrawable animationDrawable = (AnimationDrawable) getBackground();
    	animationDrawable.start();
    }
}