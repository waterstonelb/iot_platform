mvn clean package -Dmaven.test.skip=true
nohup java -jar ./target/*.jar &