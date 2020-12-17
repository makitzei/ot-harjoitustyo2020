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
Uusi käyttäjä voi rekisteröityä syöttämällä oikean nimensä ja uuden käyttäjätunnuksen. Käyttäjätunnuksen tulee olla uniikki. Sekä käyttäjätunnuksen että oikean nimen tulee olla vähintään neljä merkkiä pitkiä. Nyt kirjautuminen onnistuu uudella tunnuksella. Jos tunnuksen luomisen haluaa keskeyttää, voi palata kirjautumisnäkymään "Takaisin"-painikkeella.  

![kayttajan_luominen](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/dokumentaatio/kuvat/register.png)

## Lukujärjestysten katselu
Käyttäjän kirjautuessa onnistuneesti aukeaa ensimmäisen viikon lukujärjestys. Muiden viikkojen lukujärjestyksiä voi selata yläreunan pudotusvalikosta valitsemalla. Näkyvillä olevaan lukujärjestykseen saa lisättyä uutta sisältöä "Lisää uusi" -painikkeella. "Päivitä"-nappulasta ei ole tässä kohden vielä hyötyä.

![lukkari1](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/dokumentaatio/kuvat/lukkari1_v2.png)  

## Uuden tapahtuman lisääminen
Uuden tapahtuman luomista varten on oletuksena kolme aihetta: opiskelu, liikunta ja vapaa. Käyttäjä voi lisätä oman aiheen listaan kirjoittamalla aiheen kenttään ja painamalla "Lisää", minkä jälkeen myös oma aihe löytyy pudotusvalikosta. Omat aiheet säilyvät vain yhden kirjautumisen ajan. Pudotusvalikoista valitaan tapahtumalle alkamis- ja loppumisaika sekä viikonpäivä. Tapahtumien lisäämistä voi jatkaa tai palata lukujärjestykseen "Takaisin"-painikkeella. 

![addsubject](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/dokumentaatio/kuvat/addsubject.png)  

Lisätty tapahtuma ilmestyy aktiiviseen lukujärjestykseen. Oletustapahtumissa on omat värinsä ja omat aiheet tulevat näkyviin keltaisella. 

![lukkari2](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/dokumentaatio/kuvat/lukkari2_v2.png)  

## Tapahtuman poistaminen

Luodun tapahtuman voi poistaa klikkaamalla sitä hiiren vasemmalla painikkeella. Ponnahdusikkuna varmistaa vielä, haluaako käyttäjä poistaa tapahtuman tietyltä hetkeltä. Peruminen tapahtuu "Peruuta"-painikkeesta tai sulkemalla ponnahdusikkuna. 

![lukkari3](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/dokumentaatio/kuvat/lukkari3_v2.png)  

Jos tapahtuman poistaa, lukujärjestys pitää tämän jälkeen vielä päivittää "Päivitä"-painikkeella, jotta muutoksen saa näkyviin esillä olevassa lukujärjestyksessä.  

![lukkari4](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/dokumentaatio/kuvat/lukkari4_v2.png)  

## Käytön lopettaminen

Lukujärjestysnäkymästä käyttäjällä on mahdollisuus kirjautua ulos painikkeella "Kirjaudu ulos". Ohjelman voi lopettaa sulkemalla ikkunan.


## Kloonaaminen
Halutessaan projektin voi .jar-tiedoston suorittamisen sijaan kloonata koneelle ja ajaa komentoriviltä tai Netbeansissa.
  
Siirry komentorivillä kansioon, jonne haluat kloonata projektin ja aja komento  
```
git clone https://github.com/makitzei/ot-harjoitustyo2020.git
```
Mukana tulee myös projektin suorituksen kannalta epäoleellinen tehtäviä sisältävä kansio "laskarit", jonka voi halutessaan poistaa.  

### Kloonatun projektin suorittaminen
Projektin voi suorittaa suoraan komentoriviltä siirtymällä projektikansion juureen, jossa sijaitsee tiedosto *pom.xml*, ja antamalla komennon  
```
mvn compile exec:java -Dexec.mainClass=timetableapp.Main
```
Projektin voi myös avata Netbeansissa ja suorittaa siellä normaalisti vihreää nappia painamalla. Jos projekti ei löydä suoritettavaa Main-luokkaa, sen voi lisätä itse klikkaamalla auki olevalta Projects-välilehdeltä projektin juuresta *TimetableApp -> Properties -> Run* ja kirjoittamalla kohtaan "Main Class" suoritettavaksi luokaksi *timetableapp.Main*.
