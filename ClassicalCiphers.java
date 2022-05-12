/*Siddhi Gandhale
 * Roll no: 4328
 * Cno: C22018221332
 * Classical Cipher
 */

import java.util.Scanner;

public class ClassicalCiphers {

	
	static String caeserCipherEncryption(String plainText, int shift)
	{

		String cipherText="";
		for(int i=0;i<plainText.length();i++)
		{
			if(plainText.charAt(i)>='a' && plainText.charAt(i)<='z')
			{
				int x=(plainText.charAt(i)+shift-97)%26+97;
				cipherText+=(char)x;
			}
			else
			{
				int x=(plainText.charAt(i)+shift-65)%26+65;
				cipherText+=(char)x;
			}
		}
		return cipherText;
	}
	static String caeserCipherDecryption(String cipherText, int shift)
	{

		String plainText="";
		
		for(int i=0;i<cipherText.length();i++)
		{
			if(cipherText.charAt(i)>='a' && cipherText.charAt(i)<='z')
			{
				int x=(cipherText.charAt(i)-shift-122)%26+122;
				plainText+=(char)x;
			}
			else
			{
				int x=(cipherText.charAt(i)-shift-90)%26+90;
				plainText+=(char)x;
			}
			
		}
		return plainText;
	}
	static String railFenceEncryption(String plainText, int key)
	{
		String cipherText="";
		int r=key;
		int c=plainText.length();
		char mat[][]=new char[r][c];
		int k = 0;
		// for direction
		boolean dir_down = false;
		int row=0,col=0;
		// filling the rail matrix with blank spaces
		for(int i=0;i< c;i++)
		  {
			   for(int j=0;j< r;j++)
			   {
				    	mat[j][i]=' ';
			   }
		  }
		// checking the direction of flow, reversing the direction if top or bottom row is filled
		for(int i=0;i< c;i++)
		  {
			 if (row == 0 || row == key-1)
		            dir_down = !dir_down;
			 
			 mat[row][col++] = plainText.charAt(i);
			 
			 if(dir_down==true)
			 {
				 row++;
			 }
			 else
				 row--;
		  }
		
		//read the matrix row wise to construct cipher text
		   for(int j=0;j< r;j++)
		   {
			   for(int i=0;i< c;i++)
			   {
				   if(mat[j][i]!=' ')
				   {
					   cipherText+=mat[j][i];
				   }
			   }
		   }
		return cipherText;
	}
	
	static String railFenceDecryption(String cipherText, int key) {
		// TODO Auto-generated method stub
		String plainText="";
		int r=key;
		int c=cipherText.length();
		char mat[][]=new char[r][c];
		boolean dir_down = false;
		int row=0,col=0;
		for(int i=0;i< c;i++)
		  {
			   for(int j=0;j< r;j++)
			   {
				    	mat[j][i]=' ';
			   }
		  }
		for(int i=0;i< c;i++)
		  {
			   if (row == 0)
		            dir_down = true;
		        if (row == key-1)
		            dir_down = false;
			 
			 mat[row][col++] = '*';
			 
			 if(dir_down==true)
			 {
				 row++;
			 }
			 else
				 row--;
			
		  }
			int cipherindex=0;
		   for(int j=0;j< r;j++)
		   {
			   for(int i=0;i< c;i++)
			   {
				   if(mat[j][i]=='*' && cipherindex<c)
				   {
					   mat[j][i]=cipherText.charAt(cipherindex);
					   cipherindex++;
				   }
			   }
		   }
		   for(int j=0;j< r;j++)
		   {
			   for(int i=0;i< c;i++)
			   {
				   System.out.print(mat[j][i]+" ");
			   }
			   System.out.println();
		   }
		   for(int j=0;j< c;j++)
		   {
			   for(int i=0;i< r;i++)
			   {
				   if(mat[i][j]!=' ')
				   {
					   plainText+=mat[i][j];
				   }
			   }
		   }
		return plainText;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String plainText;
			int shift = 0;
			int key = 0;
			String cipher = null;
			String plain;
			int choice;
			Scanner s=new Scanner(System.in);
			System.out.println("                               CLASSICAL CIPHER TECHNIQUES");
			do {
				
				System.out.println("************************************************************************************************************");

				System.out.println("Enter your choice");
				System.out.println("1.Encryption Using Caeser Cipher");
				System.out.println("2.Decryption Using Caeser Cipher");
				System.out.println("3.Encryption Using Rail Fence Technique");
				System.out.println("4.Decryption Using Rail Fence Technique");
				System.out.println("5.Exit");	 
				choice=s.nextInt();	 
				switch(choice)
				{
				case 1:	System.out.println("CAESER CIPHER: ");
						System.out.println("Enter plain text: ");
						plainText=s.next();
						System.out.println("Enter shift: ");
						shift=s.nextInt();
						cipher=caeserCipherEncryption(plainText,shift);
						System.out.println("Encrypted text: "+cipher);
						break;
				case 2:	plain=caeserCipherDecryption(cipher,shift);
						System.out.println("Decrypted text: "+plain);
						break;
				case 3:	System.out.println("RAIL FENCE CIPHER: ");
						System.out.println("Enter plain text: ");
						plainText=s.next();
						System.out.println("Enter key: ");
						key=s.nextInt();
						cipher=railFenceEncryption(plainText,key);
						System.out.println("Encrypted text: "+cipher);
			       	    break;
				case 4: plain=railFenceDecryption(cipher,key);
						System.out.println("Decrypted text: "+plain);
						break;
				case 5:	System.out.println("Exit");
						break;
				}
			
		}while(choice!=5);	
	}


}
/*
CLASSICAL CIPHER TECHNIQUES
************************************************************************************************************
Enter your choice
1.Encryption Using Caeser Cipher
2.Decryption Using Caeser Cipher
3.Encryption Using Rail Fence Technique
4.Decryption Using Rail Fence Technique
5.Exit
1
CAESER CIPHER: 
Enter plain text: 
AttackAtOnce
Enter shift: 
4
Encrypted text: ExxegoExSrgi
************************************************************************************************************
Enter your choice
1.Encryption Using Caeser Cipher
2.Decryption Using Caeser Cipher
3.Encryption Using Rail Fence Technique
4.Decryption Using Rail Fence Technique
5.Exit
2
Decrypted text: AttackAtOnce
************************************************************************************************************
Enter your choice
1.Encryption Using Caeser Cipher
2.Decryption Using Caeser Cipher
3.Encryption Using Rail Fence Technique
4.Decryption Using Rail Fence Technique
5.Exit
3
RAIL FENCE CIPHER: 
Enter plain text: 
DefendTheEastWall
Enter key: 
3
Encrypted text: DnetleedhEsWlfTaa
************************************************************************************************************
Enter your choice
1.Encryption Using Caeser Cipher
2.Decryption Using Caeser Cipher
3.Encryption Using Rail Fence Technique
4.Decryption Using Rail Fence Technique
5.Exit
4
D       n       e       t       l 
  e   e   d   h   E   s   W   l   
    f       T       a       a         
Decrypted text: DefendTheEastWall
************************************************************************************************************
Enter your choice
1.Encryption Using Caeser Cipher
2.Decryption Using Caeser Cipher
3.Encryption Using Rail Fence Technique
4.Decryption Using Rail Fence Technique
5.Exit
5
Exit
*/