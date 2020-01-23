## Author : Silas Oyewale

## Title: Songr App

## Clear instructions on how to run this application
Download Intellij and gradle.
Clone the repository to your local machine
In the songr application.java, run the server.
In the URL, type localhost:8080/hello to go to the homepage
In the URL, type localhost:8080/albums to see a display of all the albums
In the URL, type localhost:8080//capitalize/anything to capitalize any query that comes after capitalize.

## Needed dependencies
This app needs two extra dependencies to run namely 
1. The spring framework.boot:spring-boot-starter-data-jpa dependency
2. the postgresql dependency

## Application Properties Update
In the application property, specify your
1. Database URL
2. Database username
3. Database password
4. Set hibernate auto to update.

## Database
Implemented in this app is the database. To view the song table, follow the commands below
1. in your terminal, run psql
2. type \c albums
3. type \dt to see all tables in the database.
You should see one for albums and one for songs.
type select * from albums; to see the list of albums
type select * from songs; to see the list of songs.




