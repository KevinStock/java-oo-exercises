package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class FlipVertical implements Filter {
	
	public Picture process(Picture original) {
		
		Picture processed = new Picture(original.width(), original.height());
		
		for (int i = 0; i < original.width(); i++) {
			for (int j = 0; j < original.height(); j++) {

				int otherY = original.height() - 1 - j;
				Color c = original.get(i,  otherY);
				processed.set(i, j, c);
			}
		}
		return processed;
	}
}
