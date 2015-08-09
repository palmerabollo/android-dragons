package es.guido;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class RandomAnimation extends Animation {
	private View view;
	private DisplayMetrics screenMetrics;
	
	public RandomAnimation(View view, DisplayMetrics screenMetrics) {
		this.view = view;
		this.screenMetrics = screenMetrics;
	}
	
	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t) {
		 // left, top, right, bottom
		view.layout(
				(int) (interpolatedTime * (screenMetrics.widthPixels - view.getWidth())),
				100,
				(int) (interpolatedTime * (screenMetrics.widthPixels - view.getWidth())) + view.getWidth(),
				100 + view.getHeight());
		super.applyTransformation(interpolatedTime, t);
	}
}
