import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import java.lang.Math;
import java.util.Random;
import java.util.ArrayList;  

public class Panel extends JPanel {
    private Soundtrack soundtrack   = new Soundtrack();
    
    private javax.swing.Timer t;
    private BufferedImage bullet = new BufferedImage(700,700, BufferedImage.TYPE_INT_ARGB);
    private BufferedImage fondo, logo, escudo, mjolnir, spiderman, red, capitan, thor, ironman, propulsoresM;
    private BufferedImage propulsoresP, fin, asteroide, vida;
    private BufferedImage [] bifrost = new BufferedImage[8];
    private BufferedImage [] estrellas = new BufferedImage[8];
    private int [][] px = new int[5][2000];
    private int [][] py = new int[5][2000];
    private BufferedImage buffer;
    private Graphics2D g2;
    private int i=0, cBifrost=0, aIronman=700, aPropulsoresP=700, aPropulsoresM=700, aSpiderman=125, cSpiderman=0;
    private int aEstrellas=0, aIronmanHorizontal=0, nAsteroide=1, nVida=100;
    private ArrayList <Integer> aAsteroideX = new ArrayList <Integer>();
    private ArrayList <Integer> aAsteroideY = new ArrayList <Integer>();
    private boolean flag=false, flagSpider=false, bfin=false, gameover=true;
    private Color c;
    private Colores cs = new Colores();
    private int exi,eyi,exf,epixeles;

    //Fin
    private int rx=100, ry=100, aFin=0;

    private int yUp     = ry;
    private int yDown   = ry; 
    private int xRight  = rx;
    private int xLeft   = rx;

    private Move move;

    public Panel(Move move){
        c=cs.negro;
        setBackground(c);
        buffer = new BufferedImage(1,1, BufferedImage.TYPE_INT_ARGB);
        this.move=move;
        t = new javax.swing.Timer(1, (ActionEvent ae) -> {
            repaint(); 
        });
    }  
    public void inicio(){
        t.start();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D)g;
        if(i==0){
            System.out.println("Dibijando graficos:");
            soundtrack.onEspera();
            //Las imagenes de bifrost las creo junto cuando las dibujo ya que va en un ciclo
            fondo = new BufferedImage(700,700, BufferedImage.TYPE_INT_ARGB);
            logo = new BufferedImage(700,700, BufferedImage.TYPE_INT_ARGB);
            escudo = new BufferedImage(41,39,BufferedImage.TYPE_INT_ARGB);
            mjolnir = new BufferedImage(23,39, BufferedImage.TYPE_INT_ARGB);
            spiderman = new BufferedImage(17,27, BufferedImage.TYPE_INT_ARGB);
            red = new BufferedImage(1,400, BufferedImage.TYPE_INT_ARGB);
            ironman = new BufferedImage(16,23, BufferedImage.TYPE_INT_ARGB);
            propulsoresP = new BufferedImage(3,2, BufferedImage.TYPE_INT_ARGB);
            propulsoresM = new BufferedImage(2,1, BufferedImage.TYPE_INT_ARGB);
            fin = new BufferedImage(200,200, BufferedImage.TYPE_INT_ARGB);;
            asteroide = new BufferedImage(25,25, BufferedImage.TYPE_INT_ARGB);
            vida = new BufferedImage(100,10, BufferedImage.TYPE_INT_ARGB);
            
            System.out.println("Fondo");
            for (int linea=0; linea<700; linea++)
                line(0,linea,700,linea,cs.negro);
            fondo = bullet;
            bullet = new BufferedImage(700,100, BufferedImage.TYPE_INT_ARGB);


            bullet = new BufferedImage(700,700, BufferedImage.TYPE_INT_ARGB);

            System.out.println("Logo");
            logo();
            logo = bullet;
            bullet = new BufferedImage(700,700, BufferedImage.TYPE_INT_ARGB);
            
            
            System.out.println("Bifrost");
            for (int j=0; j<8; j++) {
                System.out.println(8-j);
                bifrost[j] = new BufferedImage(700,700, BufferedImage.TYPE_INT_ARGB);  
                bifrost();
                bifrost[j] = bullet;
                bullet = new BufferedImage(700,700, BufferedImage.TYPE_INT_ARGB); 
            }
            
            
            System.out.println("Estrellas");
            for (int j=0; j<5; j++)
                estrellas[j] = new BufferedImage(700,700, BufferedImage.TYPE_INT_ARGB);
            estrellas();
            bullet = new BufferedImage(700,700, BufferedImage.TYPE_INT_ARGB);
            estrellas[0] = bullet;
            puntos();
            bullet = new BufferedImage(41,39,BufferedImage.TYPE_INT_ARGB);

            System.out.println("Escudo");
            escudo();
            escudo = bullet;
            bullet = new BufferedImage(23,39,BufferedImage.TYPE_INT_ARGB);

            System.out.println("Mjolnir");
            mjolnir();
            mjolnir = bullet;
            bullet = new BufferedImage(1,400,BufferedImage.TYPE_INT_ARGB); 

            System.out.println("Red");
            line(0,0,0,25,cs.blanco);
            red = bullet;
            bullet = new BufferedImage(17,27,BufferedImage.TYPE_INT_ARGB);

            System.out.println("Spiderman");
            spiderman();
            spiderman = bullet;
            bullet = new BufferedImage(16,23,BufferedImage.TYPE_INT_ARGB);

            System.out.println("Iron man");
            ironman();
            ironman = bullet;
            bullet = new BufferedImage(3,2,BufferedImage.TYPE_INT_ARGB);

            System.out.println("PropulsoresP");
            line(0,0,4,0,cs.celeste);
            drawPixel(1,1,cs.celeste);
            propulsoresP = bullet;

            bullet = new BufferedImage(2,1,BufferedImage.TYPE_INT_ARGB);
            System.out.println("PropulsoresM");
            drawPixel(0,0,cs.celeste);
            drawPixel(1,0,cs.celeste);
            propulsoresM = bullet;

            //Asteroide
            bullet = new BufferedImage(25,25,BufferedImage.TYPE_INT_ARGB);
            System.out.println("Asteroide");
            asteroide();
            asteroide = bullet;
            aAsteroideX.add(325);
            aAsteroideY.add(0);

            //Vida
            bullet = new BufferedImage(100,10,BufferedImage.TYPE_INT_ARGB);
            System.out.println("Barra de vida");
            vida();
            vida = bullet;
            
            
            //Para la red
            bullet = new BufferedImage(1,400,BufferedImage.TYPE_INT_ARGB); 

            System.out.print("Iniciando");
            for (int j=0; j<4; j++) {
                try{
                    Thread.sleep(1000);
                    if(j!=3)
                        System.out.print(".");
                }catch(Exception e){

                }
            }
            soundtrack.offEspera();
            soundtrack.onBifrost();
        }
        //System.out.println(i);
        //600
        if(i<600){
            g2.drawImage(bifrost[cBifrost],null,0,0);
            cBifrost = (int) (Math.random() * 7);
        }else{
            //Iron man llega al 343
            g2.drawImage(fondo,null,0,0);
            g2.drawImage(logo, null, 0, 0); 
            
            //checkpoint
            //1185
            aEstrellas = (int) (Math.random() * 4);
            g2.drawImage(estrellas[aEstrellas],null,0,0);
        
            g2.drawImage(escudo,null,225,150);
            g2.drawImage(mjolnir,null,150,225);

            g2.drawImage(red,null,200,120);
            g2.drawImage(spiderman,null,192,aSpiderman);
            if(i<1200){
                g2.drawImage(ironman,null,340,aIronman);
            }
            //Animacion Ironman
            if(aIronman<=683 && !flag){
                aPropulsoresM--;
                g2.drawImage(propulsoresM,null,339,aPropulsoresM);
                g2.drawImage(propulsoresM,null,354,aPropulsoresM);
            }
            if(aIronman<=678 && !flag){
                aPropulsoresP--;
                g2.drawImage(propulsoresP,null,341,aPropulsoresP);
                g2.drawImage(propulsoresP,null,351,aPropulsoresP);
            }
            
            if(aIronman>337 && !flag)
                aIronman--;
            if(aIronman == 337){
                flag=true;
            }

            if(flag && i<1080){
                g2.drawImage(propulsoresM,null,339,aPropulsoresM);
                g2.drawImage(propulsoresM,null,354,aPropulsoresM);
                g2.drawImage(propulsoresP,null,341,aPropulsoresP);
                g2.drawImage(propulsoresP,null,351,aPropulsoresP);
            }

            if(aIronman < 343 && flag && i>1080 && !bfin)
                aIronman++;

            //Animacion spiderman
            //Red
            if(i<1098){
                if(cSpiderman==0)
                    flagSpider=false;

                if(cSpiderman<125 && !flagSpider){
                    cSpiderman++;
                    line(0,0,0,25+cSpiderman,cs.blanco);
                    red = bullet;
                    aSpiderman ++;
                }
                if(cSpiderman==125 && !flagSpider)
                    flagSpider=true;
                
                if(flagSpider){
                    bullet = new BufferedImage(1,400, BufferedImage.TYPE_INT_ARGB);
                    red = new BufferedImage(1,400, BufferedImage.TYPE_INT_ARGB);
                    cSpiderman--;
                    line(0,0,0,25+cSpiderman,cs.blanco);
                    red = bullet;
                    aSpiderman --;
                }
            }
        }

        if(i == 1150){
            bfin=true;
            aIronmanHorizontal=340;
            soundtrack.onGame();
            System.out.println("\nJarvis: Cuidado!!!");
        }
        if(bfin){
            bullet = new BufferedImage(200,200,BufferedImage.TYPE_INT_ARGB);
            yUp++;
            yDown--;
            xRight++;
            xLeft--;
            drawPixel(xLeft, ry,        cs.celeste);
            drawPixel(xLeft, ry+1,      cs.celeste);
            drawPixel(xRight, rx,       cs.celeste);
            drawPixel(xRight, rx+1,     cs.celeste);
            drawPixel(rx,    yUp,       cs.celeste);
            drawPixel(rx,   yDown,      cs.celeste);
            fin = bullet;
            if(i==1100)
                System.out.println("Cuidado D:!!!");
            if(i>1100){
                g2.drawImage(fin,null,247,251);
                if(move.left && aIronmanHorizontal>0){
                    aIronmanHorizontal-=5;
                    move.left=false;
                }
                if(move.rigth && aIronmanHorizontal<675){
                    aIronmanHorizontal+=5;
                    move.rigth=false;
                }
                if(move.down && aIronman<644){
                    aIronman+=4;
                    move.down=false;
                }
                if(move.up && aIronman>3){
                    aIronman-=4;
                    move.up=false;
                }
            }
            g2.drawImage(ironman,null,aIronmanHorizontal,aIronman);
            g2.drawImage(propulsoresM,null,aIronmanHorizontal,aIronman+17);
            g2.drawImage(propulsoresM,null,aIronmanHorizontal+14,aIronman+17);
            g2.drawImage(propulsoresP,null,aIronmanHorizontal+2,aIronman+22);
            g2.drawImage(propulsoresP,null,aIronmanHorizontal+10,aIronman+22);
            if((aAsteroideY.get(nAsteroide-1)) == 30){
                nAsteroide++;
                aAsteroideX.add((int) (Math.random() * 675));
                aAsteroideY.add(0);
            }
            for (int j=0; j<nAsteroide; j++) {
                g2.drawImage(asteroide,null,aAsteroideX.get(j),aAsteroideY.get(j));
                aAsteroideY.set(j, aAsteroideY.get(j)+2);
            }

            for (int j=0; j<nAsteroide; j++) {
                if((aAsteroideY.get(nAsteroide-1)) == 700){
                    aAsteroideX.remove(j);
                    aAsteroideY.remove(j);
                    nAsteroide--;
                }
            }

            for (int j=0; j<nAsteroide; j++) {
                if ((Math.abs(aAsteroideX.get(j)-aIronmanHorizontal)<=15) && (Math.abs(aAsteroideY.get(j)-aIronman)<=23)){
                    nVida-=10;
                    aAsteroideX.remove(j);
                    aAsteroideY.remove(j);
                    nAsteroide--;
                    if(nVida>0){
                        bullet = new BufferedImage(100,10,BufferedImage.TYPE_INT_ARGB);
                        vida();
                        vida = bullet;
                    }
                    if(nVida<0)
                        bfin=false;
                }
            }
            g2.drawImage(vida,null,600,0);

        }

        if(!bfin && i>1150){
            if(gameover){
                soundtrack.offGame();
                soundtrack.onFin();
                gameover=false;
            }
            g2.drawImage(ironman,null,aIronmanHorizontal,aIronman);
            g2.drawImage(propulsoresM,null,aIronmanHorizontal,aIronman+17);
            g2.drawImage(propulsoresM,null,aIronmanHorizontal+14,aIronman+17);
            g2.drawImage(propulsoresP,null,aIronmanHorizontal+2,aIronman+22);
            g2.drawImage(propulsoresP,null,aIronmanHorizontal+10,aIronman+22);
            for (int j=0; j<nAsteroide; j++)
                g2.drawImage(asteroide,null,aAsteroideX.get(j),aAsteroideY.get(j));
        }

        i++;
    }

    public void drawPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        bullet.getGraphics().drawImage(buffer, x, y, this);
    }


    public void logo(){
        c = cs.blanco;
        circleThickness (325, 300, 225, 010, c);
        lineThickness   (150, 550, 400, 050, 20, c);
        lineThickness   (400, 050, 400, 450, 20, c);
        lineThickness   (235, 375, 375, 375, 20, c);
    }

    public void bifrost(){
        Color [] cBifrost = {cs.azul, cs.rojo, cs.amarillo, cs.violeta, cs.celeste,
        cs.verde, cs.naranja, cs.rosa, cs.plata, cs.tinto, cs.morado, cs.cafe};
        int c = (int) (Math.random() * 12);
        Color color = cBifrost[c];
        boolean flag=true;
        for (int i=0; i<700; i++) {
            line(i,0,i,700,color);
            if(i%5 == 0){
                if(flag){
                    color=cs.blanco;
                    flag=false;
                }
                else{
                    c = (int) (Math.random() * 12);
                    color = cBifrost[c];
                    flag=true;
                }
            }   
        }
        
    }

    public void estrellas(){
        int x, y;
        for (int i=0; i<2000; i++) {
                x = (int) (Math.random() * 700);
                y = (int) (Math.random() * 700);
                px[0][i]=x;
                py[0][i]=y;
                drawPixel(x,y,cs.rojo);
                x = (int) (Math.random() * 700);
                y = (int) (Math.random() * 700);
                px[1][i]=x;
                py[1][i]=y;
                drawPixel(x,y,cs.amarillo);
                x = (int) (Math.random() * 700);
                y = (int) (Math.random() * 700);
                px[2][i]=x;
                py[2][i]=y;
                drawPixel(x,y,cs.rosa);
                x = (int) (Math.random() * 700);
                y = (int) (Math.random() * 700);
                px[3][i]=x;
                py[3][i]=y;
                drawPixel(x,y,cs.cafe);
                x = (int) (Math.random() * 700);
                y = (int) (Math.random() * 700);
                px[4][i]=x;
                py[4][i]=y;
                drawPixel(x,y,cs.verde);
        }
    }

    public void puntos(){
        //0, Rojo
        //1, Amarillo
        //2, Rosa
        //3, Cafe
        //4, Verde
        int image=1;
        for (int i=0; i<2000; i++) {
            drawPixel(px[0][i],py[0][i],cs.verde);
            drawPixel(px[1][i],py[1][i],cs.rosa);
            drawPixel(px[2][i],py[2][i],cs.amarillo);
            drawPixel(px[3][i],py[3][i],cs.rojo);
            drawPixel(px[4][i],py[4][i],cs.cafe);
        }
        estrellas[image] = bullet;
        bullet = new BufferedImage(700,700, BufferedImage.TYPE_INT_ARGB);
        image++;
        for (int i=0; i<2000; i++) {
            drawPixel(px[0][i],py[0][i],cs.amarillo);
            drawPixel(px[1][i],py[1][i],cs.cafe);
            drawPixel(px[2][i],py[2][i],cs.rojo);
            drawPixel(px[3][i],py[3][i],cs.rosa);
            drawPixel(px[4][i],py[4][i],cs.verde);
        }
        estrellas[image] = bullet;
        bullet = new BufferedImage(700,700, BufferedImage.TYPE_INT_ARGB);
        image++;
        for (int i=0; i<2000; i++) {
            drawPixel(px[0][i],py[0][i],cs.rosa);
            drawPixel(px[1][i],py[1][i],cs.rojo);
            drawPixel(px[2][i],py[2][i],cs.verde);
            drawPixel(px[3][i],py[3][i],cs.amarillo);
            drawPixel(px[4][i],py[4][i],cs.cafe);
        }
        estrellas[image] = bullet;
        bullet = new BufferedImage(700,700, BufferedImage.TYPE_INT_ARGB);
        image++;
        for (int i=0; i<2000; i++) {
            drawPixel(px[0][i],py[0][i],cs.amarillo);
            drawPixel(px[1][i],py[1][i],cs.rosa);
            drawPixel(px[2][i],py[2][i],cs.cafe);
            drawPixel(px[3][i],py[3][i],cs.rojo);
            drawPixel(px[4][i],py[4][i],cs.verde);
        }
        estrellas[image] = bullet;
        px = new int[1][1];
        py = new int[1][1];
    }

    public void escudo(){
        //13 pixeles de escudo, 14 left,right
        //13 escudo 13 up,down
        //1ro
        exi=14; eyi=0; epixeles=12;
        exf=exi+epixeles;
        line(exi, eyi, exf, eyi, cs.rojo);
        pixeles(3, 4, cs.rojo);
        pixeles(3, 2, cs.rojo);
        pixeles(1,cs.rojo);
        pixeles(1, 2, cs.rojo);
        pixeles(1, 2, cs.rojo);
        pixeles(1,cs.rojo);
        pixeles(1, 2, cs.rojo);
        pixeles(2,cs.rojo);
        pixeles(1, 2, cs.rojo);
        pixeles(11,cs.rojo);
        //2do
        exi=15; eyi=4; epixeles=10;
        exf=exi+epixeles;
        line(exi, eyi, exf, eyi, cs.rojo);
        pixeles(2,4,cs.blanco);
        pixeles(3,2,cs.blanco);
        pixeles(1,2,cs.blanco);
        pixeles(1,cs.blanco);
        pixeles(1,2,cs.blanco);
        pixeles(1,cs.blanco);
        pixeles(10,cs.blanco);
        //3ro
        exi=16; eyi=8; epixeles=8;
        exf=exi+epixeles;
        line(exi, eyi, exf, eyi, cs.rojo);
        for (int i=0; i<3; i++) {
            pixeles(1,4,cs.rojo);
            pixeles(1,cs.rojo);
        }
        pixeles(1,2,cs.rojo);
        pixeles(8,cs.rojo);
        


        //Inverso
        exi=14; eyi=39; epixeles=12;
        exf=exi+epixeles;
        line(exi, eyi, exf, eyi, cs.rojo);
        pixelesAbajo(3, 4, cs.rojo);
        pixelesAbajo(3, 2, cs.rojo);
        pixelesAbajo(1,cs.rojo);
        pixelesAbajo(1, 2, cs.rojo);
        pixelesAbajo(1, 2, cs.rojo);
        pixelesAbajo(1,cs.rojo);
        pixelesAbajo(1, 2, cs.rojo);
        pixelesAbajo(2,cs.rojo);
        pixelesAbajo(1, 2, cs.rojo);
        pixelesAbajo(1,cs.rojo);
        //2do
        exi=15; eyi=35; epixeles=10;
        exf=exi+epixeles;
        line(exi, eyi, exf, eyi, cs.rojo);
        pixelesAbajo(2,4,cs.blanco);
        pixelesAbajo(3,2,cs.blanco);
        pixelesAbajo(1,2,cs.blanco);
        pixelesAbajo(1,cs.blanco);
        pixelesAbajo(1,2,cs.blanco);
        pixelesAbajo(1,cs.blanco);
        pixelesAbajo(10,cs.blanco);
        //3ro
        exi=16; eyi=31; epixeles=8;
        exf=exi+epixeles;
        line(exi, eyi, exf, eyi, cs.rojo);
        for (int i=0; i<3; i++) {
            pixelesAbajo(1,4,cs.rojo);
            pixelesAbajo(1,cs.rojo);
        }
        pixelesAbajo(1,2,cs.rojo);
        pixelesAbajo(8,cs.rojo);

        //Azul
        line(17, 12, 24, 12, cs.azul);
        line(16, 13, 25, 13, cs.azul);
        line(15, 14, 26, 14, cs.azul);
        line(14, 15, 27, 15, cs.azul);
        line(13, 16, 28, 16, cs.azul);
        line(12, 17, 29, 17, cs.azul);
        line(12, 18, 29, 18, cs.azul);
        line(12, 19, 29, 19, cs.azul);
        line(12, 20, 29, 20, cs.azul);
        line(12, 21, 29, 21, cs.azul);
        line(12, 22, 29, 22, cs.azul);
        line(12, 23, 29, 23, cs.azul);
        line(13, 24, 28, 24, cs.azul);
        line(14, 25, 27, 25, cs.azul);
        line(15, 26, 26, 26, cs.azul);
        line(16, 27, 25, 27, cs.azul);
        line(17, 28, 24, 28, cs.azul);

        //Estrellas
        drawPixel(20,13,cs.blanco);
        drawPixel(20,14,cs.blanco);
        exi=19; eyi=15; epixeles=3;
        exf=exi+epixeles;
        line(exi, eyi, exf, eyi, cs.blanco);
        pixeles(1,cs.blanco);
        pixeles(1,8,cs.blanco);
        exi++;
        eyi++;
        line(exi, eyi, exi+9, eyi, cs.blanco);
        exi++;
        eyi++;
        line(exi, eyi, exi+7, eyi, cs.blanco);
        exi++;
        eyi++;
        line(exi, eyi, exi+5, eyi, cs.blanco);
        exi--;
        eyi++;
        line(exi, eyi, exi+7, eyi, cs.blanco);
        exi--;
        eyi++;
        line(exi, eyi, exi+8, eyi, cs.blanco);
        line(16,23,25,23,cs.blanco);
        line(15,24,18,24,cs.blanco); line(23,24,26,24,cs.blanco);
        drawPixel(15, 25,cs.blanco); drawPixel(25,25,cs.blanco);
    }

    public void pixeles(int i, int p, Color c){
        int dx = p/2;
        if(dx== 0){
            dx=1;
            p=2;
        }
        for (int j=0; j<i; j++) {
            eyi++;
            epixeles = epixeles+p;
            exi = exi - dx;
            exf = exi + epixeles;
            line(exi,eyi,exf,eyi,c);
        }
    }

    public void pixeles(int i, Color c){
        for (int j=0; j<i; j++) {
            eyi++;
            line(exi,eyi,exf,eyi,c);
        }
    }

    public void pixelesAbajo(int i, int p, Color c){
        int dx = p/2;
        if(dx == 0){
            dx=1;
            p=2;
        }
        for (int j=0; j<i; j++) {
            eyi--;
            epixeles = epixeles+p;
            exi = exi - dx;
            exf = exi + epixeles;
            line(exi,eyi,exf,eyi,c);
        }
    }

    public void pixelesAbajo(int i, Color c){
        for (int j=0; j<i; j++) {
            eyi--;
            line(exi,eyi,exf,eyi,c);
        }
    }

    public void mjolnir(){
        //Inicia en 0
        //22x, 39y
        line(9,0,15,0,cs.gris);
        line(2,1,21,1,cs.gris);
        drawPixel(1,2,cs.gris); drawPixel(21,2,cs.gris);
        line(0,2,0,11,cs.gris);
        line(22,2,22,11,cs.gris);
        line(2,12,21,12,cs.gris);
        
    
        line(2,2,21,2,cs.plata);
        exi=1; eyi=2; epixeles=21;
        exf=exi+epixeles;
        pixeles(9,cs.plata);
        drawPixel(1,11,cs.gris); drawPixel(21,11,cs.gris);
        line(8,10,15,10,cs.gris);
        line(3,11,8,11,cs.gris);
        line(16,11,21,11,cs.gris);
        for (int i=0; i<17; i++)
            line(10,13+i,15,13+i,cs.cafe);
        drawPixel(10,14,cs.negro); drawPixel(14,14,cs.negro);
        //line(11,15,12,15,cs.negro);
    }

    public void spiderman(){
        //16x 26y
        line(8,0,8,9,cs.blanco);
        drawPixel(7,0,cs.rojo); drawPixel(9,0,cs.rojo);
        line(6,1,8,1,cs.rojo);  line(9,1,11,1,cs.rojo);
        line(5,2,8,2,cs.rojo);  line(9,2,12,2,cs.rojo);
        line(4,3,8,3,cs.rojo);  line(9,3,13,3,cs.rojo);
        line(3,4,6,4,cs.rojo);  line(11,4,14,4,cs.rojo);
        
        drawPixel(2,4,cs.azul); drawPixel(14,4,cs.azul);
        drawPixel(4,5,cs.rojo); drawPixel(12,5,cs.rojo);
        line(1,5,3,5,cs.azul);  line(13,5,16,5,cs.azul);
        
        line(0,6,4,6,cs.azul);  line(13,6,17,6,cs.azul);
        line(0,7,3,7,cs.azul);  line(14,7,17,7,cs.azul);

        line(5,7,8,7,cs.rojo);  line(10,7,13,7,cs.rojo);
        line(4,8,8,8,cs.rojo);  line(10,8,14,8,cs.rojo);
        drawPixel(7,7,cs.blanco); drawPixel(9,7,cs.blanco);
        
        drawPixel(3,9,cs.rojo);    drawPixel(4,9,cs.rojo);    drawPixel(5,9,cs.azul);
        drawPixel(12,9,cs.rojo);   drawPixel(13,9,cs.rojo);   drawPixel(11,9,cs.azul);
        
        drawPixel(2,10,cs.rojo);    drawPixel(3,10,cs.rojo);    drawPixel(4,10,cs.azul);
        drawPixel(13,10,cs.rojo);   drawPixel(14,10,cs.rojo);   drawPixel(12,10,cs.azul);
        
        drawPixel(2,11,cs.rojo);    drawPixel(3,11,cs.rojo);    drawPixel(5,11,cs.azul);
        drawPixel(13,11,cs.rojo);   drawPixel(14,11,cs.rojo);   drawPixel(11,11,cs.azul);
        
        drawPixel(8,9,cs.rojo);
        
        line(7,10,10,10,cs.rojo);
        drawPixel(6,11,cs.rojo);    drawPixel(7,11,cs.rojo); drawPixel(9,11,cs.rojo);    drawPixel(10,11,cs.rojo);
        line(3,12,14,12,cs.rojo);
        drawPixel(6,13,cs.rojo);    drawPixel(5,13,cs.rojo); drawPixel(11,13,cs.rojo);    drawPixel(10,13,cs.rojo);

        //Cabeza
        line(7,14,10,14,cs.rojo);
        line(5,15,12,15,cs.rojo);
        line(4,16,13,16,cs.rojo);
        line(3,17,14,17,cs.rojo);
        line(3,18,3,24,cs.rojo);
        line(13,18,13,24,cs.rojo);

        drawPixel(4,18,cs.rojo); drawPixel(12,18,cs.rojo);
        line(7,18,10,18,cs.rojo);
        drawPixel(8,19,cs.rojo);
        line(7,20,10,20,cs.rojo);
        line(6,21,11,21,cs.rojo);
        line(5,22,12,22,cs.rojo);
        line(4,23,13,23,cs.rojo);
        drawPixel(6,19,cs.blanco); drawPixel(5,19,cs.blanco); drawPixel(5,20,cs.blanco);
        drawPixel(10,19,cs.blanco); drawPixel(11,19,cs.blanco); drawPixel(11,20,cs.blanco);
        line(4,24,13,24,cs.rojo);
        line(6,25,11,25,cs.rojo);
    }

    public void ironman(){
        line(6,0,9,0,cs.rojo);
        line(3,1,12,1,cs.rojo);
        line(2,2,13,2,cs.rojo);
        line(2,3,13,3,cs.rojo);
        line(2,4,13,4,cs.rojo);
        drawPixel(3,2,cs.amarillo); drawPixel(4,2,cs.amarillo); drawPixel(10,2,cs.amarillo); drawPixel(11,2,cs.amarillo);
        drawPixel(3,3,cs.amarillo); drawPixel(4,3,cs.amarillo); drawPixel(10,3,cs.amarillo); drawPixel(11,3,cs.amarillo);
        line(3,4,6,4,cs.amarillo); line(9,4,12,4,cs.amarillo);
        line(3,4,12,4,cs.amarillo);
        line(1,5,1,9,cs.rojo); line(13,5,13,9,cs.rojo);
        drawPixel(2,6,cs.amarillo); drawPixel(12,6,cs.amarillo);
        line(3,6,5,6,cs.celeste); line(9,6,12,6,cs.celeste);
        line(2,7,13,7,cs.amarillo);
        
        line(3,8,12,8,cs.amarillo);
        line(3,9,12,9,cs.amarillo);
        drawPixel(4,10,cs.amarillo); drawPixel(10,10,cs.amarillo);
        line(5,11,10,11,cs.amarillo);
        
        drawPixel(2,8,cs.rojo); drawPixel(2,9,cs.rojo); drawPixel(12,8,cs.rojo); drawPixel(12,9,cs.rojo);
        drawPixel(3,10,cs.rojo); drawPixel(12,10,cs.rojo);
        line(5,12,11,12,cs.rojo);
        drawPixel(3,12,cs.rojo); drawPixel(12,12,cs.rojo);
        line(4,13,4,18,cs.rojo); line(11,13,11,18,cs.rojo);
        line(5,15,5,19,cs.rojo); line(10,15,10,19,cs.rojo);
        line(6,16,6,19,cs.rojo); line(9,16,9,19,cs.rojo);
        drawPixel(7,17,cs.rojo); drawPixel(7,18,cs.rojo);
        drawPixel(8,17,cs.rojo); drawPixel(8,18,cs.rojo);
        drawPixel(7,15,cs.celeste); drawPixel(7,16,cs.celeste);
        drawPixel(8,15,cs.celeste); drawPixel(8,16,cs.celeste);
        drawPixel(6,15,cs.celeste); drawPixel(9,15,cs.celeste);
        drawPixel(7,14,cs.celeste); drawPixel(8,14,cs.celeste);
        drawPixel(5,14,cs.rojo); drawPixel(6,14,cs.rojo);
        line(5,13,12,13,cs.rojo);
        drawPixel(10,14,cs.rojo);
        drawPixel(9,14,cs.rojo);
        drawPixel(4,18,cs.amarillo); drawPixel(3,18,cs.amarillo);
        drawPixel(4,19,cs.amarillo); drawPixel(5,19,cs.amarillo);
        drawPixel(11,18,cs.amarillo); drawPixel(12,18,cs.amarillo);
        drawPixel(11,19,cs.amarillo); drawPixel(10,19,cs.amarillo);
        drawPixel(3,19,cs.rojo); drawPixel(12,19,cs.rojo);
        drawPixel(3,20,cs.rojo); drawPixel(12,20,cs.rojo);
        drawPixel(4,20,cs.rojo); drawPixel(11,20,cs.rojo);
        drawPixel(2,21,cs.rojo); drawPixel(13,21,cs.rojo);
        drawPixel(3,21,cs.rojo); drawPixel(12,21,cs.rojo);
        drawPixel(4,21,cs.rojo); drawPixel(11,21,cs.rojo);


        drawPixel(2,13,cs.rojo); drawPixel(13,13,cs.rojo);
        
        drawPixel(1,15,cs.rojo); drawPixel(0,15,cs.rojo);
        drawPixel(0,16,cs.rojo); drawPixel(1,16,cs.rojo);

        drawPixel(14,15,cs.rojo); drawPixel(15,15,cs.rojo);
        drawPixel(14,16,cs.rojo); drawPixel(15,16,cs.rojo);

        drawPixel(1,14,cs.amarillo); drawPixel(2,14,cs.amarillo); drawPixel(2,15,cs.amarillo);
        drawPixel(13,14,cs.amarillo); drawPixel(14,14,cs.amarillo); drawPixel(13,15,cs.amarillo);
    }

    public void asteroide(){
        line(5, 24, 16, 24,cs.naranja);
        line(5, 23, 16, 23,cs.gris); drawPixel(4,23,cs.naranja); drawPixel(16,23,cs.naranja);
        line(4, 22, 17, 22,cs.gris); drawPixel(3,22,cs.naranja); drawPixel(17,22,cs.naranja);
                                     drawPixel(2,22,cs.naranja); drawPixel(18,22,cs.naranja);
        line(2, 21, 18, 21,cs.gris); drawPixel(1,21,cs.naranja); drawPixel(19,21,cs.naranja);
        line(1, 20, 20, 20,cs.gris); drawPixel(0,20,cs.naranja); drawPixel(20,20,cs.naranja);
        line(0, 19, 0, 14,cs.rojo);  line(20, 19, 20, 14,cs.rojo);
        for (int i=19; i>13; i--) {
            //line(2, 13, 19, 13,cs.gris);
            line(1, i, 20, i,cs.gris);
        }
        line(2, 13, 18, 13,cs.gris); drawPixel(1,13,cs.naranja); drawPixel(19,13,cs.naranja);
        line(2, 12, 18, 12,cs.gris); drawPixel(1,12,cs.naranja); drawPixel(19,12,cs.naranja);
        line(4, 11, 16, 11,cs.gris); drawPixel(3,11,cs.naranja); drawPixel(16,11,cs.naranja);
        line(4, 10, 16, 10,cs.gris); drawPixel(3,10,cs.naranja); drawPixel(16,10,cs.naranja);
        line(5, 9, 15, 9,cs.gris);   drawPixel(4,9,cs.naranja); drawPixel(15,9,cs.naranja);
        line(5, 8, 14, 8,cs.gris);   drawPixel(4,8,cs.naranja); drawPixel(14,8,cs.naranja);
        line(6, 7, 13, 7,cs.gris);   drawPixel(5,7,cs.naranja); drawPixel(13,7,cs.naranja);
        line(7, 6, 12, 6,cs.gris);   drawPixel(6,6,cs.naranja); drawPixel(12,6,cs.naranja);
        line(7, 5, 12, 5,cs.gris);  drawPixel(6,5,cs.naranja); drawPixel(12,5,cs.naranja);
        line(7, 4, 12, 4,cs.naranja); line(8, 4, 11, 4,cs.rojo);
        line(8, 3, 11, 3,cs.naranja); line(9, 3, 10, 3,cs.rojo);
        line(9, 2, 10, 2,cs.naranja); line(10, 2, 11, 2,cs.rojo);
        line(10, 1, 11, 1,cs.naranja);

        drawPixel(18,12,cs.naranja); drawPixel(29,12,cs.naranja);
    }

    public void vida(){
        for (int j=0; j<10; j++) {
            line(100-nVida, j, 100, j, cs.celeste);
        }
    }

    public void line(float xi, float yi, int xf, int yf, Color c){
        float b, m, dx, dy, xinc, yinc, step, rx, ry;
        dy = (yf-yi);
        dx = (xf-xi);
        drawPixel((int)xi, (int)yi, c);
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
            drawPixel(Math.round(xi), Math.round(yi), c);
        }
    }
    
    public void lineThickness(int xi, int yi, int xf, int yf, int grosor, Color c){
        boolean impar;
        if((grosor%2) == 0)
            impar = false;
        else
            impar = true;

        int repeticiones = grosor/2;
        line(xi, yi, xf, yf, c);
        float dy = yi-yf;
        if(Math.abs(dy) == 0){
            for (int i=1; i<=repeticiones; i++) {
                line(xi, yi+i, xf, yf+i, c);
                line(xi, yi-i, xf, yf-i, c);
            }
            if(impar){
                repeticiones+=1;
                line(xi, yi+repeticiones, xf, yf+repeticiones, c);
            }
        }

        float dx = xi-xf;
        if(dy != 0){
            for (int i=1; i<=repeticiones; i++) {
                line(xi+i, yi, xf+i, yf, c);
                line(xi-i, yi, xf-i, yf, c);
            }
            if(impar){
                repeticiones+=1;
                line(xi+repeticiones, yi, xf+repeticiones, yf, c);
            }
        }
    }

    public void circleThickness(int xc, int yc, int r, int grosor, Color c){
        double inc = Math.asin(1.0/r);
        double grados = 0;
        int x, y;
        int y1, y2, y3, x1, x2, x3;
        int grosorc = grosor;
        while(grados <= 2*Math.PI){
            x = xc + (int)(r * Math.sin(grados));
            y = yc + (int)(r * Math.cos(grados));
            drawPixel(x, y, c);
            for (int j = 1; j <= grosor; j++)
                drawPixel(x, y + j, c);
            for (int j = 1; j <= grosor; j++)
                drawPixel(x, y - j, c);
            for (int j = 1; j <= grosor; j++)
                  drawPixel(x + j, y, c);
            for (int j = 1; j <= grosor; j++)
                drawPixel(x - j, y, c);
            grados += inc;
        }
    }

}
