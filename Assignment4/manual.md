	Corey Crooks
	ccrooks6@gatech.edu
	SDP Vigenère Cipher
	How to use: 
	
	Launch SDP Vigenère app from your device. 
	View will show two text fields named Text and Key Phrase along with 2 radio buttons Encrypt and Decrypt. 
	By default, Encrypt button will be enabled. 

	To Encrypt: 
	Input the text to become encrypted. 
	Input the keyphrase (lock/unlock key) to build the Vigenère matrix 
	Hit Run to view your results within the "Results field"

	Example of Encryption: 
	Text: gtech
	Key Phrase: fun

	Results: lnrhb 

	What happens behind the scenes for the example? 
	A matrix is build:

	A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 
	F G H I J K L M N O P Q R S T U V W X Y Z A B C D E 
	U V W X Y Z A B C D E F G H I J K L M N O P Q R S T
	N O P Q R S T U V W X Y Z A B C D E F G H I J K L M 

	The encryption grabs the first letter in the Text field 'g' and goes to the first row to find 'g'.
	Once found it will go to the row of the first letter of key phrase which is 'f' which will pair at 'l'. The cycle repeats until 	the end of the text. The Key Phrase will continue to repeat, e.g funfun...etc 

	Example of Decryption: 
	Decryption works the same was as encryption. 
	Enter the text to decrypt. 
	Enter the Keyword (unlock key) 
	Make sure the Decrypt radio button is selected.
	Click Run to view your original text. 

	The decryption algorithm is almost identical to the encryption however only in reversal. 


	Important Notes: 
	 1. Text field must have value otherwise error will display "Nothing to encode/decode""
	 2. Key must not include spaces nor any non-alphabetic character(s) otherwise will display "Non-alphabetuc character(s) in 		 keyphrase"
	 3. Keyphrase cannot be empty. Will display "Keyphrase required"


