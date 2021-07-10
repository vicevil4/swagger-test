package io.vicevil4.swagger.controller;

import io.vicevil4.swagger.dto.HelloRequestDto;
import io.vicevil4.swagger.dto.HelloResultDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private final ModelMapper modelMapper;

    @Autowired
    public HelloController(ModelMapper modelMapper) {

        PropertyMap<HelloRequestDto, HelloResultDto> helloMap = new PropertyMap<HelloRequestDto, HelloResultDto>() {
            protected void configure() {
                map().setReturnMessage(source.getMessage());
            }
        };
        modelMapper.addMappings(helloMap);
        this.modelMapper = modelMapper;
    }

    /**
     * <pre>
     * return echo message
     *
     * - echo '{"message": "blah blah"}' | http POST http://localhost:8080/hello/echo
     * </pre>
     *
     * @param param
     * @return
     */
    @PostMapping(path = "/echo")
    public ResponseEntity hello(@RequestBody HelloRequestDto param) {

        HelloResultDto result = modelMapper.map(param, HelloResultDto.class);
        result.setServerTime(new Date().toString());
        return ResponseEntity.ok(result);
    }
}
