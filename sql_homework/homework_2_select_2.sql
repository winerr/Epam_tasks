SELECT DISTINCT maker
  from Product
  WHERE type = 'PC' and maker NOT in (SELECT maker FROM Product WHERE type = 'Laptop');

SELECT DISTINCT maker
  from Product
  WHERE type = 'PC' and maker <> all (SELECT maker FROM Product WHERE type = 'Laptop');

SELECT DISTINCT maker
  from Product
  WHERE type = 'PC' and not maker = any (SELECT maker FROM Product WHERE type = 'Laptop');

select DISTINCT maker from Product
  WHERE type = 'PC' and maker in ( SELECT maker FROM Product WHERE type = 'Laptop');

SELECT DISTINCT  maker FROM Product
	WHERE type = 'PC' AND maker = any(SELECT maker from Product WHERE type = 'Laptop');

SELECT DISTINCT  maker FROM Product
	WHERE type = 'PC' AND not maker <> all(SELECT maker from Product WHERE type = 'Laptop');

SELECT maker from Product
  WHERE model in (SELECT model from PC);

SELECT maker from Product
  WHERE model = ANY (SELECT model from PC);

SELECT maker from Product
  WHERE not model != All (SELECT model from PC);


-- як тут бути 4.8
SELECT country, class from Classes
  WHERE country = 'Ukraine';

SELECT ship, battle, `date` from Outcomes o LEFT JOIN Battles b ON o.battle = b.name
   WHERE result = 'damaged' and ship = ANY (SELECT o.ship from Outcomes o LEFT JOIN Battles b ON o.battle = b.name WHERE o.result = 'OK');

SELECT count(*) FROM Product RIGHT JOIN PC P ON Product.model = P.model WHERE maker = 'A';

SELECT maker from Product
  WHERE exists(SELECT * from PC WHERE Product.model = PC.model);

SELECT maker from Product
  WHERE exists(SELECT * from PC WHERE Product.model = PC.model and speed >= 750);

SELECT DISTINCT maker from Product
  WHERE
    exists(SELECT * from PC WHERE Product.model = PC.model and speed >= 750) or
    exists(SELECT * from Laptop WHERE Product.model = Laptop.model and speed >= 750);

SELECT concat('Середня ціна = ', avg(price)) as 'average price' from Laptop;

SELECT concat('model: ', model) as model, concat('speed: ', speed) as speed,
    concat('hd: ', hd) as hd, concat('ram: ', ram) as ram, concat('price: ', price) as price from PC;

SELECT maker as main, (
                SELECT COUNT(*)
                FROM Product
                  right JOIN PC on Product.model = PC.model
                WHERE maker = main
              ) as PC, (
                SELECT COUNT(*)
                FROM Product
                  right JOIN Laptop L ON Product.model = L.model
                WHERE maker = main
              ) as Laptop, (
                SELECT COUNT(*)
                FROM Product
                  right JOIN Printer P ON Product.model = P.model
                WHERE maker = main
              ) as Printer
  from Product
  GROUP BY maker;


SELECT maker as main, (
                SELECT avg(screen)
                FROM Product
                  right JOIN Laptop on Product.model = Laptop.model
                WHERE maker = main
              ) as PC
  from Product
  GROUP BY maker;



SELECT maker as main, (
                SELECT max(price)
                FROM Product
                  right JOIN PC on Product.model = PC.model
                WHERE maker = main
              ) as PC
  from Product
  GROUP BY maker;

SELECT maker as main, (
                SELECT min(price)
                FROM Product
                  right JOIN PC on Product.model = PC.model
                WHERE maker = main
              ) as PC
  from Product
  GROUP BY maker;


