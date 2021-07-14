import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: BlackHorse
 * Date: Dec 15, 2009
 * Time: 9:37:44 PM
 * To change this template use File | Settings | File Templates.
 */

public class Positions implements Serializable {
    
        private int posX ;
        private int posY ;
        

        public Positions(int posX, int posY)
        {
            this.posX = posX;
            this.posY = posY;
        }

        public Positions()
        {
        }

        public int getPosX()
        {
            return posX;
        }

        public void setPosX(int posX)
        {
            this.posX = posX;
        }

        public int getPosY()
        {
            return posY;
        }

        public void setPosY(int posY)
        {
            this.posY = posY;
        }
    }


