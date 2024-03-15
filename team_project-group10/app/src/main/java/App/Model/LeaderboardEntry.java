package App.Model;

import java.io.Serializable;

public class LeaderboardEntry implements Serializable {
    private int xSize;
    private int ySize;
    private int zSize;
    private String time;

    public LeaderboardEntry(int xSize, int ySize, int zSize, String time) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.zSize = zSize;
        this.time = time;
    }

    public int getXSize() {
        return xSize;
    }

    public int getYSize() {
        return ySize;
    }

    public int getZSize() {
        return zSize;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return xSize + "x" + ySize + "x" + zSize + " : " + time;
    }
}