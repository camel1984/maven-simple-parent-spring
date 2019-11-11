1. In root directory, execute mvn clean
1. In root directory, execute mvn install
1. In ./simple-webapp subdirectory, execute: mvn hibernate3:hbm2ddl, if there is any issues, use mvn hibernate3:hbm2ddl -X to debug.
1. In ./simple-webapp subdirectory, execute: mvn jetty:run
1. Access following url: http://127.0.0.1:8080/simple-webapp/weather.x
1. How to add remote git repository: git remote add origin https://github.com/camel1984/maven-simple-parent-spring.git
1. Push code: git push -u origin master
1. Clone local working directory: git clone https://github.com/camel1984/maven-simple-parent-spring.git