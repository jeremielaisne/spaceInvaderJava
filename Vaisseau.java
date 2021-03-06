class Vaisseau 
{
    //Attributs
    private double posX;
    private double posY;
    Dessin dessin;

    //Constructeur
    Vaisseau (double px, double py)
    {
		this.posX = px;
		this.posY = py;
		dessin = new Dessin();
    }

    //Getters
    public double getPx()
    {
    	return this.posX;
    }

    public double getPy()
    {
    	return this.posY;
    }


    //Setters
    public void setPx(double px)
    {
        this.posX+=px;
    }

    public void setPy(double py)
    {
        this.posY+=py;
    }

    //Méthodes
    Dessin getDessin()
    {
        // Dessine et Re-Dessine le vaisseau
        dessin.vider();
        dessin.ajouteChaine(getPx()+6,getPy()+5,"▄");
        dessin.ajouteChaine(getPx()+5,getPy()+4,"███");
        dessin.ajouteChaine(getPx(),getPy()+3,"▄███████████▄");
        dessin.ajouteChaine(getPx(),getPy()+2,"█████████████");
        dessin.ajouteChaine(getPx(),getPy()+1,"█████████████");
        return dessin;
    }

    Dessin getDessinCollision()
    {
        // Re-Dessine le vaisseau endommagé
        dessin.vider();
        dessin.ajouteChaine(getPx()+1,getPy()+5,"██▓      ██▓");
        dessin.ajouteChaine(getPx()+1,getPy()+4,"▒▓██▓   ▒▓▒");
        dessin.ajouteChaine(getPx()-2,getPy()+3,"░▒▒▓▒      ░ ▒");
        dessin.ajouteChaine(getPx()-2,getPy()+2,"░ ░▒      ░  ");
        return dessin;
    }

    public void deplace(double dx, double dy)
    {
        setPx(dx);
        setPy(dy);
    	for (ChainePositionnee cp : dessin.getChaines())
    	{
    		cp.setx(cp.getx()+dx);
    		cp.sety(cp.gety()+dy);
    	}
    }

    // Position du projectile par rapport au canon du vaisseau
    public double positionCanonX()
    {
		return getPx()+6;
    }

    public double positionCanonY()
    {
    	return getPy()+5;
    }

    // Methode contient necessaire pour les collisions entre le vaisseau et les projectiles aliens
    public boolean contient(double posx, double posy)
    {
        if (dessin.contient(posx, posy))
            return true;
        else
            return false;
    }
}
