package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class BlurFilter implements Filter {

	public Picture process(Picture original) {
		Picture processed = new Picture(original.width(), original.height());
	
		for (int i = 0; i < original.width(); i++) {
			for (int j = 0; j < original.height(); j++) {
				// top row
				if (j == 0) {
					// left most column
					if (i == 0) {
						int r1 = getWeight(original.get(i, j).getRed(), 8); // center pixel Red
						int r2 = getWeight(original.get(i + 1, j).getRed(), 3); // right pixel Red
						int r3 = getWeight(original.get(i, j + 1).getRed(), 3); // bottom pixel Red
						int newRed = (r1 + r2 + r3) / 14;
						
						int g1 = getWeight(original.get(i, j).getGreen(), 8); // center pixel Green
						int g2 = getWeight(original.get(i + 1, j).getGreen(), 3); // right pixel Green
						int g3 = getWeight(original.get(i, j + 1).getGreen(), 3); // bottom pixel Green
						int newGreen = (g1 + g2 + g3) / 14;

						int b1 = getWeight(original.get(i, j).getBlue(), 8); // center pixel blue
						int b2 = getWeight(original.get(i + 1, j).getBlue(), 3); // right pixel blue
						int b3 = getWeight(original.get(i, j + 1).getBlue(), 3); // bottom pixel blue
						int newBlue = (b1 + b2 + b3) / 14;
						
						processed.set(i, j, new Color(newRed, newGreen, newBlue));
					}
					// right most column
					else if (i == original.width() - 1) {
						int r1 = getWeight(original.get(i, j).getRed(), 8); // center pixel red
						int r2 = getWeight(original.get(i - 1, j).getRed(), 3); // left pixel red
						int r3 = getWeight(original.get(i, j + 1).getRed(), 3); // bottom pixel red
						int newRed = (r1 + r2 + r3) / 14;
						
						int g1 = getWeight(original.get(i, j).getGreen(), 8); // center pixel green
						int g2 = getWeight(original.get(i - 1, j).getGreen(), 3); // left pixel green
						int g3 = getWeight(original.get(i, j + 1).getGreen(), 3); // bottom pixel green
						int newGreen = (g1 + g2 + g3) / 14;
						
						int b1 = getWeight(original.get(i, j).getBlue(), 8); // center pixel blue
						int b2 = getWeight(original.get(i - 1, j).getBlue(), 3); // left pixel blue
						int b3 = getWeight(original.get(i, j + 1).getBlue(), 3); // bottom pixel blue
						int newBlue = (b1 + b2 + b3) / 14;
						
						processed.set(i, j, new Color(newRed, newGreen, newBlue));
					}
					// center columns
					else {
						int r1 = getWeight(original.get(i, j).getRed(), 8); // center pixel red
						int r2 = getWeight(original.get(i - 1, j).getRed(), 3); // left pixel red
						int r3 = getWeight(original.get(i, j + 1).getRed(), 3); // bottom pixel red
						int r4 = getWeight(original.get(i + 1, j).getRed(), 3); // right pixel red
						int newRed = (r1 + r2 + r3 + r4) / 17;
						
						int g1 = getWeight(original.get(i, j).getGreen(), 8); // center pixel green
						int g2 = getWeight(original.get(i - 1, j).getGreen(), 3); // left pixel green
						int g3 = getWeight(original.get(i, j + 1).getGreen(), 3); // bottom pixel green
						int g4 = getWeight(original.get(i + 1, j).getGreen(), 3); // right pixel green
						int newGreen = (g1 + g2 + g3 + g4) / 17;
						
						int b1 = getWeight(original.get(i, j).getBlue(), 8); // center pixel blue
						int b2 = getWeight(original.get(i - 1, j).getBlue(), 3); // left pixel blue
						int b3 = getWeight(original.get(i, j + 1).getBlue(), 3); // bottom pixel blue
						int b4 = getWeight(original.get(i + 1,  j).getBlue(), 3); // right pixel blue
						int newBlue = (b1 + b2 + b3 + b4) / 17;
						
						processed.set(i, j, new Color(newRed, newGreen, newBlue));
					}
					
				}
				
				// bottom row
				else if (j == original.height() - 1) {
					// left most column
					if (i == 0) {
						int r1 = getWeight(original.get(i, j).getRed(), 8); // center pixel Red
						int r2 = getWeight(original.get(i + 1, j).getRed(), 3); // right pixel Red
						int r3 = getWeight(original.get(i, j - 1).getRed(), 3); // top pixel Red
						int newRed = (r1 + r2 + r3) / 14;
						
						int g1 = getWeight(original.get(i, j).getGreen(), 8); // center pixel Green
						int g2 = getWeight(original.get(i + 1, j).getGreen(), 3); // right pixel Green
						int g3 = getWeight(original.get(i, j - 1).getGreen(), 3); // top pixel Green
						int newGreen = (g1 + g2 + g3) / 14;

						int b1 = getWeight(original.get(i, j).getBlue(), 8); // center pixel blue
						int b2 = getWeight(original.get(i + 1, j).getBlue(), 3); // right pixel blue
						int b3 = getWeight(original.get(i, j - 1).getBlue(), 3); // top pixel blue
						int newBlue = (b1 + b2 + b3) / 14;
						
						processed.set(i, j, new Color(newRed, newGreen, newBlue));
					}
					// right most column
					else if (i == original.width() - 1) {
						int r1 = getWeight(original.get(i, j).getRed(), 8); // center pixel red
						int r2 = getWeight(original.get(i - 1, j).getRed(), 3); // left pixel red
						int r3 = getWeight(original.get(i, j - 1).getRed(), 3); // top pixel red
						int newRed = (r1 + r2 + r3) / 14;
						
						int g1 = getWeight(original.get(i, j).getGreen(), 8); // center pixel green
						int g2 = getWeight(original.get(i - 1, j).getGreen(), 3); // left pixel green
						int g3 = getWeight(original.get(i, j - 1).getGreen(), 3); // top pixel green
						int newGreen = (g1 + g2 + g3) / 14;
						
						int b1 = getWeight(original.get(i, j).getBlue(), 8); // center pixel blue
						int b2 = getWeight(original.get(i - 1, j).getBlue(), 3); // left pixel blue
						int b3 = getWeight(original.get(i, j - 1).getBlue(), 3); // top pixel blue
						int newBlue = (b1 + b2 + b3) / 14;
						
						processed.set(i, j, new Color(newRed, newGreen, newBlue));
					}
					// center columns
					else {
						int r1 = getWeight(original.get(i, j).getRed(), 8); // center pixel red
						int r2 = getWeight(original.get(i - 1, j).getRed(), 3); // left pixel red
						int r3 = getWeight(original.get(i, j - 1).getRed(), 3); // top pixel red
						int r4 = getWeight(original.get(i + 1, j).getRed(), 3); // right pixel red
						int newRed = (r1 + r2 + r3 + r4) / 17;
						
						int g1 = getWeight(original.get(i, j).getGreen(), 8); // center pixel green
						int g2 = getWeight(original.get(i - 1, j).getGreen(), 3); // left pixel green
						int g3 = getWeight(original.get(i, j - 1).getGreen(), 3); // top pixel green
						int g4 = getWeight(original.get(i + 1, j).getGreen(), 3); // right pixel green
						int newGreen = (g1 + g2 + g3 + g4) / 17;
						
						int b1 = getWeight(original.get(i, j).getBlue(), 8); // center pixel blue
						int b2 = getWeight(original.get(i - 1, j).getBlue(), 3); // left pixel blue
						int b3 = getWeight(original.get(i, j - 1).getBlue(), 3); // top pixel blue
						int b4 = getWeight(original.get(i + 1,  j).getBlue(), 3); // right pixel blue
						int newBlue = (b1 + b2 + b3 + b4) / 17;
						
						processed.set(i, j, new Color(newRed, newGreen, newBlue));
					}
				}
				else {
					// left most column
					if (i == 0) {
						int r1 = getWeight(original.get(i, j).getRed(), 8); // center pixel Red
						int r2 = getWeight(original.get(i + 1, j).getRed(), 3); // right pixel Red
						int r3 = getWeight(original.get(i, j - 1).getRed(), 3); // top pixel Red
						int r4 = getWeight(original.get(i, j + 1).getRed(), 3); // bottom pixel Red
						int newRed = (r1 + r2 + r3) / 17;
						
						int g1 = getWeight(original.get(i, j).getGreen(), 8); // center pixel Green
						int g2 = getWeight(original.get(i + 1, j).getGreen(), 3); // right pixel Green
						int g3 = getWeight(original.get(i, j - 1).getGreen(), 3); // top pixel Green
						int g4 = getWeight(original.get(i, j + 1).getGreen(), 3); // bottom pixel Green
						int newGreen = (g1 + g2 + g3 + g4) / 17;

						int b1 = getWeight(original.get(i, j).getBlue(), 8); // center pixel blue
						int b2 = getWeight(original.get(i + 1, j).getBlue(), 3); // right pixel blue
						int b3 = getWeight(original.get(i, j - 1).getBlue(), 3); // top pixel blue
						int b4 = getWeight(original.get(i, j + 1).getBlue(), 3); // bottom pixel blue
						int newBlue = (b1 + b2 + b3 + b4) / 17;
						
						processed.set(i, j, new Color(newRed, newGreen, newBlue));
					}
					// right most column
					else if (i == original.width() - 1) {
						int r1 = getWeight(original.get(i, j).getRed(), 8); // center pixel red
						int r2 = getWeight(original.get(i - 1, j).getRed(), 3); // left pixel red
						int r3 = getWeight(original.get(i, j - 1).getRed(), 3); // top pixel red
						int r4 = getWeight(original.get(i, j + 1).getRed(), 3); // bottom pixel Red
						int newRed = (r1 + r2 + r3 + r4) / 17;
						
						int g1 = getWeight(original.get(i, j).getGreen(), 8); // center pixel green
						int g2 = getWeight(original.get(i - 1, j).getGreen(), 3); // left pixel green
						int g3 = getWeight(original.get(i, j - 1).getGreen(), 3); // top pixel green
						int g4 = getWeight(original.get(i, j + 1).getGreen(), 3); // bottom pixel Green
						int newGreen = (g1 + g2 + g3 + g4) / 17;
						
						int b1 = getWeight(original.get(i, j).getBlue(), 8); // center pixel blue
						int b2 = getWeight(original.get(i - 1, j).getBlue(), 3); // left pixel blue
						int b3 = getWeight(original.get(i, j - 1).getBlue(), 3); // top pixel blue
						int b4 = getWeight(original.get(i, j + 1).getBlue(), 3); // bottom pixel blue
						int newBlue = (b1 + b2 + b3 + b4) / 17;
						
						processed.set(i, j, new Color(newRed, newGreen, newBlue));
					}
					// center columns
					else {
						int r1 = getWeight(original.get(i, j).getRed(), 8); // center pixel red
						int r2 = getWeight(original.get(i - 1, j).getRed(), 3); // left pixel red
						int r3 = getWeight(original.get(i, j - 1).getRed(), 3); // top pixel red
						int r4 = getWeight(original.get(i + 1, j).getRed(), 3); // right pixel red
						int r5 = getWeight(original.get(i, j + 1).getRed(), 3); // bottom pixel Red
						int newRed = (r1 + r2 + r3 + r4 + r5) / 20;
						
						int g1 = getWeight(original.get(i, j).getGreen(), 8); // center pixel green
						int g2 = getWeight(original.get(i - 1, j).getGreen(), 3); // left pixel green
						int g3 = getWeight(original.get(i, j - 1).getGreen(), 3); // top pixel green
						int g4 = getWeight(original.get(i + 1, j).getGreen(), 3); // right pixel green
						int g5 = getWeight(original.get(i, j + 1).getGreen(), 3); // bottom pixel Green
						int newGreen = (g1 + g2 + g3 + g4 + g5) / 20;
						
						int b1 = getWeight(original.get(i, j).getBlue(), 8); // center pixel blue
						int b2 = getWeight(original.get(i - 1, j).getBlue(), 3); // left pixel blue
						int b3 = getWeight(original.get(i, j - 1).getBlue(), 3); // top pixel blue
						int b4 = getWeight(original.get(i + 1,  j).getBlue(), 3); // right pixel blue
						int b5 = getWeight(original.get(i, j + 1).getBlue(), 3); // bottom pixel blue
						int newBlue = (b1 + b2 + b3 + b4 + b5) / 20;
						
						processed.set(i, j, new Color(newRed, newGreen, newBlue));
					}

				}

			}
		}
		return processed;
	}
	
	public int getWeight(int val, int weight) {
		return val * weight;
	}

}
