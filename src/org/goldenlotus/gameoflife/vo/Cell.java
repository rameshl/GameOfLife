package org.goldenlotus.gameoflife.vo;

/**
 * Created by rameshl
 * Date: 11/15/11
 */
public class Cell {
    private String coordX;
    private String coordY;

    private boolean cellAlive;

    public String getCoordX(){
        return coordX;
    }
    public void setCoordX(String coordX){
        this.coordX = coordX;
    }
    public String getCoordY(){
        return coordY;
    }
    public void setCoordY(String coordY){
        this.coordY = coordY;
    }

    public boolean isCellAlive() {
        return cellAlive;
    }

    public void setCellAlive(boolean cellAlive) {
        this.cellAlive = cellAlive;
    }

}
