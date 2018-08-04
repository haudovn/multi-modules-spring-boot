FROM mysql:5.6.41

COPY mysql/mysql.cnf /etc/mysql/conf.d/
COPY mysql/sql /docker-entrypoint-initdb.d

#VOLUME mysql/sql:/var/lib/mysql

EXPOSE 3306