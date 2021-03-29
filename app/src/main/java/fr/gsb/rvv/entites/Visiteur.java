package fr.gsb.rvv.entites;

public class Visiteur {

    public String matricule;
    public String mdp;
    public String nom;
    public String prenom;

    public Visiteur(String matricule,String mdp,String nom,String prenom){
        this.matricule=matricule;
        this.mdp=mdp;
        this.nom=nom;
        this.prenom=prenom;
    }

    public Visiteur(String matricule,String mdp){
        this.matricule=matricule;
        this.mdp=mdp;}

    public Visiteur(){

    }

    public String getMatricule(){
        return matricule;
    }

    public String getMdp(){
        return mdp;
    }

    public String getNom(){
        return nom;
    }

    public String getPrenom(){
        return prenom;
    }

    public void setMatricule(String matricule){
        this.matricule=matricule;
    }

    public void setMdp(String mdp){
        this.mdp=mdp;
    }

    public void setNom(String nom){
        this.nom=nom;
    }

    public void setPrenom(String prenom){
        this.prenom=prenom;
    }


    @Override
    public String toString() {
        return "Visiteur{" +
                "matricule='" + matricule + '\'' +
                ", mdp='" + mdp + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
