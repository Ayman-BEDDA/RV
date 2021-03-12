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
        Session session=new Session();
    }

    public static void fermer(){
        Session session=null;
    }

    public static Session getSession(){
        return Session.session;
    }
}
