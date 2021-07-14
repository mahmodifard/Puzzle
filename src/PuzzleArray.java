/**
 * Created by IntelliJ IDEA.
 * User: BlackHorse
 * Date: Dec 15, 2009
 * Time: 11:38:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class PuzzleArray {
    int[][] beginArray = new int[5][5];
    int[][] endArray   = new int[5][5];

    public PuzzleArray() {
        for (int i = 0; i < beginArray.length; i++) {

            beginArray[i] = new int[6];

        }

    }
    public void setBeginArray(int x,int y,int value)
    {
        this.beginArray[x][y] = value ;
    }

    public void setEndArray(int x,int y,int value)
    {
        this.endArray[x][y] = value ;
    }

    public int getBeginArray(int x,int y)
    {
        return this.beginArray[x][y] ;
    }

    public int getEndArray(int x,int y)
    {
        return this.endArray[x][y] ;
    }


}
