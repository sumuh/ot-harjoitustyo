# Arkkitehtuurikuvaus

## Rakenne

Sovelluksen rakenne on seuraava:

![alt text](https://github.com/sumuh/ot-harjoitustyo/blob/master/dokumentaatio/updatedPakkauskaavio.jpg)

Ui-pakkaus huolehtii käyttöliittymän toiminnasta ja se on riippuvainen domain-pakkauksesta, joka sisältää sovelluslogiikan. Domain taas on riippuvainen dao-pakkauksesta, joka vastaa pysyväistallennuksesta. Sovelluksen pakkausrakenne on siis kolmitasoisen kerrosarkkitehtuurin mukainen. 

## Käyttöliittymä

Käyttöliittymä sisältää kolme näkymää:
- aloitusmenu, jossa valitaan jatketaanko edellistä tallennusta vai luodaanko uusi
- nimenluontinäkymä, jos luodaan uusi kissa
- pelinäkymä

Jokainen näkymä on oma Scene-olionsa.

Käyttöliittymää ja näiden kolmen näkymän välillä siirtymistä hallinnoi luokka UiHandler. Pelinäkymää hallinnoi luokka GameWindow, jonka metodi getWindow palauttaa borderpanen. UiHandler asettaa tämän borderpanen luomalleen Scenelle, kun siirrytään pelinäkymään. 

Käyttöliittymä on eriytetty sovelluslogiikasta lukuunottamatta UiHandler-luokan alkua, jossa init-metodissa otetaan käyttöön properties-tiedosto. Metodissa luodaan myös CatService-olio, joka mm. annetaan parametrina GameWindow-luokalle.

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

## Pysyväistallennus

Kissan tietojen tallentamisesta tiedostoon vastaa FileCatDao-luokka, joka toteuttaa CatDao-rajapinnan. Tämä toteutustapa noudattaa Data Access Object -suunnittelumallia. Sovelluslogiikka hyödyntää DAO:a siten, että CatService-luokkaan injektoidaan CatDao-rajapinnan toteuttava olio, tässä tapauksessa siis käyttöliittymälogiikan puolella luotu FileCatDao-olio.

### Tiedosto

Sovellus tallentaa kissan tiedot catfile.txt-nimiseen tiedostoon. Sen muoto on seuraava:

<pre>
nimi;nälkä;tylsistyminen;väsymys
</pre>

Eli esimerkiksi

<pre>
Kisse;12;40;6
</pre>

## Rakenteen heikkoudet

UiHandler-luokan start-metodi on sekava ja turhan pitkä, se olisi kannattanut eriyttää pienemmiksi metodeiksi ja mahdollisesti tehdä aloitusmenusta ja nimenluontinäkymästä omat luokkansa pelinäkymän tapaan.
