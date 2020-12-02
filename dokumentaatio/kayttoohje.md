# Käyttöohje
Lataa tiedosto [TimetableApp.jar](https://github.com/makitzei/ot-harjoitustyo2020/releases) tai kloonaa projekti alaosasta löytyvien ohjeiden avulla.

## Käynnistäminen
Ohjelma käynnistetään .jar-tiedoston avulla komennolla 
```
java -jar TimetableApp.jar
```
Huomaa, että ohjelma luo tiedon tallentamista varten tiedostot *users.txt* ja *timetables.txt* siihen kansioon, josta ohjelmaa suoritetaan.

## Kirjautuminen
## Uuden käyttäjän luominen
## Lukujärjestysten katselu
## Uuden tapahtuman lisääminen

### Kloonaaminen
Halutessaan projektin voi .jar-tiedoston suorittamisen sijaan kloonata koneelle ja ajaa komentoriviltä tai Netbeansissa.
  
Siirry komentorivillä kansioon, jonne haluat kloonata projektin ja aja komento  
```
git clone https://github.com/makitzei/ot-harjoitustyo2020.git
```
Mukana tulee myös projektin suorituksen kannalta epäoleellinen tehtäviä sisältävä kansio "laskarit", jonka voi halutessaan poistaa.  

#### Kloonatun projektin suorittaminen
Projektin voi suorittaa suoraan komentoriviltä siirtymällä projektikansion juureen, jossa sijaitsee tiedosto *pom.xml*, ja antamalla komennon  
```
mvn compile exec:java -Dexec.mainClass=timetableapp.Main
```
Projektin voi myös avata Netbeansissa ja suorittaa siellä normaalisti vihreää nappia painamalla. Jos projekti ei löydä suoritettavaa Main-luokkaa, sen voi lisätä itse klikkaamalla auki olevalta Projects-välilehdeltä projektin juuresta *TimetableApp -> Properties -> Run* ja kirjoittamalla kohtaan "Main Class" suoritettavaksi luokaksi *timetableapp.Main*.
