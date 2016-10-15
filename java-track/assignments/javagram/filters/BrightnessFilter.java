package javagram.filters;

import java.awt.Color;
import javagram.Picture;

public class BrightnessFilter implements Filter {
	
	private int level;
	
	public BrightnessFilter(int level) {
		this.level = level;
	}
	
	public Picture process(Picture original) {
		
		Picture processed = new Picture(original.width(), original.height());
		
		for (int i = 0; i < original.width(); i++) {
			for (int j = 0; j < original.height(); j++) {
				Color c = original.get(i, j);
		    	//get color components from each pixel
		    	int r = c.getRed();
		    	int g = c.getGreen();
		    	int b = c.getBlue();
		    	
		    	int newR = 0;
		    	int newG = 0;
		    	int newB = 0;
		    	
		    	if (r + level <= 255) {
		    		newR = r + level;
		    	}
		    	else {
		    		newR = 255;
		    	}
		    	
		    	if (g + level <= 255) {
		    		newG = g + level;
		    	}
		    	else {
		    		newG = 255;
		    	}
		    	
		    	if (b + level <= 255) {
		    		newB = b + level;
		    	}
		    	else {
		    		newB = 255;
		    	}
		    	
		    	processed.set(i, j, new Color(newR, newG, newB));
			}
		}
		return processed;
	}
}
