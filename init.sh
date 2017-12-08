#!/bin/sh

CONTAINER_NAME=java_testing

my_docker_run () {
    docker run -it \
        --volume "$(pwd)/work:/var/work" \
        --name "${CONTAINER_NAME}" \
        nekketsuuu/testing-lecture \
        /bin/bash
}
