# Mediscreen

Spring Boot application - Gradle - PostgreSQL - MongoDB - API ReST- OpenFeign - Docker


---
**Annex directory : content**

- coverage reports

- documentation


---

**Instructions - all in Docker**
---

/Mediscreen/docker-compose]<br>
$ docker-compose up <br>
http://localhost:9000/patient/home <br>
<br>
bonus:<br>
  - get the IpAddress<br>
  $ docker ps // to get CONTAINER ID<br>
  $ docker inspect {ij} // i & j are the 2 first numbers of the CONTAINER ID<br>
  - connect to pgAdmin4<br>
  http://localhost:5050 <br>
  login: root@root.com - psw: root<br>
  choose a name and add the IP address and password
  - connect to Mongo Express:<br>
      http://localhost:8081/ <br>

---
**Instructions - only db in Docker**
---

1-**create data base 'dbpatient' with Docker-compose:**<br>

/Mediscreen/dbpatient]<br>
$ docker pull postgres:alpine<br>
$ docker pull dpage/pgadmin4<br>
$ docker-compose up<br>
<br>
bonus:<br>
- get the IpAddress<br>
$ docker ps // to get CONTAINER ID<br>
$ docker inspect {ij} // i & j are the 2 first numbers of the CONTAINER ID<br>
- connect IDE to the new db<br>
- connect to pgAdmin4<br>
http://localhost:5050 <br>
login: root@root.com - psw: root<br>


2-**create data base 'db_medical_record' with Docker-compose:**<br>

/Mediscreen/db_medical_record]<br>
$ docker-compose up<br>
<br>
bonus:<br>
- connect to Mongo Express:<br>
http://localhost:8081/ <br>


3-**run :**<br>

- patient
- medicalReport
- diabetesRiskAssessment
- userInterface
- http://localhost:9000/patient/home

