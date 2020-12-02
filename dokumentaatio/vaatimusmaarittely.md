# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen avulla käyttäjät voivat tehdä itselleen viikkokohtaisia lukujärjestyksiä ja seurata viikoittaista työajan jakautumistaan eri tehtäville. Sovellukseen tulee rekisteröityä, jolloin jokaisella käyttäjällä on oma lukujärjestyksensä.

## Käyttöliittymäluonnos

![kayttoliittyma_1](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/dokumentaatio/kuvat/kl_luonnos_1.png)

Sovelluksen eri näkymät ovat kirjautumis- ja rekisteröitymisnäkymä, lukujärjestyksen katselunäkymä ja uuden lukujärjestykseen laitettavan tehtävän/aiheen lisääminen.

## Toiminnallisuudet (tehdyt merkattu täpällä alkuun)

### Ennen kirjautumista
- [x] käyttäjä voi luoda uuden käyttäjätunnuksen (viikko 4)
- [x] kun uusi käyttäjätunnus luodaan, alustetaan tietokantaan (tekstitiedosto *timetables.txt*) pohja käyttäjän koko vuoden lukujärjestyksille (viikko 5)
- [x] käyttäjä voi kirjautua järjestelmään (viikko 4)

### Kirjautumisen jälkeen
- [ ] käyttäjä näkee aluksi tämän viikon oman lukujärjestyksensä
- [ ] käyttäjä voi selata taakse- tai eteenpäin menneiden ja tulevien viikkojen lukujärjestyksiään
- [ ] käyttäjä voi lisätä nykyiseen tai tuleviin lukujärjestyksiinsä lisää tehtäviä tai poistaa niitä
- [x] alkuversio tapahtuman luomisesta: käyttäjä voi valita tapahtuman valmiista listasta ja asettaa sille tapahtuma-ajan, minkä jälkeen tapahtuman tiedot tulostuvat tapahtuman luomisnäkymään (viikko 5)
- [x] käyttäjä voi kirjautua ulos järjestelmästä (viikko 4)

## Jatkokehitysideoita

Sovellusta on mahdollista laajentaa esimerkiksi seuraavilla tavoilla:

* käyttäjä voi katsoa lisätietoa tehtävästä siirtämällä kursorin lukujärjestyksen tehtävän kohdalle
* Käyttäjä voi valita jonkin valmiista tehtävistä ja myös käyttäjän itse lisäämät tehtävät lisätään oletustehtävävalikkoon
* Lukujärjestyksen tehtävien muokkaaminen
