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

public class HomeImpiegatoController {

    @FXML
    private Button HI_BtnLogout;
    private RequestController requestController;
    private Utenti UtenteLoggato;

    public void setRequestController(RequestController controller) {
        this.requestController = controller;
    }

    public void setUtenteLoggato(Utenti utenteLoggato) {
        this.UtenteLoggato = utenteLoggato;
    }
    public void initialize() {
    }
}
