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
        //rs = this.requestController.makeRequest();
    }
    public void initialize() {
    }
}
