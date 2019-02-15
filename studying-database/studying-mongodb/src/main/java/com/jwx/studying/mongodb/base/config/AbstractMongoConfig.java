package com.jwx.studying.mongodb.base.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: TODO
 * <p>
 * PackageName:com.jwx.studying.mongodb.base.config
 * FileName: AbstractMongoConfig.java
 * Copyright: Copyright (c)2019. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2019-02-14
 */

public abstract class AbstractMongoConfig {


    @Value("${host}")
    private List<String> host;

    @Value("${port}")
    private int port;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @Value("${database}")
    private String database;

    @Value("${authentication-database}")
    private String authenticationDatabase;

    @Value("${connectionsPerHost}")
    private Integer connectionsPerHost;

    @Value("${min-connections-per-host}")
    private Integer minConnectionsPerHost;

    @Value("${threads-allowed-to-block-for-connection-multiplier}")
    private Integer threadsAllowedToBlockForConnectionMultiplier;

    @Value("${max-wait-time}")
    private Integer maxWaitTime;

    @Value("${socket-timeout}")
    private Integer socketTimeout;

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {

        //客户端配置（连接数、副本集群验证）
        MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
        builder.connectionsPerHost(this.connectionsPerHost);
        builder.minConnectionsPerHost(this.minConnectionsPerHost);
        builder.threadsAllowedToBlockForConnectionMultiplier(this.threadsAllowedToBlockForConnectionMultiplier);
        builder.maxWaitTime(this.maxWaitTime);
        builder.socketTimeout(this.socketTimeout);

        MongoClientOptions mongoClientOptions = builder.build();

        List<ServerAddress> serverAddresses = new ArrayList<>();
        List<String> address = this.host;
        for (String add : address) {
            String[] str = add.split(":");
            ServerAddress serverAddress = new ServerAddress(str[0], Integer.parseInt(str[1]));
            serverAddresses.add(serverAddress);
        }


        // 连接认证
        List<MongoCredential> mongoCredentialList = new ArrayList<>();
        if (this.username != null) {
            mongoCredentialList.add(MongoCredential.createScramSha1Credential(
                    this.username,
                    this.authenticationDatabase != null ? this.authenticationDatabase : this.database,
                    this.password.toCharArray()));
        }


        return new SimpleMongoDbFactory(new MongoClient(serverAddresses, mongoCredentialList, mongoClientOptions), this.database);

    }


    abstract public MongoTemplate getMongoTemplate() throws Exception;


    public List<String> getHost() {
        return host;
    }

    public void setHost(List<String> host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getAuthenticationDatabase() {
        return authenticationDatabase;
    }

    public void setAuthenticationDatabase(String authenticationDatabase) {
        this.authenticationDatabase = authenticationDatabase;
    }

    public Integer getConnectionsPerHost() {
        return connectionsPerHost;
    }

    public void setConnectionsPerHost(Integer connectionsPerHost) {
        this.connectionsPerHost = connectionsPerHost;
    }

    public Integer getMinConnectionsPerHost() {
        return minConnectionsPerHost;
    }

    public void setMinConnectionsPerHost(Integer minConnectionsPerHost) {
        this.minConnectionsPerHost = minConnectionsPerHost;
    }

    public Integer getThreadsAllowedToBlockForConnectionMultiplier() {
        return threadsAllowedToBlockForConnectionMultiplier;
    }

    public void setThreadsAllowedToBlockForConnectionMultiplier(Integer threadsAllowedToBlockForConnectionMultiplier) {
        this.threadsAllowedToBlockForConnectionMultiplier = threadsAllowedToBlockForConnectionMultiplier;
    }

    public Integer getMaxWaitTime() {
        return maxWaitTime;
    }

    public void setMaxWaitTime(Integer maxWaitTime) {
        this.maxWaitTime = maxWaitTime;
    }

    public Integer getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(Integer socketTimeout) {
        this.socketTimeout = socketTimeout;
    }
}