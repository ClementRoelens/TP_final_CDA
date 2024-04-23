create database tp_final;
use tp_final;
select * from employee;
select * from attendance;
select * from address;
select * from report;

INSERT INTO address (id, complement ,country , number , street, town , zip_code)
VALUES
    (101, 'Apt. 202', 'USA', 101, 'Main Street', 'Anytown', '12345-6789'),
    (103, 'Apt 02', 'France',28, 'Rue des étoiles', 'Lille', '06123456178'),
    ( 104,'Apt. 007', 'USA', 777, 'Kenedy Street', 'Dc Washington', '12345-6789'),
    (102, null, 'Canada', 2578, 'Mappe Street', 'Downtown', '0713-5648');



INSERT INTO attendance (start, end,  employee_id)
VALUES
    ( ' 08:00:00','12:00:00', 1);

ALTER TABLE employee ADD COLUMN address_id INT;


INSERT INTO employee (id, birth_date, email, first_name, gender, last_name, password,  pay,  photo_path, role, address_id)
VALUES
    (1, '1990-05-15', 'john.doe@example.com', 'John', 'Male', 'Doe', 'password123', 50000, 'john_doe.jpg', 'Employee', 101),
    ( 2, '1988-08-20', 'jane.smith@example.com', 'Jane', 'Female', 'Smith', 'password456', 55000, 'jane_smith.jpg', 'Manager', 103),
    (3, '1995-02-10', 'bob.johnson@example.com', 'Bob', 'Male', 'Johnson', 'password789', 45000, 'bob_johnson.jpg', 'Employee', 104),
    (4 , '1992-11-30', 'alice.williams@example.com', 'Alice', 'Female', 'Williams', 'passwordABC', 60000, 'alice_williams.jpg', 'Manager', 102);