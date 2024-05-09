# Simple Spring boot + dockerjava example

## Pre-requisites

- Java 11 or higher
- Maven 3.6.3 or higher
- Docker installed and running
- Be logged in to a docker registry (docker hub or private registry)

Also for testing purposes, I used the following instruction :

```java
DockerClientConfig custom = DefaultDockerClientConfig.createDefaultConfigBuilder().build();
```

which uses default settings of my computer but in production you would have to configure the client with the following
to be able to connect to a remote docker daemon AND download images from a private registry (or docker hub) :

```java
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.DefaultDockerClientConfig;

DockerClientConfig custom = DefaultDockerClientConfig.createDefaultConfigBuilder()
        .withDockerHost("tcp://docker.somewhere.tld:2376")
        .withDockerTlsVerify(true)
        .withDockerCertPath("/home/user/.docker")
        .withRegistryUsername(registryUser)
        .withRegistryPassword(registryPass)
        .withRegistryEmail(registryMail)
        .withRegistryUrl(registryUrl)
        .build();
```

For more details, please refer to
the [docker-java documentation](https://github.com/docker-java/docker-java/blob/main/docs/getting_started.md)

## How to use

Run the spring boot application with the following command:

```bash
mvn spring-boot:run
```

Then go to [http://localhost:8080/docker/create-sync](http://localhost:8080/docker/create-sync)

## Output example

```bash
C:\Users\maws\.jdks\openjdk-22\bin\java.exe -XX:TieredStopAtLevel=1 -Dspring.output.ansi.enabled=always -Dcom.sun.management.jmxremote -Dspring.jmx.enabled=true -Dspring.liveBeansView.mbeanDomain -Dspring.application.admin.enabled=true "-Dmanagement.endpoints.jmx.exposure.include=*" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2023.2\lib\idea_rt.jar=60155:C:\Program Files\JetBrains\IntelliJ IDEA 2023.2\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath D:\maws\git\docker-launcher\target\classes;C:\Users\maws\.m2\repository\org\springframework\boot\spring-boot-starter-web\3.2.5\spring-boot-starter-web-3.2.5.jar;C:\Users\maws\.m2\repository\org\springframework\boot\spring-boot-starter\3.2.5\spring-boot-starter-3.2.5.jar;C:\Users\maws\.m2\repository\org\springframework\boot\spring-boot\3.2.5\spring-boot-3.2.5.jar;C:\Users\maws\.m2\repository\org\springframework\boot\spring-boot-autoconfigure\3.2.5\spring-boot-autoconfigure-3.2.5.jar;C:\Users\maws\.m2\repository\org\springframework\boot\spring-boot-starter-logging\3.2.5\spring-boot-starter-logging-3.2.5.jar;C:\Users\maws\.m2\repository\ch\qos\logback\logback-classic\1.4.14\logback-classic-1.4.14.jar;C:\Users\maws\.m2\repository\ch\qos\logback\logback-core\1.4.14\logback-core-1.4.14.jar;C:\Users\maws\.m2\repository\org\apache\logging\log4j\log4j-to-slf4j\2.21.1\log4j-to-slf4j-2.21.1.jar;C:\Users\maws\.m2\repository\org\apache\logging\log4j\log4j-api\2.21.1\log4j-api-2.21.1.jar;C:\Users\maws\.m2\repository\org\slf4j\jul-to-slf4j\2.0.13\jul-to-slf4j-2.0.13.jar;C:\Users\maws\.m2\repository\jakarta\annotation\jakarta.annotation-api\2.1.1\jakarta.annotation-api-2.1.1.jar;C:\Users\maws\.m2\repository\org\yaml\snakeyaml\2.2\snakeyaml-2.2.jar;C:\Users\maws\.m2\repository\org\springframework\boot\spring-boot-starter-json\3.2.5\spring-boot-starter-json-3.2.5.jar;C:\Users\maws\.m2\repository\com\fasterxml\jackson\datatype\jackson-datatype-jdk8\2.15.4\jackson-datatype-jdk8-2.15.4.jar;C:\Users\maws\.m2\repository\com\fasterxml\jackson\datatype\jackson-datatype-jsr310\2.15.4\jackson-datatype-jsr310-2.15.4.jar;C:\Users\maws\.m2\repository\com\fasterxml\jackson\module\jackson-module-parameter-names\2.15.4\jackson-module-parameter-names-2.15.4.jar;C:\Users\maws\.m2\repository\org\springframework\boot\spring-boot-starter-tomcat\3.2.5\spring-boot-starter-tomcat-3.2.5.jar;C:\Users\maws\.m2\repository\org\apache\tomcat\embed\tomcat-embed-core\10.1.20\tomcat-embed-core-10.1.20.jar;C:\Users\maws\.m2\repository\org\apache\tomcat\embed\tomcat-embed-el\10.1.20\tomcat-embed-el-10.1.20.jar;C:\Users\maws\.m2\repository\org\apache\tomcat\embed\tomcat-embed-websocket\10.1.20\tomcat-embed-websocket-10.1.20.jar;C:\Users\maws\.m2\repository\org\springframework\spring-web\6.1.6\spring-web-6.1.6.jar;C:\Users\maws\.m2\repository\org\springframework\spring-beans\6.1.6\spring-beans-6.1.6.jar;C:\Users\maws\.m2\repository\io\micrometer\micrometer-observation\1.12.5\micrometer-observation-1.12.5.jar;C:\Users\maws\.m2\repository\io\micrometer\micrometer-commons\1.12.5\micrometer-commons-1.12.5.jar;C:\Users\maws\.m2\repository\org\springframework\spring-webmvc\6.1.6\spring-webmvc-6.1.6.jar;C:\Users\maws\.m2\repository\org\springframework\spring-aop\6.1.6\spring-aop-6.1.6.jar;C:\Users\maws\.m2\repository\org\springframework\spring-context\6.1.6\spring-context-6.1.6.jar;C:\Users\maws\.m2\repository\org\springframework\spring-expression\6.1.6\spring-expression-6.1.6.jar;C:\Users\maws\.m2\repository\org\springframework\boot\spring-boot-starter-webflux\3.2.5\spring-boot-starter-webflux-3.2.5.jar;C:\Users\maws\.m2\repository\org\springframework\boot\spring-boot-starter-reactor-netty\3.2.5\spring-boot-starter-reactor-netty-3.2.5.jar;C:\Users\maws\.m2\repository\io\projectreactor\netty\reactor-netty-http\1.1.18\reactor-netty-http-1.1.18.jar;C:\Users\maws\.m2\repository\io\netty\netty-codec-http\4.1.109.Final\netty-codec-http-4.1.109.Final.jar;C:\Users\maws\.m2\repository\io\netty\netty-common\4.1.109.Final\netty-common-4.1.109.Final.jar;C:\Users\maws\.m2\repository\io\netty\netty-buffer\4.1.109.Final\netty-buffer-4.1.109.Final.jar;C:\Users\maws\.m2\repository\io\netty\netty-transport\4.1.109.Final\netty-transport-4.1.109.Final.jar;C:\Users\maws\.m2\repository\io\netty\netty-codec\4.1.109.Final\netty-codec-4.1.109.Final.jar;C:\Users\maws\.m2\repository\io\netty\netty-handler\4.1.109.Final\netty-handler-4.1.109.Final.jar;C:\Users\maws\.m2\repository\io\netty\netty-codec-http2\4.1.109.Final\netty-codec-http2-4.1.109.Final.jar;C:\Users\maws\.m2\repository\io\netty\netty-resolver-dns\4.1.109.Final\netty-resolver-dns-4.1.109.Final.jar;C:\Users\maws\.m2\repository\io\netty\netty-resolver\4.1.109.Final\netty-resolver-4.1.109.Final.jar;C:\Users\maws\.m2\repository\io\netty\netty-codec-dns\4.1.109.Final\netty-codec-dns-4.1.109.Final.jar;C:\Users\maws\.m2\repository\io\netty\netty-resolver-dns-native-macos\4.1.109.Final\netty-resolver-dns-native-macos-4.1.109.Final-osx-x86_64.jar;C:\Users\maws\.m2\repository\io\netty\netty-resolver-dns-classes-macos\4.1.109.Final\netty-resolver-dns-classes-macos-4.1.109.Final.jar;C:\Users\maws\.m2\repository\io\netty\netty-transport-native-epoll\4.1.109.Final\netty-transport-native-epoll-4.1.109.Final-linux-x86_64.jar;C:\Users\maws\.m2\repository\io\netty\netty-transport-native-unix-common\4.1.109.Final\netty-transport-native-unix-common-4.1.109.Final.jar;C:\Users\maws\.m2\repository\io\netty\netty-transport-classes-epoll\4.1.109.Final\netty-transport-classes-epoll-4.1.109.Final.jar;C:\Users\maws\.m2\repository\io\projectreactor\netty\reactor-netty-core\1.1.18\reactor-netty-core-1.1.18.jar;C:\Users\maws\.m2\repository\io\netty\netty-handler-proxy\4.1.109.Final\netty-handler-proxy-4.1.109.Final.jar;C:\Users\maws\.m2\repository\io\netty\netty-codec-socks\4.1.109.Final\netty-codec-socks-4.1.109.Final.jar;C:\Users\maws\.m2\repository\org\springframework\spring-webflux\6.1.6\spring-webflux-6.1.6.jar;C:\Users\maws\.m2\repository\com\github\docker-java\docker-java-core\3.3.6\docker-java-core-3.3.6.jar;C:\Users\maws\.m2\repository\com\github\docker-java\docker-java-api\3.3.6\docker-java-api-3.3.6.jar;C:\Users\maws\.m2\repository\com\fasterxml\jackson\core\jackson-annotations\2.15.4\jackson-annotations-2.15.4.jar;C:\Users\maws\.m2\repository\com\github\docker-java\docker-java-transport\3.3.6\docker-java-transport-3.3.6.jar;C:\Users\maws\.m2\repository\org\slf4j\slf4j-api\2.0.13\slf4j-api-2.0.13.jar;C:\Users\maws\.m2\repository\commons-io\commons-io\2.13.0\commons-io-2.13.0.jar;C:\Users\maws\.m2\repository\org\apache\commons\commons-compress\1.21\commons-compress-1.21.jar;C:\Users\maws\.m2\repository\org\apache\commons\commons-lang3\3.13.0\commons-lang3-3.13.0.jar;C:\Users\maws\.m2\repository\com\fasterxml\jackson\core\jackson-databind\2.15.4\jackson-databind-2.15.4.jar;C:\Users\maws\.m2\repository\com\fasterxml\jackson\core\jackson-core\2.15.4\jackson-core-2.15.4.jar;C:\Users\maws\.m2\repository\com\google\guava\guava\19.0\guava-19.0.jar;C:\Users\maws\.m2\repository\org\bouncycastle\bcpkix-jdk18on\1.76\bcpkix-jdk18on-1.76.jar;C:\Users\maws\.m2\repository\org\bouncycastle\bcprov-jdk18on\1.76\bcprov-jdk18on-1.76.jar;C:\Users\maws\.m2\repository\org\bouncycastle\bcutil-jdk18on\1.76\bcutil-jdk18on-1.76.jar;C:\Users\maws\.m2\repository\com\github\docker-java\docker-java-transport-httpclient5\3.3.6\docker-java-transport-httpclient5-3.3.6.jar;C:\Users\maws\.m2\repository\org\apache\httpcomponents\client5\httpclient5\5.2.3\httpclient5-5.2.3.jar;C:\Users\maws\.m2\repository\org\apache\httpcomponents\core5\httpcore5\5.2.4\httpcore5-5.2.4.jar;C:\Users\maws\.m2\repository\org\apache\httpcomponents\core5\httpcore5-h2\5.2.4\httpcore5-h2-5.2.4.jar;C:\Users\maws\.m2\repository\net\java\dev\jna\jna\5.13.0\jna-5.13.0.jar;C:\Users\maws\.m2\repository\org\projectlombok\lombok\1.18.32\lombok-1.18.32.jar;C:\Users\maws\.m2\repository\org\springframework\spring-core\6.1.6\spring-core-6.1.6.jar;C:\Users\maws\.m2\repository\org\springframework\spring-jcl\6.1.6\spring-jcl-6.1.6.jar;C:\Users\maws\.m2\repository\io\projectreactor\reactor-core\3.6.5\reactor-core-3.6.5.jar;C:\Users\maws\.m2\repository\org\reactivestreams\reactive-streams\1.0.4\reactive-streams-1.0.4.jar com.mawsfr.DockerLauncherApplication

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.2.5)

2024-05-09T01:59:14.237+02:00  INFO 26812 --- [docker-launcher] [           main] com.mawsfr.DockerLauncherApplication     : Starting DockerLauncherApplication using Java 22 with PID 26812 (D:\maws\git\docker-launcher\target\classes started by maws in D:\maws\git\docker-launcher)
2024-05-09T01:59:14.243+02:00  INFO 26812 --- [docker-launcher] [           main] com.mawsfr.DockerLauncherApplication     : No active profile set, falling back to 1 default profile: "default"
2024-05-09T01:59:15.335+02:00  INFO 26812 --- [docker-launcher] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2024-05-09T01:59:15.356+02:00  INFO 26812 --- [docker-launcher] [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-05-09T01:59:15.357+02:00  INFO 26812 --- [docker-launcher] [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.20]
2024-05-09T01:59:15.416+02:00  INFO 26812 --- [docker-launcher] [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-05-09T01:59:15.416+02:00  INFO 26812 --- [docker-launcher] [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1099 ms
2024-05-09T01:59:15.926+02:00  INFO 26812 --- [docker-launcher] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path ''
2024-05-09T01:59:15.940+02:00  INFO 26812 --- [docker-launcher] [           main] com.mawsfr.DockerLauncherApplication     : Started DockerLauncherApplication in 2.102 seconds (process running for 2.79)
2024-05-09T01:59:27.988+02:00  INFO 26812 --- [docker-launcher] [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2024-05-09T01:59:27.989+02:00  INFO 26812 --- [docker-launcher] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2024-05-09T01:59:27.990+02:00  INFO 26812 --- [docker-launcher] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 0 ms
Image pull started
Image pull status: Pulling from library/busybox
Image pull status: Pulling fs layer
Image pull status: Downloading
Image pull status: Downloading
Image pull status: Downloading
Image pull status: Downloading
Image pull status: Downloading
Image pull status: Downloading
Image pull status: Downloading
Image pull status: Downloading
Image pull status: Verifying Checksum
Image pull status: Download complete
Image pull status: Extracting
Image pull status: Extracting
Image pull status: Extracting
Image pull status: Extracting
Image pull status: Pull complete
Image pull status: Digest: sha256:5eef5ed34e1e1ff0a4ae850395cbf665c4de6b4b83a32a0bc7bcb998e24e7bbb
Image pull status: Status: Downloaded newer image for busybox:latest
Image pulled
Container logs started printing
1

2

3

4

5

Container logs printed

```