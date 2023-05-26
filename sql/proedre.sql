
DROP PROCEDURE IF EXISTS sp_sales_borrow_return;

DELIMITER //

CREATE PROCEDURE `sp_sales_borrow_return`(IN start_time DATETIME, IN end_time DATETIME)
BEGIN
SELECT vcd_id,
       SUM(sale_num) AS total_sales,
       SUM(CASE WHEN status = 0 THEN br_num ELSE 0 END) AS total_borrow,
       SUM(CASE WHEN status = 1 THEN br_num ELSE 0 END) AS total_return
FROM (
         SELECT vcd_id, sale_num, 0 AS br_num, 0 AS status
         FROM vcd_sale
         WHERE sale_time BETWEEN start_time AND end_time
         UNION ALL
         SELECT vcd_id, 0 AS sale_num, br_num, status
         FROM vcd_borrow_return
         WHERE br_time BETWEEN start_time AND end_time
     ) AS t
GROUP BY vcd_id;
END //

DELIMITER ;