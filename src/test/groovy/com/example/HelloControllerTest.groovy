package com.example

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

/**
 *
 * @author Paolo Di Tommaso <paolo.ditommaso@gmail.com>
 */
@MicronautTest
class HelloControllerTest extends Specification {

    @Client("/")
    @Inject
    HttpClient client;

    void 'should handle foo get'(){
        when:
        HttpRequest<?> request = HttpRequest.GET("/foo")

        HttpResponse<String> response = client.toBlocking().exchange(request, String);
        then:
        response.status() == HttpStatus.OK
        response.body() == 'foo'
        response.contentLength == 3
        response.contentType.get() == MediaType.TEXT_PLAIN_TYPE
    }

    void 'should handle foo head length'(){
        when:
        HttpRequest<?> request = HttpRequest.HEAD("/foo")

        HttpResponse<String> response = client.toBlocking().exchange(request, String);
        then:
        response.status() == HttpStatus.OK
        response.contentLength == 3
    }

    void 'should handle foo head type'(){
        when:
        HttpRequest<?> request = HttpRequest.HEAD("/foo")

        HttpResponse<String> response = client.toBlocking().exchange(request, String);
        then:
        response.status() == HttpStatus.OK
        response.contentType.get() == MediaType.TEXT_PLAIN_TYPE
    }

    void 'should handle bar head length'(){
        when:
        HttpRequest<?> request = HttpRequest.HEAD("/bar")

        HttpResponse<String> response = client.toBlocking().exchange(request, String);
        then:
        response.status() == HttpStatus.OK
        response.contentLength == 10
    }

    void 'should handle bar head type'(){
        when:
        HttpRequest<?> request = HttpRequest.HEAD("/bar")

        HttpResponse<String> response = client.toBlocking().exchange(request, String);
        then:
        response.status() == HttpStatus.OK
        response.contentType.get() == MediaType.TEXT_PLAIN_TYPE
    }

}
