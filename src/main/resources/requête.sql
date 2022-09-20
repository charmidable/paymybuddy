use paymybuddy;

select c.name, a.name
from client c, role r, authority a
where c.id = r.client
and r.authority = a.id;
