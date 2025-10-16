package az.cybernet.managingtraveltours.service.concrete;

import az.cybernet.managingtraveltours.dao.repository.GuideRepository;
import az.cybernet.managingtraveltours.dao.repository.PassportRepository;
import az.cybernet.managingtraveltours.mapper.PassportMapper;
import az.cybernet.managingtraveltours.model.request.PassportRequest;
import az.cybernet.managingtraveltours.service.abstraction.PassportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PassportServiceHandler implements PassportService {
    private final PassportRepository passportRepository;
    private final GuideRepository guideRepository;

    @Override
    public void savePassport(PassportRequest request) {
        log.info("ActionLog.savePassport.start");

        var guideEntity = guideRepository.findById(request.getGuideId())
                .orElseThrow(() -> new RuntimeException("Guide not found with id: " + request.getGuideId()));
        passportRepository.save(PassportMapper.PASSPORT_MAPPER.buildEntity(request, guideEntity));

        log.info("ActionLog.savePassport.end");
    }
}
