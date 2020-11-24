# Arkkitehtuurikuvaus

## Rakenne
Ohjelma noudattaa kolmitasoista kerrosarkkitehtuuria, jonka pakkausrakenne on seuraava:  

![paketit](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/TimetableApp/dokumentaatio/kuvat/paketit.png)  

Paketissa *timetableapp.ui* on JavaFX:llä toteutettu graafinen käyttöliittymä, *todoapp.domain*-paketissa sovelluslogiikkakoodi ja *todoapp.dao*:n koodit vastaavat tietojen tallennuksesta.

## Käyttöliittymä

## Sovelluslogiikka
![luokat](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/TimetableApp/dokumentaatio/kuvat/luokkakaavio.png)
![pakkauskaavio](https://github.com/makitzei/ot-harjoitustyo2020/blob/master/TimetableApp/dokumentaatio/kuvat/pakettikaavio.png)

## Tietojen tallennus
Tietojen tallennus tapahtuu alustavasti tekstitiedostoon. Tällä hetkellä ohjelma tallentaa käyttäjän rekisteröitymishetkellä antaman nimen ja käyttäjätunnuksen tekstitiedostoon *users.txt*.
