./mvnw clean package

docker pull mysql

docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=db_example -e MYSQL_USER=dung -e MYSQL_PASSWORD=123456 -d mysql:5.6


docker build . -t hello

docker run -p 8086:8086 --name hello --link mysql-standalone:mysql -d hello

docker logs mysql-standalone

docker logs hello

