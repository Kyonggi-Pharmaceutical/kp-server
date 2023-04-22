package kr.ac.kgu.kpserver.domain.activity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    public List<Activity> allActivityView() {return activityRepository.findAll();}


}
