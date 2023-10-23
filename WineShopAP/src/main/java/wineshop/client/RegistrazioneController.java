package wineshop.client;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import model.Utenti;
import utilities.Costanti;
import utilities.Response;

import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrazioneController {
    private RequestController requestController;
    @FXML
    private Button Reg_BtnLogin;

    @FXML
    private Button Reg_BtnReg;

    @FXML
    private TextField Reg_CF;

    @FXML
    private TextField Reg_Cog;

    @FXML
    private PasswordField Reg_ConfPass;

    @FXML
    private TextField Reg_Email;

    @FXML
    private TextField Reg_Ind;

    @FXML
    private CheckBox Reg_Mostra;

    @FXML
    private TextField Reg_Nome;

    @FXML
    private PasswordField Reg_Password;

    @FXML
    private TextField Reg_Tel;

    @FXML
    private TextField Reg_Username;
    @FXML
    private ComboBox<String> Reg_SceltaTipo = new ComboBox<>();
    public void setRequestController(RequestController controller) {
        this.requestController = controller;
    }

    public void OnReg_BtnRegClick(ActionEvent event) throws Exception {
        String nome = this.Reg_Nome.getText();
        String cognome = this.Reg_Cog.getText();
        String indirizzo = this.Reg_Ind.getText();
        String telefono = this.Reg_Tel.getText();
        String cf = this.Reg_CF.getText();
        String email = this.Reg_Email.getText();
        String tipo = this.Reg_SceltaTipo.getValue();
        String username = this.Reg_Username.getText();
        String password = this.Reg_Password.getText();
        String cof_password = this.Reg_ConfPass.getText();

        if(username.isEmpty() || nome.isEmpty() || cognome.isEmpty() || indirizzo.isEmpty() || telefono.isEmpty() || cf.isEmpty() || email.isEmpty() || tipo.isEmpty() || password.isEmpty() || cof_password.isEmpty())
        {
            String s = "Il campo non può essere vuoto";
            PopUpCampiVuoti(s);
            Reg_Nome.clear();
            Reg_Cog.clear();
            Reg_Ind.clear();
            Reg_Tel.clear();
            Reg_CF.clear();
            Reg_Email.clear();
            Reg_Username.clear();
            Reg_Password.clear();
            Reg_ConfPass.clear();
            return;
        }

        if(!Reg_Email.getText().contains("@") || email.isEmpty())
        {
            PopUpEmail();
            Reg_Email.clear();
            return;
        }

        if(!checkCF(cf))
        {
            String s = "Reinserire il codice fiscale perche' non sono stati rispettati i criteri necessari";
            PopUpCampiVuoti(s);
            Reg_CF.clear();
            return;
        }

        if(!password.equals(cof_password))
        {
            PopUpPassword();
            Reg_Password.clear();
            Reg_ConfPass.clear();
            return;
        }

        try {
            Utenti u = new Utenti(username, nome, cognome, cf, email, telefono, indirizzo, password, tipo);
            Response r = this.requestController.makeRequest(Costanti.Registrazione, u);

            if(r.getStatusCode() == Costanti.Successo)
            {
                System.out.println("Registrazione avvenuta con successo");
            } else {
                System.out.println("Registrazione fallita");
            }
        } catch (Exception e)
        {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public static boolean checkCF(String input)
    {
        Pattern pattern = Pattern.compile("^[A-Z]{6}\\d{2}[A-Z]\\d{2}[A-Z]\\d{3}[A-Z]$");
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }
    private void PopUpCampiVuoti(String s)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setHeaderText("Si è verificato un errore");
        alert.setContentText("Compilare tutti i campi." + s);
        alert.showAndWait();
    }
    private void PopUpEmail()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setHeaderText("Si è verificato un errore");
        alert.setContentText("L'email deve contenere una @ e non puo essere vuota");
        alert.showAndWait();
    }
    private void PopUpPassword()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setHeaderText("Si è verificato un errore");
        alert.setContentText("Le password non coincidono");
        alert.showAndWait();
    }

}
