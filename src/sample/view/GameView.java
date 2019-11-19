package sample.view;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Model.Level;

public class GameView extends Group {

    private ImageView[][] gridView;
    
    private int rows;
    private int columns;

    private Gifs pacManGifs;

    public final static double CELL_WIDTH = 20.0;

    public GameView() {
        //pacManGifs = new Gifs();
        initializeGridView();
    }

    private void initializeGridView() {
        this.gridView = new ImageView[this.rows][this.columns];
        for (int row = 0; row < this.rows; row++) {
            for (int column = 0; column < this.columns; column++) {
                ImageView imageView = new ImageView();
                imageView.setX((double)column * CELL_WIDTH);
                imageView.setY((double)row * CELL_WIDTH);
                imageView.setFitWidth(CELL_WIDTH);
                imageView.setFitHeight(CELL_WIDTH);
                this.gridView[row][column] = imageView;
                this.getChildren().add(imageView);
            }
        }
    }

    public void update(Level level) {
        for (int row = 0; row < this.rows; row++) {
            for (int column = 0; column < this.columns; column++) {
                gridView[row][column].setImage(new Image(getClass().getResourceAsStream("/src/ressources/smalldot.png")));
                //gridView[row][column].setImage(level.getCell(new Position(row,column)).toImageView());
            }
        }
    }

}
