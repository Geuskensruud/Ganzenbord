import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class Ganzenbord {

	static Scanner scan = new Scanner(System.in);
	static ArrayList <Player> lijstSpelers = new ArrayList <Player> ();
	
	public static void main(String[] args) 
	{
		spelersAanmaken();
		int sum = 0;
		Random random = new Random();
		System.out.println("spel begonnen, type (g) om de dobbelsteen te gooien");
        for(int i = 0; i < 1000; i++) { 
        	String g = scan.nextLine();
        	int randomNum = random.nextInt(6) + 1;
            if(sum==23) 
            {
            	System.out.println("Game over");
            	break;
            }
            if(sum==25) 
            {
            	sum=0;
            	System.out.println("Terug naar Start");            	
            }
            if(sum==45) 
            {
            	sum=0;
            	System.out.println("Terug naar Start");            	
            }
            if(sum==10) 
            {
            	sum+= randomNum;
            	System.out.println("dubbele stapjes!");
           	
            }
            if(sum==20) 
            {
            	sum+= randomNum;
            	System.out.println("dubbele stapjes!");
            }
            if(sum==30) 
            {
            	sum+= randomNum;
            	System.out.println("dubbele stapjes!");
            }
            if(sum==40) 
            {
            	sum+= randomNum;
            	System.out.println("dubbele stapjes!");
            }
            if(sum==50) 
            {
            	sum+= randomNum;
            	System.out.println("dubbele stapjes!");
            }
            if(sum==60) 
            {
            	sum+= randomNum;
            	System.out.println("dubbele stapjes!");
            }
            
            if(sum>=63)
            {
            	System.out.println("Einde game");            	
            	break;

            }
                        sum += randomNum;
                        System.out.println("Je hebt " + randomNum + " gegooid");
                        System.out.println("je staat op nummer " + sum);

 
        }
	}
	static void spelersAanmaken()
	{
		System.out.println("Met Hoeveel Spelers wil je spelen?");
		int aantalSpelers = scan.nextInt();
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
	
}
