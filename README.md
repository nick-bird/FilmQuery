### Film Query Project
This project is a terminal-line application which allows a user to search and display from a database containing info about films. The user is presented with a menu which has the options to search for films by their numeric ID, get a list of all films whose title or description contains a specific keyword, or exit the program. If a valid film is found through the user search, information about the film is printed to the screen. If no film is found, the user is notified to try different search parameters.


### Technologies Used
This program uses JDBC technology with Maven to interface with a MySQL database. The program uses a DataBase Accessor class to retrieve information based on SQL queries, customized by user input. The data is stored in objects defined by entity classes so that it can be displayed. User input and information display is all handled in a main App class to allow proper separation of concerns and encapsulation. 
