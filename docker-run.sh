#!/bin/sh

set -ex

. ./init.sh

docker rm --force ${CONTAINER_NAME} || true
my_docker_run
