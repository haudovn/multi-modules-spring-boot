FROM mysql:5.7

COPY mysql/mysql.cnf /etc/mysql/conf.d/
COPY mysql/sql/ /docker-entrypoint-initdb.d/
COPY mysql/sql/* /docker-entrypoint-initdb.d/
COPY mysql/sql/*/* /docker-entrypoint-initdb.d/

#VOLUME mysql/sql:/var/lib/mysql

EXPOSE 3306

#CMD ["mysqld", "--user=mysql", "--lower_case_table_names=1"]

CMD ["mysqld"]