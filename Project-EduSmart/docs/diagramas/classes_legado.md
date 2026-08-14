# Visão parcial do legado

```mermaid
classDiagram
 class EduSmartService
 class Student
 class Teacher
 class Course
 class ClassGroup
 class Assessment
 class Grade
 class AcademicLegacyApi
 EduSmartService --> Student
 EduSmartService --> ClassGroup
 EduSmartService --> Assessment
 EduSmartService --> Grade
 EduSmartService --> AcademicLegacyApi
```
