DELIMITER //
CREATE TRIGGER update_inventory AFTER INSERT ON vcd_in
    FOR EACH ROW
BEGIN
    UPDATE vcd_info SET num = num + NEW.in_num WHERE vcd_info.vcd_id = NEW.vcd_id;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER sub_inventory AFTER INSERT ON vcd_sale
    FOR EACH ROW
BEGIN
    UPDATE vcd_info SET num = num - NEW.sale_num WHERE vcd_info.vcd_id = NEW.vcd_id;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER borrow_inventory AFTER INSERT ON vcd_borrow_return
    FOR EACH ROW
BEGIN
    UPDATE vcd_info SET num = num - NEW.br_num WHERE vcd_info.vcd_id = NEW.vcd_id and NEW.status = 0;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER return_inventory AFTER INSERT ON vcd_borrow_return
    FOR EACH ROW
BEGIN
    UPDATE vcd_info SET num = num + NEW.br_num WHERE vcd_info.vcd_id = NEW.vcd_id and NEW.status = 1;
END //
DELIMITER ;