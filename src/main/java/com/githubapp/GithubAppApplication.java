package com.githubapp;

import feign.FeignException;
import feign.RetryableException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RequiredArgsConstructor
@EnableFeignClients
@Log4j2
public class GithubAppApplication {

    private final GithubProxy proxy;

    public static void main(String[] args) {
        SpringApplication.run(GithubAppApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void run() {
        try {

//            List<RepositoryResponse> list = proxy.getRepositories("Mikel99M");
//            List<RepositoryResponse> list = proxy.getRepositories("kalqa");
//            list.forEach(System.out::println);


//            List<Branch> list2 = proxy.getBranches("Mikel99M", "resttemplatewithspring6");
//            System.out.println();
//            list2.forEach(System.out::println);

//            System.out.println(proxy.getUserByUserName("Mikeasdasdl99M"));
            ;

        } catch (FeignException.FeignClientException e) {
            log.error("Client exception: " + e.getMessage());
        } catch (FeignException.FeignServerException e) {
            log.error("Server exception: " + e.getMessage());
        } catch (RetryableException e) {
            log.error("Retryable exception: " + e.getMessage());
        } catch (FeignException e) {
            log.error("Some other Feign exception: " + e.getMessage());
        }
    }
}