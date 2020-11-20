# TimetableApp

Sovelluksen käyttäjä voi tallentaa erilaisia tehtäviä koko viikon päivät kattavaan lukujärjestykseen. Myös menneiden ja tulevien viikkojen lukujärjestyksiä voi katsella. Sovellukseen tulee kirjautua tai luoda uusi käyttäjätili. Jokaisella käyttäjällä on oma yksilöllinen lukujärjestyksensä.

## Dokumentaatio
[Vaatimusmäärittely](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/TimetableApp/dokumentaatio/vaatimusmaarittely.md)  
[Työaikakirjanpito](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/TimetableApp/dokumentaatio/tuntikirjanpito.md)

## Käyttöohje
Projektin voi kloonata koneelle ja ajaa komentoriviltä tai Netbeansissa.  
Siirry komentorivillä kansioon, jonne haluat kloonata projektin ja aja komento  
```
git clone https://github.com/makitzei/ot-harjoitustyo2020.git
```
Projektin voi suorittaa suoraan komentoriviltä siirtymällä projektikansion juureen, jossa sijaitsee tiedosto *pom.xml*, ja antamalla komennon  
```
mvn compile exec:java -Dexec.mainClass=timetableapp.Main
```
Projektin voi myös avata Netbeansissa ja suorittaa siellä normaalisti vihreää nappia painamalla. Jos projekti ei löydä suoritettavaa Main-luokkaa, sen voi lisätä itse klikkaamalla auki olevalta Projects-välilehdeltä projektin juuresta *TimetableApp -> Properties -> Run* ja kirjoittamalla kohtaan "Main Class" suoritettavaksi luokaksi *timetableapp.Main*.
