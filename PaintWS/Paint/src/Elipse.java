import java.awt.*;
import java.util.*;
 
public class Elipse extends Figura
{
    protected Ponto centro;
    protected int raioA;
    protected int raioB;
    
    public Elipse (int x, int y, int raioA, int raioB)
    {
        this (x, y, raioA, raioB, Color.BLACK);
        
    }
	
    public Elipse (int x, int y, int raioA, int raioB, Color cor)
    {
        super(cor);

        this.centro = new Ponto (x,y,cor);
        this.raioA = raioA;
        this.raioB = raioB;
    }

    public Elipse (String s)
    {
        StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();
			int   x  = Integer.parseInt(quebrador.nextToken());
			int   y  = Integer.parseInt(quebrador.nextToken());
			
			int raioA = Integer.parseInt(quebrador.nextToken());
			int raioB = Integer.parseInt(quebrador.nextToken());

			Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
								   Integer.parseInt(quebrador.nextToken()),  // G
								   Integer.parseInt(quebrador.nextToken())); // B
		this.centro  = new Ponto (x,y,cor);
        this.raioA = raioA;
        this.raioB = raioB;
        this.cor = cor;
    }

    public void setCentro (int x, int y)
    {
        this.centro = new Ponto (x,y,this.getCor());
    }

    public Ponto getCentro ()
    {
        return this.centro;
    }

    public int getRaioA() {
        return raioA;
    }

    public void setRaioA(int raioA) {
        this.raioA = raioA;
    }

    public int getRaioB() {
        return raioB;
    }

    public void setRaioB(int raioB) {
        this.raioB = raioB;
    }
    public void torneSeVisivel (Graphics g)
    {
        g.setColor(this.cor);
        g.drawOval( this.centro.getX() - this.raioA, this.centro.getY() - this.raioB,   // centro
                    2* this.raioA, 2* this.raioB);  // diametro
    }

    public String toString()
    {
        return "c:" +
               this.centro.getX() +
               ":" +
               this.centro.getY() +
               ":" +
               this.raioA +
               ":" +
               this.raioB +
               ":" +
               this.getCor().getRed() +
               ":" +
               this.getCor().getGreen() +
               ":" +
               this.getCor().getBlue();
    }
}
