SELECT `maker`, `type` FROM labor_sql.product where `type`='laptop' order by `maker`;

SELECT model, ram, screen, price 
	FROM labor_sql.laptop 
    where price > 1000 
    order by ram, price desc;

SELECT * FROM labor_sql.printer where color='y' order by price desc;

SELECT model, speed, hd, cd, price 
	FROM labor_sql.pc 
    where (cd = '12x' or cd = '24x') and price < 600
    order by speed desc;

SELECT `name`, `class` FROM labor_sql.ships order by `name`;

SELECT * 
	FROM labor_sql.pc 
    where speed >= 500 and price < 800
    order by price desc;

SELECT * FROM labor_sql.printer where not `type`='matrix' and price < 300 order by `type` desc;

SELECT model, speed 
	FROM labor_sql.pc 
    where price between 400 and 600
    order by hd;

-- для повної вибірки треба дві таблиці що противорічить умові в завдані
SELECT model, speed, hd
	FROM labor_sql.pc
    where hd = 10 or hd = 20
    order by speed;

SELECT model, speed, hd
	FROM labor_sql.laptop
    where screen >= 12
    order by price desc;

SELECT model, type, price
	FROM labor_sql.printer 
	where price < 300 
    order by `type` desc;

SELECT model, ram, price
	FROM labor_sql.laptop
    where ram = 64
    order by screen;

SELECT model, ram, price
	FROM labor_sql.pc
    where ram > 64
    order by hd;

SELECT model, speed, price
	FROM labor_sql.pc
    where speed between 500 and 750
    order by hd desc;

SELECT * 
	FROM labor_sql.outcome_o
    where `out` > 2000
    order by `date` desc;

SELECT * 
	FROM labor_sql.income_o
    where inc between 5000 and 10000
    order by inc;

SELECT * 
	FROM labor_sql.income
	where `point` = 1
    order by inc;

SELECT * 
	FROM labor_sql.outcome
    where `point` = 2
    order by `out`;

SELECT * 
	FROM labor_sql.classes
	where country = 'Japan'
    order by `type` desc;

SELECT `name`, `launched` 
	FROM labor_sql.ships
    where launched between 1920 and 1942
    order by launched desc;

SELECT * 
	FROM labor_sql.outcomes
	where battle = 'Guadalcanal' and result = 'OK'
    order by ship desc;

SELECT * 
	FROM labor_sql.outcomes
	where result = 'sunk'
    order by ship desc;

SELECT class, displacement
	FROM labor_sql.classes
	where displacement > 40000
    order by `type` ;

SELECT trip_no, town_from, town_to 
	FROM labor_sql.trip
	where town_from = 'London' or town_to = 'London'
    order by time_out;

SELECT trip_no, plane, town_from, town_to 
	FROM labor_sql.trip
	where plane = 'TU-134'
    order by time_out desc;

SELECT trip_no, plane, town_from, town_to 
	FROM labor_sql.trip
	where plane <> 'IL-86'
    order by plane;

SELECT trip_no, town_from, town_to 
	FROM labor_sql.trip
	where not town_from = 'Rostov' and not town_to = 'Rostov'
    order by plane;

SELECT * FROM labor_sql.pc where model rlike '1{2,}';

SELECT * FROM labor_sql.outcome where month(`date`) = 3;

SELECT * FROM labor_sql.outcome_o where dayofmonth(`date`) = 14;

SELECT `name` FROM labor_sql.ships where `name` rlike '^W' and `name` rlike 'n$';

--повино вивести тільки якщо зустрічається 2 рази але не працює
SELECT `name` FROM labor_sql.ships where `name` rlike 'e{2}';

SELECT `name`, `launched` FROM labor_sql.ships where not `name` rlike 'a$';

SELECT `name` FROM labor_sql.battles where `name` rlike '() ()' and `name` rlike '[^c]$';

SELECT * FROM labor_sql.trip where hour(time_out) between 12 and 17;

SELECT * FROM labor_sql.trip where hour(time_out) between 17 and 23;

SELECT `date` FROM labor_sql.pass_in_trip where place rlike '^1';

SELECT `date` FROM labor_sql.pass_in_trip where place rlike 'c$';

SELECT * FROM labor_sql.passenger where `name` like '% C%';

SELECT * FROM labor_sql.passenger where not `name` like '% J%';

SELECT p.maker, p.`type` , pc.speed, pc.hd
	FROM labor_sql.product p 
	right join labor_sql.pc pc on p.model = pc.model
    where pc.hd <= 8;

SELECT p.maker
	FROM labor_sql.product p 
	right join labor_sql.pc pc on p.model = pc.model
    where pc.speed >= 600;

SELECT p.maker
	FROM labor_sql.product p 
	right join labor_sql.laptop l on p.model = l.model
    where l.speed <= 500;

SELECT l1.model model1, l2.model model2, l1.hd, l1.ram
	FROM labor_sql.laptop l1, labor_sql.laptop l2
    where l1.hd = l2.hd and l1.ram = l2.ram and l1.model > l2.model;

SELECT c1.class, c1.`type`, c2.class, c2.`type`
	FROM labor_sql.classes c1, labor_sql.classes c2
	where c1.`type`= 'bb' and c2.`type` = 'bc' and c1.country = c2.country;

SELECT pc.model, p.maker
	FROM labor_sql.product p 
	right join labor_sql.pc pc on p.model = pc.model
    where pc.price < 600;


SELECT pr.model, p.maker
	FROM labor_sql.product p 
	right join labor_sql.printer pr on p.model = pr.model
    where pr.price > 300;

SELECT p.maker, pc.model, pc.price
	FROM labor_sql.product p 
	right join labor_sql.pc pc on p.model = pc.model;

--тут что-то не так
SELECT p.maker, pc.price
	FROM labor_sql.product p 
	right join labor_sql.pc pc on p.model = pc.model;

SELECT p.maker, p.`type`, p.model, l.speed
	FROM labor_sql.product p 
	right join labor_sql.laptop l on p.model = l.model
    where l.speed > 600;

SELECT s.`name`, c.displacement 
	FROM labor_sql.ships s 
    left join labor_sql.classes c on s.class = c.class;

SELECT b.`name`, b.`date` 
	FROM labor_sql.outcomes o
    left join labor_sql.battles b on o.battle = b.name
    where o.result = 'OK';

SELECT s.`name`, c.country 
	FROM labor_sql.ships s 
    left join labor_sql.classes c on s.class = c.class;

SELECT c.`name` FROM labor_sql.trip t left join labor_sql.company c on t.ID_comp = c.ID_comp where t.plane = 'Boeing';

SELECT pt.`date` FROM labor_sql.passenger p right join labor_sql.pass_in_trip pt on p.ID_psg = pt.ID_psg;
