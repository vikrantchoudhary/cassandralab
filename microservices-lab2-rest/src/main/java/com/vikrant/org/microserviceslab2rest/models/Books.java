package com.vikrant.org.microserviceslab2rest.models;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.oss.driver.internal.core.type.codec.TimeUuidCodec;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Table
public class Books {
    @PrimaryKey
    private UUID id;

    private String title;
    private String Author;
    private boolean published;

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    
}
