package demo;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@Api(value = "demo", tags = "demo")
@RestController
public class Controller {

    @ApiOperation(value = "hello", tags = "hello", response = String.class)
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @ApiOperation(value = "hello2", tags = "hello")
    @PostMapping("/hello2")
    public String hello2(@ApiParam(name = "hah",value = "haha") String a ) {
        return "Hello World!";
    }

    @ApiOperation(value = "hello3", tags = "hello2", response = String.class)
    @DeleteMapping("/hello3")
    public String hello3() {
        return "Hello World!";
    }

    @ApiOperation(value = "hello4", tags = "hello2")
    @ApiResponse(response = Integer.class, code = 2010, message = "haha")
    @PutMapping("/hello4")
    public int hello4() {
        return 1;
    }


}
