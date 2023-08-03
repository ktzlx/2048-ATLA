import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class gui2{
    game a;
    int boardz=456;
    int fh=576;
    int fw=496;
    Color background = new Color(0xf2a2a2);
    int sides=20;
    board b;
    JFrame frame;
   
    BufferedImage empty;
    BufferedImage katara;
    BufferedImage aang;
    BufferedImage sokka;
    BufferedImage suki;
    BufferedImage toph;
    BufferedImage zuko;
    BufferedImage asula;
    BufferedImage mai;
    BufferedImage tylee;
    BufferedImage momo;
    BufferedImage appa;
    
    public gui2(){
        a=new game();
        frame= new JFrame("2048 ;)");
        frame.setFocusable(true);
        frame.addKeyListener(new arrows());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        images();
        b = new board();

        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout());
        panel.setPreferredSize(new Dimension(fw,100));

        JLabel game= new JLabel("2048",SwingConstants.CENTER);
        game.setFont(new Font("Serif",Font.BOLD,40));

        panel.add(game);
        JLabel intro = new JLabel("<html>add characters until<br>you reach to appa</html>",SwingConstants.CENTER);
        intro.setFont(new Font("Serif",Font.BOLD,20));
        panel.add(intro);

        panel.setBackground(background);

        JPanel side1 = new JPanel();
        side1.setPreferredSize(new Dimension(sides,boardz));
        side1.setBackground(background);

        JPanel side2 = new JPanel();
        side2.setPreferredSize(new Dimension(sides,boardz));
        side2.setBackground(background);

        JPanel bottom = new JPanel();
        bottom.setPreferredSize(new Dimension(fw,sides));
        bottom.setBackground(background);
        frame.getContentPane().add(panel,BorderLayout.NORTH);
        frame.getContentPane().add(side1,BorderLayout.WEST);
        frame.getContentPane().add(side2,BorderLayout.EAST);
        frame.getContentPane().add(bottom,BorderLayout.SOUTH);
        frame.getContentPane().add(b,BorderLayout.CENTER);

        frame.getContentPane().setPreferredSize(new Dimension(fw, fh));
        

        frame.pack();
        frame.setVisible(true);
    }
    void images(){
        try{
            zuko= ImageIO.read(new File("pics/64.png"));
            aang= ImageIO.read(new File("pics/2.png"));
            katara= ImageIO.read(new File("pics/4.png"));
            sokka= ImageIO.read(new File("pics/8.png"));
            suki= ImageIO.read(new File("pics/16.png"));
            toph= ImageIO.read(new File("pics/32.png"));
            asula= ImageIO.read(new File("pics/128.png"));
            mai= ImageIO.read(new File("pics/256.png"));
            tylee= ImageIO.read(new File("pics/512.png"));
            momo= ImageIO.read(new File("pics/1024.png"));
            appa= ImageIO.read(new File("pics/2048.png"));
            empty= ImageIO.read(new File("pics/0.png"));
        }
        catch(IOException ex){
        }
    }
  
    class arrows extends JPanel implements KeyListener {
       @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

       @Override
        public void keyReleased(KeyEvent e) {
            int arrow= e.getKeyCode();
            switch(arrow){
                case KeyEvent.VK_LEFT:
                    a.up();
                    a.addNum();
                    b.repaint();
                    break;
                case KeyEvent.VK_RIGHT:
                    a.down();
                    a.addNum();
                    b.repaint();
                    break;
                case KeyEvent.VK_UP:
                    a.left();
                    a.addNum();
                    b.repaint();
                    break;
                case KeyEvent.VK_DOWN:
                    a.right();
                    a.addNum();
                    b.repaint();
                    break;
            }
        }
    }
    class board extends JPanel{

        protected void paintComponent(Graphics g) {
            //@overide
            g.setColor(new Color(20, 20, 20));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            super.paintComponent(g);

            int[][] arr = a.guigame();
            int counx;
            int county;

            for (int y = 0; y < 4; y++) {
                for (int x = 0; x < 4; x++) {
                    int value = arr[x][y];
                    if (value == 0) {
                        g.drawImage(empty, x * 115, y * 115, this);
                    }
                    if (value == 2) {
                        g.drawImage(aang, x * 115, y * 115, this);
                    }
                    if (value == 4) {
                        g.drawImage(katara, x * 115, y * 115, this);
                    }
                    if (value == 8) {
                        g.drawImage(sokka, x * 115, y * 115, this);
                    }
                    if (value == 16) {
                        g.drawImage(suki, x * 115, y * 115, this);
                    }
                    if (value == 32) {
                        g.drawImage(toph, x * 115, y * 115, this);
                    }
                    if (value == 64) {
                        g.drawImage(zuko, x * 115, y * 115, this);
                    }
                    if (value == 128) {
                        g.drawImage(asula, x * 115, y * 115, this);
                    }
                    if (value == 256) {
                        g.drawImage(mai, x * 115, y * 115, this);
                    }
                    if (value == 512) {
                        g.drawImage(tylee, x * 115, y * 115, this);
                    }
                    if (value == 1024) {
                        g.drawImage(momo, x * 115, y * 115, this);
                    }
                    if (value == 2048) {
                        g.drawImage(appa, x * 115, y * 115, this);
                    }
                    a.winlose();

                }
            }

        }

    }


}
