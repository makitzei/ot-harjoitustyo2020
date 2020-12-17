# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen avulla käyttäjät voivat tehdä itselleen viikkokohtaisia lukujärjestyksiä ja seurata viikoittaista työajan jakautumistaan eri tehtäville. Sovellukseen tulee rekisteröityä, jolloin jokaisella käyttäjällä on oma lukujärjestyksensä.

## Käyttöliittymäluonnos

![kayttoliittyma_1](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/dokumentaatio/kuvat/kl_luonnos_1.png)

Sovelluksen eri näkymät ovat kirjautumis- ja rekisteröitymisnäkymä, lukujärjestyksen katselunäkymä ja uuden lukujärjestykseen laitettavan tehtävän/aiheen lisääminen.

## Toiminnallisuudet lopullisessa versiossa

### Ennen kirjautumista
- käyttäjä voi luoda uuden käyttäjätunnuksen
- kun uusi käyttäjätunnus luodaan, alustetaan tietokantaan pohja käyttäjän koko vuoden lukujärjestyksille
- käyttäjä voi kirjautua järjestelmään

### Kirjautumisen jälkeen
- käyttäjä näkee aluksi viikon 1 lukujärjestyksensä
- käyttäjä voi selata pudotusvalikosta muiden viikkojen lukujärjestyksiä
- käyttäjä voi lisätä katseltavana olevaan lukujärjestykseen tapahtumia
- tapahtumille voi keksiä myös omia aiheita
- käyttäjä voi poistaa tapahtumia klikkaamalla niitä lukujärjestyksessä
- käyttäjä voi kirjautua ulos järjestelmästä
- lukujärjestysten tiedot tallentuvat myös seuraavia käyttökertoja varten

## Jatkokehitysideoita

Sovellusta on mahdollista laajentaa esimerkiksi seuraavilla tavoilla:

* käyttäjä voi katsoa lisätietoa tehtävästä siirtämällä kursorin lukujärjestyksen tehtävän kohdalle
* lukujärjestyksen tehtäviä voisi myös muokata, ei vain poistaa
* sisäänkirjautumisvaiheessa käyttäjälle voitaisiin näyttää ensimmäisenä ajankohtainen, meneillään olevan viikon lukujärjestys
* myös käyttäjän itse laatimat aiheet voisi tallentaa tulevaa varten käyttäjäkohtaisesti
