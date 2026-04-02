package fr.afpa.codecasesite.exception;

import org.springframework.web.server.ResponseStatusException;


/**
 * ExceptionManager.
 * <i>de fr.afpa.codecasesite.exception</i>
 * <hr>
 * <p>Gestionnaire des Exceptions, dédié à rassembler la gestion des exceptions
 * majeures et centralisables</p>
 *
 * @author Mordant Thierry
 * @version 0.0.1
 * @since 02/04/2026
 */
public class ExceptionManager {

    /**
     * Constante de Severité haute.
     */
    public static int severityHigh = 6;

    /**
     * Constante de sévérité basse.
     */
    public static int severityLow = 1;


    /**
     * Méthode handleException.
     *
     * <i>de ExceptionManager</i>
     * <hr>
     * <p>Méthode "carrefour" du Gestionnaire des erreurs, renvoie vers la
     * bonne gestion d'erreur</p>
     *
     * @param ex l'exception à gérer
     * @return Objet de type RetourException
     */
    public static RetourException handleException(Exception ex) {

        if (ex instanceof ResponseStatusException) {

            return handleStatus(ex);
        }
        else {

            return handleUnknown(ex);
        }
    }

    /**
     * Méthode handleStatus.
     *
     * <i>de ExceptionManager</i>
     * <hr>
     * <p>Gère les Exceptions inconnues, aka "Si ça arrive faudra la trouver et
     * l'ajouter autrepart", évite des crashs inutiles</p>
     *
     * @param ex l'exception à gérer
     * @return Objet de type RetourException
     */
    private static RetourException handleStatus(Exception ex) {

        RetourException retour = new RetourException();

        retour.setSeverity(5);
        retour.setMsgUtilisateur("Une erreur applicative est survenue, veuillez"
                + " contactez la DSI !");


        return retour;
    }

    /**
     * Méthode handleUnknown.
     *
     * <i>de ExceptionManager</i>
     * <hr>
     * <p>Gère les Exceptions inconnues, aka "Si ça arrive faudra la trouver et
     * l'ajouter autrepart", évite des crashs inutiles</p>
     *
     * @param ex l'exception à gérer
     * @return Objet de type RetourException
     */
    private static RetourException handleUnknown(Exception ex) {

        RetourException retour = new RetourException();

        retour.setSeverity(5);
        retour.setMsgUtilisateur("Une erreur applicative est survenue, veuillez"
                + " contactez la DSI !");


        return retour;
    }
}
