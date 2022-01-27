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
- connect you IDE to the new db<br>
- access to pgAdmin4<br>
http://localhost:5050 <br>
login: root@root.com - psw: root<br>
<br>

2-**Testing tools:**<br>

- GET a list of internal patients:<br>
http://localhost:8080/patient/initializeInternalPatients
<br>
- GET all the patients from the db:<br>
http://localhost:8080/patient/resetDb
<br>

3-**Endpoints:**<br>

- GET a list of all patients:<br>
http://localhost:8080/patient/list
<br>
- GET a patient by id:<br>
http://localhost:8080/patient/{id}
<br>
- GET a list of patients by lastName:<br>
http://localhost:8080/patient/search/{lastName}
<br>
- GET a patient deleted by id:<br>
http://localhost:8080/patient/delete?id={id}
<br>
- POST a new patient to add:<br>
http://localhost:8080/patient/newPatient
<br>
- POST a patient to update:<br>
http://localhost:8080/updatePatient
<br>