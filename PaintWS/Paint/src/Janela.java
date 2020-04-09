import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.util.*;
 
public class Janela extends JFrame 
{
    protected static final long serialVersionUID = 1L;

    protected JButton btnPonto   	= new JButton ("Ponto"),
                      btnLinha   	= new JButton ("Linha"),
                      btnCirculo	= new JButton ("Circulo"),
                      btnElipse  	= new JButton ("Elipse"),
                      btnRetangulo 	= new JButton ("Retangulo"),
                      btnQuadrado   = new JButton ("Quadrado"),
                      btnCores   	= new JButton ("Cores"),
                      btnAbrir   	= new JButton ("Abrir"),
                      btnSalvar  	= new JButton ("Salvar"),
                      btnApagar  	= new JButton ("Apagar"),
                      btnSair    	= new JButton ("Sair");

    protected MeuJPanel pnlDesenho = new MeuJPanel ();
    
    protected JLabel statusBar1 = new JLabel ("Mensagem:"),
                     statusBar2 = new JLabel ("Coordenada:");

    protected boolean esperaPonto, esperaInicioReta, esperaFimReta, esperaCentro, esperaRaio, esperaCentroElipse , esperaRaioElipse, esperaInicioRetangulo, esperaFimRetangulo, esperaInicioQuadrado, esperaFimQuadrado;

    protected Color corAtual = Color.BLACK;
    protected Ponto p1;
    protected int pressed = 0;
    
    protected Vector<Figura> figuras = new Vector<Figura>();

    public Janela ()
    {
        super("Editor Gráfico");

        try
        {
            Image btnPontoImg = ImageIO.read(getClass().getResource("resources/ponto.jpg"));
            btnPonto.setIcon(new ImageIcon(btnPontoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo ponto.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnLinhaImg = ImageIO.read(getClass().getResource("resources/linha.jpg"));
            btnLinha.setIcon(new ImageIcon(btnLinhaImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo linha.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnCirculoImg = ImageIO.read(getClass().getResource("resources/circulo.jpg"));
            btnCirculo.setIcon(new ImageIcon(btnCirculoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo circulo.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnElipseImg = ImageIO.read(getClass().getResource("resources/elipse.jpg"));
            btnElipse.setIcon(new ImageIcon(btnElipseImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo elipse.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnCoresImg = ImageIO.read(getClass().getResource("resources/cores.jpg"));
            btnCores.setIcon(new ImageIcon(btnCoresImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo cores.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnAbrirImg = ImageIO.read(getClass().getResource("resources/abrir.jpg"));
            btnAbrir.setIcon(new ImageIcon(btnAbrirImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo abrir.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnSalvarImg = ImageIO.read(getClass().getResource("resources/salvar.jpg"));
            btnSalvar.setIcon(new ImageIcon(btnSalvarImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo salvar.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnApagarImg = ImageIO.read(getClass().getResource("resources/apagar.jpg"));
            btnApagar.setIcon(new ImageIcon(btnApagarImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo apagar.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnSairImg = ImageIO.read(getClass().getResource("resources/sair.jpg"));
            btnSair.setIcon(new ImageIcon(btnSairImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo sair.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        
        try
        {
            Image btnRetanguloImg = ImageIO.read(getClass().getResource("resources/retangulo.jpg"));
            btnRetangulo.setIcon(new ImageIcon(btnRetanguloImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo retangulo.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        
        try
        {
            Image btnQuadradoImg = ImageIO.read(getClass().getResource("resources/quadrado.jpg"));
            btnQuadrado.setIcon(new ImageIcon(btnQuadradoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo quadrado.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        btnPonto.addActionListener (new DesenhoDePonto());
        btnLinha.addActionListener (new DesenhoDeReta ());
        btnCirculo.addActionListener (new DesenhoDeCirculo ());
        btnElipse.addActionListener (new DesenhoDeElipse ());
        btnRetangulo.addActionListener (new DesenhoDeRetangulo ());
        btnQuadrado.addActionListener (new DesenhoDeQuadrado ());
        btnCores.addActionListener (new TrocaCor ());

        JPanel     pnlBotoes = new JPanel();
        FlowLayout flwBotoes = new FlowLayout(); 
        pnlBotoes.setLayout (flwBotoes);

        pnlBotoes.add (btnAbrir);
        pnlBotoes.add (btnSalvar);
        pnlBotoes.add (btnPonto);
        pnlBotoes.add (btnLinha);
        pnlBotoes.add (btnCirculo);
        pnlBotoes.add (btnElipse);
        pnlBotoes.add (btnRetangulo);
        pnlBotoes.add (btnQuadrado);
        pnlBotoes.add (btnCores);
        pnlBotoes.add (btnApagar);
        pnlBotoes.add (btnSair);

        JPanel     pnlStatus = new JPanel();
        GridLayout grdStatus = new GridLayout(1,2);
        pnlStatus.setLayout(grdStatus);

        pnlStatus.add(statusBar1);
        pnlStatus.add(statusBar2);

        Container cntForm = this.getContentPane();
        cntForm.setLayout (new BorderLayout());
        cntForm.add (pnlBotoes,  BorderLayout.NORTH);
        cntForm.add (pnlDesenho, BorderLayout.CENTER);
        cntForm.add (pnlStatus,  BorderLayout.SOUTH);
        
        this.addWindowListener (new FechamentoDeJanela());

        this.setSize (1000,700);
        this.setVisible (true);
    }

    protected class MeuJPanel extends    JPanel 
                              implements MouseListener,
                                         MouseMotionListener
    {
	public MeuJPanel()
        {
            super();

            this.addMouseListener       (this);
            this.addMouseMotionListener (this);
        }

        public void paint (Graphics g)
        {
            for (int i=0 ; i<figuras.size(); i++)
                figuras.get(i).torneSeVisivel(g);
        }
        
        public void mousePressed (MouseEvent e)
        {
            if (esperaPonto)
            {
				statusBar1.setText("Mensagem: clique o local do ponto desejado");    
                figuras.add (new Ponto (e.getX(), e.getY(), corAtual));
                figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                esperaPonto = true;
            }
            else
                if (esperaInicioReta)
                {
                    p1 = new Ponto (e.getX(), e.getY(), corAtual);
                    esperaInicioReta = false;
                    esperaFimReta = true;
                    statusBar1.setText("Mensagem: clique o ponto final da reta");    
                 }
                 else
                    if (esperaFimReta)
                    {
                        esperaInicioReta = true;
                        esperaFimReta = false;
                        figuras.add (new Linha(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual));
                        figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                        statusBar1.setText("Mensagem: clique o ponto inicial da reta");    
                    }
                    else
						if (esperaCentro)
						{
							p1 = new Ponto (e.getX(), e.getY(), corAtual);
							esperaCentro = false;
							esperaRaio = true;
							statusBar1.setText("Mensagem: clique o ponto final do raio do circulo");    
						}
						else
							if (esperaRaio)
							{
								int raio = (int) (Math.round (Math.sqrt (Math.pow ((e.getX() - p1.getX() ), 2) + Math.pow ((e.getY() - p1.getY() ), 2))));
								figuras.add ( new Circulo( p1.getX(), p1.getY(), raio, corAtual));
								figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
								esperaCentro = true;
								esperaRaio = false;
								statusBar1.setText("Mensagem: clique o ponto central do circulo");   
							}
							else
								if (esperaCentroElipse)
								{
									p1 = new Ponto (e.getX(), e.getY(), corAtual);
									esperaCentroElipse = false;
									esperaRaioElipse = true;
									statusBar1.setText("Mensagem: clique o ponto final da elipse");    
								}
								else
									if (esperaRaioElipse)
									{
										int raioA = (int) (Math.round (Math.sqrt (Math.pow ((e.getX() - p1.getX() ), 2))));
										int raioB = (int) (Math.round (Math.sqrt (Math.pow ((e.getY() - p1.getY() ), 2))));
										figuras.add ( new Elipse( p1.getX(), p1.getY(), raioA, raioB, corAtual));
										figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
										esperaCentroElipse = true;
										esperaRaioElipse = false;
										statusBar1.setText("Mensagem: clique o pomto central da elipse");   
									}
									else
										if (esperaInicioRetangulo)
										{
											p1 = new Ponto (e.getX(), e.getY(), corAtual);
											esperaInicioRetangulo = false;
											esperaFimRetangulo = true;
											statusBar1.setText("Mensagem: clique o ponto final do retangulo");    
											}
									else
										if (esperaFimRetangulo)
										{
											int largura = (int) (Math.round (Math.sqrt (Math.pow ((e.getX() - p1.getX() ), 2))));
											int altura = (int) (Math.round (Math.sqrt (Math.pow ((e.getY() - p1.getY() ), 2))));
											figuras.add ( new Retangulo( p1.getX(), p1.getY(), largura, altura, corAtual));
											figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
											esperaInicioRetangulo = true;
											esperaFimRetangulo = false;
											statusBar1.setText("Mensagem: clique o ponto inicial do retangulo");   
										}
										else
											if (esperaInicioQuadrado)
											{
												p1 = new Ponto (e.getX(), e.getY(), corAtual);
												esperaInicioQuadrado = false;
												esperaFimQuadrado = true;
												statusBar1.setText("Mensagem: clique o ponto final do quadrado");    
												}
												else
													if (esperaFimQuadrado)
													{
														int lado = (int) (Math.round (Math.sqrt (Math.pow ((e.getX() - p1.getX() ), 2))));
														figuras.add ( new Quadrado( p1.getX(), p1.getY(), lado, corAtual));
														figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
														esperaInicioQuadrado = true;
														esperaFimQuadrado = false;
														statusBar1.setText("Mensagem: clique o ponto inicial do quadrado");   
													}
			}
        
        public void mouseReleased (MouseEvent e)
        {}
        
        public void mouseClicked (MouseEvent e)
        {}
        
        public void mouseEntered (MouseEvent e)
        {}

        public void mouseExited (MouseEvent e)
        {}
        
        public void mouseDragged(MouseEvent e)
        {}

        public void mouseMoved(MouseEvent e)
        {
            statusBar2.setText("Coordenada: "+e.getX()+","+e.getY());
        }
    }

    protected class DesenhoDePonto implements ActionListener
    {
          public void actionPerformed (ActionEvent e)    
          {
            esperaPonto      	= true;
            esperaCentro     	= false;
            esperaRaio       	= false;
            esperaInicioReta 	= false;
            esperaFimReta    	= false;
            esperaRaioElipse 	= false;
            esperaCentroElipse = false;

              statusBar1.setText("Mensagem: clique o local do ponto desejado");
          }
    }

    protected class DesenhoDeReta implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
            esperaPonto       	= false;
            esperaCentro      	= false;
            esperaRaio        	= false;
            esperaInicioReta  	= true;
            esperaFimReta     	= false;
            esperaRaioElipse  	= false;
            esperaCentroElipse	= false;

            statusBar1.setText("Mensagem: clique o ponto inicial da reta");
        }
    }
        protected class DesenhoDeCirculo implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
            esperaPonto      	= false;
            esperaCentro     	= true;
            esperaRaio       	= false;
            esperaInicioReta 	= false;
            esperaFimReta    	= false;
            esperaRaioElipse 	= false;
            esperaCentroElipse 	= false;

            statusBar1.setText("Mensagem: clique o ponto central do circulo");
        }
    }
    
        protected class DesenhoDeElipse implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
            esperaPonto      	= false;
            esperaCentro     	= false;
            esperaCentroElipse 	= true;
            esperaRaio      	= false;
            esperaInicioReta	= false;
            esperaFimReta    	= false;
            esperaRaioElipse 	= false;

            statusBar1.setText("Mensagem: clique o ponto central da elipse");
        }
    }
        
        protected class DesenhoDeRetangulo implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
            esperaPonto      					= false;
            esperaCentro     					= false;
            esperaCentroElipse 					= false;
            esperaRaio      					= false;
            esperaInicioReta					= false;
            esperaInicioRetangulo    			= true;
            esperaFimRetangulo 					= false;

            statusBar1.setText("Mensagem: clique o ponto inicial do retangulo");
        }
    }
        
        protected class DesenhoDeQuadrado implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
            esperaPonto      					= false;
            esperaCentro     					= false;
            esperaCentroElipse 					= false;
            esperaRaio      					= false;
            esperaInicioReta					= false;
            esperaInicioQuadrado    			= true;
            esperaFimQuadrado 					= false;

            statusBar1.setText("Mensagem: clique o ponto inicial do quadrado");
        }
    }
        protected class TrocaCor implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
			switch(pressed){
				case 0:
					corAtual = Color.RED;
					pressed++;
					statusBar1.setText("Mensagem: Cor alterada para vermelho");   
					break;
				case 1:
					corAtual = Color.BLUE;
					pressed++;
					statusBar1.setText("Mensagem: Cor alterada para azul");   
					break;
				case 2:
					corAtual = Color.YELLOW;
					pressed++;
					statusBar1.setText("Mensagem: Cor alterada para amarelo");   
					break;
				case 3:
					corAtual = Color.GREEN;
					pressed++;
					statusBar1.setText("Mensagem: Cor alterada para verde");   
					break;
				case 4:
					corAtual = Color.ORANGE;
					pressed++;
					statusBar1.setText("Mensagem: Cor alterada para laranja");   
					break;
				case 5:
					corAtual = Color.BLACK;
					pressed = 0;
					statusBar1.setText("Mensagem: Cor alterada para preto");   
					break;
			}
		}
	}

    protected class FechamentoDeJanela extends WindowAdapter
    {
        public void windowClosing (WindowEvent e)
        {
            System.exit(0);
        }
    }
}
