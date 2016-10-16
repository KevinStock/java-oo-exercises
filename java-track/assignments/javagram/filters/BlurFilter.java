package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class BlurFilter implements Filter {

	public Picture process(Picture original) {
		Picture processed = new Picture(original.width(), original.height());
		int primaryWt = 8;
		int secondaryWt = 3;
	
		for (int i = 0; i < original.width(); i++) {
			for (int j = 0; j < original.height(); j++) {
				// top row
				if (j == 0) {
					// left most column
					if (i == 0) {
						int totalWt = primaryWt + (secondaryWt * 2);
						int r1 = getWeight(original.get(i, j).getRed(), primaryWt); // center pixel Red
						int r2 = getWeight(original.get(i + 1, j).getRed(), secondaryWt); // right pixel Red
						int r3 = getWeight(original.get(i, j + 1).getRed(), secondaryWt); // bottom pixel Red
						int newRed = (r1 + r2 + r3) / totalWt;
						
						int g1 = getWeight(original.get(i, j).getGreen(), primaryWt); // center pixel Green
						int g2 = getWeight(original.get(i + 1, j).getGreen(), secondaryWt); // right pixel Green
						int g3 = getWeight(original.get(i, j + 1).getGreen(), secondaryWt); // bottom pixel Green
						int newGreen = (g1 + g2 + g3) / totalWt;

						int b1 = getWeight(original.get(i, j).getBlue(), primaryWt); // center pixel blue
						int b2 = getWeight(original.get(i + 1, j).getBlue(), secondaryWt); // right pixel blue
						int b3 = getWeight(original.get(i, j + 1).getBlue(), secondaryWt); // bottom pixel blue
						int newBlue = (b1 + b2 + b3) / totalWt;
						
						processed.set(i, j, new Color(newRed, newGreen, newBlue));
					}
					// right most column
					else if (i == original.width() - 1) {
						int totalWt = primaryWt + (secondaryWt * 2);
						int r1 = getWeight(original.get(i, j).getRed(), primaryWt); // center pixel red
						int r2 = getWeight(original.get(i - 1, j).getRed(), secondaryWt); // left pixel red
						int r3 = getWeight(original.get(i, j + 1).getRed(), secondaryWt); // bottom pixel red
						int newRed = (r1 + r2 + r3) / totalWt;
						
						int g1 = getWeight(original.get(i, j).getGreen(), primaryWt); // center pixel green
						int g2 = getWeight(original.get(i - 1, j).getGreen(), secondaryWt); // left pixel green
						int g3 = getWeight(original.get(i, j + 1).getGreen(), secondaryWt); // bottom pixel green
						int newGreen = (g1 + g2 + g3) / totalWt;
						
						int b1 = getWeight(original.get(i, j).getBlue(), primaryWt); // center pixel blue
						int b2 = getWeight(original.get(i - 1, j).getBlue(), secondaryWt); // left pixel blue
						int b3 = getWeight(original.get(i, j + 1).getBlue(), secondaryWt); // bottom pixel blue
						int newBlue = (b1 + b2 + b3) / totalWt;
						
						processed.set(i, j, new Color(newRed, newGreen, newBlue));
					}
					// center columns
					else {
						int totalWt = primaryWt + (secondaryWt * 3);
						int r1 = getWeight(original.get(i, j).getRed(), primaryWt); // center pixel red
						int r2 = getWeight(original.get(i - 1, j).getRed(), secondaryWt); // left pixel red
						int r3 = getWeight(original.get(i, j + 1).getRed(), secondaryWt); // bottom pixel red
						int r4 = getWeight(original.get(i + 1, j).getRed(), secondaryWt); // right pixel red
						int newRed = (r1 + r2 + r3 + r4) / totalWt;
						
						int g1 = getWeight(original.get(i, j).getGreen(), primaryWt); // center pixel green
						int g2 = getWeight(original.get(i - 1, j).getGreen(), secondaryWt); // left pixel green
						int g3 = getWeight(original.get(i, j + 1).getGreen(), secondaryWt); // bottom pixel green
						int g4 = getWeight(original.get(i + 1, j).getGreen(), secondaryWt); // right pixel green
						int newGreen = (g1 + g2 + g3 + g4) / totalWt;
						
						int b1 = getWeight(original.get(i, j).getBlue(), primaryWt); // center pixel blue
						int b2 = getWeight(original.get(i - 1, j).getBlue(), secondaryWt); // left pixel blue
						int b3 = getWeight(original.get(i, j + 1).getBlue(), secondaryWt); // bottom pixel blue
						int b4 = getWeight(original.get(i + 1,  j).getBlue(), secondaryWt); // right pixel blue
						int newBlue = (b1 + b2 + b3 + b4) / totalWt;
						
						processed.set(i, j, new Color(newRed, newGreen, newBlue));
					}
					
				}
				
				// bottom row
				else if (j == original.height() - 1) {
					// left most column
					if (i == 0) {
						int totalWt = primaryWt + (secondaryWt * 2);
						int r1 = getWeight(original.get(i, j).getRed(), primaryWt); // center pixel Red
						int r2 = getWeight(original.get(i + 1, j).getRed(), secondaryWt); // right pixel Red
						int r3 = getWeight(original.get(i, j - 1).getRed(), secondaryWt); // top pixel Red
						int newRed = (r1 + r2 + r3) / totalWt;
						
						int g1 = getWeight(original.get(i, j).getGreen(), primaryWt); // center pixel Green
						int g2 = getWeight(original.get(i + 1, j).getGreen(), secondaryWt); // right pixel Green
						int g3 = getWeight(original.get(i, j - 1).getGreen(), secondaryWt); // top pixel Green
						int newGreen = (g1 + g2 + g3) / totalWt;

						int b1 = getWeight(original.get(i, j).getBlue(), primaryWt); // center pixel blue
						int b2 = getWeight(original.get(i + 1, j).getBlue(), secondaryWt); // right pixel blue
						int b3 = getWeight(original.get(i, j - 1).getBlue(), secondaryWt); // top pixel blue
						int newBlue = (b1 + b2 + b3) / totalWt;
						
						processed.set(i, j, new Color(newRed, newGreen, newBlue));
					}
					// right most column
					else if (i == original.width() - 1) {
						int totalWt = primaryWt + (secondaryWt * 2);
						int r1 = getWeight(original.get(i, j).getRed(), primaryWt); // center pixel red
						int r2 = getWeight(original.get(i - 1, j).getRed(), secondaryWt); // left pixel red
						int r3 = getWeight(original.get(i, j - 1).getRed(), secondaryWt); // top pixel red
						int newRed = (r1 + r2 + r3) / totalWt;
						
						int g1 = getWeight(original.get(i, j).getGreen(), primaryWt); // center pixel green
						int g2 = getWeight(original.get(i - 1, j).getGreen(), secondaryWt); // left pixel green
						int g3 = getWeight(original.get(i, j - 1).getGreen(), secondaryWt); // top pixel green
						int newGreen = (g1 + g2 + g3) / totalWt;
						
						int b1 = getWeight(original.get(i, j).getBlue(), primaryWt); // center pixel blue
						int b2 = getWeight(original.get(i - 1, j).getBlue(), secondaryWt); // left pixel blue
						int b3 = getWeight(original.get(i, j - 1).getBlue(), secondaryWt); // top pixel blue
						int newBlue = (b1 + b2 + b3) / totalWt;
						
						processed.set(i, j, new Color(newRed, newGreen, newBlue));
					}
					// center columns
					else {
						int totalWt = primaryWt + (secondaryWt * 3);
						int r1 = getWeight(original.get(i, j).getRed(), primaryWt); // center pixel red
						int r2 = getWeight(original.get(i - 1, j).getRed(), secondaryWt); // left pixel red
						int r3 = getWeight(original.get(i, j - 1).getRed(), secondaryWt); // top pixel red
						int r4 = getWeight(original.get(i + 1, j).getRed(), secondaryWt); // right pixel red
						int newRed = (r1 + r2 + r3 + r4) / totalWt;
						
						int g1 = getWeight(original.get(i, j).getGreen(), primaryWt); // center pixel green
						int g2 = getWeight(original.get(i - 1, j).getGreen(), secondaryWt); // left pixel green
						int g3 = getWeight(original.get(i, j - 1).getGreen(), secondaryWt); // top pixel green
						int g4 = getWeight(original.get(i + 1, j).getGreen(), secondaryWt); // right pixel green
						int newGreen = (g1 + g2 + g3 + g4) / totalWt;
						
						int b1 = getWeight(original.get(i, j).getBlue(), primaryWt); // center pixel blue
						int b2 = getWeight(original.get(i - 1, j).getBlue(), secondaryWt); // left pixel blue
						int b3 = getWeight(original.get(i, j - 1).getBlue(), secondaryWt); // top pixel blue
						int b4 = getWeight(original.get(i + 1,  j).getBlue(), secondaryWt); // right pixel blue
						int newBlue = (b1 + b2 + b3 + b4) / totalWt;
						
						processed.set(i, j, new Color(newRed, newGreen, newBlue));
					}
				}
				else {
					// left most column
					if (i == 0) {
						int totalWt = primaryWt + (secondaryWt * 3);
						int r1 = getWeight(original.get(i, j).getRed(), primaryWt); // center pixel Red
						int r2 = getWeight(original.get(i + 1, j).getRed(), secondaryWt); // right pixel Red
						int r3 = getWeight(original.get(i, j - 1).getRed(), secondaryWt); // top pixel Red
						int r4 = getWeight(original.get(i, j + 1).getRed(), secondaryWt); // bottom pixel Red
						int newRed = (r1 + r2 + r3 + r4) / totalWt;
						
						int g1 = getWeight(original.get(i, j).getGreen(), primaryWt); // center pixel Green
						int g2 = getWeight(original.get(i + 1, j).getGreen(), secondaryWt); // right pixel Green
						int g3 = getWeight(original.get(i, j - 1).getGreen(), secondaryWt); // top pixel Green
						int g4 = getWeight(original.get(i, j + 1).getGreen(), secondaryWt); // bottom pixel Green
						int newGreen = (g1 + g2 + g3 + g4) / totalWt;

						int b1 = getWeight(original.get(i, j).getBlue(), primaryWt); // center pixel blue
						int b2 = getWeight(original.get(i + 1, j).getBlue(), secondaryWt); // right pixel blue
						int b3 = getWeight(original.get(i, j - 1).getBlue(), secondaryWt); // top pixel blue
						int b4 = getWeight(original.get(i, j + 1).getBlue(), secondaryWt); // bottom pixel blue
						int newBlue = (b1 + b2 + b3 + b4) / totalWt;
						
						processed.set(i, j, new Color(newRed, newGreen, newBlue));
					}
					// right most column
					else if (i == original.width() - 1) {
						int totalWt = primaryWt + (secondaryWt * 3);
						int r1 = getWeight(original.get(i, j).getRed(), primaryWt); // center pixel red
						int r2 = getWeight(original.get(i - 1, j).getRed(), secondaryWt); // left pixel red
						int r3 = getWeight(original.get(i, j - 1).getRed(), secondaryWt); // top pixel red
						int r4 = getWeight(original.get(i, j + 1).getRed(), secondaryWt); // bottom pixel Red
						int newRed = (r1 + r2 + r3 + r4) / totalWt;
						
						int g1 = getWeight(original.get(i, j).getGreen(), primaryWt); // center pixel green
						int g2 = getWeight(original.get(i - 1, j).getGreen(), secondaryWt); // left pixel green
						int g3 = getWeight(original.get(i, j - 1).getGreen(), secondaryWt); // top pixel green
						int g4 = getWeight(original.get(i, j + 1).getGreen(), secondaryWt); // bottom pixel Green
						int newGreen = (g1 + g2 + g3 + g4) / totalWt;
						
						int b1 = getWeight(original.get(i, j).getBlue(), primaryWt); // center pixel blue
						int b2 = getWeight(original.get(i - 1, j).getBlue(), secondaryWt); // left pixel blue
						int b3 = getWeight(original.get(i, j - 1).getBlue(), secondaryWt); // top pixel blue
						int b4 = getWeight(original.get(i, j + 1).getBlue(), secondaryWt); // bottom pixel blue
						int newBlue = (b1 + b2 + b3 + b4) / totalWt;
						
						processed.set(i, j, new Color(newRed, newGreen, newBlue));
					}
					// center columns
					else {
						int totalWt = primaryWt + (secondaryWt * 4);
						int r1 = getWeight(original.get(i, j).getRed(), primaryWt); // center pixel red
						int r2 = getWeight(original.get(i - 1, j).getRed(), secondaryWt); // left pixel red
						int r3 = getWeight(original.get(i, j - 1).getRed(), secondaryWt); // top pixel red
						int r4 = getWeight(original.get(i + 1, j).getRed(), secondaryWt); // right pixel red
						int r5 = getWeight(original.get(i, j + 1).getRed(), secondaryWt); // bottom pixel Red
						int newRed = (r1 + r2 + r3 + r4 + r5) / totalWt;
						
						int g1 = getWeight(original.get(i, j).getGreen(), primaryWt); // center pixel green
						int g2 = getWeight(original.get(i - 1, j).getGreen(), secondaryWt); // left pixel green
						int g3 = getWeight(original.get(i, j - 1).getGreen(), secondaryWt); // top pixel green
						int g4 = getWeight(original.get(i + 1, j).getGreen(), secondaryWt); // right pixel green
						int g5 = getWeight(original.get(i, j + 1).getGreen(), secondaryWt); // bottom pixel Green
						int newGreen = (g1 + g2 + g3 + g4 + g5) / totalWt;
						
						int b1 = getWeight(original.get(i, j).getBlue(), primaryWt); // center pixel blue
						int b2 = getWeight(original.get(i - 1, j).getBlue(), secondaryWt); // left pixel blue
						int b3 = getWeight(original.get(i, j - 1).getBlue(), secondaryWt); // top pixel blue
						int b4 = getWeight(original.get(i + 1,  j).getBlue(), secondaryWt); // right pixel blue
						int b5 = getWeight(original.get(i, j + 1).getBlue(), secondaryWt); // bottom pixel blue
						int newBlue = (b1 + b2 + b3 + b4 + b5) / totalWt;
						
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
