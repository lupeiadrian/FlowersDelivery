import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class Demo extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");
        Button btn = new Button();
        Button btn1 =new Button();
        btn.setText("Login");
        btn1.setText("Register");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
           
            public void handle(ActionEvent event) {
                System.out.println("Login");
            }
        });
        btn1.setOnAction(new EventHandler<ActionEvent>() {
        	 
            
            public void handle(ActionEvent event) {
                System.out.println("Register");
            }
        });
        VBox root = new VBox();
        root.getChildren().addAll(btn,btn1);
        primaryStage.setTitle("FlowersDelivery");
        primaryStage.setScene(new Scene(root, 500, 300));
        primaryStage.show();
    }
}