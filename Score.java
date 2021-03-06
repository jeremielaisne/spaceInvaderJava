class Score 
{
    
    private int cpt = 0;
    private int vie = 3;
    private int tmp = 0;
    Dessin dessin;
    
    //Constructeur sans argument
    Score()
    {
        cpt = 0;
    	dessin = new Dessin();
    }

    // Getters
    public int getCpt()
    {
        return this.cpt;
    }

    public int getVie()
    {
        return this.vie;
    }

    public int getTmp()
    {
        return this.tmp;
    }


    // Setters
    public void setCpt(int cpt)
    {
        this.cpt = cpt;
    }

    public void setVie(int vie)
    {
        this.vie = vie;
    }

    public void setTmp(int tmp)
    {
        this.tmp = tmp;
    }


    // Dessin
    Dessin getDessin()
    {
        dessin.vider();
        dessin.ajouteChaine(5, 59, "Score : "+getCpt());
        dessin.ajouteChaine(25, 59, "Vie  : "+getVie());
        dessin.ajouteChaine(5, 57, "Tmp  : "+(3000-getTmp()));
        dessin.ajouteChaine(45, 59, "Touche ENTREE pour mettre en pause");
        return dessin;
    }

    // Methodes
    public void ajouteScore(int cpt)
    {
        setCpt(getCpt()+cpt);
        getDessin();
        //System.out.println(getCpt());
    }

    public void ajouteTemps()
    {
        setTmp(getTmp()+1);
        //System.out.println(getTmp());
    }

    public void baisseVie()
    {
        setVie(getVie()-1);
        getDessin();
        //System.out.println(getVie());
    }
}
