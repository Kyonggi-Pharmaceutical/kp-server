package kr.ac.kgu.kpserver.domain.activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityMBTIRepository extends JpaRepository<ActivityMBTI, Long> {
}
