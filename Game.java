
import java.util.Scanner;
import edu.princeton.cs.introcs.StdDraw;


public class Game {
	
	String joueur1;
	String joueur2;
	String m;




	public Game(int dimensionX, int dimensionY) {
		Plateau plateau = new Plateau(dimensionX,dimensionY);
		plateau.CaseAleatoire();

	}
	
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Pseudo du joueur 1");
		String joueur1 = scan.nextLine();
		System.out.println("Pseudo du joueur 2");
		String joueur2 = scan.nextLine();
		System.out.println("nombre de cases en absisse et ordonnée");
		int dimensionX = scan.nextInt();
		int dimensionY = scan.nextInt();
		Plateau plateau = new Plateau(dimensionX,dimensionY);
		plateau.CaseAleatoire();
		plateau.init(dimensionX, dimensionY);
		plateau.afficherPlateau(joueur1, joueur2);

		int i=0;
		while(plateau.Arret()==false)  
		{


			if (i%2==1)
			{
				System.out.println("C'est au joueur 2 de jouer");
			}
			else
			{
				System.out.println("C'est au joueur 1 de jouer");
			}
			System.out.println("Quelle couleur choissisez vous ?");
			
			String Couleur=plateau.clique();
			while (Couleur==plateau.c00() || Couleur==plateau.c11() || Couleur.charAt(0)==plateau.c01().charAt(0) || Couleur.charAt(0)==plateau.c10().charAt(0))
			{
				Couleur=plateau.clique();
			}
			
			//String Couleur = scan.next();
			plateau.chgt(Couleur, i);
			int t=0;
			for(t=0;t<10;t++)  //pour éviter la récurrence
			{
				for(int x=0; x<dimensionX; x++)
				{
					for(int y=0; y<dimensionY; y++)
					{				
						plateau.recherche(Couleur, x, y, i);
						
					}
				}


			}
				StdDraw.clear();
				plateau.afficherPlateau(joueur1, joueur2);
				i=i+1;


		}
		StdDraw.clear();
		plateau.afficherPlateau(joueur1, joueur2);
		System.out.println("c est bon");
		plateau.count();
	}
}


