package graficos.primitivas;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.lang.Math;

public class Line{

	public void drawLine(float xi, float yi, int xf, int yf, Color c, BufferedImage image, Pixel pixel){
		float b, m, dx, dy, xinc, yinc, step, rx, ry;
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

	public void drawLineThickness(int xi, int yi, int xf, int yf, int grosor, Color c, BufferedImage image, Pixel pixel){
        boolean impar;
        
        if((grosor%2) == 0)
            impar = false;
        else
            impar = true;

        int repeticiones = grosor/2;
        drawLine(xi, yi, xf, yf, c, image, pixel);
        float dy = yi-yf;
        if(Math.abs(dy) == 0){
            for (int i=1; i<=repeticiones; i++) {
                drawLine(xi, yi+i, xf, yf+i, c, image, pixel);
                drawLine(xi, yi-i, xf, yf-i, c, image, pixel);
            }
            if(impar){
                repeticiones+=1;
                drawLine(xi, yi+repeticiones, xf, yf+repeticiones, c, image, pixel);
            }
        }

        float dx = xi-xf;
        if(dy != 0){
            for (int i=1; i<=repeticiones; i++) {
                drawLine(xi+i, yi, xf+i, yf, c, image, pixel);
                drawLine(xi-i, yi, xf-i, yf, c, image, pixel);
            }
            if(impar){
                repeticiones+=1;
                drawLine(xi+repeticiones, yi, xf+repeticiones, yf, c, image, pixel);
            }
        }
    }
}