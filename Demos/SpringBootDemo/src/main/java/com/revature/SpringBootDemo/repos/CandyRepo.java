package com.revature.SpringBootDemo.repos;

import com.revature.SpringBootDemo.models.Candy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CandyRepo extends JpaRepository<Candy,Integer> {

    @Query(value = "UPDATE candies SET c_name=?1, c_price=?2 WHERE c_id=?3", nativeQuery = true)
    public boolean update(String name, double price, int id);

    @Query(value = "SELECT * FROM candies WHERE c_id=?1", nativeQuery = true)
     public Candy findById(int id);

}
