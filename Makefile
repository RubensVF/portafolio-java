java-build: 
	mvn clean install -DskipTests

docker-red:
	docker network create portafolio

docker-mysql:
	docker run --name db -v /home/rubs/Temp/portafolio-java/db:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=secret -e MYSQL_DATABASE=posts -d --net=portafolio mysql:5.7

docker-build: Dockerfile
	sudo docker build -t rubensvf/portafolio:1.1 .

docker-start: 
	docker run -d -p 8000:8080 --name server --net=portafolio rubensvf/portafolio:1.1

push: 
	docker push rubensvf/portafolio:1.1

#docker run --name db -e MYSQL_ROOT_PASSWORD=secret -e MYSQL_DATABASE=posts -d -p 3306:3306 mysql:5.7