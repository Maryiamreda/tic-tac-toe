package org.example;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import static org.example.GameConstants.*;

public class UI extends Application {
    private final ChoiceBox<Levels> levelsClass = new ChoiceBox<>();
    Player player1 = new Human();
    Player player2;
    Game game;
    GridPane gridPane;
    Label gameStatus = new Label();
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(GAME_TITLE);
        VBox root= new VBox(displayNewMatrix());
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    private Parent displayNewMatrix() {
        gridPane = new GridPane();
        gameStatus.setStyle(STATUS_TEXT_STYLE);
        gameStatus.setTextFill(STATUS_TEXT_COLOR);
        Button resetButton = new Button("Reset Board");
        resetButton.setOnAction(evt -> newGame());
        HBox buttons = new HBox(levelsChoice() , resetButton);
        buttons.setSpacing(ITEMS_SPACING);
        VBox v = new VBox(buttons, gameStatus, gridPane);
        v.setSpacing(ITEMS_SPACING);
        for (int i = 0; i < GRID_ROW; i++) {
            for (int j = 0; j < GRID_COLUMN; j++) {
                Button b = new Button();
                b.setMinWidth(BUTTON_SIZE);
                b.setMinHeight(BUTTON_SIZE);
                gridPane.add(b, j, i);
            }
        }
        gridPane.setHgap(ITEMS_SPACING);
        gridPane.setVgap(ITEMS_SPACING);
        v.setAlignment(Pos.CENTER);
        return v;
    }
    private void gameStart() {
        for (int i = 0; i < GRID_ROW; i++) {
            for (int j = 0; j < GRID_COLUMN; j++) {
                final int r = i;
                final int c = j;
                Button btn = (Button) getChildAtRowCol(r, c);
                btn.setOnAction(evt -> {
                    onCellClick( r ,  c);
                });
            }
        }
    }
    private void onCellClick(int r , int c){
        ((Human) player1).setMove(r, c);
        game.runGameLoop();
        updateBoard();
        checkGameStatus();
    }
    private Parent levelsChoice() {
        Label label = new Label("Bot Level:");
        levelsClass.setPrefWidth(200);
        Button saveButton = new Button("ok");
        HBox hbox = new HBox(label, levelsClass, saveButton);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(40));
        initChoice();
        saveButton.setOnAction((evt) -> {
            newGame();
            saveButton.setDisable(true);

        });
        return hbox;
    }
    private void updateBoard() {
        Symbols[][] board = game.getBoard();
        for (int i = 0; i < GRID_ROW; i++) {
            for (int j = 0; j < GRID_COLUMN; j++) {
                Button btn = (Button) getChildAtRowCol(i, j);
                if (board[i][j] != null) {
                    btn.setText(board[i][j].toString());
                }
            }
        }
    }
    private void initChoice() {
        List<Levels> levelClasses = new ArrayList<>();
        levelClasses.add(Levels.EASY);
        levelClasses.add(Levels.MEDIUM);
        levelClasses.add(Levels.HARD);
        levelsClass.getItems().addAll(levelClasses);
        levelsClass.setValue(null);
    }
    private void checkGameStatus() {
        Status status = game.getGameStatus();
        switch (status) {
            case X_WINS -> gameStatus.setText(X_WINNING_TEXT);
            case O_WINS -> gameStatus.setText(O_WINNING_TEXT);
            case TIE -> gameStatus.setText(TIE_TEXT);
        }
    }
    private void newGame() {
        if (game== null) {
            player2 = new Bot(levelsClass.getValue());
            game= new Game(player1, player2);
        } else {
            game.reset();
            player2 = new Bot(levelsClass.getValue());
        }
        gameStatus.setText("");
        for (int i = 0; i < GRID_ROW; i++) {
            for (int j = 0; j < GRID_COLUMN; j++) {
                Button btn = (Button) getChildAtRowCol(i, j);
                btn.setText(null);
                btn.setOnAction(null);
            }
        }
        gameStart();
    }
    Node getChildAtRowCol(int row, int col) {
        ObservableList<Node> children = gridPane.getChildren();
        for (Node child : children) {
            Integer childRow = GridPane.getRowIndex(child);
            Integer childColumn = GridPane.getColumnIndex(child);
            int rr = (childRow == null) ? 0 : childRow;
            int cc = (childColumn == null) ? 0 : childColumn;
            if (cc == col && rr == row) {
                return child;
            }
        }
        return null;
    }
}