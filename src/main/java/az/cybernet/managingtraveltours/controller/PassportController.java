package az.cybernet.managingtraveltours.controller;

import az.cybernet.managingtraveltours.model.request.PassportRequest;
import az.cybernet.managingtraveltours.service.abstraction.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/passports")
public class PassportController {
    private final PassportService passportService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void addPassport(@RequestBody PassportRequest request) {
        passportService.savePassport(request);
    }
}
