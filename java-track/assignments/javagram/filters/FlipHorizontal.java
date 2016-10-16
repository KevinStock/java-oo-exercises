package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class FlipHorizontal implements Filter {
	
	public Picture process(Picture original) {
		
		Picture processed = new Picture(original.width(), original.height());
		
		for (int i = 0; i < original.width(); i++) {
			for (int j = 0; j < original.height(); j++) {

				int otherX = original.width() - 1 - i;  // otherX is the mirror of x
				Color c = original.get(otherX, j);      // get the Color at the mirror point of the source
				processed.set(i, j, c);                  // and set it at x,y in the target
			}
		}
		return processed;
	}
}
