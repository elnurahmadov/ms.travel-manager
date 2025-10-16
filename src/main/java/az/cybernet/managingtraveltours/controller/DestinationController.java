package az.cybernet.managingtraveltours.controller;

import az.cybernet.managingtraveltours.model.request.DestinationRequest;
import az.cybernet.managingtraveltours.service.abstraction.DestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/destinations")
public class DestinationController {
    private final DestinationService destinationService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void addTour(@RequestBody DestinationRequest request) {
        destinationService.addDestination(request);
    }
}
