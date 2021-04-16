# Star Wars Application

Have fun searching Star Wars information via cURL requests obtaining the information from your shell.

## Instructions for running the application as a Docker container

### On your shell do the following

1. Clone the repository on your local machine (`git clone https://github.com/brunopique/star-wars`)
2. Navigate to the project's folder (`cd star-wars`)
3. Do a Maven Verify, which will produce a .jar file (`mvn verify`)
4. Use Docker to buil said .jar file (`docker build -t star-wars-docker.jar .`)
5. Finally run the Docker container (`docker run -p 6969:6969 star-wars-docker.jar`)

## cURL Requests

### While still on your shell you can visit

1. To get a list of starships (and their details) a particular character has piloted, visit http://localhost:6969/api/starships/characters/{characterName}
(eg. `curl http://localhost:6969/api/starships/characters/chewbacca`)
2. To get a list of all the characters names from a certain planet, visit http://localhost:6969/api/planets/characters/{planetName}
(eg. `curl http://localhost:6969/api/planets/characters/tatooine`)

## Video with Instructions

### And if you're a a visual person like me, check out the video where I follow the steps above

[Video](https://youtu.be/aXkrpRkPV9U )

