import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: BlackHorse
 * Date: Dec 15, 2009
 * Time: 9:00:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class PuzzleGraphic extends JFrame implements ActionListener, MouseListener, Serializable {

    Part activePart ;
    int flag = 0;
    Part[] parts = new Part[20] ;
    ArrayList<Positions> listAddressBegin = new ArrayList();
    Positions [][] listAddressEnd = new Positions[6][6];

    ArrayList<Positions> startArrange ;

    Random rand = new Random();
    int index =21;
    PuzzleArray array = new PuzzleArray();

    public PuzzleGraphic() throws HeadlessException {
        super();
        setSize(1200,800);
        addMouseListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Icon icon = new ImageIcon("background.gif");
        JButton image = new JButton(icon);
        image.setSize(210,170);
        image.setLocation(400,500);
        Container contain = new Container() ;
        contain.add(image);
        creatTablesAddress();


        for (int i = 0; i < parts.length; i++) {
            icon = new ImageIcon((i+1)+".gif");
         //   icon = new ImageIcon("1S.gif");
            parts[i] = new Part(icon , (i+1)) ;
            parts[i].addActionListener(this);
           // Positions positions = new Positions(getPosition());

            parts[i].setPositions(getPosition());
            parts[i].setSize(86,86);
            contain.add(parts[i]) ;


        }
        setContentPane(contain);

        show();

    }

    public void actionPerformed(ActionEvent e) {

        System.out.println("e = " + ((Part)e.getSource()).getNumber());
        activePart = (Part)e.getSource() ;
        flag = 1 ;

    }

    public void mouseClicked(MouseEvent e) {
        if(flag == 0 ) return ;
        int y = e.getX();
        int x = e.getY();
        int table = 1 ;
        if(y>560){
        table = 2 ;
        y-=560 ;
        x-=60;
        y/=90;
        x/=90;
        }
        else if(y<560)
        {
        y-=80 ;
        x-=60;
        y/=90;
        x/=90;
        }
        x++;
        y++;
        
        moveActivePart(x,y,activePart.getNumber());
        System.out.println("y = " + y);

    }

    private void moveActivePart(int x, int y,int number) {

        activePart.setPositions(listAddressEnd[x][y]);
        array.setBeginArray(x,y,0);
        array.setEndArray(x,y,number);
        checkArray();
        flag = 0 ;


    }

    private void checkArray() {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

     @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        //Graphics2D graphics2D = (Graphics2D) g;

//        graphics2D.setPaint(Color.black);

	g.setColor(Color.BLACK);
        int x = 80 ,y = 0 ;
        for (int i = 0; i <= 5; i++) {

             g.drawLine(x,80,x,440);
             x += 90 ;

        }
        x = 80 ;
        for (int i = 0; i <= 4; i++) {

             g.drawLine(80,x,530,x);
             x += 90 ;

        }
        //----------------------------
         x = 560 ; y = 0 ;
        for (int i = 0; i <= 5; i++) {

             g.drawLine(x,80,x,440);
             x += 90 ;

        }
        x = 80 ;
        for (int i = 0; i <= 4; i++) {

             g.drawLine(560,x,1010,x);
             x += 90 ;

        }

    }

    private void creatTablesAddress()
    {
        int column = 1 ;
        int hight = 60 ;
        int witd = 80 ;
        for(int i=0;i<21;i++){
        Positions positions = new Positions(witd+1,hight+1);
            witd += 90 ;
            column++;
            if (column > 5) {
                column = 1 ;
                hight += 90 ;
                witd = 80 ;
            }
         listAddressBegin.add(positions);
        }
        startArrange = listAddressBegin ;

         column = 1 ;
         int row = 1 ;
         hight = 60 ;
         witd = 560 ;
        for (int i = 0; i < listAddressEnd.length; i++) {
            listAddressEnd[i] = new Positions[6];

        }
        for(int i=0;i<21;i++){
        Positions positions = new Positions(witd+1,hight+1);
        witd += 90 ;
            
         this.listAddressEnd[row][column] = positions ;
            column++;
            if (column > 5) {
             row++;
             column = 1 ;
             hight += 90 ;
             witd = 560 ;
        }
        }


    }
    private Positions getPosition()
    {
        int rands = rand.nextInt(--index);
        Positions pos = listAddressBegin.get(rands);
        listAddressBegin.remove(pos);
        return  pos ;

    }


}
