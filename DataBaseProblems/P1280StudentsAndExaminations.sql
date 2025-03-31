SELECT St.student_id, St.student_name, Sb.subject_name, 
SUM(CASE WHEN Sb.subject_name = Ex.subject_name THEN 1 ELSE 0 END) as "attended_exams"
FROM
Students St CROSS JOIN Subjects Sb LEFT OUTER JOIN Examinations Ex
ON St.student_id = Ex.student_id
GROUP BY St.student_id, St.student_name, Sb.subject_name