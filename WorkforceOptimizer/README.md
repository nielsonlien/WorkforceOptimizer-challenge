Tools and technologies used:
1. Hibernate 5.4.18
2. logback-classic 1.2.3
3. Oracle database
4. Maven 4.0.0
5. Eclipse 4.14.0

Table relationship:
- There are three tables; shift, shift_group, shift_grouping
- shift.code is linked to shift_grouping.shift_code and shift_group.code is linked to shift_grouping.shift_group_code
- shift.code and shift_group.code are unique
- shift_grouping.shift_code consists of many shift.code
- shift_grouping.shift_group_code consists of many shift_group.code

Program background:
This program is used to check if the shift code belongs to the shift group. When run the program, you will be asked to input through console Scanner. The output of the program will be displayed in the application log (/logs/app.log).

Features:
-Logs are separated between application log (app.log) and database log (hibernate.log)
-Any exception will be stored in application log