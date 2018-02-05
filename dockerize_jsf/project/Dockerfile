FROM java:latest
RUN wget http://ftp.itu.edu.tr/Mirror/Apache/maven/maven-3/3.5.2/binaries/apache-maven-3.5.2-bin.tar.gz
RUN tar xzvf apache-maven-3.5.2-bin.tar.gz
RUN mkdir project
COPY springJSF-CRUD/ project/
WORKDIR /project
RUN /apache-maven-3.5.2/bin/mvn install clean
