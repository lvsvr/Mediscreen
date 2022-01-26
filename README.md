# Mediscreen

Spring Boot application - Gradle - Microservices - Feign - Docker

---
**Instructions**
---

1-**create data base 'dbpatient' with Docker-compose:**<br>

/Mediscreen/dbpatient]<br>
$ docker pull postgres:alpine<br>
$ docker pull dpage/pgadmin4<br>
$ docker-compose up<br><br>
bonus:<br>
- get the IpAddress<br>
$ docker ps // to get CONTAINER ID<br>
$ docker inspect {ij} // i & j are the 2 first numbers of the CONTAINER ID<br>
-  connect you IDE to the new db<br>
- access to pgAdmin4<br>
http://localhost:5050 <br>
login: root@root.com - psw: root<br>
