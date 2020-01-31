package com.satendra.springLearn.SpringBot.Learnigs.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostReposotory extends JpaRepository<Post,Integer> {


}
