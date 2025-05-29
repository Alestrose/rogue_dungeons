package alan.grids;

import java.awt.Graphics2D;

import javax.swing.JPanel;

import alan.Constants;

// Singleton Class
public class Grid {
    private int rows, cols;
    private Cell[][] cellArray;
    protected int borderBuffer = 1;

    private static Grid instance = null;
    private Grid(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        setCellArray();
    }

    /*
     * Methods
     */

    public static Grid getInstance(int rows, int cols){
        if(instance == null){
            instance = new Grid(rows, cols);
        }return instance;
    }

    // For use in "GameManager.drawSprites()"
    public void drawGrid(Grid grid, Graphics2D graphics, JPanel panel){
        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getCols(); j++) {
                graphics.drawImage(
                    grid.getCellArray()[i][j].getImage(),
                    grid.getCellArray()[i][j].getX(),
                    grid.getCellArray()[i][j].getY(),
                    grid.getCellArray()[i][j].getWidth(),
                    grid.getCellArray()[i][j].getHeight(),
                    panel);
            }
        }
    }

    /*
     * Getters and Setters
     */

    public Cell[][] getCellArray() {
        return cellArray;
    }

    private void setCellArray(){
        cellArray = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cellArray[i][j] = new Cell(i, j,(Constants.GRID_PANEL_WIDTH/rows)-borderBuffer, (Constants.GRID_PANEL_WIDTH/cols)-borderBuffer, "Cell.png");
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }


}
