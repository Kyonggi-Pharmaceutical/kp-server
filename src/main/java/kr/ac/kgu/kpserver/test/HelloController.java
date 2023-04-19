package kr.ac.kgu.kpserver.test;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "테스트 API")
@RestController
@RequestMapping("/test")
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Operation(summary = "핑 API")
    @GetMapping("/ping")
    public String ping() {
        log.info("### ping");
        return "pong";
    }
}
