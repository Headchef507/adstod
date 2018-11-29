# Adstod
Project for group 5 in Software Project class at University of Iceland

## How do I get this ?
You can clone the project repo into your chosen IDE (this project was written in IntelliJ). You can download the project repo as a .zip but there seems to be an issue with the Java Spring dependecies when that is done so you're better off cloning the repo straight from GitHub.

## How do I run this ?
The process for running this is not quite ideal since the database is locally hosted, written in MySQL. As such, there are several steps for running this.

1. Download and install the program XAMPP: https://www.apachefriends.org/xampp-files/7.2.12/xampp-win32-7.2.12-0-VC15-installer.exe
  This is what hosts our database locally and is therefore required to run the program.
2. Open XAMPP and press the Start buttons next to Apache and MySQL
3. Open a browser and go to localhost/phpmyadmin
4. In the top row on said page, click "User Accounts"
5. Near the bottom of the page, click "Add user account"
6. Fill out the fields with the following information:
    -Username: kannski
    -Hostname: (dropdown)Local
    -Password: Kannski123
    -Re-type: Kannski123
    -Global privileges: (Check) Data, (Check) Structure, (Check) Administration
  Then hit "Go" near the bottom of the page
7. In the top row on the page, click "Import"
8. Click the "Choose file" button and find the file named "db.sql" in the repository on your computer
  Said file is stored in the following path: /adstod/src/main/java/project/Database
9. Click "Go" near the bottom of the page. This will run the script to create the database, all tables and fill the with data

Once this process has been completed you can run the program in your chosen IDE and go to localhost:8080 to finally get the project running

## What is going on ?
Once a language is chosen on the front page, it sets that language into the repository and displays the first question in the chosen language. Currently, there are 2 questions which are conditional on a previous question. If you answer yes to question 4 then you get question 5 but if you answer no then you skip to question 7. Similarly, if you answer yes to question 8, otherwise you skip to question 9.
There are also different results based on how you answer the questions. Once you finish answering all the questions (currently 16 of them are available but fairly easy to expand by insterting more into the database, no code has to be changed) you will get all results that correspong to your set of answers. If there is no result in out database that corresponds to your set of answers then a default result is displayed which points to a general counsel.

### What did you use to make this ?
This project was coded in IntelliJ, using Java Spring for the most part, JDBC for the database connection and MySQL for the database itself.

### Database
The database is created in MySQL. It's design is using relational ideologies to connect tables together and minimize duplicate data in the database itself.

### Credits
This project was created by Arnar Þór Sigurðsson (aths18@hi.is), Atli Hólm Lárusson (ahl3@hi.is) and Thomas Samúel Pálsson (tsp3) for the Software Project 1 class at University of Iceland
