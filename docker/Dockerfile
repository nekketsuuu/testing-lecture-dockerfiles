FROM gradle:jdk8

LABEL maintainer="nekketsuuu <nekketsuuu@gmail.com>"

USER root

RUN apt-get update \
 && apt-get install -y --no-install-recommends \
      apt-transport-https \
 && echo 'deb https://dl.bintray.com/sbt/debian /' >> /etc/apt/sources.list.d/sbt.list \
 && apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 2EE0EA64E40A89B84B2DF73499E82A75642AC823 \
 && apt-get update \
 && apt-get install -y --no-install-recommends \
      emacs-nox \
      git \
      mercurial \
      sbt \
      scala \
 && apt-get clean \
 && rm -rf /var/lib/apt/lists/* \
 && echo "alias ls='ls --color=auto'" >> ~/.bashrc

WORKDIR /var
