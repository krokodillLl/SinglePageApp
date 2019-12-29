package com.krokofillLl.singlePageApp.repos;

import com.krokofillLl.singlePageApp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
}
