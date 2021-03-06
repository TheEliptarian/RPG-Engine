/* Main class. Loads save files (sometime in the future it will, at 
 * least), runs main game loop, etc.
 */
import java.io.*;
import java.lang.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.ArrayList;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main
{
	public static Player player;
	public static String dir = System.getenv("APPDATA") + "\\RPG Engine";
	private static final String ALGORITMO = "AES/CBC/PKCS5Padding";
	private static final String CODIFICACION = "UTF-8";
	private static String key = "605bd70efed2c6374823b54bbc560b58";
	public static String name = "";
	public static Class sClass;
	public static int[] stat = new int[9]; //For testing, refactor later.

	
	public static void newGame()
	{
		Engine.cls();
		print("Enter your name: ");
		System.out.print(">> ");
		name = Engine.input.nextLine();
		Engine.cls();
		print("Welcome, " + name + ". Please choose a class. 1 for Light Mage, 2 for Dark Mage, 3 for Swordsman, 4 for Knight.");
		String classn = Engine.getInput("1", "2", "3", "4");
		Class c = (classn.equals("1") ? Instances.lightMage : classn.equals("2") ? Instances.darkMage : classn.equals("3") ? Instances.swordsman : Instances.knight);
		Engine.cls();
		print("Rolling stats...");
		int[] s = Player.rollStats(c);
		player = new Player(name, c, s);
		player.printArmory();
		saveFile();
	}
	
	public static void loadFile()
	{
		//TODO: Check if file exists & create saveFile()
		if (!new File(dir).exists()) 
		{
			print("Creating directory: " + new File(dir).getName());
			boolean result = false;

			try
			{
				new File(dir).mkdir();
				result = true;
			} 
			catch(SecurityException se)
			{
				//TODO: Handle folder security exception
				print("Directory creation failed.");
			}        
			if(result) 
			{    
				print("DIR created");  
			}
		}
		
		File f = new File(dir + "\\save.rpg");
		if(f.exists() && !f.isDirectory())
		{
			try
			{
				Scanner s = new Scanner(new File(dir + "\\save.rpg"));
				ArrayList<String> data = new ArrayList<String>();
				while (s.hasNext())
				{
					String entry = decrypt(s.next(),key);
					data.add(entry);
				}
				s.close();
				name = data.get(0);
				stat[0] = Integer.parseInt(data.get(1));
				stat[1] = Integer.parseInt(data.get(2));
				stat[2] = Integer.parseInt(data.get(3));
				stat[3] = Integer.parseInt(data.get(4));
				stat[4] = Integer.parseInt(data.get(5));
				stat[5] = Integer.parseInt(data.get(6));
				stat[6] = Integer.parseInt(data.get(7));
				stat[7] = Integer.parseInt(data.get(8));
				stat[8] = Integer.parseInt(data.get(9));
				
				//Reading in class
				String classn = data.get(10);
				sClass = (classn.equals("Light Mage") ? Instances.lightMage : classn.equals("Dark Mage") ? Instances.darkMage : classn.equals("Swordsman") ? Instances.swordsman : Instances.knight);
			}
			catch(Exception e){}
		}
		else
		{
			print("Save File not found. Please make sure your save file is located in " + dir + " or start a new game.");
			start();
		}
	}
	
	public static void saveFile()
	{
		try
		{
			ArrayList<String> data = new ArrayList<String>();
			data.add(name);
			data.add(Integer.toString(player.hp));
			data.add(Integer.toString(player.str));
			data.add(Integer.toString(player.def));
			data.add(Integer.toString(player.spd));
			data.add(Integer.toString(player.eva));
			data.add(Integer.toString(player.dge));
			data.add(Integer.toString(player.crt));
			data.add(Integer.toString(player.mag));
			data.add(Integer.toString(player.con));
			data.add(player.c.toString());
			PrintWriter writer = new PrintWriter(dir + "\\save.rpg", "UTF-8");
			for(String entry : data)
			{
				writer.println(encrypt(entry,key));
			}
			writer.close();
		} catch (Exception e) 
		{
			//TODO: Handle IOException
		}
		
	}
	 
	public static void print(String s)
	{
		Dialogue.print(s);
	}
	
	public static void slowPrint(String s)
	{
		Dialogue.slowPrint(s);
	}
	
	public static String input(String... s)
	{
		return Engine.getInput(s);
	}
	
	public static void main(String[] args)
	{
		start();
	}
	public static void start()
	{
		print("Type 'n' to start a new game, and 'l' to load a save file.");
		String input = input("n", "l");
		if(input.equals("n")) 
		{
			newGame();
			return;
		}
		else loadFile();
		game();
	}
	
	public static void game()
	{
		Engine.cls();
		print("Welcome, " + name + ".");
		player = new Player(name, sClass, stat);
		player.printArmory();
		saveFile();
	}
	
	public static String encrypt(String plaintext, String key)throws NoSuchAlgorithmException, NoSuchPaddingException,InvalidKeyException, IllegalBlockSizeException,BadPaddingException, IOException
	{
		try
		{
			byte[] raw = DatatypeConverter.parseHexBinary(key);
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance(ALGORITMO);
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			byte[] cipherText = cipher.doFinal(plaintext.getBytes(CODIFICACION));
			byte[] iv = cipher.getIV();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			outputStream.write(iv);
			outputStream.write(cipherText);
			byte[] finalData = outputStream.toByteArray();
			String encodedFinalData = DatatypeConverter.printBase64Binary(finalData);
			return encodedFinalData;
		}
		catch(Exception e){return "";}
	}
	public static String decrypt(String encodedInitialData, String key)throws InvalidKeyException, IllegalBlockSizeException,BadPaddingException, UnsupportedEncodingException,NoSuchAlgorithmException, NoSuchPaddingException,InvalidAlgorithmParameterException
	{
		try
		{
			byte[] encryptedData = DatatypeConverter.parseBase64Binary(encodedInitialData);
			byte[] raw = DatatypeConverter.parseHexBinary(key);
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance(ALGORITMO);
			byte[] iv = Arrays.copyOfRange(encryptedData, 0, 16);
			byte[] cipherText = Arrays.copyOfRange(encryptedData, 16, encryptedData.length);
			IvParameterSpec iv_specs = new IvParameterSpec(iv);
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv_specs);
			byte[] plainTextBytes = cipher.doFinal(cipherText);
			String plainText = new String(plainTextBytes);
			return plainText;
		}
		catch(Exception e){return "";}
	}
}
