# Arkkitehtuurikuvaus

## Rakenne
Ohjelma noudattaa kerrosarkkitehtuuria, jonka pakkausrakenne on seuraava:  

![paketit](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/dokumentaatio/kuvat/paketit.png)  

Paketissa *timetableapp.ui* on JavaFX:llä toteutettu graafinen käyttöliittymä, *todoapp.domain*-paketissa sovelluslogiikkakoodi ja *todoapp.dao*:n koodit vastaavat tietojen tallennuksesta.

## Käyttöliittymä
Käyttöliittymässä on neljä eri näkymää:
* kirjautuminen
* uuden käyttäjän luominen
* viikon lukujärjestys
* uuden tapahtuman luominen lukujärjestykseen

## Sovelluslogiikka
Sovelluksen ytimen muodostavat kolme luokkaa *User*, *Timetable* ja *Event*, jotka kuvaavat käyttäjiä, heidän omia lukujärjestyksiään ja niissä olevia tapahtumia:   
![luokat](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/dokumentaatio/kuvat/luokkakaavio.png)  

Luokka *TimetableService* vastaa toiminnallisista kokonaisuuksista. Luokka pääsee käsiksi käyttäjiin ja lukujärjestyksiin niitä vastaavien *Dao*-rajapintojen kautta. Tapahtumat ovat osa lukujärjestyksiä ja niiden käsittely tapahtuu *Timetable*-olioiden kautta.
![pakkauskaavio](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/dokumentaatio/kuvat/pakettikaavio_v2.png)

## Tietojen tallennus
Tietojen tallennus tapahtuu kahteen tekstitiedostoon. Ohjelma tallentaa käyttäjän rekisteröitymishetkellä antaman nimen ja käyttäjätunnuksen tekstitiedostoon *users.txt* ja alustaa käyttäjätunnukselle 52 viikon lukujärjestyspohjat tiedostoon *timetables.txt*. Tiedostot syntyvät kansioon, josta ohjelmaa suoritetaan. Käyttäjät tallennetaan puolipisteellä erotettuina oikea nimi ensin ja käyttäjänimi sitten:  
```
Maikki Heehee;makitzei
Iiris Kissanen;iiris

```
Lukujärjestykset tallennetaan käyttäjänimi edellä, sitten viikon numero, sitten viikon tapahtumien aihe- ja aikatiedot peräkkäin:
```
makitzei;1;opiskelu;maanantai;8;9;opiskelu;maanantai;9;10;opiskelu;maanantai;10;11;
makitzei;2;vapaa;tiistai;10;11;
makitzei;3;
...
makitzei;52;
iiris;1;juoksu;torstai;11;12;juoksu;torstai;12;13;opiskelu;maanantai;8;9;opiskelu;maanantai;9;10;
iiris;2;liikunta;perjantai;14;15;
iiris;3;
...
iiris;52;jouluostokset;sunnuntai;13;14;jouluostokset;sunnuntai;14;15;jouluostokset;sunnuntai;15;16;jouluostokset;sunnuntai;16;17;

```
Muun ohjelman toiminnan jouhevoittamiseksi tapahtumat tallentuvat tiedostoon tunnin pätkissä. Esimerkiksi *iiris*-käyttäjän jouluostokset edellisessä esimerkissä on alun perin luotu *Event*-oliona, jonka kesto on 13-17, mutta tiedostoon tallennettaessa *TimetableService* pilkkoo tapahtuman tunnin mittaisiksi tapahtumiksi. Tämä mahdollistaa tapahtumien näyttämisen oikein lukujärjestyksessä sekä yksittäisten tuntien tapahtumien poistamisen.

## Toiminnallisuuksia
Uuden käyttäjän luomisnäkymässä voi edetä, kun käyttäjätunnus ei ole vielä ennestään käytössä ja kun käyttäjätunnus tai oikea nimi ovat tarpeeksi pitkiä merkkijonoja. Painamalla nappia *createUserButton* kontrolli etenee kuvatulla tavalla:  
![kayttajan_luominen](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/dokumentaatio/kuvat/Kayttajan%20luominen.png)

Tapahtumakäsittelijä käyttöliittymässä kutsuu sovelluslogiikan *timetableService* metodia *createUser* parametreina käyttäjän oikea nimi ja nimimerkki. Rajapinnan *userDao* metodin *findByUsername* avulla selvitetään, onko käyttäjätunnus jo olemassa. Jos ehto palauttaa arvon *null*, luominen jatkuu. Sovelluslogiikka luo *User*-olion annetuilla parametreilla ja tallettaa sen *UserDao*:n metodilla *create*. Lopuksi käyttöliittymä vaihtaa näkymäksi kirjautumisnäkymän *window*-nimisen *Stage*-olion metodilla *setScene* parametrilla *sceneLogin*.

## Tunnettuja heikkouksia

* käyttöliittymä on turhan pitkä ja monimutkainen ja sitä voisi selkeyttää eriyttämällä toimintaa luokiksi ja metodeiksi
* lukujärjestysnäkymä ei päivity automaattisesti tapahtuman luomisen jälkeen, sillä poistamisominaisuus luodaan lukujärjestyksen tapahtumatiiliin viikon vaihtamisen toiminnallisuuden sisällä
