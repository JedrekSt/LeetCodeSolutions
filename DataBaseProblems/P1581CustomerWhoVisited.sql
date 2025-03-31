SELECT V.customer_id, Count(V.visit_id) as "count_no_trans" FROM 
Visits V LEFT OUTER JOIN Transactions T 
ON V.visit_id = T.visit_id
WHERE T.transaction_id IS NULL
GROUP BY V.customer_id 
ORDER BY V.customer_id ASC