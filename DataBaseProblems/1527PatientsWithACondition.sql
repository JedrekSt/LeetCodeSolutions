/* Write your T-SQL query statement below */
SELECT patient_id, patient_name , conditions FROM Patients WHERE
LEFT(conditions,5) = 'DIAB1' OR PATINDEX('% DIAB1%', conditions) != 0