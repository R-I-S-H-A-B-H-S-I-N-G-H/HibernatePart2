package com.example.HibernatePart2.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.HibernatePart2.entities.Student;

public interface StudentRepo extends CrudRepository<Student, Long> {
    @Query("from Student")
    List<Student> findAllStudents(Pageable pageable);

    @Query("select st.firstname,st.lastname from Student st")
    List<Object[]> findAllStudentPartial();

    @Query("from Student where firstname=:firstname")
    List<Student> findAllStudentByfirstname(@Param("firstname") String firstname);

    @Query("from Student where score> :min and score< :max")
    List<Student> findStudentForGivenScore(@Param("min") int min, @Param("max") int max);

    @Modifying
    @Query("delete from Student where firstname=:firstname")
    void deleteStudentbyfirstname(@Param("firstname") String firstname);

    // USING JPQL
    @Query(value = "select * from student", nativeQuery = true)
    List<Student> findAllStudents();

    @Query(value = "select * from student where fname = :firstname", nativeQuery = true)
    List<Student> findAllStudentByfirstnameQ(@Param("firstname") String firstname);

}
