import java.awt.*;
import java.util.*;
 
public class Retangulo extends Figura
{
    protected Ponto ponto;
    protected int altura;
    protected int largura;
    
    public Retangulo (int x, int y, int altura, int largura)
    {
        this (x, y, altura, largura, Color.BLACK);
    }
	
    public Retangulo (int x, int y, int altura, int largura, Color cor)
    {
        super(cor);

        this.ponto = new Ponto (x,y,cor);
        this.altura = altura;
        this.largura = largura;
    }

    public Retangulo (String s)
    {
        StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();
			int   x  = Integer.parseInt(quebrador.nextToken());
			int   y  = Integer.parseInt(quebrador.nextToken());
			
			int altura = Integer.parseInt(quebrador.nextToken());
			int largura = Integer.parseInt(quebrador.nextToken());

			Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
								   Integer.parseInt(quebrador.nextToken()),  // G
								   Integer.parseInt(quebrador.nextToken())); // B
								   
		this.ponto  = new Ponto (x,y,cor);
        this.largura = largura;
        this.altura = altura;  
        this.cor = cor;
    }

    public void setPonto (int x, int y)
    {
        this.ponto = new Ponto (x,y,this.getCor());
    }

    public void setAltura (int altura)
    {
        this.altura = altura;
    }
    
    public void setLargura (int largura)
    {
        this.largura = largura;
    }

    public Ponto getPonto ()
    {
        return this.ponto;
    }

    public int getAltura ()
    {
        return this.altura;
    }
    
    public int getLargura ()
    {
		return this.largura;
	}
    public void torneSeVisivel (Graphics g)
    {
        g.setColor(this.cor);
        g.drawRect(this.ponto.getX(), this.ponto.getY(),
                   this.altura, this.largura);
    }

    public String toString()
    {
        return "c:" +
               this.ponto.getX() +
               ":" +
               this.ponto.getY() +
               ":" +
               this.altura +
               ":" +
               this.largura +
               ":" +
               this.getCor().getRed() +
               ":" +
               this.getCor().getGreen() +
               ":" +
               this.getCor().getBlue();
    }
}
