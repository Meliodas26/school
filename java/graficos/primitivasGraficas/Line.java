package primitivasGraficas;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.lang.Math;

public class Line{

	private Pixel pixel = new Pixel();
	private float b, m, dx, dy, xinc, yinc, step, rx, ry;

	public void drawLine(int xi, int yi, int xf, int yf, Color c, BufferedImage image){
		dy = (yf-yi);
		dx = (xf-xi);
		pixel.drawPixel((int)xi, (int)yi, c, image);
		rx = Math.abs(dx);
		ry = Math.abs(dy);
		if(rx>ry)
			step = rx;
		else
			step = ry;
		xinc = dx/step;
		yinc = dy/step;
		for (int i=1; i<step; i++) {
			xi+=xinc;
			yi+=yinc;
			pixel.drawPixel(Math.round(xi), Math.round(yi), c, image);
		}
	}
}