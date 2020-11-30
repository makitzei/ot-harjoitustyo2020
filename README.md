# TimetableApp

Sovelluksen käyttäjä voi tallentaa erilaisia tehtäviä koko viikon päivät kattavaan lukujärjestykseen. Myös menneiden ja tulevien viikkojen lukujärjestyksiä voi katsella. Sovellukseen tulee kirjautua tai luoda uusi käyttäjätili. Jokaisella käyttäjällä on oma yksilöllinen lukujärjestyksensä.

## Dokumentaatio
[Käyttöohje](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/dokumentaatio/kayttoohje.md)  
[Vaatimusmäärittely](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/dokumentaatio/vaatimusmaarittely.md)  
[Työaikakirjanpito](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/dokumentaatio/tuntikirjanpito.md)  
[Arkkitehtuurikuvaus](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/dokumentaatio/arkkitehtuuri.md)

## Komentorivitoiminnot

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

### Checkstyle
Tiedostossa checkstyle.xml on määritelty koodin tarkistukset, jotka voi suorittaa komennolla
```
mvn jxr:jxr checkstyle:checkstyle
```
Tarkistuksen tuloksia voi tarkastella avaamalla selaimessa tiedoston *target/site/checkstyle.html*
