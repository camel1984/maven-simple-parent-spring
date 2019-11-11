#Set up this project
1. In root directory, execute mvn clean
1. In root directory, execute mvn install
1. In ./simple-webapp subdirectory, execute: mvn hibernate3:hbm2ddl, if there is any issues, use mvn hibernate3:hbm2ddl -X to debug.
1. In ./simple-webapp subdirectory, execute: mvn jetty:run
1. Access following url: http://127.0.0.1:8080/simple-webapp/weather.x
#Import existing source into git hub
1. In root directory: git init
1. In root directory: git remote add origin https://github.com/camel1984/maven-simple-parent-spring.git
1. In root directory: git add ${file or directory name} to add all the project directories and files.
1. In root directory: git push -u origin master
#Import remote repository into local work space
1. Clone local working directory: git clone https://github.com/camel1984/maven-simple-parent-spring.git





