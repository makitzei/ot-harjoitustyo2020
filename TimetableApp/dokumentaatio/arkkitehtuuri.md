# Arkkitehtuurikuvaus

## Rakenne
Ohjelma noudattaa kolmitasoista kerrosarkkitehtuuria, jonka pakkausrakenne on seuraava:  

![paketit](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/TimetableApp/dokumentaatio/kuvat/paketit.png)  

Paketissa *timetableapp.ui* on JavaFX:llä toteutettu graafinen käyttöliittymä, *todoapp.domain*-paketissa sovelluslogiikkakoodi ja *todoapp.dao*:n koodit vastaavat tietojen tallennuksesta.

## Käyttöliittymä
Käyttöliittymässä on neljä eri näkymää:
* kirjautuminen
* uuden käyttäjän luominen
* viikon lukujärjestys
* uuden tapahtuman luominen lukujärjestykseen

## Sovelluslogiikka
Sovelluksen ytimen muodostavat kolme luokkaa *User*, *Timetable* ja *Event*, jotka kuvaavat käyttäjiä, heidän omia lukujärjestyksiään ja niissä olevia tapahtumia:   
![luokat](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/TimetableApp/dokumentaatio/kuvat/luokkakaavio.png)  

Luokka *TimetableService* vastaa toiminnallisista kokonaisuuksista. Luokka pääsee käsiksi käyttäjiin, lukujärjestyksiin ja tapahtumiin niitä vastaavien *Dao*-rajapintojen kautta.
![pakkauskaavio](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/TimetableApp/dokumentaatio/kuvat/pakettikaavio.png)

## Tietojen tallennus
Tietojen tallennus tapahtuu alustavasti tekstitiedostoon. Tällä hetkellä ohjelma tallentaa käyttäjän rekisteröitymishetkellä antaman nimen ja käyttäjätunnuksen tekstitiedostoon *users.txt*. Myöhemmin lisätään konfiguraatiotiedosto *properties*, jossa voi määritellä tallennettavien tiedostojen nimet. Tietokantaan tallentamista harkittanee myös.
