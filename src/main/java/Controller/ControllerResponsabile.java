package Controller;

import Entity.RegistroProdotti;

public class ControllerResponsabile {
    public static final int PRODOTTO_NON_INSERITO=0;
    public static final int PRODOTTO_INSERITO_SUCCESSO=1;
    public static final int PRODOTTO_MODIFICATO_SUCCESSO=2;
    public static final int ERRORE_DATI_PRODOTTO=-1;
    public static final int PRODOTTO_GIA_PRESENTE=-2;

    public int creaProdotto(
            String nome,
            String descrizione,
            String categoria,
            int sogliaMinima,
            String posizione) {

        RegistroProdotti registroProdotti = new RegistroProdotti();

        boolean datiValidi = registroProdotti.validaDati(nome);

        if (!datiValidi) {return PRODOTTO_GIA_PRESENTE;}

        boolean esito = registroProdotti.creaProdotto(
                nome,
                descrizione,
                categoria,
                sogliaMinima,
                posizione
        );

        if (esito) {return PRODOTTO_INSERITO_SUCCESSO;}

        return PRODOTTO_NON_INSERITO;
    }

}
