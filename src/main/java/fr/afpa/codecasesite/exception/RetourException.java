package fr.afpa.codecasesite.exception;


import java.util.logging.Logger;

/**
 * RetourException.
 * <i>de fr.afpa.ecfjackarta.exceptions</i>
 * <hr>
 * <p>Objet servant de conteneur pour les retours d'exceptions.
 * Messages utilisateur, sévérité ect seront contenu dedans</p>
 *
 * @author Mordant Thierry
 * @version 0.0.1
 * @since 2026/04/02
 */
public class RetourException {

    /**
     * LOGGER pour écrire dans Tomcat.
     */
    private static final Logger LOGGER =
            Logger.getLogger(RetourException.class.getName());

    /**
     * Le message pour l'utilisateur.
     */
    private String msgUtilisateur;

    /**
     * la sévérité.
     */
    private int severity;

    /**
     *Constructeur implicite.
     */
    public RetourException() {
    }

    /**
     *
     *Constructeur.
     *<i>de RetourException</i>
     *<hr>
     *
     * @param paraMsg le message Utilisateur
     * @param paraSevere la sévérité
     */
    public RetourException(String paraMsg, int paraSevere) {

        setMsgUtilisateur(paraMsg);
        setSeverity(paraSevere);
    }


    /**
     * Méthode setMsgUtilisateur.
     *
     * <i>de RetourException</i>
     * <hr>
     * <p>Définit le message utilisateur</p>
     *
     * @param paraMsg le message
     */
    public void setMsgUtilisateur(String paraMsg) {

        //* Un simple test pour permettre de rapidement remarquer quand un
        // message est non défini lors des test de l'appli
        if (paraMsg != null) {
            this.msgUtilisateur = paraMsg;
        } else {
            LOGGER.severe("Un message utilisateur est null !");
            this.msgUtilisateur = "DEBUG MESSAGE: Aucun message utilisateur "
                    + "défini pour cette exception !";
        }
    }


    /**
     * Méthode setSeverity.
     *
     * <i>de RetourException</i>
     * <hr>
     * <p>Définit la severité</p>
     *
     * @param paraSeverity la sévérité
     */
    public void setSeverity(int paraSeverity) {

        if (paraSeverity >= ExceptionManager.severityLow && paraSeverity
                <= ExceptionManager.severityHigh) {
            this.severity = paraSeverity;
        } else {
            LOGGER.severe("Un niveau de sévérité est hors des caps "
                    + "imposés ! Niveau: " + paraSeverity);
            this.severity = 5;
        }
    }


    /**
     * Méthode getMsgUtilisateur.
     *
     * <i>de RetourException</i>
     * <hr>
     * <p>Renvoie le message utilisateur</p>
     *
     * @return le message
     */
    public String getMsgUtilisateur() {

        return this.msgUtilisateur;
    }


    /**
     * Méthode getSeverity.
     *
     * <i>de RetourException</i>
     * <hr>
     * <p>Renvoie la severité</p>
     *
     * @return la sévérité
     */
    public int getSeverity() {

        return this.severity;
    }
}

