select person.FirstName, person.LastName, address.City, address.State
from Person person
         left join Address address
                   on person.PersonId = address.PersonId;
#
where 只查询公共部分
# left join 查询左表全部并把右表存在的对应数据填充进结果集