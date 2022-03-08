build: Dockerfile
	docker build -t rubensvf/portafolio:1.0 .

start: 
	docker run -p 8080:8080 rubensvf/portafolio:1.0

push: 
	docker push rubensvf/portafolio:1.0