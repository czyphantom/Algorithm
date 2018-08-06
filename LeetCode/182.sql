/**
* 编写一个 SQL 查询，查找 Person 表中所有重复的电子邮箱。
*/

SELECT Email FROM Person GROUP BY EMAIL HAVING COUNT(EMAIL) > 1