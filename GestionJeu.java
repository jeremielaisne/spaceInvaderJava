// CLASSE DONNEE AUX ETUDIANTS
// A COMPLETER

import java.util.ArrayList;

class GestionJeu
{
	/* ======== Attributs ======== */
		Dessin dessin;
        Vaisseau vaisseau;
        Alien alienS;
        Alien alienS2;
        ArrayList<Projectile> listProj;
        ArrayList<Projectile> listProjAlien;
        ArrayList<Alien> listAlien;
        ArrayList<Projectile> projTouche;
        ArrayList<Projectile> projToucheAlien;
        ArrayList<Alien> alienTouche;
        Score score;
        private int largeur = 100;
        private int hauteur = 60;
        private int sc = 0;
        private int tour = 0;
        private boolean toucheSuperVaisseau = false;
        private boolean toucheSuperVaisseau2 = false;
        private boolean projHorsLimite = false;
        private boolean projHorsLimiteAlien = false;
        private boolean vaisseauEndommage = false;
        private boolean pause = true;
        private boolean fin = false;
	
	/* ======== Constructeur ======== */
	// ATTENTION, seul le constructeur sans paramètre est accepté
	GestionJeu()
	{
		dessin = new Dessin();
		score = new Score();
		//Creation du vaisseau joueur
		vaisseau = new Vaisseau(42.5,0.0);

		// Creation de la liste de projectile du joueur
		this.listProj = new ArrayList<Projectile>();
		// Creation de la liste de projectile des aliens
		this.listProjAlien = new ArrayList<Projectile>();

		// Creation des deux super-vaisseaux aliens
		alienS = new Alien(-10.0,50.0);
		alienS2 = new Alien(290.0,49.0);
		// Creation d'une liste d'alien et ajout d'un premier alien
		this.listAlien = new ArrayList<Alien>();
		ajouteAlien(10.5,44.0);

		// Creation d'une liste de projectile qui ont touche les aliens
		this.projTouche = new ArrayList<Projectile>();
		// Creation d'une liste de projectile qui ont touche le joueur
		this.projToucheAlien = new ArrayList<Projectile>();
		// Creation d'une liste d'aliens touche par le projectile
		this.alienTouche = new ArrayList<Alien>();
	}
	
	/* ======== Getteurs ======== */
	public int getLargeur()
	{ 
		return largeur; 
	}
	public int getHauteur()
	{ 
		return hauteur; 
	}

	// Getteurs des arraylist 
	ArrayList<Projectile> getListeProjectile()
	{
		return this.listProj;
	}

	ArrayList<Projectile> getListeProjectileAlien()
	{
		return this.listProjAlien;
	}

	ArrayList<Alien> getListeAlien()
	{
		return this.listAlien;
	}
	
	ArrayList<Projectile> getProjTouche()
	{
		return this.projTouche;
	}

	ArrayList<Alien> getAlienTouche()
	{
		return this.alienTouche;
	}

	ArrayList<Projectile> getProjToucheAlien()
	{
		return this.projToucheAlien;
	}


	// Getteurs et setteurs des booleens
	public boolean getToucheSuperVaisseau()
	{
		return this.toucheSuperVaisseau;
	}

	public void setToucheSuperVaisseau(boolean t)
	{
		this.toucheSuperVaisseau = t;
	}

	public boolean getToucheSuperVaisseau2()
	{
		return this.toucheSuperVaisseau2;
	}

	public void setToucheSuperVaisseau2(boolean t2)
	{
		this.toucheSuperVaisseau2 = t2;
	}

	public boolean getProjectileHorsLimite()
	{
		return this.projHorsLimite;
	}

	public void setProjectileHorsLimite(boolean phl)
	{
		this.projHorsLimite = phl;
	}

	public boolean getProjectileHorsLimiteAlien()
	{
		return this.projHorsLimiteAlien;
	}

	public void setProjectileHorsLimiteAlien(boolean phla)
	{
		this.projHorsLimiteAlien = phla;
	}

	public boolean getVaisseauEndommage()
	{
		return this.vaisseauEndommage;
	}

	public void setVaisseauEndommage(boolean ve)
	{
		this.vaisseauEndommage = ve;
	}

	public boolean getPause()
	{
		return this.pause;
	}

	public void setPause(boolean pause)
	{
		this.pause = pause;
	}

	public boolean getFin()
	{
		return this.fin;
	}

	public void setFin(boolean fin)
	{
		this.fin = fin;
	}

	// ATTENTION - la méthode getDessin() est appelée environ 40 fois par seconde
	// donc, il ne faut pas instancier de nouvel objet dans cette 
	// méthode au risque de saturer rapidement la mémoire
	Dessin getDessin()
	{
		// A COMPLETER
	    return dessin;
	}
	
	/* ======== Autres méthodes ======== */

	//Initialise des aliens et les ajoutes dans la liste d'aliens
	public void ajouteAlien(double px, double py)
	{
       	for(int i=0; i<20; i++)
		{
			if (i>-1 && i<5)
				getListeAlien().add(i,new Alien(px+i*15,py));
			else if (i>4 && i<10)
				getListeAlien().add(i,new Alien(px+(i-5)*15,py-6));
			else if (i>9 && i<15)
				getListeAlien().add(i,new Alien(px+(i-10)*15,py-12));
			else if (i>14 && i<20)
				getListeAlien().add(i,new Alien(px+(i-15)*15,py-18));
		}
	}

	//Gestion des projectiles aliens
	public void gestionProjectilesAliens()
	{
		if ((tour==75) && (listAlien.size()>11))
		{
			getListeProjectileAlien().add(new Projectile(listAlien.get(11).getPx(),listAlien.get(11).getPy()));
			getListeProjectileAlien().add(new Projectile(listAlien.get(7).getPx(),listAlien.get(7).getPy()));
			getListeProjectileAlien().add(new Projectile(listAlien.get(4).getPx(),listAlien.get(4).getPy()));
		}
		else if ((tour==85) && (listAlien.size()>8) && (listAlien.size()<12))
		{
			getListeProjectileAlien().add(new Projectile(listAlien.get(8).getPx(),listAlien.get(8).getPy()));
			getListeProjectileAlien().add(new Projectile(listAlien.get(5).getPx(),listAlien.get(5).getPy()));
			getListeProjectileAlien().add(new Projectile(listAlien.get(2).getPx(),listAlien.get(2).getPy()));
		}
		else if ((tour==95) && (listAlien.size()>4) && (listAlien.size()<8))
		{
			getListeProjectileAlien().add(new Projectile(listAlien.get(4).getPx(),listAlien.get(4).getPy()));
			getListeProjectileAlien().add(new Projectile(listAlien.get(1).getPx(),listAlien.get(1).getPy()));
		}
		if ((tour>10) && (tour <20))
			getListeProjectileAlien().add(new Projectile(alienS.getPx(),alienS.getPy()));
		if ((tour>175) && (tour<185))
			getListeProjectileAlien().add(new Projectile(alienS2.getPx(),alienS2.getPy()));
	}

	// Methodes lies aux collisions
	public void collision()
	{
		for (Projectile p : listProj)
		{
			for (Alien a : listAlien)
			{
				if (a.contient(p.getPx(),p.getPy()))
				{
					//System.out.println("TOUCHE ALIEN");
					getProjTouche().add(p);
					getAlienTouche().add(a);
					score.ajouteScore(25);
				}
			}
		}
	}

	public void collisionJoueur()
	{
		// En cas de collisions, le projectile sera transfere dans la liste des projectiles qui ont touche le joueur
		for (Projectile p : listProjAlien)
		{
			if (vaisseau.contient(p.getPx(),p.getPy()))
			{
				System.out.println("TOUCHE PLAYER");
				setVaisseauEndommage(true);
				getProjToucheAlien().add(p);
			}
		}
		// Parcours liste des projectiles qui ont touche le joueur, on baisse le score et la vie du joueuren fonction du nombre de projectile
		// qui sera normalement de 1 puisque vide cette liste a chaque passage
		for (Projectile p : projToucheAlien)
		{
			score.baisseVie();
			score.ajouteScore(-75);
			listProjAlien.clear();
		}
		projToucheAlien.clear();

		//
		if (score.getVie() == getProjToucheAlien().size())
			finDuJeu(); 
	}

	//Methodes liés a l'affichage graphique

	// ATTENTION - la méthode jouerUnTour() est appelée environ 40 fois par seconde
	// donc, il ne faut pas instancier de nouvel objet dans cette 
	// méthode au risque de saturer rapidement la mémoire
	public void jouerUnTour()
	{
		// Efface l'ecran a chaque debut de tour, dessin le vaisseau-joueur et le score
		dessin.vider();
		if (getVaisseauEndommage())
			dessin.ajouteDessin(vaisseau.getDessinCollision());
		else
			dessin.ajouteDessin(vaisseau.getDessin());
		dessin.ajouteDessin(score.getDessin());
		// Parcours de la liste de projectile du joueur
		// Vie du projectile et deplacement, si hors limite (haut de l'ecran) boolean detruit passera a vrai sinon le projectile continue son parcours
		for (Projectile p : listProj)
		{
			if(p.getPy() < 59)
			{
				dessin.ajouteDessin(p.getDessin());
			    p.evolue();
			}
			else
				setProjectileHorsLimite(true);
		}
		// Parcours de la liste de projectile de l'alien
		// Vie du projectile et deplacement, si hors limite (bas de l'ecran) boolean detruit passera a vrai sinon le projectile continue son parcours
		for (Projectile p : listProjAlien)
		{
			if(p.getPy() > 0)
			{
				dessin.ajouteDessin(p.getDessinA());
				p.evolueA();
			}
			else
				setProjectileHorsLimiteAlien(true);
		}
		// Fin de vie du projectile, destruction du projectile en dehors de la boucle for(liste de projectiles)
		if (getProjectileHorsLimite())
		{
			listProj.remove(0);
			setProjectileHorsLimite(false);
		}
		if (getProjectileHorsLimiteAlien())
		{
			listProjAlien.remove(0);
			setProjectileHorsLimiteAlien(false);
		}


		// Parcours d'une liste d'aliens et deplacement
		for (Alien a : listAlien)
		{
			if ((tour>0 && tour<20) || (tour >60 && tour <80) || (tour >100 && tour <120) || (tour >160 && tour <180))
				dessin.ajouteDessin(a.getDessinA());
			else
				dessin.ajouteDessin(a.getDessinB());
			a.deplace(tour);
		}

		// Gestion des projectiles
		gestionProjectilesAliens();

		// Affichage et deplacements des 2 super-vaisseaux, on re-dessine le vaisseau en cas de collisions
		if (getToucheSuperVaisseau())
			dessin.ajouteDessin(alienS.getDessinCollision());
		else
			dessin.ajouteDessin(alienS.getDessinC());
		if (getToucheSuperVaisseau2())
			dessin.ajouteDessin(alienS2.getDessinCollision());
		else
			dessin.ajouteDessin(alienS2.getDessinC());
		alienS.deplaceS();
		alienS2.deplaceS();


		// Verification des collisions
		collision();
		collisionJoueur();
		// Suppression des Projectile et aliens present dans la liste des projectiles touches et dans la liste des aliens touche
		for (Projectile p : projTouche)
			listProj.remove(p);

		for (Alien a : alienTouche)
		{
			dessin.ajouteDessin(a.getDessinCollision());
			listAlien.remove(a);
		}
		
		// Si le super-vaisseau Alien est touche, on ajoute 100 au score et on re-dessine le vaisseau endommage 
		//par l'intermedaire d'un boolean qui va faire appel au dessin getDessinCollision() dans la methode collisionJoueur()
		for (Projectile p : listProj)
		{
			if (alienS.contient(p.getPx(),p.getPy()))
			{
				setToucheSuperVaisseau(true);
				score.ajouteScore(100);
			}
			if (alienS2.contient(p.getPx(),p.getPy()))
			{
				setToucheSuperVaisseau2(true);
				score.ajouteScore(100);
			}
			
		}

		// Deplacement selon le nombre de tours
		if (tour < 200)
			tour++;
		else
			tour = 0;

		// Supprime les aliens touche de l'ecran tous les 50 tours
		if(tour == tour%50)
		{
			alienTouche.clear();
			setVaisseauEndommage(false);
		}

		// Compte-a-rebours avant fin du jeu
		score.ajouteTemps();
		// Fin du Jeu
		if ((score.getTmp() > 3000) || (listAlien.size() == 0))
			finDuJeu();
	}

	// Methode de fin du jeu : respecte 3 conditions (plus de vie, compte-a-rebours et plus d'aliens)
	public void finDuJeu()
	{
		setFin(true);
		dessin.vider();
		if (score.getVie() <= 0)
		{
			dessin.ajouteChaine(35,38,"Vous avez PERDU ! Vous n'avez plus de vie.");
			score.setCpt(0);
		}
		else if (score.getTmp() > 2200)
		{
			dessin.ajouteChaine(35,38,"Vous avez PERDU ! Les aliens ont gagnés.");
			score.setCpt(0);
		}
		else 
			dessin.ajouteChaine(35,38,"Bravo ! vous avez GAGNE.");

		dessin.ajouteChaine(10,50," ██████╗  █████╗ ███╗   ███╗███████╗     ██████╗ ██╗   ██╗███████╗██████╗ ");
		dessin.ajouteChaine(10,49,"██╔════╝ ██╔══██╗████╗ ████║██╔════╝    ██╔═══██╗██║   ██║██╔════╝██╔══██╗");
		dessin.ajouteChaine(10,48,"██║  ███╗███████║██╔████╔██║█████╗      ██║   ██║██║   ██║█████╗  ██████╔╝");
		dessin.ajouteChaine(10,47,"██║   ██║██╔══██║██║╚██╔╝██║██╔══╝      ██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗");
		dessin.ajouteChaine(10,46,"╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗    ╚██████╔╝ ╚████╔╝ ███████╗██║  ██║");
		dessin.ajouteChaine(10,45," ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝     ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝");
		dessin.ajouteChaine(35,35,"Votre Score  : "+score.getCpt()+" pts.");
	}
	

	// Methodes lié a la gestion clavier

	public void toucheEspace()
	{
	  	getListeProjectile().add(new Projectile(vaisseau.positionCanonX(),vaisseau.positionCanonY()));
	}

	public void toucheEntree()
	{
		if (getPause())
		{
			System.out.println("pause");
			setPause(false);
		}
		else
		{
			System.out.println("reprise");
			setPause(true);
		}
	}

	public void toucheDroite()
	{
		if (vaisseau.getPx()<85)
		    vaisseau.deplace(1.0,0.0);
	}

	public void toucheGauche()
	{
		if (vaisseau.getPx()>5)
		    vaisseau.deplace(-1.0,0.0);
	}
}
