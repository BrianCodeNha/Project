with data as (
select H.hacker_id, name, sum(S.maxscore) as totalScore
from Hackers H, (select hacker_id, max(score) as maxscore from Submissions group by hacker_id, challenge_id) S
where S.hacker_id = H.hacker_id
group by H.hacker_id, name
)
select * from data
where totalScore <> 0
order by totalScore desc, hacker_id