class Projectile 
{

    private double posX;
    private double posY;
    Dessin dessin;
    
    Projectile(double px, double py)
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


    //Methodes
    Dessin getDessin()
    {
    	dessin.ajouteChaine(getPx(), getPy(), "O");
		return dessin;
    }
    
    Dessin getDessinA()
    {
    	dessin.ajouteChaine(getPx(), getPy(), "█");
		return dessin;
    }

    public void evolue()
    {
		setPy(0.2);
		dessin.vider();
		dessin.ajouteChaine(getPx(), getPy(), "O");
    }

    public void evolueA()
    {
		setPy(-0.4);
		dessin.vider();
		dessin.ajouteChaine(getPx(), getPy(), "█");
    }

     // Methode contient entre projectiles 
    public boolean contient(double posx, double posy)
    {
        if (dessin.contient(posx, posy))
            return true;
        else
            return false;
    }
}