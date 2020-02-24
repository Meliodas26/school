package graficos.primitivas;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.lang.Math;

public class Circle{

    public void circleThickness(int xc, int yc, int r, int grosor, Color c, BufferedImage image, Pixel pixel){
        double inc = Math.asin(1.0/r);
        double grados = 0;
        int x, y;
        int y1, y2, y3, x1, x2, x3;
        int grosorc = grosor;
        while(grados <= 2*Math.PI){
            x = xc + (int)(r * Math.sin(grados));
            y = yc + (int)(r * Math.cos(grados));
            pixel.drawPixel(x, y, c, image);
            for (int j = 1; j <= grosor; j++)
                pixel.drawPixel(x, y + j, c, image);
            for (int j = 1; j <= grosor; j++)
                pixel.drawPixel(x, y - j, c, image);
            for (int j = 1; j <= grosor; j++)
                  pixel.drawPixel(x + j, y, c, image);
            for (int j = 1; j <= grosor; j++)
                pixel.drawPixel(x - j, y, c, image);
            grados += inc;    
        }
    }
}