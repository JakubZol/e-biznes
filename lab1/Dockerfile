FROM ubuntu:20.04
ENV TZ=Europe/Warsaw

# JAVA
RUN apt-get update
RUN apt-get install openjdk-8-jdk -y
ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk
ENV PATH $PATH:$JAVA_HOME/bin

# SCALA
RUN apt-get install wget dpkg -y
RUN wget https://downloads.lightbend.com/scala/2.12.0/scala-2.12.0.deb
RUN dpkg -i scala-2.12.0.deb

# NPM
RUN apt-get install npm -y

# CURL
RUN apt-get install curl -y

# SBT
RUN echo "deb https://dl.bintray.com/sbt/debian /" | tee -a /etc/apt/sources.list.d/sbt.list 
RUN curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | apt-key add
RUN apt-get update
RUN apt-get install sbt -y
	
# ADDING USER AND PORT
RUN useradd -ms /bin/bash jakubzol
RUN adduser jakubzol sudo
EXPOSE 8080
USER jakubzol
WORKDIR /home/jakubzol
RUN mkdir /home/jakubzol/e-biznes
VOLUME /home/jakubzol/e-biznes

