package com.vikrant.cassandraLab.cassandralab.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;

@Configuration
public class CassandraConfiguration extends AbstractCassandraConfiguration{
       @Value("${spring.cassandra.keyspace-name}")
       private String keySpace;
       @Value("${spring.cassandra.contact-points}")
       private String contactPoints;
       @Value("${spring.cassandra.port}")
       private int port;

       @Override
       public String getKeyspaceName() {
           return keySpace;
       }

       @Override
       public String getContactPoints() {
           return contactPoints;
       }

       @Override
       public int getPort() {
           return port;
       }
}
