package kr.ac.kgu.kpserver.domain.activity;

import kr.ac.kgu.kpserver.domain.mbti.MBTI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityMBTIRepository extends JpaRepository<ActivityMBTI, Long> {

    List<ActivityMBTI> findByMbti(MBTI mbti);
}
