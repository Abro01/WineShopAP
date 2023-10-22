package wineshop.client;

import model.Utenti;

public class HomeAdminController {
    private RequestController requestController;
    private Utenti UtenteLoggato;

    public void setRequestController(RequestController requestController) {
        this.requestController = requestController;
    }

    public void setUtenteLoggato(Utenti utenteLoggato) {
        this.UtenteLoggato = utenteLoggato;
    }
    public void initialize() {
    }
}
