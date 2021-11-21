# TVIK4I_WEBAlk

-maven package-et kell létrehozni (intellij-ben már megtörtént)
-parancssorból meg kell nyitni a tomcat bin mappáját (ez nekem itt található: C:\CATALINA_HOME\apache-tomcat-10.0.11\bin)
-el kell indítani a startup.bat -et, ezzel elindítva a tomcatet
-a tomcat webapps mappájába át kell másolni a package folyamat által létrejött target mappából a .war filet, ezzel létrejön egy azonos nevű mappa is
-ezek után a böngészőbe beírjuk ezt: "localhost:8080" és a projekt nevét, ez esetben szamologepSpring -> "localhost:8080/szamologepSpring"
-be lehet írni a két számot és kiválasztani a használni kívánt alapműveletet, majd a küldés gombra nyomva kiírja az eredményt
