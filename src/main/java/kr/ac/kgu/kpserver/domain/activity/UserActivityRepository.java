package kr.ac.kgu.kpserver.domain.activity;

import kr.ac.kgu.kpserver.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActivityRepository extends JpaRepository<UserActivity, Long> {
    public void deleteByUser(User user);
}
