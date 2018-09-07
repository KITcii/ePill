(c) 2017 by Niclas Kannengießer

# ePill
ePill is a service for presenting health package information (PIL) leaflets in a customized way.
By implementing personalization and tailoring mechanisms understanding of PILs should be improved.


# Customization Features

This project provides the following features:
Personalization:
	- personal and daytime-sensitive addressing in the banner on the home site
	- personal addressing in help-information
	- change "color mode" for alert by selecting a user has a red-green-blindness
	- change font-size
	- frontend language adapts browser language automatically
	- responsive design of the website
	- most-viewed item list on home site offers the possibility to easily return to items that appear relevant to the user
	
Tailoring:
	- presented packaging information is selected with respect to user's gender and age
	- presented "used when" diseases in drug lists and detail view are show with respect to gender
	- icons in drug lists are tailored with respect to a users gender and age
		- the warning-icon referring to pregnancy are only presented to females
		- the warning-icon referring to roadworthiness is only presented to user with an age >= 16
	- warnings for adverse effects are presented in respective lists
	- users can enable/disable help texts


# Technical Overview

This Java project is based on Maven and Webpack and uses spring framework and react.
There is a strict seperation between frontend and backend.
Currently you can choose between three profiles:
Per default ePill is using H2 database for development mode which is very comfortable when developing
locally. For configurations see:
	/src/main/resources/application.properties
		
When deployed to heroku as a running instance have a look at application-heroku.properties. When using
heroku profile ePill uses postgres database. For configurations see:
	/src/main/resources/application-heroku.properties


To execute epill-1.9-SNAPSHOT.jar on epill.uni-kassel.de use "uni" profile:
	java -jar epill.jar --spring.profiles.active='uni'


To keep the application alive after closing SSH connection use:
	nohup java -jar epill.jar --spring.profiles.active='uni' &


Frontend was developed using react and Webpack. Webpack-dependencies can be added in:
	/src/main/frontend/package.json
	

For changes regarding the frontend have a look at 
	/src/main/frontend/src/**

	
The frontend is built into spring public folder:
	/src/main/resources/public/***
	
	
For serialization of bidirectional connections SDMLib is used. For further information
have a look at:
	com.doccuty.epill.model.util.*

# Initial Data
The initial data is inserted by executing sql from /src/main/resources/*.sql for
the respective, active profile.
For Unit testing use

	/src/test/resources/data-h2-test.sql.



# Executing in development mode
First ensure you have H2, Java 8 (or higher) and Maven installed
Open the fratcher project in you IDE (e. g. Eclipse).

To build this maven project following requirements must be fulfilled:
- H2 database
- Java 8 or later
- NPM
- Maven

***********************************************************************************
Before running this project in your favorite IDE please run	
	mvn clean install																	 
in console in the project directory in order to download all necessary packages.
**********************************************************************************


Database Settings can be changed for the respective profile in
	/src/main/resources/application-yourprofile.properties
	
When creating new profiles do not forget to add its name to
	/Procfile


Execute the project by starting FratcherMain.java

# Execute on Server
Ensure you have Java 8 (or higher), Maven, npm and postgres installed on your server.
Then just move the /target/demo-1.0-SNAPSHOT.jar file into your favorite
direction. You can execute this file from console with following command:

	nohup java -jar -Dspring.profiles.active=uni  epill-1.1-SNAPSHOT.jar &