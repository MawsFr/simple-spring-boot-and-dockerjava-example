package com.mawsfr;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.async.ResultCallback;
import com.github.dockerjava.api.command.LogContainerCmd;
import com.github.dockerjava.api.model.Frame;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.PullResponseItem;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import com.github.dockerjava.transport.DockerHttpClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Closeable;
import java.io.IOException;
import java.time.Duration;

@RestController
@RequestMapping("/docker")
public class DockerController {

    @GetMapping("/create-sync")
    public String hello() {
        // Create docker java client configuration
        DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder().build();

        // Create docker http client
        try (DockerHttpClient httpClient = new ApacheDockerHttpClient.Builder()
                .dockerHost(config.getDockerHost())
                .sslConfig(config.getSSLConfig())
                .maxConnections(100)
                .connectionTimeout(Duration.ofSeconds(30))
                .responseTimeout(Duration.ofSeconds(45))
                .build()) {

            // Create a container
            DockerClient client = DockerClientImpl.getInstance(config, httpClient);

            HostConfig hostConfig = HostConfig.newHostConfig().withMemory(512 * 1024 * 1024L);

            // Pull image if not present
            client.pullImageCmd("busybox:latest").exec(new ResultCallback.Adapter<>() {

                @Override
                public void onStart(Closeable stream) {
                    super.onStart(stream);
                    System.out.println("Image pull started");
                }

                @Override
                public void onError(Throwable throwable) {
                    super.onError(throwable);
                    System.out.println("Error while pulling image");
                }

                @Override
                public void onNext(PullResponseItem object) {
                    super.onNext(object);
                    System.out.println("Image pull status: " + object.getStatus());
                }

                @Override
                public void onComplete() {
                    super.onComplete();
                    System.out.println("Image pulled");
                }
            }).awaitCompletion();

            client.createContainerCmd("busybox:latest")
                    .withHostConfig(hostConfig)
                    .withName("my-container-from-spring")
                    // log 1 to 5 in stdout every second
                    .withCmd("sh", "-c", "for i in $(seq 1 5); do echo $i; sleep 1; done")
                    .exec();

            // Start the container
            client.startContainerCmd("my-container-from-spring").exec();

            // Stream logs
            LogContainerCmd logContainerCmd = client.logContainerCmd("my-container-from-spring")
                    .withStdOut(true)
                    .withStdErr(true)
                    .withFollowStream(true)
                    .withTailAll();

            logContainerCmd.exec(new ResultCallback.Adapter<>() {

                @Override
                public void onComplete() {
                    super.onComplete();
                    System.out.println("Container logs printed");
                }

                @Override
                public void onError(Throwable throwable) {
                    super.onError(throwable);
                    System.out.println("Error while printing container logs");
                }

                @Override
                public void onStart(Closeable stream) {
                    super.onStart(stream);
                    System.out.println("Container logs started printing");
                }

                @Override
                public void onNext(Frame object) {
                    super.onNext(object);
                    System.out.println(new String(object.getPayload()));
                }
            }).awaitCompletion(); // awaits for ALL the logs to be printed

            // Remove the container when ALL logs are finished to be printed
            client.removeContainerCmd("my-container-from-spring").exec();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Docker container launched";
    }
}
