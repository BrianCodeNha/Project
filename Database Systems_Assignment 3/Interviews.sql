NOTE: KHI BẢNG DỮ LIỆU CÓ NHIỀU THÔNG SỐ TRÊN CÙNG 1 ID NÊN DÙNG SUBQUERY ĐỂ LÀM GỌN LẠI SAU ĐÓ THAO TÁC VỚI CÁC BẢNG KHÁC.

SELECT C.contest_id, 
       C.hacker_id, name, 
       sum(total_submissions) AS total_submissions, 
       SUM(total_accepted_submissions) AS total_accepted_submissions, 
       SUM(total_views) AS total_views , 
       SUM(total_unique_views) AS total_unique_views
FROM Contests C 
JOIN Colleges CL ON C.contest_id = CL.contest_id
JOIN Challenges CH ON CL.college_id = CH.college_id
-- DUNG SUB QUERY gan vao bang challenge DE CONG DE TRANH VIEC bi DU LIEU NHAN LEN VA bi TRUNG LAP
LEFT JOIN (
    SELECT challenge_id, SUM(total_views) AS total_views,  SUM(total_unique_views) AS total_unique_views
    FROM View_Stats group by challenge_id
) V ON CH.challenge_id = V.challenge_id
-- DUNG SUB QUERY gan vao bang challenge(*****NEU GAN VA VIEW SE SAI DU LIEU****) DE CONG DE TRANH VIEC bi DU LIEU NHAN LEN VA bi TRUNG LAP
LEFT JOIN ( 
    SELECT challenge_id, sum(total_submissions) AS total_submissions, SUM(total_accepted_submissions) AS total_accepted_submissions
    FROM Submission_Stats group by challenge_id
) S ON CH.challenge_id = S.challenge_id
GROUP BY C.contest_id, C.hacker_id, C.name
order by C.contest_id

TOTAL 47 ROW

845 579 Rose 1252 392 1635 566
858 1053 Angela 680 153 1002 384
883 1055 Frank 1121 319 1217 338
1793 2655 Patrick 1159 273 1216 412
2374 2765 Lisa 2709 792 3368 904
2963 2845 Kimberly 3334 986 3603 1184
3584 2873 Bonnie 2068 506 3019 954
4044 3067 Michael 1058 374 1722 528
4249 3116 Todd 1136 306 1767 463
4269 3256 Joe 1018 372 1766 530
4483 3386 Earl 1487 416 1644 477
4541 3608 Robert 1639 459 1694 504
4601 3868 Amy 1900 639 1738 548
4710 4255 Pamela 1930 496 2378 705
4982 5639 Maria 2366 669 2558 711
5913 5669 Joe 2397 676 3181 835
5994 5713 Linda 2531 736 3048 954
6939 6550 Melissa 2751 835 3574 1004
7266 6947 Carol 2662 648 3044 835
7280 7030 Paula 1303 379 886 259
7484 7033 Marilyn 2860 812 3795 1061
7734 7386 Jennifer 3633 957 3637 1099
7831 7787 Harry 3110 877 2933 1012
7862 8029 David 1375 382 1475 472
8812 8147 Julia 1044 302 819 266
8825 8438 Kevin 2286 683 2187 689
9136 8727 Paul 3318 1102 3125 954
9613 8762 James 3190 859 3620 1046
10568 8802 Kelly 1436 462 2577 798
11100 8809 Robin 1610 488 1883 619
12742 9203 Ralph 1523 413 1344 383
12861 9644 Gloria 1474 475 2089 623
12865 10108 Victor 1091 340 1259 418
13503 10803 David 537 167 584 167
13537 11390 Joyce 1296 481 1784 538
13612 12592 Donna 1641 444 1487 465
14502 12923 Michelle 1172 381 1830 545
14867 13017 Stephanie 1940 552 2291 574
15164 13256 Gerald 2016 671 2085 607
15804 13421 Walter 1454 459 1396 476
15891 13569 Christina 1746 587 2266 786
16063 14287 Brandon 1530 483 1621 521
16415 14311 Elizabeth 4078 1226 3631 1071
18477 14440 Joseph 1061 303 1419 428
18855 16973 Lawrence 2652 894 3371 1011
19097 17123 Marilyn 2878 794 2554 750
19575 17562 Lori 2239 696 2627 760


select con.contest_id,
        con.hacker_id, 
        con.name, 
        sum(total_submissions), 
        sum(total_accepted_submissions), 
        sum(total_views), sum(total_unique_views)
from contests con 
join colleges col on con.contest_id = col.contest_id 
join challenges cha on  col.college_id = cha.college_id 
left join (
	select challenge_id, sum(total_views) as total_views, sum(total_unique_views) as total_unique_views
	from view_stats group by challenge_id
) vs on cha.challenge_id = vs.challenge_id 

left join (
	select challenge_id, sum(total_submissions) as total_submissions, sum(total_accepted_submissions) as total_accepted_submissions 
	from submission_stats group by challenge_id
) ss on cha.challenge_id = ss.challenge_id
    group by con.contest_id, con.hacker_id, con.name
        having sum(total_submissions)!=0 or 
                sum(total_accepted_submissions)!=0 or
                sum(total_views)!=0 or
                sum(total_unique_views)!=0
            order by contest_id;

845 579 Rose 1987 580 1635 566
858 1053 Angela 703 160 1002 384
883 1055 Frank 1121 319 1217 338
1793 2655 Patrick 1337 360 1216 412
2374 2765 Lisa 2733 815 3368 904
2963 2845 Kimberly 4306 1221 3603 1184
3584 2873 Bonnie 2492 652 3019 954
4044 3067 Michael 1323 449 1722 528
4249 3116 Todd 1452 376 1767 463
4269 3256 Joe 1018 372 1766 530
4483 3386 Earl 1911 572 1644 477
4541 3608 Robert 1886 516 1694 504
4601 3868 Amy 1900 639 1738 548
4710 4255 Pamela 2752 639 2378 705
4982 5639 Maria 2705 759 2558 711
5913 5669 Joe 2646 790 3181 835
5994 5713 Linda 3369 967 3048 954
6939 6550 Melissa 2842 859 3574 1004
7266 6947 Carol 2758 665 3044 835
7280 7030 Paula 1963 554 886 259
7484 7033 Marilyn 3217 934 3795 1061
7734 7386 Jennifer 3780 1015 3637 1099
7831 7787 Harry 3190 883 2933 1012
7862 8029 David 1738 476 1475 472
8812 8147 Julia 1044 302 819 266
8825 8438 Kevin 2624 772 2187 689
9136 8727 Paul 4205 1359 3125 954
9613 8762 James 3438 943 3620 1046
10568 8802 Kelly 1907 620 2577 798
11100 8809 Robin 1929 613 1883 619
12742 9203 Ralph 1523 413 1344 383
12861 9644 Gloria 1596 536 2089 623
12865 10108 Victor 2076 597 1259 418
13503 10803 David 924 251 584 167
13537 11390 Joyce 1381 497 1784 538
13612 12592 Donna 1981 550 1487 465
14502 12923 Michelle 1510 463 1830 545
14867 13017 Stephanie 2471 676 2291 574
15164 13256 Gerald 2570 820 2085 607
15804 13421 Walter 1454 459 1396 476
15891 13569 Christina 2188 710 2266 786
16063 14287 Brandon 1804 580 1621 521
16415 14311 Elizabeth 4535 1366 3631 1071
18477 14440 Joseph 1320 391 1419 428
18855 16973 Lawrence 2967 1020 3371 1011
19097 17123 Marilyn 2956 807 2554 750
19575 17562 Lori 2590 863 2627 760