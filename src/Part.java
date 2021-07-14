import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: BlackHorse
 * Date: Dec 15, 2009
 * Time: 9:35:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Part extends JButton{

    private int number ;
    private Positions positions ;
    private Icon icon ;

    public Part(Icon icon,int number) {
        super(icon);
        this.icon = icon ;
        this.number = number ;
    }

    public int getNumber() {
        return number;
    }

    public Positions getPositions() {
        return positions;
    }

    public void setPositions(Positions positions) {
        this.setLocation(positions.getPosX(),positions.getPosY());
        this.positions = positions;
    }
}
