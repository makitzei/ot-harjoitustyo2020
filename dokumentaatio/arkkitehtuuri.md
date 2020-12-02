# Arkkitehtuurikuvaus

## Rakenne
Ohjelma noudattaa kolmitasoista kerrosarkkitehtuuria, jonka pakkausrakenne on seuraava:  

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

Luokka *TimetableService* vastaa toiminnallisista kokonaisuuksista. Luokka pääsee käsiksi käyttäjiin, lukujärjestyksiin ja tapahtumiin niitä vastaavien *Dao*-rajapintojen kautta.
![pakkauskaavio](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/dokumentaatio/kuvat/pakettikaavio.png)

## Tietojen tallennus
Tietojen tallennus tapahtuu alustavasti tekstitiedostoon. Tällä hetkellä ohjelma tallentaa käyttäjän rekisteröitymishetkellä antaman nimen ja käyttäjätunnuksen tekstitiedostoon *users.txt* ja alustaa käyttäjätunnukselle 52 viikon lukujärjestyspohjat tiedostoon *timetables.txt*. Myöhemmin lisätään konfiguraatiotiedosto *properties*, jossa voi määritellä tallennettavien tiedostojen nimet.

## Toiminnallisuuksia
Uuden käyttäjän luomisnäkymässä voi edetä, kun käyttäjätunnus ei ole vielä ennestään käytössä ja kun käyttäjätunnus tai oikea nimi ovat tarpeeksi pitkiä merkkijonoja. Painamalla nappia *createUserButton* kontrolli etenee kuvatulla tavalla:  
![kayttajan_luominen](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/dokumentaatio/kuvat/Kayttajan%20luominen.png)

Tapahtumakäsittelijä käyttöliittymässä kutsuu sovelluslogiikan *timetableService* metodia *createUser* parametreina käyttäjän oikea nimi ja nimimerkki. Rajapinnan *userDao* metodin *findByUsername* avulla selvitetään, onko käyttäjätunnus jo olemassa. Jos ehto palauttaa arvon *null*, luominen jatkuu. Sovelluslogiikka luo *User*-olion annetuilla parametreilla ja tallettaa sen *UserDao*:n metodilla *create*. Lopuksi käyttöliittymä vaihtaa näkymäksi kirjautumisnäkymän *window*-nimisen *Stage*-olion metodilla *setScene* parametrilla *sceneLogin*.  
