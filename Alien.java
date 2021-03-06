class Alien
{

	//Attributs
	private double posX;
	private double posY;
	private double vitesse = 0;
	Dessin dessin;
	ChainePositionnee cp;

	//Constructeur
	Alien (double px, double py)
	{
		this.posX=px;
		this.posY=py;
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
	Dessin getDessinA()
	{
		// Dessine et Re-Dessine le vaisseau
		dessin.vider();
		dessin.ajouteChaine(getPx()+2,getPy()+5," ▀▄   ▄▀");
		dessin.ajouteChaine(getPx()+1,getPy()+4,"▄█▀███▀█▄ ");
		dessin.ajouteChaine(getPx(),getPy()+3,"█▀███████▀█");
		dessin.ajouteChaine(getPx(),getPy()+2,"█ █▀▀▀▀▀█ █");
		dessin.ajouteChaine(getPx()+2,getPy()+1," ▀▀ ▀▀");
		return dessin;
	}

	Dessin getDessinB()
	{
		// Dessine et Re-Dessine le vaisseau 
		dessin.vider();
		dessin.ajouteChaine(getPx()+2,getPy()+5,"▀▄   ▄▀");
		dessin.ajouteChaine(getPx()+1,getPy()+4,"▄█▀███▀█▄ ");
		dessin.ajouteChaine(getPx(),getPy()+3,"█▀███████▀█");
		dessin.ajouteChaine(getPx(),getPy()+2,"█ █▀▀▀▀▀█ █");
		dessin.ajouteChaine(getPx(),getPy()+1," ▀▀     ▀▀");
		return dessin;
	}

	Dessin getDessinC()
	{
		// Dessine le vaisseau 2
		dessin.vider();
		dessin.ajouteChaine(getPx()+4,getPy()+4,"▄▄████▄▄");
		dessin.ajouteChaine(getPx()+2,getPy()+3,"▄██████████▄");
		dessin.ajouteChaine(getPx(),getPy()+2,"▄██▄██▄██▄██▄██▄");
		dessin.ajouteChaine(getPx()+2,getPy()+1,"▀█▀░░▀▀░░▀█▀");
		return dessin;
	}

	Dessin getDessinCollision()
	{
		// Dessine le vaisseau 2
		dessin.vider();
		dessin.ajouteChaine(getPx()+4,getPy()+4,"▄▄████▄▄");
		dessin.ajouteChaine(getPx(),getPy()+3,"▄██████████▄");
		dessin.ajouteChaine(getPx()+1,getPy()+2,"██▓   ██▓");
		dessin.ajouteChaine(getPx()+1,getPy()+1,"▒▓██▓ ▒▓▒");
		return dessin;
	}

    public void deplace(int tour)
    {
    	// Affecte une vitesse de deplacement en fonction de son nombre de tours
    	vitesse+=0.00015;
    	if (tour > 0 && tour < 100)
			setPx(vitesse+0.1);
		else if (tour > 100 && tour < 200)
			setPx(-0.1-vitesse);
		else if (tour == 100 || tour == 200)
			setPy(-1-vitesse);
    }

    public void deplaceS()
    {	
    	if (getPx()>-202 && getPy()==50) 
    	{
    		if (getPy()==50 && getPx()==300)
    			setPy(-1);
    		setPx(2);
    	}
    	else
    	{
    		if (getPy()==49 && getPx()==-198)
    			setPy(1);
    		setPx(-2);
    	}
    	//System.out.println(getPx()+" "+getPy());
    }

    public boolean contient(double posx, double posy)
    {
        if (dessin.contient(posx, posy))
            return true;
        else
        	return false;
    }
}