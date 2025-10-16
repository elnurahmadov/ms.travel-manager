package az.cybernet.managingtraveltours.service.concrete;

import az.cybernet.managingtraveltours.dao.repository.GuideRepository;
import az.cybernet.managingtraveltours.model.request.GuideRequest;
import az.cybernet.managingtraveltours.service.abstraction.GuideService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static az.cybernet.managingtraveltours.mapper.GuideMapper.GUIDE_MAPPER;

@Service
@RequiredArgsConstructor
@Slf4j
public class GuideServiceHandler implements GuideService {
    private final GuideRepository guideRepository;

    @Override
    public void addGuide(GuideRequest request) {
        guideRepository.save(GUIDE_MAPPER.buildEntity(request));
    }
}
