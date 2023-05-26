CREATE VIEW vcd_stock_status AS
SELECT t.type_name, SUM(i.num) AS stock_num
FROM vcd_info i
         JOIN vcd_type t ON i.type_id = t.type_id
GROUP BY t.type_name;
