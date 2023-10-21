package wineshop.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Optional;

public class Client extends Application{

    public void start(Stage primaryStage) throws Exception{
        Socket socket = null;
        String ip = "localhost";
        int port = 1234;

        if (getParameters().getRaw().size() == 2)
        {
            ip = getParameters().getNamed().get("ip");
            port = Integer.parseInt(getParameters().getNamed().get("port"));
        }

        System.out.println(ip + " : " + port);

        do
        {
            try {
                System.out.print("\nControllando la connessione al server...\n");
                socket = new Socket(ip, port);
            }catch (Exception e)
            {
                ButtonType btn = new ButtonType("Riprova");
                Alert alert = new Alert(AlertType.ERROR, "Controlla la tua connessione a (" + ip + ":" + port + ") e riprova, se il problema persiste, " +
                        "probabilmente il server e' spento.\nUsa un ip e una porta chiamando il programma con --ip=yourip --port=yourport", btn, ButtonType.CANCEL);

                alert.setHeaderText("Indisponibilità di ricerca del server");
                alert.setTitle("Errore di connessione");
                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                Optional<ButtonType> result = alert.showAndWait();

                if(result.get() == btn)
                {
                    System.out.println("\nRiprovando...");
                }else{
                    System.out.println("Exit");
                    System.exit(0);
                }
            }
        }while (socket == null);

        System.out.println("Connesso!");

        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

        FXMLLoader loader = new FXMLLoader(Client.class.getResource("Login.fxml"));

        /*Parent root = loader.load();
        LoginController controller = loader.getController();
        RequestController requestController = new RequestController(out, in);
        controller.setRequestController(requestController);*/
        Scene scene = new Scene(loader.load(), 346, 600);

        //primaryStage.getIcons().add(new Image("C:/Users/andre/OneDrive/Documenti/GitHub/WineShopAP/WineShopAP/src/main/resources/Design/Loghi/Logo.png"));

        primaryStage.setScene(scene);
        primaryStage.show();

        /*final Socket fSock = socket;
        primaryStage.setOnCloseRequest(event -> {
            try {
                //requestController.CloseConnection();
                fSock.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        });*/
    }
    public static void main(String[] args)
    {
        launch();
    }
}
