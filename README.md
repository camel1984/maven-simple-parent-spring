# Set up this project
1. In root directory, execute mvn clean
1. In root directory, execute mvn install
1. In ./simple-webapp subdirectory, execute: mvn hibernate3:hbm2ddl, if there is any issues, use mvn hibernate3:hbm2ddl -X to debug.
1. In ./simple-webapp subdirectory, execute: mvn jetty:run
1. Access following url: http://127.0.0.1:8080/simple-webapp/weather.x
1. When deploying this project into tomcat, the hsqldb file path is relative path: jdbc:hsqldb:data/weather, so the data dir must be in the same directory when you start web server, so do the following:
   * pwd: /Users/shuaijie/server/apache-tomcat-8.5.15/webapps/simple-webapp
   * cp -R /Users/shuaijie/document/java_frameworks/maven/mycode/ch07/simple-parent-spring/simple-webapp/data .
   * ../../bin/startup.sh
   * we copy data dir into webapps/simple-webapp, then start the tomcat from this very directory so the data directory is in the root directory of the current directory of the tomcat process.
   * Then access this url: http://127.0.0.1:8080/simple-webapp/weather.x
   * For this version, access this: http://127.0.0.1:8080/simple-webapp/weather.x?name=bellevue,wa
   * http://127.0.0.1:8080/simple-webapp/history.x?woeid=2362031
# Import existing source into git hub
1. In root directory: git init
1. In root directory: git remote add origin https://github.com/camel1984/maven-simple-parent-spring.git
1. In root directory: git add ${file or directory name} to add all the project directories and files.
1. In root directory: git push -u origin master
# Import remote repository into local work space
1. Clone local working directory: git clone https://github.com/camel1984/maven-simple-parent-spring.git





