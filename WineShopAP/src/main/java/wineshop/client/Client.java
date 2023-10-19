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
                System.out.print("\nControllando la connessione al server...");
                socket = new Socket(ip, port);
            }catch (Exception e)
            {
                ButtonType btn = new ButtonType("Riprova");
                Alert alert = new Alert(AlertType.ERROR, "Controlla la tua connessione a (" + ip + ":" + port + ") e riprova, se il problema persiste, " +
                        "probabilmente il server e' spento.\nUsa un ip e una porta chiamando il programma con --ip=yourip --port=yourport", btn, ButtonType.CANCEL);

                alert.setHeaderText("indisponibilità di ricerca del server");
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

        System.out.println("Connesso");

        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login_Reg_PassDim.fxml"));

        Parent root = loader.load();
        LoginController controller = loader.getController();
        RequestController requestController = new RequestController(out, in);
        //controller.set
    }
    public static void main(String[] args)
    {

    }
}
