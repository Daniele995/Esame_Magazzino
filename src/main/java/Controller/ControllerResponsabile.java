package Controller;

import Entity.RegistroProdotti;
import Entity.Prodotto;

public class ControllerResponsabile {
    public static final int PRODOTTO_NON_INSERITO=0;
    public static final int PRODOTTO_INSERITO_SUCCESSO=1;
    public static final int PRODOTTO_NON_MODIFICATO = 2;
    public static final int PRODOTTO_MODIFICATO_SUCCESSO = 3;
    public static final int ERRORE_DATI_PRODOTTO=-1;
    public static final int PRODOTTO_GIA_PRESENTE=-2;

    public static int creaProdotto(
            String nome,
            String descrizione,
            String categoria,
            int sogliaMinima,
            String posizione) {

        RegistroProdotti registroProdotti = new RegistroProdotti();
        boolean datiValidi = registroProdotti.validaDati(nome);
        if (!datiValidi) {return PRODOTTO_GIA_PRESENTE;}

        boolean esito = registroProdotti.creaProdotto(nome, descrizione, categoria, sogliaMinima, posizione);
        if (esito) {return PRODOTTO_INSERITO_SUCCESSO;}

        return PRODOTTO_NON_INSERITO;
    }

    private static String[] estraiDatiProdotto(Prodotto prodotto) {

        return new String[] {
                String.valueOf(prodotto.getId()),
                prodotto.getNome(),
                prodotto.getDescrizione(),
                prodotto.getCategoria(),
                String.valueOf(prodotto.getSogliaMinima()),
                prodotto.getPosizione()
        };
    }



    public static String[] ricercaProdotto(int idProdotto) {

        RegistroProdotti registroProdotti = new RegistroProdotti();
        Prodotto prodotto = registroProdotti.ricercaProdotto(idProdotto);
        if (prodotto == null) {return null;}

        return estraiDatiProdotto(prodotto);
    }

    public static String[] ricercaProdotto(String nomeProdotto) {

        RegistroProdotti registroProdotti = new RegistroProdotti();
        Prodotto prodotto = registroProdotti.ricercaProdotto(nomeProdotto);
        if (prodotto == null) {return null;}

        return estraiDatiProdotto(prodotto);
    }

    public static int modificaProdotto(
            int idProdotto,
            String nome,
            String descrizione,
            String categoria,
            int sogliaMinima,
            String posizione) {

        RegistroProdotti registroProdotti = new RegistroProdotti();

        boolean nomeValido = registroProdotti.validaNomeModifica(idProdotto, nome);

        if (!nomeValido) {return PRODOTTO_GIA_PRESENTE;}

        boolean esito =
                registroProdotti.modificaProdotto(
                        idProdotto,
                        nome,
                        descrizione,
                        categoria,
                        sogliaMinima,
                        posizione
                );

        if (esito) {return PRODOTTO_MODIFICATO_SUCCESSO;}

        return PRODOTTO_NON_MODIFICATO;
    }

}
