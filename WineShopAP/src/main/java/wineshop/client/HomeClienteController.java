package wineshop.client;

import model.Utenti;
import utilities.Costanti;
import utilities.Response;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
public class HomeClienteController {

    @FXML
    private Button HC_BtnLogout;

    // questi 4 campi vanno copiati su ogni controller
    private RequestController requestController;
    private Utenti UtenteLoggato;


    public void setRequestController(RequestController controller) {
        this.requestController = controller;
    }

    public void setUtenteLoggato(Utenti utenteLoggato) {
        this.UtenteLoggato = utenteLoggato;
    }

    public void OnHC_BtnLogoutClick(ActionEvent event) throws Exception{
        System.out.println("Tentativo di logout");

        Response rs;
        rs = this.requestController.makeRequest(Costanti.Logout, UtenteLoggato);

        if(rs.getStatusCode() != Costanti.Successo)
        {
            return;
        }
        setUtenteLoggato(null);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent LoginGui = loader.load();
        Object controller = loader.getController();
        Scene scene = new Scene(LoginGui, 346, 600);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ((LoginController) controller).setRequestController(this.requestController);
        ((LoginController) controller).setUtenteLoggato(UtenteLoggato);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    public void initialize() {
    }
}
