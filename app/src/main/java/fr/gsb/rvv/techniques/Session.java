package fr.gsb.rvv.techniques;
import fr.gsb.rvv.entites.Visiteur;

public class Session {

    private static Session session=null;
    private Visiteur leVisiteur;

    private Session(Visiteur leVisiteur){
        this.leVisiteur=leVisiteur;
    }

    public Session() {

    }

    public static void ouvrir(Visiteur leVisiteur){
        session=new Session(leVisiteur);
    }

    public static void fermer(){
        session=null;
    }

    public static Session getSession(){
        return Session.session;
    }

    public Visiteur getLeVisiteur() {
        return leVisiteur;
    }



}
