import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class Ganzenbord {

	static Scanner scan = new Scanner(System.in);
	static ArrayList <Player> lijstSpelers = new ArrayList <Player> ();
	static int aanDeBeurt;
	static boolean spel = true;
	static boolean winnaar = false;
	static int aantalSpelers;	
	
	public static void main(String[] args) 
	{
		spelersAanmaken();
		Random random = new Random();
		while(spel) 
		{
			if (aanDeBeurt >= aantalSpelers) {
				aanDeBeurt = 0;
			}
			System.out.println("type (enter) om de dobbelsteen te gooien");
			scan.nextLine();
			aanDeBeurt++;
			System.out.println(lijstSpelers.get(aanDeBeurt).getName());
			int gooi = random.nextInt(6) + 1;
			System.out.println(lijstSpelers.get(aanDeBeurt).getName() + "Je hebt " + gooi + " gegooid");
			lijstSpelers.get(aanDeBeurt).verhoogStaPlaats(gooi);
	        System.out.println("je staat op nummer " + lijstSpelers.get(aanDeBeurt).getStaPlaats());
	        
	        if(lijstSpelers.get(aanDeBeurt).getStaPlaats() == 10 || lijstSpelers.get(aanDeBeurt).getStaPlaats() == 20 ||lijstSpelers.get(aanDeBeurt).getStaPlaats() == 30 || lijstSpelers.get(aanDeBeurt).getStaPlaats() == 40 || lijstSpelers.get(aanDeBeurt).getStaPlaats() == 50 ||lijstSpelers.get(aanDeBeurt).getStaPlaats() == 60) 
	        {
	        	lijstSpelers.get(aanDeBeurt).verhoogStaPlaats(gooi);
	        	System.out.println("jeeh Bonusstapjes");
	        	System.out.println("je staat op nummer " + lijstSpelers.get(aanDeBeurt).getStaPlaats());
	        }
	        if(lijstSpelers.get(aanDeBeurt).getStaPlaats() == 25 || lijstSpelers.get(aanDeBeurt).getStaPlaats() == 45) 
	        {
	        	lijstSpelers.get(aanDeBeurt).setStaPlaats(0);
	        	System.out.println("Terug naar start :(");
	        	System.out.println("je staat op nummer " + lijstSpelers.get(aanDeBeurt).getStaPlaats());
	        }
	        if (lijstSpelers.get(aanDeBeurt).getStaPlaats() == 23)
			{
	        	spel= false;
	        	System.out.println("Game Over X(");
	        }
	        if (lijstSpelers.get(aanDeBeurt).getStaPlaats() == 63) 
	        {
	        	spel= false;
	        	winnaar = true;
	        }
	        if (lijstSpelers.get(aanDeBeurt).getStaPlaats() > 63) 
	        {
	        	int Huidigeplaats = lijstSpelers.get(aanDeBeurt).getStaPlaats();
	        	int AantalStappenTerug = (Huidigeplaats - 63)*2;
	        	lijstSpelers.get(aanDeBeurt).verlaagStaPlaats(AantalStappenTerug);
	        }
		}

 

	}
	static void spelersAanmaken()
	{
		System.out.println("Met Hoeveel Spelers wil je spelen?");
		aantalSpelers = scan.nextInt();
		System.out.println("Vul de namen in van de spelers");
		
		for (int x = 0; x<=aantalSpelers; x++) 
		{
			String naam = scan.nextLine();
			lijstSpelers.add(x, new Player(naam));
			
		}
	}

}
class Player 
{
	private String name;
	private int staPlaats = 0;
	
	Player(String naam)
	{
		name =naam;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStaPlaats() {
		return staPlaats;
	}
	public void setStaPlaats(int staPlaats) {
		this.staPlaats = staPlaats;
	}
	public void verhoogStaPlaats(int gooi) {
		this.staPlaats += gooi;
	}
	public void verlaagStaPlaats(int gooi) {
		this.staPlaats -= gooi;
	}
	
}
