# Käyttöohje
Lataa tiedosto [TimetableApp.jar](https://github.com/makitzei/ot-harjoitustyo2020/releases) tai kloonaa projekti alaosasta löytyvien ohjeiden avulla.

## Käynnistäminen
Ohjelma käynnistetään .jar-tiedoston avulla komennolla 
```
java -jar TimetableApp.jar
```
Huomaa, että ohjelma luo tiedon tallentamista varten tiedostot *users.txt* ja *timetables.txt* siihen kansioon, josta ohjelmaa suoritetaan.

## Kirjautuminen
Sovelluksen aluksi aukeaa kirjautumisikkuna, josta pääsee lukujärjestykseen syöttämällä rekisteröidyn käyttäjätunnuksen ja painamalla "Kirjaudu sisään" -painiketta.  

![kirjautuminen](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/dokumentaatio/kuvat/kirjautuminen.png)  

Jos käyttäjätunnusta ei vielä ole, sen voi luoda "Luo uusi käyttäjä" -painikkeesta.  

## Uuden käyttäjän luominen
Uusi käyttäjä voi rekisteröityä syöttämällä oikean nimensä ja uuden käyttäjätunnuksen. Käyttäjätunnuksen tulee olla uniikki. Sekä käyttäjätunnuksen että oikean nimen tulee olla vähintään neljä merkkiä pitkiä.    

![kayttajan_luominen](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/dokumentaatio/kuvat/register.png)

## Lukujärjestysten katselu
Käyttäjän kirjautuessa onnistuneesti aukeaa ensimmäisen viikon lukujärjestys, ainakin näin alustavasti. Muiden viikkojen lukujärjestyksiä voi selata yläreunan pudotusvalikosta valitsemalla. Nyt yläreunassa on vielä testitulostus, joka ilmoittaa, että valittu lukujärjestys todella on aktiivisena järjestelmässä.  

![lukkari1](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/dokumentaatio/kuvat/lukujarjestys.png)  

Uuden tapahtuman voi lisätä "Lisää uusi" -painikkeesta.

## Uuden tapahtuman lisääminen
Uusen tapahtuman luomista varten on alustavasti kolme aihetta ja yhden istunnon aikana käyttäjä voi lisätä uusia aiheita. Pudotusvalikoista valitaan tapahtumalle alkamis- ja loppumisaika sekä viikonpäivä.  

![addsubject](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/dokumentaatio/kuvat/addsubject.png)  

Lisätty tapahtuma ilmestyy aktiiviseen lukujärjestykseen alustavasti seuraavan näköisenä. Tässä vaiheessa kalentereita joutuu selata vielä hieman edestakaisin, jotta tapahtuman näkee.  

![lukkari2](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/dokumentaatio/kuvat/lukujarjestys2.png)  

Lukujärjestysnäkymästä käyttäjällä on mahdollisuus kirjautua ulos painikkeella. Ohjelma voi lopettaa sulkemalla ikkunan.


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
