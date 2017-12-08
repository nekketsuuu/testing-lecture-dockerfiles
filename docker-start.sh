#!/bin/sh

set -ex

. ./init.sh

if [ "$(docker ps -a | grep ${CONTAINER_NAME})" ] ; then
    docker start -i "${CONTAINER_NAME}"
else
    my_docker_run
fi
