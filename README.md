# TimetableApp

Sovelluksen käyttäjä voi tallentaa erilaisia tehtäviä viikon kaikki päivät kattavaan lukujärjestykseen. Myös menneiden ja tulevien viikkojen lukujärjestyksiä voi katsella ja muokata. Lukujärjestyksiä on 52, yksi vuoden jokaiselle viikolle. Sovellukseen tulee kirjautua tai luoda uusi käyttäjätili. Jokaisella käyttäjällä on omat yksilölliset lukujärjestyksensä.

## Dokumentaatio
[Käyttöohje](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/dokumentaatio/kayttoohje.md)  
[Vaatimusmäärittely](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/dokumentaatio/vaatimusmaarittely.md)  
[Työaikakirjanpito](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/dokumentaatio/tuntikirjanpito.md)  
[Arkkitehtuurikuvaus](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/dokumentaatio/arkkitehtuuri.md)  

## Releaset
[Viikko 5](https://github.com/makitzei/ot-harjoitustyo2020/releases/tag/viikko5)  
[Viikko 6](https://github.com/makitzei/ot-harjoitustyo2020/releases/tag/viikko6)

## Komentorivitoiminnot
### Kloonaaminen
Halutessaan projektin voi kloonata koneelle ja ajaa komentoriviltä tai Netbeansissa.
  
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

### Testaus
Testit voi suorittaa projektin juuressa komennolla
```
mvn test
```
Testikattavuusraportti luodaan komennolla 
```
mvn jacoco:report
```
Kattavuusraporttia voi katsella avaamalla selaimessa tiedoston *target/site/jacoco/index.html*

### Suoritettavan jar-tiedoston generointi

Projektin hakemistoon *target* saa generoitua suoritettavan jar-tiedoston *TimetableApp-1.0-SNAPSHOT.jar* komennolla
```
mvn package
```

### Checkstyle
Tiedostossa checkstyle.xml on määritelty koodin tarkistukset, jotka voi suorittaa komennolla
```
mvn jxr:jxr checkstyle:checkstyle
```
Tarkistuksen tuloksia voi tarkastella avaamalla selaimessa tiedoston *target/site/checkstyle.html*

### Javadoc
Javadocin saa generoitua käskyllä
```
mvn javadoc:javadoc
```
Javadocia voi tarkastella esimerkiksi avaamalla selaimella tiedoston */target/site/apidocs/index.html*
