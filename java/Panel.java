import java.lang.Math;
import java.util.Random;
import java.util.ArrayList;  

public class {
    
    
    private javax.swing.Timer t;
    
    
    private BufferedImage [] bifrost = new BufferedImage[8];
    private BufferedImage [] estrellas = new BufferedImage[8];
    private int [][] px = new int[5][2000];
    private int [][] py = new int[5][2000];
    
    
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
        if(i==0){
            
            red = new BufferedImage(1,400, BufferedImage.TYPE_INT_ARGB);
            ironman = new BufferedImage(16,23, BufferedImage.TYPE_INT_ARGB);
            propulsoresP = new BufferedImage(3,2, BufferedImage.TYPE_INT_ARGB);
            propulsoresM = new BufferedImage(2,1, BufferedImage.TYPE_INT_ARGB);
            fin = new BufferedImage(200,200, BufferedImage.TYPE_INT_ARGB);;
            asteroide = new BufferedImage(25,25, BufferedImage.TYPE_INT_ARGB);
            vida = new BufferedImage(100,10, BufferedImage.TYPE_INT_ARGB);
            
            
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
    
}
