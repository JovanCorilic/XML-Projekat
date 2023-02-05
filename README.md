# XML-Projekat
Verzija jave je 1.8
## Postavljanje baza
- Za XML koristi se <b>exist</b> baza a za meta podatke koristi se <b>fuseki</b> (https://jena.apache.org/documentation/fuseki2/)
#### Kako se instalira
- Skida se tomcat verzija 8 (https://tomcat.apache.org)
- U webapps stavljaju se exist.war i fuseki.war
- Onda se u lib folderu pokrene tomcat preko komande 'startup'

## Pokretanje programa
- Za backend se koristio Spring a za frontend Angular. Za exist i fuseki bazu, koristio se Tomcat 8. 
- Za P1 portovi su : 4252 - Frontend, 9195 - BackEnd, 8081 - Baza
- Za A1 portovi su : 4200, 8080, 8085
- Za Z1 portovi su : 8083, 8086, 8888, 9090 (Korsinik backend)
- Backend i Frontend projekte otvoriti preko Visual Studio Code ( ili drugim po vašoj želji ) i pokrenuti ih

## Assets kod frontend-a
- Koristi se xonomy (https://github.com/michmech/xonomy) i jQuery

## Članovi
- SW39/2017	Filip Vasic -> Z1
- SW48/2017	Jovan	Ćorilić -> P1
- SW79/2017	Bogdan Čiplić -> A1

## Zig Apliacija
- ExistDB baza aplikacije za zig se deploy-ue na tomcat server i pokrece se na portu 8083.
- ExistDB baza aplikacije za korisnike se deploy-ue na tomcat server i pokrece se na portu 8086.
- Fuseki baza se pokrece na portu 4040 u ugradjenom fuseki serveru.
- Komanda za pokretanje fuseki baze je 'fuseki-server --port=4040'.
- Backend aplikacija za zig se pokrece na portu 8888(aplikacija se automatski pokrece na ovom portu prilikom pokretanja iz razvojnog okruzenja).
- Backend aplikacija za korisnike se pokrece na portu 9090(aplikacija se automatski pokrece na ovom portu prilikom pokretanja iz razvojnog okruzenja).
- Front aplikacija za zig se pokrece na bilo kom slobodnom portu(4200 ili bilo koji drugi slobodan port).
- Front aplikacija za korisnike se pokrece na bilo kom slobodnom portu(4200 ili bilo koji drugi slobodan port).
- Komanda za pokretanje front aplikacije je 'ng serve --port=<PORT>'.
