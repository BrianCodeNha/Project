;WITH CTE_Projects AS 
(
  SELECT Start_Date, End_Date, ROW_NUMBER() OVER (ORDER BY Start_Date) AS RowNumber
  FROM Projects 
)
SELECT MIN(Start_Date), MAX(End_Date) 
FROM CTE_Projects 
GROUP BY DATEDIFF(DAY, RowNumber, Start_Date) -- ID CHO TỪNG PROJECT VÌ THỜI GIAN LIÊN TỤC NHAU
ORDER BY DATEDIFF(DAY, MIN(Start_Date), MAX(End_Date)), MIN(Start_Date)