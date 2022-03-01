select convert(decimal(7,4),lat_n) from 
    (select lat_n, row_number() over(order by lat_n desc) as rnum from station) as t 
    where rnum =
    (select case when max(rnum1)%2 = 0 then max(rnum1)/2
                else max(rnum1)/2+1 end
     from
    (select row_number() over(order by lat_n desc) as rnum1 from station) as t1)