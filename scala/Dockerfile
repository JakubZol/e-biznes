FROM ubuntu:20.04

ENV TZ=Europe/Warsaw
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone 

RUN apt update && apt install -y build-essential unzip vim git curl wget zip

RUN apt-get update &&\
	apt-get upgrade -y &&\
    apt-get install -y  software-properties-common

# JS
RUN curl -sL https://deb.nodesource.com/setup_14.x | bash -
RUN apt-get install -y nodejs
RUN npm install -g npm@latest
RUN npm install -g serve@latest
RUN apt-get install -y net-tools

USER root
RUN id -u jakubzol 1>/dev/null 2>&1 || (( getent group 0 1>/dev/null 2>&1 || ( type groupadd 1>/dev/null 2>&1 && groupadd -g 0 root || addgroup -g 0 -S root )) && ( type useradd 1>/dev/null 2>&1 && useradd --system --create-home --uid 1001 --gid 0 jakubzol || adduser -S -u 1001 -G root jakubzol ))
RUN chown jakubzol:root /opt
USER 1001:0

USER jakubzol
WORKDIR /home/jakubzol/
RUN curl -s "https://get.sdkman.io" | bash
RUN chmod a+x "/home/jakubzol/.sdkman/bin/sdkman-init.sh"
RUN bash -c "source /home/jakubzol/.sdkman/bin/sdkman-init.sh && sdk install java 8.0.302-open"

RUN pwd
RUN ls -al
COPY --chown=jakubzol:root target/universal/stage /opt/stage
EXPOSE 9000
RUN chmod a+x "/opt/stage/bin/backend-scala"
CMD ["/opt/stage/bin/backend-scala", "-java-home", "/home/jakubzol/.sdkman/candidates/java/current"]