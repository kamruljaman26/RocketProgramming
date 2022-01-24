package firstname_lastname_part1;

import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class FirstName_lastName_Part1 extends Application {

    public static void main(String[] args) {

        launch(args);
        // TODO code application logic here
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label first_name = new Label("First Name");
        Label last_name = new Label("Last Name");
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        Button Submit = new Button("Submit");
        Button start = new Button("Start");
        Button stop = new Button("Stop");
        Button reset = new Button("Reset");
        
        // Here We Use Key Event For Button
       Submit.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Submited");
            }
        });

        // Here we Use 4 different Shape  in Center Section Of Border Pane
        VBox vBox = new VBox();
        Rectangle rectangle = getRectangle();
        Circle circle = getCircle();
        Line line = getLine();
        Ellipse ellipse = getEllipse();

        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(line, circle, rectangle, ellipse);

        // Use Grid pane in Top Section Of Border Pane
        GridPane gridPane = new GridPane();

        gridPane.addRow(0, first_name, tf1);
        gridPane.addRow(1, last_name, tf2);
        gridPane.addRow(2, Submit);
        gridPane.setAlignment(Pos.CENTER);

        // Use FlowPane in Bpttom Section Of Border Pane  
        FlowPane flowPane = new FlowPane();
        flowPane.setVgap(6);
        flowPane.setHgap(5);
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setPrefWrapLength(250);
        flowPane.getChildren().add(start);
        flowPane.getChildren().add(stop);
        flowPane.getChildren().add(reset);

        // Here We use BorderPane For Our App 
        BorderPane borderPane = new BorderPane();

        Scene scene = new Scene(borderPane, 400, 600);

        borderPane.setTop(gridPane);
        borderPane.setBottom(flowPane);
        borderPane.setCenter(vBox);

        primaryStage.setScene(scene);

        primaryStage.show();

    }

    // In This method We get Rectangle Shape 
    public Rectangle getRectangle() {
        Rectangle rect = new Rectangle(200, 90, 70, 50);
        rect.setStroke(Color.WHITE);
        rect.setFill(Color.BLUE);
        // Here we Lambda Expression for handle mouse events for rectangle shape
        rect.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent me) -> {
            System.out.println("Rectangle pressed to left");
        });

        return rect;
    }
    // In This method We get Circle Shape 
    // In This method We get Circle Shape 

    public Circle getCircle() {
        Circle circle = new Circle(40, 30, 10);
        circle.setStroke(Color.WHITE);
        circle.setFill(Color.BLUE);
        // Here we use Anonymous Class for handle mouse events for Circle shape
        // And we Also use key event For Mouse 
        circle.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                System.out.println("Circle pressed to Middle ");
            }
        });
        return circle;
    }
// In This method We get line Shape 

    public Line getLine() {
        Line line = new Line(10, 10, 40, 20);
        line.setStroke(Color.AQUA);

        line.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                System.out.println("Line pressed to Bottom");
            }
        });
        return line;
    }
    // In This method We get Ellispse Shape 


    public Ellipse getEllipse() {
        Ellipse ellipse = new Ellipse(30, 14, 7, 17);
        ellipse.setStroke(Color.WHITE);
        ellipse.setFill(Color.BLUE);

        // Here we Lambda Expression for handle mouse events for Ellipse shape
        ellipse.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent me) -> {
            System.out.println("Elipse pressed to Bottom");
        });

        return ellipse;
    }
}
