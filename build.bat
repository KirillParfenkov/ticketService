xcopy .\out\production\ticketService .\build\ticket\WEB-INF\classes\ /Y/E /exclude:excludedfileslist.txt
xcopy .\out\production\ticketService\WEB-INF\web.xml .\build\ticket\WEB-INF\web.xml /Y
xcopy .\out\production\ticketService\application.properties .\build\ticket\application.properties /Y
xcopy .\lib .\build\ticket\WEB-INF\lib
cd .\build\ticket\
jar -cvf ..\ticket.war .
cd ..\..
copy .\build\ticket.war D:\Programs\apache-tomcat-9.0.0.M17\webapps\ticket.war