with data as 
(
select hackers.hacker_id, name, count(challenge_id) as counter
from challenges, hackers
where challenges.hacker_id = hackers.hacker_id
group by hackers.hacker_id, name
)
select * from data
where counter = (select max(counter) from data)
or counter in (select counter from data group by counter having count(counter) = 1 )
order by counter desc, hacker_id