package com.revature.SpringBootDemo.repos;

import com.revature.SpringBootDemo.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ShopRepo extends JpaRepository<Shop,Integer> {
    /**
     * The Spring Data module takes this simplification one step
     * further by providing standard implementation for common DAO methods
     * allowing for the removal of the DAO implementation and only requiring the
     * definition of the DAO interface methods.
     *
     * In order to leverage the Spring Data programming model with JPA,
     * a DAO interface should extend the Spring JpaRepository interface
     * from the org.springframework.data.jpa.repository package.
     *
     */

    /*
    Extending the CrudRepository should implement the following CRUD operations for us:
    save()
    saveAll()
    findById()
    existsById()
    findAll()
    findAllById()
    count()
    deleteById()
    delete()
    deleteAll()
     */

    // when we are using the Query annotation you have to add the wildcard (?) with param numbers
    //that indicated the index of the values
    //example of an update method using @Query

    @Query(value="UPDATE shops SET s_name=?1, s_inven_count=?2, WHERE s_id=?3", nativeQuery = true)
    public boolean update(String name, int invCount, int id);

}
