Windows rendszeren kicsit máshogy működik ez a H2 console.

Először is le kell tölteni a windows installert innen: "https://www.h2database.com/html/main.html" Utána a H2 console (command line) appot futtatni kell. 
Ez utóbbi lépés behozza a böngészőbe a H2 consolet.

A kódba 1-es exit kóddal leállt a futtatás mindig, ezért az application.properties 
-ben az urlt átírtam erről: "jdbc:h2:file:/tmp/data/demo" erre "jdbc:h2:file:./tmp/data/demo", így már fut a program hiba nélkül. 
(egyébként ha ez nincs ott: "spring.jpa.hibernate.ddl-auto = create" akkor is fut leállás nélkül, de az előbbi megoldással úgy vélem jobb)

A H2 console JDBC URL-jéhez erre módosítottam a kapott hibaüzenet alapján: "jdbc:h2:file:~/tmp/data/demo" ezekkel a módosításokkal sikeresen be tudtam lépni az adatbázisba.
