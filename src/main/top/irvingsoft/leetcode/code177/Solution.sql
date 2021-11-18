CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    SET N = N - 1;
    RETURN (
        # Write your MySQL query statement below.
        select (select distinct Salary from Employee order by Salary desc limit N, 1) as SecondHighestSalary
    );
END
# distinct 对 Salary 去重
# limit 取去重后的第二个
# 加一层 select 用于对空值返回 null