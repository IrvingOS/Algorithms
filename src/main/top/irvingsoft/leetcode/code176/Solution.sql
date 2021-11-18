select (select distinct Salary from Employee order by Salary desc limit 1, 1) as SecondHighestSalary;
# distinct 对 Salary 去重
# limit 取去重后的第二个
# 加一层 select 用于对空值返回 null 