package utilities;

public enum Operation {
    getUsers {
        public String toString() { return "getUsers"; }
    },
    getWine{
        public String toString() { return "getWine"; }
    },
    getDipendenti {
        public String toString() { return "getDipendenti"; }
    },
    getClienti {
        public String toString() { return "getClienti"; }
    },
    getAmministratori{
        public String toString() { return "getAmministratori"; }
    },
    getCorrieri {
        public String toString() { return "getCorrieri"; }
    },
    getFornitori {
        public String toString() { return "getFornitori"; }
    },
    getOrdiniAcquisto{
        public String toString() { return "getOrdiniAcquisto"; }
    },
    getOrdiniSaldi {
        public String toString() { return "getOrdiniSaldi"; }
    },
    getProposteAcquisto {
        public String toString() { return "getProposteAcquisto"; }
    },
    Login {
        public String toString() { return "Login"; }
    },
    Registrazione {
        public String toString() { return "Registrazione"; }
    },
    UpdatePassword{
        public String toString() { return "UpdatePassword"; }
    },
    CloseConn {
        public String toString() { return "CloseConn"; }
    },
    OpenConn {
        public String toString() { return "OpenConn"; }
    },
    CheckUsername{
        public String toString() { return "CheckUsername"; }
    },
    CheckUserPassword {
        public String toString() { return "CheckUserPassword"; }
    },
    getImmagine{
        public String toString() { return "getImmagine"; }
    },
    UpdateWine {
        public String toString() { return "UpdateWine"; }
    },
    AddWine {
        public String toString() { return "AddWine"; }
    },
    DeleteWine{
        public String toString() { return "DeleteWine"; }
    },
    AddUsers {
        public String toString() { return "UpdateFornitori"; }
    },
    DeleteUsers {
        public String toString() { return "DeleteUsers"; }
    },
    UpdateUsers{
        public String toString() { return "UpdateUsers"; }
    },
    AddFornitore {
        public String toString() { return "AddFornitore"; }
    },
    DeleteFornitore {
        public String toString() { return "getClienti"; }
    },
    UpdateFornitore{
        public String toString() { return "getAmministratori"; }
    },
    getProposteAcquistoDipendeteAttivo {
        public String toString() { return "getProposteAcquistoDipendeteAttivo"; }
    },
    getProposteAcquistoDipendeteAttivoFiltro {
        public String toString() { return "getProposteAcquistoDipendeteAttivoFiltro"; }
    },
    getProposteAcquistoDipendeteCompleto{
        public String toString() { return "getProposteAcquistoDipendeteCompleto"; }
    },
    getProposteAcquistoDipendeteCompletoFiltro {
        public String toString() { return "getProposteAcquistoDipendeteCompletoAttivo"; }
    },
    AddAcquisto {
        public String toString() { return "AddAcquisto"; }
    },
    AddCorriere {
        public String toString() { return "AddCorriere"; }
    },
    DeleteCorriere {
        public String toString() { return "DeleteCorriere"; }
    },
    UpdateCorriere{
        public String toString() { return "UpdateCorriere"; }
    },
    getCarrelloUser {
        public String toString() { return "getCarrelloUser"; }
    },
    getWineFiltro {
        public String toString() { return "getWineFiltro"; }
    },
    Compra{
        public String toString() { return "CheckUsername"; }
    },
    getClientiFiltro {
        public String toString() { return "getClientiFiltro"; }
    },
    UpdateBilancio{
        public String toString() { return "UpdateBilancio"; }
    },
    getOrdiniSaldoFiltro {
        public String toString() { return "getOrdiniSaldoFiltro"; }
    },
    getAcquistoOrdineFiltro {
        public String toString() { return "getAcquistoOrdineFiltro"; }
    },
    getAcquistoPropostoFiltro{
        public String toString() { return "getAcquistoPropostoFiltro"; }
    },
    getAllOrdiniSaldoCLienti {
        public String toString() { return "getAllOrdiniSaldoCLienti"; }
    },
    getAllOrdiniSaldiDipendentiFiltro {
        public String toString() {
            return "getAllOrdiniSaldiDipendentiFiltro";
        }
    },
    getOrdiniSaldoAttivoDipendenti{
        public String toString() {
            return "getOrdiniSaldoAttivoDipendenti";
        }
    },
    getOrdiniSaldoAttivoDipendentiFiltro {
        public String toString() {
            return "getOrdiniSaldoAttivoDipendentiFiltro";
        }
    },
    getOrdineSaldoCancellatoDipendenti {
        public String toString() {
            return "getOrdineSaldoCancellatoDipendenti";
        }
    },
    getOrdineSaldoCancellatoDipendentiFiltro {
        public String toString() {
            return "getOrdineSaldoCancellatoDipendentiFiltro";
        }
    },
    getSaldoOrdineCompletatoDipendenti {
        public String toString() { return "getSaldoOrdineCompletatoDipendenti"; }
    },
    getSaldoOrdineCompletatoDipendentiFiltro {
        public String toString() { return "getSaldoOrdineCompletatoDipendentiFiltro"; }
    },
    getAllProposteAcquistoDipendenti {
        public String toString() { return "getAllProposteAcquistoDipendenti"; }
    },
    getAllProposteAcquistoDipendentiFiltro {
        public String toString() { return "getAllProposteAcquistoDipendentiFiltro"; }
    },
    UpdateAcquisto {
        public String toString() { return "UpdateAcquisto"; }
    },
    DeleteAcquisto {
        public String toString() { return "DeleteAcquisto"; }
    },
    CompletaPropostaAcquisto {
        public String toString() { return "CompletaPropostaAcquisto"; }
    },
    getAcquistoDallaPropostaAcquisto {
        public String toString() { return "getAcquistoDallaPropostaAcquisto"; }
    },
    getAllProposteAcquistoClienti {
        public String toString() { return "getAllProposteAcquistoClienti"; }
    },
    getAllSaldoOrdineDipendente {
        public String toString() { return "getAllSaldoOrdineDipendente"; }
    },
    CompletoSaldoOrdine {
        public String toString() { return "CompletoSaldoOrdine"; }
    },
    setValutazioneSaldoOrdine {
        public String toString() { return "setValutazioneSaldoOrdine"; }
    },
    CancellaSaldoOrdine {
        public String toString() { return "CancellaSaldoOrdine"; }
    },
    RichiestaNuovi {
        public String toString() { return "RichiestaNuovi"; }
    },
    getInfoReport {
        public String toString() { return "getInfoReport"; }
    },
    CheckAssegnamentoDataDinamica {
        public String toString() { return "CheckAssegnamentoData"; }
    },
    UpdatePrezzovinoDinamica {
        public String toString() { return "UpdatePrezzovinoDinamica"; }
    },
    CheckSogliaVinoDinamica {
        public String toString() { return "CheckSogliaVinoDinamica"; }
    },
    getSconto {
        public String toString() { return "getSconto"; }
    },
    TestConn {
        public String toString() { return "TestConn"; }
    };

    public String toTitle()
    {
        String s;

        switch (this)
        {
            case getWine -> s = "Vini";
            case getUsers -> s = "Utenti";
            case getDipendenti -> s = "Dipendenti";
            case getClienti -> s = "Clienti";
            case getAmministratori -> s = "Amministratori";
            case getCorrieri -> s = "Corrieri";
            case getFornitori -> s = "Fornitori";
            case getOrdiniAcquisto -> s = "Ordini Acquistati";
            case getOrdiniSaldi -> s = "Saldo Ordini";
            case getProposteAcquisto -> s = "Proposte Acquisto";
            case getProposteAcquistoDipendeteAttivo -> s = "Proposte D'acquisto Attive";
            case getProposteAcquistoDipendeteAttivoFiltro -> s = "Proposte D'acquisto Attive Filtro";
            case getProposteAcquistoDipendeteCompleto -> s = "Proposte D'acquisto Completate dai DIpendenti";
            case getProposteAcquistoDipendeteCompletoFiltro -> s = "Proposte D'acquisto Completate dai DIpendenti Filtro";
            case getCarrelloUser -> s = "Carrello";
            case getWineFiltro -> s = "Filtro Vini";
            case getClientiFiltro -> s = "Filtro Clienti";
            case getOrdiniSaldoFiltro -> s = "Saldo Filtro Ordini";
            case getAcquistoOrdineFiltro -> s = "Filtro Acquisto Ordine";
            case getAcquistoPropostoFiltro -> s = "Filtro Acquisti Proposti";
            case getAllSaldoOrdineDipendente -> s = "Saldo Ordine Dipendente";
            case getAllOrdiniSaldiDipendentiFiltro -> s = "Saldo Ordine DIpendenti FIltro";
            case getOrdiniSaldoAttivoDipendenti -> s = "Saldo Ordine Attivo Dipendenti";
            case getOrdiniSaldoAttivoDipendentiFiltro -> s = "Filtro Saldo Ordine Attivo Dipendenti";
            case getOrdineSaldoCancellatoDipendenti -> s = "Saldo Ordine Cancellato Dipendenti";
            case getOrdineSaldoCancellatoDipendentiFiltro -> s = "Filtro Saldo Ordine Cancellato Dipendenti";
            case getSaldoOrdineCompletatoDipendenti -> s = "Saldo Ordine Completato Dipendenti";
            case getSaldoOrdineCompletatoDipendentiFiltro -> s = "Filtro Saldo Ordine Completato Dipendenti";
            case getAllProposteAcquistoDipendenti -> s = "Proposte Acquisto DIpendenti";
            case getAllProposteAcquistoDipendentiFiltro -> s = "Filtro Proposte Acquisto DIpendenti";
            case getAllProposteAcquistoClienti -> s = "Proposta D'acquisto CLienti";
            case getAllOrdiniSaldoCLienti -> s = "Saldo Ordine Clienti";
            default -> s = null;
        }
        return s;
    }
}
