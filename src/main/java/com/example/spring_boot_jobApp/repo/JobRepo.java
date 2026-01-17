package com.example.spring_boot_jobApp.repo;

import com.example.spring_boot_jobApp.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);


//    List<JobPost> jobs = new ArrayList<>(List.of(
//            new JobPost(1,
//                    "Java Developer",
//                    "Develop and maintain enterprise-level applications using Spring Boot and Hibernate.",
//                    "2-4 years",
//                    List.of("Java", "Spring Boot", "Hibernate", "MySQL", "REST API")),
//
//            new JobPost(2,
//                    "Frontend Engineer",
//                    "Build responsive and dynamic web interfaces with React and TypeScript.",
//                    "1-3 years",
//                    List.of("JavaScript", "React", "TypeScript", "HTML", "CSS")),
//
//            new JobPost(3,
//                    "Data Scientist",
//                    "Analyze data, build predictive models, and present insights to stakeholders.",
//                    "3-5 years",
//                    List.of("Python", "TensorFlow", "Pandas", "NumPy", "Scikit-learn")),
//
//            new JobPost(4,
//                    "DevOps Engineer",
//                    "Implement CI/CD pipelines and manage cloud infrastructure using AWS.",
//                    "4-6 years",
//                    List.of("AWS", "Docker", "Kubernetes", "Jenkins", "Terraform")),
//
//            new JobPost(5,
//                    "Mobile App Developer",
//                    "Design and develop Android and iOS applications using Flutter.",
//                    "2-5 years",
//                    List.of("Dart", "Flutter", "Firebase", "REST API", "Git"))
//    ));
}
