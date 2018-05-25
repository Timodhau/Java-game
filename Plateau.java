import edu.princeton.cs.introcs.StdDraw;
import java.util.Random;


public class Plateau {
	int dimensionX;
	int dimensionY;
	public String grille[][];
	public String grille2[][];
	String Color[] = {"b","r","g","y","p","o"};
	String Colorup;
	public String ccolor;
	
	
	
	public Plateau(int dimensionX, int dimensionY) {
		this.dimensionX = dimensionX;
		this.dimensionY = dimensionY;
		
	}
	
	public String c00()
	{
		return grille[0][0];
	}
	public String c11()
	{
		return grille[dimensionX-1][dimensionY-1];
	}
	public String c01()
	{
		return grille[0][0].toLowerCase();
	}
	public String c10()
	{
		return grille[dimensionX-1][dimensionY-1].toLowerCase();
	}
	
	
	
	public void CaseAleatoire(){
		String grille[][] = new String[dimensionX][dimensionY];
		String grille2[][] = new String[dimensionX][dimensionY];
		this.grille = grille;
		this.grille2 = grille2;

			for(int i=0; i<dimensionX; i++){
				for(int j=0; j<dimensionY; j++){
					int a = (int)(6*Math.random());	
					grille[i][j] = Color[a];
					grille2[i][j] = Color[a];
				}	
			}
		while(grille[0][0].charAt(0)==grille[dimensionX-1][dimensionY-1].charAt(0))
		{
			int a = (int)(6*Math.random());
			grille[0][0]=Color[a];
		}
			
	}
	public void count()
	{
		int k=0;
		int m=0;
		for(int p=0; p<dimensionX; p++)
		{
			for(int j=0; j<dimensionY; j++)
			{
				if(grille[p][j].charAt(0)==grille[0][0].charAt(0))
				{
					k=k+1;
				}
				else
				{
					m=m+1;
				}
			}
		}
		System.out.println("Le score du joueur 1 est "+k);
		System.out.println("Le score du joueur 2 est "+m);
	}
	
	public void chgt(String w, int i)
	{
		String h;
		w=w.toUpperCase();
		
		if (i%2==0)
		{
			h=grille[0][0];
			grille[0][0]=w;
			
			for(int p=0; p<dimensionX; p++)
			{
				for(int j=0; j<dimensionY; j++)
				{
					if(grille[p][j].charAt(0)==h.charAt(0))
					{
						grille[p][j]=grille[0][0];
					}
				}
			}
		}
		else 
		{
			h=grille[dimensionX-1][dimensionY-1];
			grille[dimensionX-1][dimensionY-1]=w;
			for(int p=0; p<dimensionX; p++)
			{
				for(int j=0; j<dimensionY; j++)
				{
					if(grille[p][j].charAt(0)==h.charAt(0))
					{
						grille[p][j]=grille[dimensionX-1][dimensionY-1];
					}
				}
			}
		}
	}

	public String clique()
	{
		
		double a, b;
		while(!StdDraw.mousePressed()) {
			a = StdDraw.mouseX();
			b = StdDraw.mouseY();
			StdDraw.show(33);
		}
		a = StdDraw.mouseX();
		b = StdDraw.mouseY();
		int xPos = (int) Math.round(a-1);
		int yPos = (int) Math.round(b-1);
		this.ccolor = grille[xPos][dimensionY-1-yPos];
		while(StdDraw.mousePressed()) {
			StdDraw.show(33);
			
		}
		return ccolor;
	}
	public boolean Comparateur()
	{
		int k = 0;
		int p;
		int j;
		for (p=0; p<dimensionX; p++)
		{
			for (j=0; j<dimensionY;j++)
			{
				if (grille[p][j].charAt(0)==grille2[p][j].charAt(0))
				{
					
				}
				else
				{
					k=k+1;
				}
			}
		}
		if (k==0)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	

	
	public boolean Arret()
	{
		int k =0;
		for (int i=0; i<dimensionX; i++)
		{
			for (int j=0; j<dimensionY; j++)
			{
				if(grille[i][j].charAt(0)=="B".charAt(0) || grille[i][j].charAt(0)=="P".charAt(0) ||grille[i][j].charAt(0)=="Y".charAt(0) ||grille[i][j].charAt(0)=="R".charAt(0) ||grille[i][j].charAt(0)=="G".charAt(0) ||grille[i][j].charAt(0)=="O".charAt(0) )
				{
				}
				else
				{
					k=k+1;
				}
			}
		}
		if (k==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public void init (int dimensionX, int dimensionY)
	{
		grille[0][0]=grille[0][0].toUpperCase();
		grille[dimensionX-1][dimensionY-1]=grille[dimensionX-1][dimensionY-1].toUpperCase();
	}
	
	public void afficherPlateau(String joueur1, String joueur2){
		for(int i=0; i<dimensionY; i++){
			for(int j=0; j<dimensionX; j++){
				System.out.print(grille[j][i]+" ");					
			}
			System.out.println();
		}
		StdDraw.setXscale(0.0,dimensionX+3);
		StdDraw.setYscale(0.0,dimensionY+3);
		StdDraw.setPenRadius(0.01);
	    StdDraw.setPenColor(StdDraw.BLACK);
	    for(int i = 0;i< dimensionX+1; i++) {
			StdDraw.line(i+0.5, 0.5, i+0.5, dimensionY+0.5);
			
		}
	    for(int i = 0;i< dimensionY+1; i++)
	    {
	    	StdDraw.line(0.5,i+0.5, dimensionX+0.5,i+0.5 );
	    }
	    StdDraw.text(2, dimensionY+2, "joueur 1");
	    StdDraw.text(2, dimensionY+1, joueur1);
	    StdDraw.text(dimensionX-1, dimensionY+2, "Le joueur 2");
	    StdDraw.text(dimensionX-1, dimensionY+1, joueur2);
	    
	    for(int i = 0; i <dimensionY;i++) {
			for(int j = 0; j <dimensionX; j++) {
				if (grille[j][i]=="b" || grille[j][i].charAt(0)=="B".charAt(0)){
					StdDraw.setPenColor(176,224,230);
					StdDraw.filledRectangle(j+1, dimensionY-i,0.49,0.49);
				}

				
				if (grille[j][i]=="o" || grille[j][i].charAt(0)=="O".charAt(0)){
					StdDraw.setPenColor(240,140,0);
					StdDraw.filledRectangle(j+1, dimensionY-i,0.49,0.49);
				}
				if (grille[j][i]=="g" || grille[j][i].charAt(0)=="G".charAt(0)){
					StdDraw.setPenColor(127,255,0);
					StdDraw.filledRectangle(j+1, dimensionY-i,0.49,0.49);
				}
				if (grille[j][i]=="r" || grille[j][i].charAt(0)=="R".charAt(0)){
					StdDraw.setPenColor(StdDraw.RED);
					StdDraw.filledRectangle(j+1, dimensionY-i,0.49,0.49);
				}
				if (grille[j][i]=="p" || grille[j][i].charAt(0)=="P".charAt(0)){
					StdDraw.setPenColor(148,0,211);
					StdDraw.filledRectangle(j+1, dimensionY-i,0.49,0.49);
				}
				if (grille[j][i]=="y" || grille[j][i].charAt(0)=="Y".charAt(0)){
					StdDraw.setPenColor(StdDraw.YELLOW);
					StdDraw.filledRectangle(j+1, dimensionY-i,0.49,0.49);
				}
				
				
				
			}
		}
		


}
	
	public void afficherPlateau2()
	{
			for(int i=0; i<dimensionX; i++)
			{
				for(int j=0; j<dimensionY; j++)
				{
					System.out.print(grille2[i][j]+" ");
				}
				System.out.println();
			}
	}
	
	public void duplicate()
	{
		int p;
		int j;
		for (p=0; p<dimensionX; p++)
		{
			for (j=0; j<dimensionY;j++)
			{
				grille2[j][p]=grille[p][j];
			}
		}
	}
	

	
	
	
	

	
	public void recherche (String Couleur, int x, int y, int i)
	{
		if (i%2 == 0)
		{
			Colorup=grille[0][0];
		}
		else
		{
			Colorup=grille[dimensionX-1][dimensionY-1];
		}
		


		if(grille[x][y].charAt(0)== Couleur.charAt(0) )
		{
			

			if(x == dimensionX-1 && y == 0)
			{
				if(grille[x-1][y].charAt(0) == Colorup.charAt(0))
				{
					grille[x][y] = Colorup;
				}
				else if (grille[x][y+1].charAt(0) == Colorup.charAt(0))
				{
					grille[x][y] = Colorup;
				}
				else
				{
					
				}
			}
			else if (x == 0 && y == dimensionY-1)
			{
				if(grille[x+1][y].charAt(0) == Colorup.charAt(0))
				{
					grille[x][y] = Colorup;
				}
				else if (grille[x][y-1].charAt(0) == Colorup.charAt(0))
				{
					grille[x][y] = Colorup;
				}
				else
				{
					
				}
			}
			else if (x == 0 && y <= dimensionY-2 && y >= 1)
			{
				if(grille[x+1][y].charAt(0) == Colorup.charAt(0))
				{
					grille[x][y] = Colorup;
				}
				else if (grille[x][y-1].charAt(0) == Colorup.charAt(0))
				{
					grille[x][y] = Colorup;
				}
				else if (grille[x][y+1].charAt(0) == Colorup.charAt(0))
				{
					grille[x][y] = Colorup;
				}
				else
				{
					
				}
			}
			else if (x == dimensionX-1 && y <= dimensionY-2 && y >= 1)
			{
				if(grille[x-1][y].charAt(0) == Colorup.charAt(0))
				{
					
					grille[x][y] = Colorup;
				}
				else if (grille[x][y+1].charAt(0) == Colorup.charAt(0))
				{
					grille[x][y] = Colorup;
				}
				else if (grille[x][y-1].charAt(0) == Colorup.charAt(0))
				{
					grille[x][y] = Colorup;
				}
				else
				{
					
				}
			}
			else if (y == 0 && x <= dimensionX-2 && x >= 1)
			{
				if(grille[x-1][y].charAt(0) == Colorup.charAt(0))
				{
					grille[x][y] = Colorup;
				}
				else if(grille[x+1][y].charAt(0) == Colorup.charAt(0))
				{
					grille[x][y] = Colorup;
				}
				else if (grille[x][y+1].charAt(0) == Colorup.charAt(0))
				{
					grille[x][y] = Colorup;
				}
				else
				{
					
				}
			}
			else if (y == dimensionY-1 && x <= dimensionX-2 && x >= 1)
			{

				if(grille[x-1][y].charAt(0) == Colorup.charAt(0) || grille[x+1][y].charAt(0) == Colorup.charAt(0) || grille[x][y-1].charAt(0) == Colorup.charAt(0))
				{

					grille[x][y] = Colorup;
				}

				else
				{
					System.out.println("blabla4");
				}
			}
			else
			{
				if(grille[x-1][y].charAt(0) == Colorup.charAt(0))
				{
					grille[x][y] = Colorup;
				}
				else if(grille[x+1][y].charAt(0) == Colorup.charAt(0))
				{
					grille[x][y] = Colorup;
				}
				else if (grille[x][y-1].charAt(0) == Colorup.charAt(0))
				{
					grille[x][y] = Colorup;
				}
				else if (grille[x][y+1].charAt(0) == Colorup.charAt(0))
				{
					grille[x][y] = Colorup;
				}
				else
				{
					
				}
			}
			
		}
		
	}
}






