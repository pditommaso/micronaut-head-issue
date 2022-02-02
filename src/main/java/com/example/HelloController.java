package com.example;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Head;

/**
 * @author Paolo Di Tommaso <paolo.ditommaso@gmail.com>
 */
@Controller
public class HelloController {

    @Get(value = "/foo", produces = MediaType.TEXT_PLAIN)
    public String hello(){
        return "foo";
    }

    @Head(value = "/bar")
    public HttpResponse<Void> world(){
        return HttpResponse.
                <Void>ok()
                .contentType("text/plain")
                .contentLength(10);
    }
}
