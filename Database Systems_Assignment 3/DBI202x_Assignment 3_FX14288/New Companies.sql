-- print the company_code, founder name, total number of lead managers, total number of senior managers, total number of managers, and total number of employees. Order your output by ascending company_code.

select C.company_code, founder, count(distinct L.lead_manager_code), count(distinct S.senior_manager_code), count (distinct M.manager_code), count (distinct E.employee_code)
from Company C, Lead_Manager L, Senior_Manager S, Manager M, Employee E
where C.company_code = L.company_code
and L.company_code = S.company_code
and S.senior_manager_code = M.senior_manager_code
and M.manager_code = E.manager_code
group by C.company_code, founder
order by C.Company_code