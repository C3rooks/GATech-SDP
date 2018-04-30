Corey Crooks <br />
ccrooks6@gatech.edu <br />
Assignment 5 Design Information <br />

1. When the user starts the application on the device, the user is prompted to either login or register. The uml design approach is to create two classes one for the user and one for creating a user. 

1. Create a backend database with the following tables: tournament, user, puzzles, statistics and puzzlestatistics. 
	* The tournament table will hold the name of the tournament, how many puzzles, date created, and the puzzle ids that were 		    created for the tournament eg. 1-5 puzzles 
	* user table to hold specific user information when registering. 
	* Puzzle tables to hold all puzzles created along with their unique puzzle ids. 
	* General Statistics table for each of the players for how many games played, tournaments won etc.
	* Puzzle statistics to hold how many times a specific puzzle has been solved. 

1. The player creation class was introduced to assign each player a unique id. 

1. A puzzle class for the current specific phrase, number of guesses to solve the specific puzzle, a bool entry for if the puzzle is random or specific. Inside the puzzle class, a method to setphrase and set maxguesses which will store the phrase in the database a newly created puzzle. 

1. A menu class designed for the user to pick a tournament, create a puzzle, solve a puzzle, join a tournament, view stats or continue the tournament. 

1. A quit class that will update the totalprize if quitting in game along with a method to show a continuing item. 

1. A letters class that will hold all of the values of each letter along with unique values for vowels. 

1. A Game class for in-game totalprize value, number of allowed guesses, the display of the puzzle and its blank spaces and nonblank spaces, methods to display the puzzle, guesses show if its a tournament etc. The tournament will like to the game class with isTournament bool.  

1. A tournamentclass that has the amount of puzzles within the tournament, the name of the tournament, puzzle ids and methods to join a new tournament and continue. 

1. A statistics class used if the user selects to view stats at the main menu. This will allow the user to either view game stats or puzzle stats. The class will be the interface between the stats table. 

1. A solve class that will use the number of guesses, the current phrase and call a validate method to see if the puzzle has been solved. The user will also call this class if solving the entire phrase without guessing any letters. The solve class will report back to the main game class with the updated prizeamt. 

High-Level Design Information: 
The overall design of this system will have the user boot up the application on the device presenting them with a login screen. 

The user will enter their uniqueId or opt to create a new user.
If the user opts to create a new user, the user will be then prompted with a new screen for their information which will become stored in a dbo.users table. 

If the user signs in with an id already created then the user will be prompted with a menu screen. 
The menu screen will allow the user to create puzzles, solve puzzles, play a tournament, continue a previous tournament or view stats.

If the user decides to create a puzzle, they will have to supply a phrase and a number of guesses to solve the phrase. This will then become stored in the puzzle table within the database.

If the user decides to solve a puzzle then a random puzzle will show 1 specific puzzle which will allow the user to solve. However, the user can join a previous tournament or create a new. 

If creating a new tournament, the user will have to create a name and a number of games. This information will be stored in a tournament table on the database. 

If the user solves the problem their totalprize will be updated and show a congratulations screen. Otherwise will show sorry you did not complete this puzzle. 
