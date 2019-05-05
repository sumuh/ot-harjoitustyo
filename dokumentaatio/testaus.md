# Testausdokumentti

Sovellusta on testattu JUnitin yksikkötesteillä sekä manuaalisella testauksella.

## Yksikkötestaus 

### Sovelluslogiikka 

Domain-testipakkauksen luokat CatServiceTest ja CatTest huolehtivat sovelluslogiikan testauksesta. CatTest testaa kissaolion toimintaa, ja CatServiceTest CatService-luokan toimintaa. CatServiceTest hyödyntää FakeCatDao-luokkaa, joka simuloi DAO:n toimintaa sillä poikkeuksella, että se tallentaa tiedoston sijaan listaan. 

### Dao-luokka

Dao-testipakkauksen CatDaoTest-luokka testaa Daon toimintaa TemporaryFolder-rulea hyödyntäen. 

### Testikattavuus

Kun käyttöliittymä jätetään huomiotta, testauksen rivikattavuus on 85% ja haaraumakattavuus 92%. Testaamatta jäivät try-catch-lausekkeiden catch-osiot, sillä en löytänyt toimivaa tapaa niiden testaamiseen.

![alt text](https://github.com/sumuh/ot-harjoitustyo/blob/master/dokumentaatio/testikattavuus.png)
