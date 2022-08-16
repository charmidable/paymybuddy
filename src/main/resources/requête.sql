use paymybuddy;

select c.name, a.name
from client c, client_authority ca, authority a
where c.id = ca.client
and ca.authority = a.id;
