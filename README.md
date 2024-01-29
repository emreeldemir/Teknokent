### Description:

- The purpose of this application is to ensure that students have information about the career programs of companies in Teknokent. For example, to announce TAI's Sky Experience internship program to students. With this app, students can follow the companies they are interested in and plan to do an internship. Also can be informed when their internship programs start. In addition, environments such as incubation centers offered by universities offer students the opportunity to realize their entrepreneurial ideas. In this way, students can also establish their own companies in Teknokent.

### Which Design Patterns Did We Use?
- **Observer**: In our application, students can follow and unfollow companies. Notification that career programs (bootcamps, jobs) have started will be sent to students. The most suitable pattern to implement this design in the most effective way without any changes in the code is the observer pattern.


- **Decorator**: We used this pattern for notifications. For now, we will use SMS, LinkedIn and E-mail in the notification system of our application. However, since we think that there will be new communication environments that may develop in the future, we decided to use the decorator pattern to prevent this change from causing any changes in our code. In this way, new platforms can be easily added to our application.

- **Singleton**: We want there to be a single application example throughout the Teknokent application in order to ensure that all transactions and situations in the system can be shared within the same application. So we aim for all students and companies to work on the same application.



