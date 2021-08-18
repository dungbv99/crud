docker system prune
docker system prune --volumes
docker image prune
docker container prune
docker container stop $(docker container ls -aq)
docker container rm $(docker container ls -aq)
docker rmi $(docker images -q)


