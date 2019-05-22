package com.example.jamila.projet_formalab_mobile;

public class Project {

    private int id;
    private String titre;

    public Project(){}
    public Project(String titre) {
        this.titre = titre;
    }

    public Project(int id, String titre) {
        this.id = id;
        this.titre = titre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

}
