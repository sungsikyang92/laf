// package com.rocket.laf.config;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Profile;
// import redis.embedded.Redis;
// import redis.embedded.RedisServer;
// import javax.annotation.PostConstruct;
// import javax.annotation.PreDestroy;

// //로컬 환경일경우 내장 레디스가 실행된다.
// @Profile("local")
// @Configuration
// public class EmbeddedRedisConfig {

//     @Value("${spring.redis.port}")
//     private int redisPort;

//     private RedisServer redisServer;

<<<<<<< HEAD
//     // @PostConstruct
//     // public void redisServer() {
//     //     //redisServer = new RedisServer(redisPort);
            
//     //     redisServer.start();
//     // }

//     @PostConstruct
//     public void redisServer() {
// //      redisServer = new RedisServer(redisPort);
//         redisServer = RedisServer.builder()
//                 .port(redisPort)
//                 .setting("maxmemory 128M")
//                 .build();
//         redisServer.start();
//     }

=======
//     @PostConstruct
//     public void redisServer() {
// //        redisServer = new RedisServer(redisPort);
//         redisServer = RedisServer.builder()
//                 .port(redisPort)
//                 .setting("maxmemory 128M")
//                 .build();
//         redisServer.start();
//     }

>>>>>>> 60ada13c7de88f8a2cc6ce95b9019aa9b3599c64
//     @PreDestroy
//     public void stopRedis() {
//         if (redisServer != null) {
//             redisServer.stop();
//         }
//     }
// }
