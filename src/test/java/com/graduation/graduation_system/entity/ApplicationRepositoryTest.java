package com.graduation.graduation_system.entity;

import com.graduation.graduation_system.data.entity.Application;
import com.graduation.graduation_system.data.entity.Student;
import com.graduation.graduation_system.data.entity.Teacher;
import com.graduation.graduation_system.data.entity.enums.ApplicationStatus;
import com.graduation.graduation_system.data.entity.enums.Position;
import com.graduation.graduation_system.data.repository.ApplicationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class ApplicationRepositoryTest {
    private ApplicationRepository applicationRepository;

    private TestEntityManager testEntityManager;

    private Application application;

    private Student student;

    private Teacher teacher;

    @BeforeEach
    public void setup() {
        student = new Student();
        student.setFirstName("Georgi");
        student.setLastName("Georgiev");
        student.setFNumber("F00000");

        teacher = new Teacher();
        teacher.setFirstName("Hristina");
        teacher.setLastName("Kostadinova");
        teacher.setPosition(Position.CHIEF_ASSISTANT);


        application = new Application();
        application.setTheme("TYhememem hehe");
        application.setPurpose("Puirpose purpose");
        application.setTasks("tasktaskatsG");
        application.setTechnologies("gsfsfsfsfs");
        application.setStudent(student);
        application.setTeacher(teacher);
        application.setStatus(ApplicationStatus.NOT_APPROVED);
    }

    @Test
    void getApplicationByIdTest() {
        // Given
        testEntityManager.persistAndFlush(application);

        // When
        Optional<Application> applicationById = applicationRepository.findById(application.getId());

        // Then
        assertTrue(applicationById.isPresent());
    }

    @Test
    void saveApplicationDocumentTest() {
        // Given
        Application application = new Application();
        application.setTheme("Exploring the oceans");
        application.setPurpose("Find new oceans");
        application.setStudent(student);
        application.setTeacher(teacher);

        // When
        Application savedApplication = applicationRepository.save(application);

        // Then
        assertThat(savedApplication).isNotNull();
    }


    @Test
    void updateApplicationDocumentNameTest() {
        // Given
        testEntityManager.persistAndFlush(application);

        // When
        application.setTheme("Newly updated theme");
        applicationRepository.save(application);

        // Then
        assertThat(application.getTheme()).isEqualTo("Newly updated theme");
    }

    @Test
    void deleteApplicationDocumentTest() {
        // Given
        testEntityManager.persistAndFlush(application);

        // When
        applicationRepository.deleteById(application.getId());
        Optional<Application> deletedApplication = applicationRepository.findById(application.getId());

        // Then
        assertTrue(deletedApplication.isEmpty());
    }
}
