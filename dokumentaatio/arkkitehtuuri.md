# Arkkitehtuurikuvaus

## Rakenne

Sovelluksen rakenne on seuraava:

![alt text](https://github.com/sumuh/ot-harjoitustyo/blob/master/dokumentaatio/updatedPakkauskaavio.jpg)

Ui-pakkaus huolehtii käyttöliittymän toiminnasta ja se on riippuvainen domain-pakkauksesta, joka sisältää sovelluslogiikan. Domain taas on riippuvainen dao-pakkauksesta, joka vastaa pysyväistallennuksesta. Sovelluksen pakkausrakenne on siis kolmitasoisen kerrosarkkitehtuurin mukainen. 

## Sovelluslogiikka

Logiikasta vastaavat luokat Cat ja CatService. CatServicen luonnin yhteydessä sille injektoidaan CatDao, jota se hyödyntää tietojen tallennuksessa. CatService huolehtii kissaan liittyvien statsien muuttamisesta sekä tarjoaa mahdollisuudet kissan tallentamiseen ja kissan hakemiseen tiedostosta. Sen metodeja ovat:
- Cat getCurrentCat()
- Cat create(String name)
- void Save(Cat cat)
- void raiseCurrentCatStats()
- void raiseOneStat(String stat)
- void feed()
- void play()
- void sleep()
